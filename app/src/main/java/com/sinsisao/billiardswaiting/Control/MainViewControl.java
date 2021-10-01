package com.sinsisao.billiardswaiting.Control;

import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.sinsisao.billiardswaiting.Model.CustomerData;

import java.util.ArrayList;
import java.util.List;

public class MainViewControl {

    private View mRootView = null;
    private ListView mWaitingListView = null;
    private TextView mWaitingCount = null;
    private List mCustomerDataList = null;

    public MainViewControl(View a_rootView){
        mRootView = a_rootView;
        mCustomerDataList = new ArrayList<CustomerData>();
    }

    public void setWaitingList(int a_id) {
        if (mWaitingListView == null) {
            return;
        }
        try {
            mWaitingListView = (ListView) mRootView.findViewById(a_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setWaitingCount(int a_id) {
        if (mWaitingCount == null) {
            return;
        }
        try {
            mWaitingCount = (TextView) mRootView.findViewById(a_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
