package com.sinsisao.billiardswaiting.Model;

import androidx.annotation.NonNull;

public class CustomerData implements Comparable<CustomerData>, Cloneable {

    private String mNickname;
    private int mRating;

    public CustomerData(String a_nickname, int a_rating) {
        mNickname = a_nickname;
        mRating = a_rating;
    }

    public String getNickname() {
        return mNickname;
    }
    public void setNickname(String a_nickname) {
        this.mNickname = a_nickname;
    }
    public int getRating() {
        return mRating;
    }
    public void setRating(int a_rating) {
        this.mRating = a_rating;
    }

    @Override
    public int compareTo(CustomerData customerData) {
        return mNickname.compareTo(customerData.getNickname());
    }

    @NonNull
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
