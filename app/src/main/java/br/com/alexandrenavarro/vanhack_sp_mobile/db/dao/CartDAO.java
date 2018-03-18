package br.com.alexandrenavarro.vanhack_sp_mobile.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import br.com.alexandrenavarro.vanhack_sp_mobile.model.Product;

/**
 * Created by alexa on 18/03/2018.
 */

@Dao
public interface CartDAO {

    @Query("SELECT * FROM products")
    LiveData<List<Product>> loadAllProductsOnCart();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Product product);
}
