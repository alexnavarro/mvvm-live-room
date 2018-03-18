package br.com.alexandrenavarro.vanhack_sp_mobile.repository;

import android.arch.lifecycle.MutableLiveData;

import java.util.List;

import br.com.alexandrenavarro.vanhack_sp_mobile.model.Product;
import br.com.alexandrenavarro.vanhack_sp_mobile.network.HttpClient;

/**
 * Created by alexa on 18/03/2018.
 */

public class ProductRepository {

    public MutableLiveData<List<Product>> list(){
        MutableLiveData mutableLiveData= new MutableLiveData<String>();
        new HttpClient().list(mutableLiveData);
        return mutableLiveData;
    }
}
