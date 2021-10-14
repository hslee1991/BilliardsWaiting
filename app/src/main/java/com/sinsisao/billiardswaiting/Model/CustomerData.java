package com.sinsisao.billiardswaiting.Model;

public class CustomerData implements Comparable<CustomerData> {

    private String mNickname;
    private int mScore;

    public CustomerData(String a_nickname, int a_score) {
        mNickname = a_nickname;
        mScore = a_score;
    }

    public String getNickname() {
        return mNickname;
    }
    public void setNickname(String a_nickname) {
        this.mNickname = a_nickname;
    }
    public int getScore() {
        return mScore;
    }
    public void setScore(int a_score) {
        this.mScore = a_score;
    }

    @Override
    public int compareTo(CustomerData customerData) {
        return mNickname.compareTo(customerData.getNickname());
    }
}
