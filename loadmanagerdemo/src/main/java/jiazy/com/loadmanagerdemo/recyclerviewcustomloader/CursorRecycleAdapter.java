package jiazy.com.loadmanagerdemo.recyclerviewcustomloader;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import jiazy.com.loadmanagerdemo.R;
import jiazy.com.loadmanagerdemo.customloader.ContactEntry;

/**
 * 作者： jiazy
 * 日期： 2017/3/28.
 * 公司： 步步高教育电子有限公司
 */

public class CursorRecycleAdapter extends RecyclerView.Adapter<CursorRecycleAdapter.MyViewHolder> {
    private Context mContext;
    private List<ContactEntry> mContactList;
    private OnItemClickListener mOnItemClickListener;

    public CursorRecycleAdapter(Context context) {
        mContext = context;
    }

    public void setContactList(List<ContactEntry> contactList) {
        mContactList = contactList;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.listview_item, parent, false));
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        ContactEntry contact = mContactList.get(position);
        holder.idTv.setText(String.valueOf(contact.getId()));
        holder.nameTv.setText(contact.getName());
        holder.numberTv.setText(contact.getNumber());
        initViewListener(holder);
    }

    private void initViewListener(final MyViewHolder holder) {
        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(holder.itemView, pos);
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickListener.onItemLongClick(holder.itemView, pos);
                    return false;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mContactList == null ? 0 : mContactList.size();
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView idTv;
        TextView nameTv;
        TextView numberTv;

        MyViewHolder(View view) {
            super(view);
            idTv = (TextView) view.findViewById(R.id.tv_id);
            nameTv = (TextView) view.findViewById(R.id.tv_name);
            numberTv = (TextView) view.findViewById(R.id.tv_number);
        }
    }

}
