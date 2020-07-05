package com.example.carl.mvvmdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.carl.mvvmdemo.bean.Account;
import com.example.carl.mvvmdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private Account account;
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        MVVMViewModel mvvmViewModel = new MVVMViewModel(getApplication(),binding);
        binding.setViewModel(mvvmViewModel);


    }

}












