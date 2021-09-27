package com.sinsisao.billiardswaiting.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import com.sinsisao.billiardswaiting.R;
import com.sinsisao.billiardswaiting.Utils.WaitingLog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        WaitingLog.d("onResume()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        WaitingLog.d("onDestroy()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        WaitingLog.d("onPause()");
    }
}