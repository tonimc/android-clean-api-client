package xyz.tonimartinez.cleanandroidapiclient.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import xyz.tonimartinez.cleanandroidapiclient.R;
import xyz.tonimartinez.cleanandroidapiclient.ui.presenter.dto.ContactDTO;

/**
 * Created by Toni Martinez on 2/12/15.
 * toni.martinez.carballo@gmail.com
 */
public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactViewHolder> {

    public interface OnItemClickListener {
        void onClick(ContactDTO item);
    }

    private List<ContactDTO> mItemList;

    private OnItemClickListener mItemClickListener;

    public ContactsAdapter(List<ContactDTO> items) {
        this.mItemList = items;
    }

    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        this.mItemClickListener = itemClickListener;
    }

    public ContactDTO getItem(int position) {
        return mItemList.get(position);
    }

    public void clear() {
        mItemList.clear();
    }

    public void addAll(List<ContactDTO> items) {
        mItemList.addAll(items);
        notifyDataSetChanged();
    }

    public void add(ContactDTO item, int position) {
        mItemList.add(position, item);
        notifyItemInserted(position);
    }

    public void changeItem(ContactDTO item) {
        int position = mItemList.indexOf(item);
        notifyItemChanged(position);
    }

    public void remove(ContactDTO item) {
        int position = mItemList.indexOf(item);
        mItemList.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_list_item, parent, false);
        return new ContactViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ContactsAdapter.ContactViewHolder holder, int position) {
        holder.render(mItemList.get(position));
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }


    public class ContactViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @Bind(R.id.contact_thumb) protected ImageView mImageIV;
        @Bind(R.id.contact_name) protected TextView mNameTV;

        public ContactViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mItemClickListener!=null) {
                mItemClickListener.onClick(getItem(getAdapterPosition()));
            }
        }

        public void render(ContactDTO contactDTO) {
            mNameTV.setText(contactDTO.getFirstName()+ " " + contactDTO.getLastName());

            Picasso.with(mImageIV.getContext())
                    .load(contactDTO.getThumbail())
                    .fit()
                    .centerCrop()
                    .into(mImageIV);
        }
    }

}
