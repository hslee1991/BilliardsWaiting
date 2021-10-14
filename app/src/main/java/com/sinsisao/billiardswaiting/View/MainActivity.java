package com.sinsisao.billiardswaiting.View;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import com.sinsisao.billiardswaiting.Control.MainViewControl;
import com.sinsisao.billiardswaiting.R;
import com.sinsisao.billiardswaiting.Utils.WaitingLog;

public class MainActivity extends AppCompatActivity {

    MainViewControl mViewController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View rootView = findViewById(R.id.root);
        mViewController = new MainViewControl(this, rootView);
        mViewController.setWaitingList(R.id.waiting_board);
        mViewController.setWaitingCount(R.id.waiting_count);
        mViewController.setJoinBtn(R.id.waiting_regist);
        mViewController.setLoadBtn(R.id.waiting_loading);

        Drawable drawable = rootView.getBackground();
        drawable.setAlpha(50);
    }

    @Override
    protected void onResume() {
        super.onResume();
        WaitingLog.d("onResume()");
        mViewController.initialize();
    }

    @Override
    protected void onPause() {
        super.onPause();
        WaitingLog.d("onPause()");
        mViewController.deinitialize();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        WaitingLog.d("onDestroy()");
    }
}