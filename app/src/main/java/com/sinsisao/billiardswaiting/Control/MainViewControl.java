package com.sinsisao.billiardswaiting.Control;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sinsisao.billiardswaiting.Listener.MainViewListener;
import com.sinsisao.billiardswaiting.Model.CustomerData;
import com.sinsisao.billiardswaiting.Model.FileStorage;
import com.sinsisao.billiardswaiting.R;
import com.sinsisao.billiardswaiting.Utils.WaitingLog;

public class MainViewControl implements MainViewListener {

    private final Context mContext;
    private final View mRootView;
    private RecyclerView mWaitingListView = null;
    private WaitingListAdapter mWaitingListAdapter = null;
    private TextView mWaitingCount = null;
    private Button mJoinBtn = null;
    private Button mLoadBtn = null;
    private EditText mNickname = null;
    private EditText mRating = null;

    private FileStorage mStorageDataManager;

    public MainViewControl(Context a_context, View a_rootView) {
        mContext = a_context;
        mRootView = a_rootView;
    }

    public void initialize() {
        mStorageDataManager = new FileStorage();
        mStorageDataManager.load(mContext);
    }

    public void deinitialize() {
        mStorageDataManager.save(mContext);
    }

    public void setWaitingList(int a_id) {
        if (mWaitingListView != null) {
            return;
        }
        try {
            mWaitingListView = mRootView.findViewById(a_id);
            mWaitingListView.setLayoutManager(new LinearLayoutManager(mContext));
            mWaitingListAdapter = new WaitingListAdapter();
            mWaitingListAdapter.setMainViewListener(this);
            mWaitingListView.setAdapter(mWaitingListAdapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setWaitingCount(int a_id) {
        if (mWaitingCount != null) {
            return;
        }
        try {
            mWaitingCount = mRootView.findViewById(a_id);
            onWaitingListItemChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setJoinBtn(int a_id) {
        if (mJoinBtn != null) {
            return;
        }
        try {
            mJoinBtn = mRootView.findViewById(a_id);
            if (mJoinBtn != null) {
                mJoinBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (checkInputValidation()) {
                            String nickname = mNickname.getText().toString();
                            String rating = mRating.getText().toString();
                            WaitingLog.d("data added in join button. (" + nickname + ", " + rating + ")");
                            CustomerData cd = new CustomerData(nickname, Integer.parseInt(rating));
                            mWaitingListAdapter.add(cd);
                            try {
                                mStorageDataManager.add((CustomerData) cd.clone());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            mRating.setText("");
                            mNickname.setText("");
                            mNickname.requestFocus();
                        }
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setLoadBtn(int a_id) {
        if (mLoadBtn != null) {
            return;
        }
        try {
            mLoadBtn = mRootView.findViewById(a_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setInputNickname(int a_id) {
        if (mNickname != null) {
            return;
        }
        try {
            mNickname = mRootView.findViewById(a_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setInputRating(int a_id) {
        if (mRating != null) {
            return;
        }
        try {
            mRating = mRootView.findViewById(a_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressLint("ShowToast")
    private boolean checkInputValidation() {
        if (mNickname == null || mRating == null) {
            Toast.makeText(mContext, mContext.getString(R.string.warning_message_no_initialize), Toast.LENGTH_SHORT).show();
            return false;
        }
        String nickname = mNickname.getText().toString();
        if (nickname.length() < 3) {
            Toast.makeText(mContext, mContext.getString(R.string.warning_message_no_nickname), Toast.LENGTH_SHORT).show();
            mNickname.requestFocus();
            return false;
        }
        String rating = mRating.getText().toString();
        if (rating.length() <= 0) {
            Toast.makeText(mContext, mContext.getString(R.string.warning_message_no_rating), Toast.LENGTH_SHORT).show();
            mRating.requestFocus();
            return false;
        }
        CustomerData cd = mStorageDataManager.get(nickname);
        if (cd != null) {
            Toast.makeText(mContext, mContext.getString(R.string.warning_message_nickname_overlapped), Toast.LENGTH_SHORT).show();
            mNickname.requestFocus();
            return false;
        }
        return true;
    }

    @Override
    public void onWaitingListItemChanged() {
        if (mWaitingCount != null && mWaitingListAdapter != null) {
            mWaitingCount.setText(String.valueOf(mWaitingListAdapter.size()));
        }
    }
}
