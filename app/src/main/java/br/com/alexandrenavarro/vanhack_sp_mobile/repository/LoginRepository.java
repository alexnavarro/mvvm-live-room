package br.com.alexandrenavarro.vanhack_sp_mobile.repository;

import android.arch.lifecycle.MutableLiveData;

import br.com.alexandrenavarro.vanhack_sp_mobile.network.HttpClient;

/**
 * Created by alexa on 18/03/2018.
 */

public class LoginRepository {

    public MutableLiveData<String> auth(String login, String password){
        MutableLiveData mutableLiveData= new MutableLiveData<String>();
        new HttpClient().auth(mutableLiveData, login, password);
        return mutableLiveData;
    }
}
