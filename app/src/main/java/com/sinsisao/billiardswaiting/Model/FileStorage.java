package com.sinsisao.billiardswaiting.Model;

import android.content.Context;

import com.sinsisao.billiardswaiting.Utils.WaitingLog;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileStorage implements Storable, Usable {

    final String OutputFileName = "customer.dat";
    private final List<CustomerData> mDataList;

    public FileStorage() {
        mDataList = new ArrayList<>();
    }

    @Override
    public void save(Context a_context) {
        Collections.sort(mDataList);
        String filePath = a_context.getFilesDir().getPath() + "/" + OutputFileName;
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(filePath));
            StringBuilder sb = new StringBuilder();
            int dataListSize = mDataList.size();

            WaitingLog.d("save " + dataListSize);
            for (int i = 0; i < dataListSize; i++) {
                CustomerData cd = mDataList.get(i);
                sb.append(cd.getNickname());
                sb.append(",");
                sb.append(cd.getScore());
                sb.append(",");
                WaitingLog.d(i + " " + cd.getNickname() + " " + cd.getScore());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void load(Context a_context) {
        String filePath = a_context.getFilesDir().getPath() + "/" + OutputFileName;
        File file = new File(filePath);
        BufferedReader reader = null;
        if (!file.exists()) {
            WaitingLog.d("load failed. file not exists.");
        }
        try {
            reader = new BufferedReader(new FileReader(file));
            String dataString = reader.readLine();
            if (dataString != null) {
                String[] dataArray = dataString.split(",");
                WaitingLog.d("load " + (dataArray.length / 2));
                for (int i = 0; i < dataArray.length; i+=2) {
                    WaitingLog.d((i / 2) + " " + dataArray[i] + " " + dataArray[i + 1]);
                    mDataList.add(new CustomerData(dataArray[i], Integer.parseInt(dataArray[i + 1])));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void add(CustomerData a_data) {
        mDataList.add(a_data);
    }

    @Override
    public CustomerData get(int a_index) {
        if (mDataList.size() <= a_index) {
            return null;
        }
        return mDataList.get(a_index);
    }
}
