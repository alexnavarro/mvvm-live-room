package br.com.alexandrenavarro.vanhack_sp_mobile.network;

import java.util.List;

import br.com.alexandrenavarro.vanhack_sp_mobile.model.Product;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by alexa on 18/03/2018.
 */

public interface ProductService {

    @GET("Product")
    Call<List<Product>> list();
}
