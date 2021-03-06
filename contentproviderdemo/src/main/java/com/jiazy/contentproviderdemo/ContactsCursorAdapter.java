package com.jiazy.contentproviderdemo;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * 作者： jiazy
 * 日期： 2017/3/25.
 * 公司： 步步高教育电子有限公司
 */

public class ContactsCursorAdapter extends CursorAdapter {

    public ContactsCursorAdapter(Context context) {
        this(context, null, true);
    }

    public ContactsCursorAdapter(Context context, Cursor c, boolean autoRequery) {
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
        final int contactId = cursor.getInt(0);
        String name = cursor.getString(1);
        String number = cursor.getString(2);

        TextView contactIdTv = (TextView) view.findViewById(R.id.tv_id);
        contactIdTv.setText(String.valueOf(contactId));
        TextView nameCtrl = (TextView) view.findViewById(R.id.tv_name);
        if (name == null) {
            nameCtrl.setText(number);
        } else {
            nameCtrl.setText(name);
        }
        TextView numberCtrl = (TextView) view.findViewById(R.id.tv_data);
        numberCtrl.setText(number);
    }

}