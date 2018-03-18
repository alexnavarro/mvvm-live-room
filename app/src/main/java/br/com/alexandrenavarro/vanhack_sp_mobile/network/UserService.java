package br.com.alexandrenavarro.vanhack_sp_mobile.network;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by alexa on 18/03/2018.
 */

public interface UserService {

    @POST("Customer/auth")
    Call<String> auth(@Query("email") String email, @Query("password") String password);
}
