package com.example.carl.mvvmdemo;

import android.app.Application;
import android.view.View;
import android.widget.Toast;


import com.example.carl.mvvmdemo.BR;
import com.example.carl.mvvmdemo.Model.MCallback;
import com.example.carl.mvvmdemo.Model.MVVMModel;
import com.example.carl.mvvmdemo.bean.Account;
import com.example.carl.mvvmdemo.databinding.ActivityMainBinding;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class MVVMViewModel extends BaseObservable {
    private String result;
    private MVVMModel mvvmModel;
    private ActivityMainBinding binding;
    public MVVMViewModel(Application application) {
        mvvmModel = new MVVMModel();
    }
    public MVVMViewModel(Application application, ActivityMainBinding binding) {
        mvvmModel = new MVVMModel();
        this.binding = binding;
    }

    public void getData(View view){
        String userInput = binding.etAccount.getText().toString();
        mvvmModel.getAccountData(userInput, new MCallback() {
            @Override
            public void onSuccess(Account account) {
                String info = account.getName() + "|"+ account.getLevel();
                setResult(info);

            }

            @Override
            public void onFailed() {
                setResult("获取数据失败");
            }
        });
    }

    @Bindable
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
        notifyPropertyChanged(com.example.carl.mvvmdemo.BR.result);
    }
}
