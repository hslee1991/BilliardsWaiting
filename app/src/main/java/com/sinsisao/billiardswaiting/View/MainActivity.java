package com.sinsisao.billiardswaiting.View;

import androidx.appcompat.app.AppCompatActivity;

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
        WaitingLog.d("onCreate()");
        setContentView(R.layout.activity_main);

        View rootView = findViewById(R.id.root);
        mViewController = new MainViewControl(this, rootView);
        mViewController.setWaitingList(R.id.waiting_list);
        mViewController.setWaitingCount(R.id.waiting_count);
        mViewController.setJoinBtn(R.id.button_registration);
        mViewController.setLoadBtn(R.id.button_load);
        mViewController.setInputNickname(R.id.newbie_nickname);
        mViewController.setInputRating(R.id.newbie_rating);
        mViewController.initialize();
    }

    @Override
    protected void onResume() {
        super.onResume();
        WaitingLog.d("onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        WaitingLog.d("onPause()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        WaitingLog.d("onDestroy()");
        mViewController.deinitialize();
    }
}