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
        ViewHolder viewHolder;
        if(convertView == null){
            convertView = mInflater.inflate(R.layout.listview_item, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder)convertView.getTag();
        }

        ContactEntry contact = (ContactEntry) getItem(position);

        viewHolder.idTv.setText(String.valueOf(contact.getId()));
        viewHolder.nameTv.setText(contact.getName());
        viewHolder.numberTv.setText(contact.getNumber());
        viewHolder.letterTv.setText(contact.getLetter());

        return convertView;
    }

    private class ViewHolder {
        TextView idTv;
        TextView nameTv;
        TextView numberTv;
        TextView letterTv;

        ViewHolder(View view) {
            idTv = (TextView) view.findViewById(R.id.tv_id);
            nameTv = (TextView) view.findViewById(R.id.tv_name);
            numberTv = (TextView) view.findViewById(R.id.tv_number);
            letterTv = (TextView) view.findViewById(R.id.tv_letter);
        }
    }
}