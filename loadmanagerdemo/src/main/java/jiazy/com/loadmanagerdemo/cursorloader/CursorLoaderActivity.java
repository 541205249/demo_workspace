package jiazy.com.loadmanagerdemo.cursorloader;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.ListView;

import jiazy.com.loadmanagerdemo.R;

import static jiazy.com.loadmanagerdemo.customloader.Constant.CONTACTS_PROJECTION;

public class CursorLoaderActivity extends Activity implements LoaderManager.LoaderCallbacks<Cursor> {

    private ContactsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cursor_loader);

        initViews();
        initLoaderManager();
    }

    private void initViews() {
        ListView mListView = (ListView) findViewById(R.id.lv_list);
        mAdapter = new ContactsAdapter(getApplicationContext());
        mListView.setAdapter(mAdapter);
    }

    private void initLoaderManager() {
        getLoaderManager().initLoader(0, null, this);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(getApplicationContext(), ContactsContract.Contacts.CONTENT_URI,
                CONTACTS_PROJECTION, null, null, ContactsContract.Contacts.SORT_KEY_PRIMARY);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        Log.i(null, "数据加载完成 共计" + data.getCount() + "条记录" + "，" + data.getColumnCount());
        mAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader loader) {
        mAdapter.swapCursor(null);
    }

}