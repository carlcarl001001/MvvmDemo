package com.example.carl.mvvmdemo.bean;

import com.example.carl.mvvmdemo.BR;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class Account extends BaseObservable {
    String name;
    int level;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Bindable
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
        notifyPropertyChanged(com.example.carl.mvvmdemo.BR.level);
    }
}
