package com.sinsisao.billiardswaiting.Control;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.sinsisao.billiardswaiting.Model.FileStorage;
import com.sinsisao.billiardswaiting.Model.Usable;

public class MainViewControl {

    private final Context mContext;
    private final View mRootView;
    private ListView mWaitingListView = null;
    private TextView mWaitingCount = null;
    private Button mJoinBtn = null;
    private Button mLoadBtn = null;
    private Usable mWaitingListDataManager;
    private FileStorage mStorageDataManager;

    public MainViewControl(Context a_context, View a_rootView){
        mContext = a_context;
        mRootView = a_rootView;
    }

    public void initialize() {
        mWaitingListDataManager = new FileStorage();
        mStorageDataManager = new FileStorage();
        mStorageDataManager.load(mContext);
    }

    public void deinitialize() {
        mStorageDataManager.save(mContext);
    }

    public void setWaitingList(int a_id) {
        if (mWaitingListView == null) {
            return;
        }
        try {
            mWaitingListView = mRootView.findViewById(a_id);
            // todo. connect waiting list to data manager.
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setWaitingCount(int a_id) {
        if (mWaitingCount == null) {
            return;
        }
        try {
            mWaitingCount = mRootView.findViewById(a_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setJoinBtn(int a_id) {
        if (mJoinBtn == null) {
            return;
        }
        try {
            mJoinBtn = mRootView.findViewById(a_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setLoadBtn(int a_id) {
        if (mLoadBtn == null) {
            return;
        }
        try {
            mLoadBtn = mRootView.findViewById(a_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
