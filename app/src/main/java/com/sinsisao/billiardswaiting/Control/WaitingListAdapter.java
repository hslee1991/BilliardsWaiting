package com.sinsisao.billiardswaiting.Control;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sinsisao.billiardswaiting.Listener.MainViewListener;
import com.sinsisao.billiardswaiting.Model.CustomerData;
import com.sinsisao.billiardswaiting.Model.FileStorage;
import com.sinsisao.billiardswaiting.Model.Usable;
import com.sinsisao.billiardswaiting.R;
import com.sinsisao.billiardswaiting.Utils.WaitingLog;

public class WaitingListAdapter extends RecyclerView.Adapter<WaitingListAdapter.ViewHolder> {

    private final Usable mWaitingListDataManager;
    private MainViewListener mListener;

    public WaitingListAdapter() {
        this.mWaitingListDataManager = new FileStorage();
    }

    public void setMainViewListener(MainViewListener a_listener) {
        mListener = a_listener;
    }

    public void add(CustomerData a_data) {
        int index = mWaitingListDataManager.size();
        WaitingLog.d("---- add [" + index + "] " + a_data.getNickname() + ", " + a_data.getRating());
        mWaitingListDataManager.add(a_data);
        notifyItemInserted(index);
        notifyItemChangedToController();
    }

    public void remove(CustomerData a_data) {
        int index = mWaitingListDataManager.indexOf(a_data);
        if (index >= 0) {
            mWaitingListDataManager.remove(index);
            notifyItemRemoved(index);
            notifyItemChangedToController();
        }
    }

    public void remove(int a_index) {
        if (mWaitingListDataManager.get(a_index) != null) {
            mWaitingListDataManager.remove(a_index);
            notifyItemRemoved(a_index);
            notifyItemChangedToController();
        }
    }

    public int size() {
        return mWaitingListDataManager.size();
    }

    private void notifyItemChangedToController() {
        if (mListener != null) {
            mListener.onWaitingListItemChanged();
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context c = parent.getContext();
        LayoutInflater li = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View v = li.inflate(R.layout.waiting_list_item, parent, false);
        return new WaitingListAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CustomerData cd = mWaitingListDataManager.get(position);
        holder.getIndex().setText(Integer.toString(position));
        holder.getNickname().setText(cd.getNickname());
        holder.getRating().setText(Integer.toString(cd.getRating()));
    }

    @Override
    public int getItemCount() {
        return mWaitingListDataManager.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView mIndex;
        private final TextView mNickname;
        private final TextView mRating;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mIndex = itemView.findViewById(R.id.customer_index);
            mNickname = itemView.findViewById(R.id.customer_nickname);
            mRating = itemView.findViewById(R.id.customer_rating);
        }

        public TextView getIndex() {
            return mIndex;
        }

        public TextView getNickname() {
            return mNickname;
        }

        public TextView getRating() {
            return mRating;
        }
    }
}
