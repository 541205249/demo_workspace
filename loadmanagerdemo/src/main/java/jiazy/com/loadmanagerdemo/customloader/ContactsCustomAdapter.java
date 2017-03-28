package jiazy.com.loadmanagerdemo.customloader;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import jiazy.com.loadmanagerdemo.R;

/**
 * 作者： jiazy
 * 日期： 2017/3/25.
 * 公司： 步步高教育电子有限公司
 */

public class ContactsCustomAdapter extends BaseAdapter {
    private List<ContactEntry> mContactList;
    private LayoutInflater mInflater;

    public ContactsCustomAdapter(Context mContext) {
        mInflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setContactList(List<ContactEntry> contactList) {
        mContactList = contactList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mContactList == null ? 0 : mContactList.size();
    }

    @Override
    public Object getItem(int position) {
        return mContactList == null ? null : mContactList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        if (convertView == null) {
            view = mInflater.inflate(R.layout.listview_item, parent, false);
        } else {
            view = convertView;
        }

        ContactEntry contact = (ContactEntry) getItem(position);
        TextView idTv = (TextView) view.findViewById(R.id.tv_id);
        TextView nameTv = (TextView) view.findViewById(R.id.tv_name);
        TextView numberTv = (TextView) view.findViewById(R.id.tv_number);

        idTv.setText(String.valueOf(contact.getId()));
        nameTv.setText(contact.getName());
        numberTv.setText(contact.getNumber());

        return view;
    }

}