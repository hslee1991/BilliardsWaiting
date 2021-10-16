package com.sinsisao.billiardswaiting.Model;

public interface Usable {
    void add(CustomerData a_data);
    CustomerData get(int a_index);
    CustomerData get(String a_nickname);
    int size();
}
