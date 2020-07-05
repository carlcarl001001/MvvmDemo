package com.example.carl.mvvmdemo.Model;

import com.example.carl.mvvmdemo.bean.Account;

public interface MCallback {
    public void onSuccess(Account account);
    public  void onFailed();

}
