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
    private String userInput;
    public MVVMViewModel(Application application) {
        mvvmModel = new MVVMModel();
    }


    public void getData(View view){
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

    @Bindable
    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
        notifyPropertyChanged(com.example.carl.mvvmdemo.BR.userInput);
    }
}
