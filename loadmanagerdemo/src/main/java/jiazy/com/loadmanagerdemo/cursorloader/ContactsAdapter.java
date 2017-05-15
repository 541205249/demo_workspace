package jiazy.com.loadmanagerdemo.cursorloader;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import jiazy.com.loadmanagerdemo.R;

import static jiazy.com.loadmanagerdemo.customloader.Constant.CONTACTS_PROJECTION;

/**
 * 作者： jiazy
 * 日期： 2017/3/25.
 * 公司： 步步高教育电子有限公司
 */

public class ContactsAdapter extends CursorAdapter {

    public ContactsAdapter(Context context) {
        this(context, null, true);
    }

    public ContactsAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return inflater.inflate(R.layout.listview_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        if (cursor == null)
            return;
        final int contactId = cursor.getInt(cursor.getColumnIndex(CONTACTS_PROJECTION[0]));
        String name = cursor.getString(cursor.getColumnIndex(CONTACTS_PROJECTION[1]));
        String number = cursor.getString(cursor.getColumnIndex(CONTACTS_PROJECTION[2]));

        TextView contactIdTv = (TextView) view.findViewById(R.id.tv_id);
        contactIdTv.setText(String.valueOf(contactId));
        TextView nameCtrl = (TextView) view.findViewById(R.id.tv_name);
        if (name == null) {
            nameCtrl.setText(number);
        } else {
            nameCtrl.setText(name);
        }
        TextView numberCtrl = (TextView) view.findViewById(R.id.tv_number);
        numberCtrl.setText(number);
    }

}