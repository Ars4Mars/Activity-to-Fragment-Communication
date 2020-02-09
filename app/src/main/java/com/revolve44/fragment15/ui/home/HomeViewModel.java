package com.revolve44.fragment15.ui.home;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

public class HomeViewModel extends ViewModel {

    // TODO: Implement the ViewModel
    private MutableLiveData<String> stringMutableLiveData;




    public void init()
    {
        stringMutableLiveData=new MutableLiveData<>();
        //stringMutableLiveData2=new MutableLiveData<>();

    }

    public void sendData(String msg)
    {
        stringMutableLiveData.setValue(msg);
        //stringMutableLiveData2.setValue(msg);
    }

    ///

    public LiveData<String> getMessage()
    {
        return stringMutableLiveData;


    }




}