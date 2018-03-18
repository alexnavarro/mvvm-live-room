package br.com.alexandrenavarro.vanhack_sp_mobile.repository;

import android.app.Application;

import br.com.alexandrenavarro.vanhack_sp_mobile.BasicApp;
import br.com.alexandrenavarro.vanhack_sp_mobile.db.AppDatabase;
import br.com.alexandrenavarro.vanhack_sp_mobile.model.Product;

/**
 * Created by alexa on 18/03/2018.
 */

public class ChartRepository {

    private final AppDatabase mDatabase;

    public ChartRepository(Application application) {
        mDatabase = ((BasicApp) application).getDatabase();
    }

    public void insertProduct(Product product) {
        mDatabase.cartDAO().insert(product);
    }
}