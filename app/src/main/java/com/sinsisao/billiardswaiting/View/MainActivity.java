package com.sinsisao.billiardswaiting.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;


import com.sinsisao.billiardswaiting.Control.MainViewControl;
import com.sinsisao.billiardswaiting.R;
import com.sinsisao.billiardswaiting.Utils.WaitingLog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View rootView = (View)findViewById(R.id.root);
        MainViewControl mvc = new MainViewControl(rootView);
        mvc.setWaitingList(R.id.waiting_board);
        mvc.setWaitingCount(R.id.waiting_count);
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
    }
}