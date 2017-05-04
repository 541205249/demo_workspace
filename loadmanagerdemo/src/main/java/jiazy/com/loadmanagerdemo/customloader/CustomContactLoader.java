package jiazy.com.loadmanagerdemo.customloader;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.List;

import hugo.weaving.DebugLog;

import static jiazy.com.loadmanagerdemo.customloader.Constant.CONTACTS_PROJECTION;

/**
 * 作者： jiazy
 * 日期： 2017/3/25.
 * 公司： 步步高教育电子有限公司
 * 描述： 自定义Loader
 * 必须覆写onStartLoading(),onStoppLoading(),onReset(),onCanceled()
 * 和deliverResult(D results)来实现一个完整功能的Loader
 */

public class CustomContactLoader extends AsyncTaskLoader<List<ContactEntry>> {
    private List<ContactEntry> mData;

    public CustomContactLoader(Context context) {
        super(context);

        //监听数据库变化，否则不能实时更新数据
        getContext().getContentResolver().registerContentObserver(
                ContactsContract.Contacts.CONTENT_URI,
                true,
                new ForceLoadContentObserver());
    }

    @Override
    public List<ContactEntry> loadInBackground() {
        return queryContacts();
    }

    @Override
    public void deliverResult(List<ContactEntry> data) {
        if(isReset()) {
            releaseData(data);
            return;
        }

        List<ContactEntry> oldData = mData;
        mData = data;

        if (isStarted()) {
            super.deliverResult(data);
        }

        if (oldData != null && oldData != data) {
            releaseData(oldData);
        }
    }

    @Override
    protected void onStartLoading() {
        if (mData != null) {
            deliverResult(mData);
        }
        if (takeContentChanged() || mData == null) {
            forceLoad();
        }
    }

    @Override
    protected void onStopLoading() {
        cancelLoad();
    }

    @Override
    protected void onReset() {
        super.onReset();

        // Ensure the loader is stopped
        onStopLoading();
        releaseData(mData);
    }

    @Override
    protected boolean onCancelLoad() {
        return super.onCancelLoad();
    }

    private void releaseData(List<ContactEntry> data) {
        if(data != null) {
            data.clear();
        }
    }

    @DebugLog
    private List<ContactEntry> queryContacts() {
        Cursor cursor = getContext().getContentResolver().query(
                ContactsContract.Contacts.CONTENT_URI,
                null/*Constant.CONTACTS_PROJECTION*/,
                null,
                null,
                ContactsContract.Contacts.SORT_KEY_PRIMARY);

        if(cursor == null) {
            return null;
        }

        List<ContactEntry> contactEntryList = new ArrayList<>();
        while (cursor.moveToNext()) {
            ContactEntry contactEntry = new ContactEntry();
            contactEntry.setId(cursor.getInt(cursor.getColumnIndex(CONTACTS_PROJECTION[0])));
            contactEntry.setName(cursor.getString(cursor.getColumnIndex(CONTACTS_PROJECTION[1])));
            contactEntry.setNumber(cursor.getString(cursor.getColumnIndex(CONTACTS_PROJECTION[2])));
            contactEntry.setLetter(cursor.getString(cursor.getColumnIndex(CONTACTS_PROJECTION[3])));

            contactEntryList.add(contactEntry);
        }
        cursor.close();

        return contactEntryList;
    }

}
