package br.com.alexandrenavarro.vanhack_sp_mobile.network;

import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import br.com.alexandrenavarro.vanhack_sp_mobile.model.Product;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by alexa on 18/03/2018.
 */

public class HttpClient {

    private final String TAG = HttpClient.class.getSimpleName();

    private Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    private Retrofit retrofit =  new Retrofit.Builder()
            .baseUrl("http://api-vanhack-event-sp.azurewebsites.net/api/v1/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();

    public void auth(final MutableLiveData<String> liveData, String email, String password){
        retrofit.create(UserService.class).auth(email, password).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()){
                    liveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                liveData.setValue(null);
                Log.d(TAG, t.getMessage());
            }
        });
    }

    public void list(final MutableLiveData mutableLiveData) {
        retrofit.create(ProductService.class).list().enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                if(response.isSuccessful()){
                    mutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Log.d(TAG, t.getMessage());
            }
        });
    }
}