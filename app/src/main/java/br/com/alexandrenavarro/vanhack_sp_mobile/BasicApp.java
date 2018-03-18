package br.com.alexandrenavarro.vanhack_sp_mobile;

import android.app.Application;

import br.com.alexandrenavarro.vanhack_sp_mobile.db.AppDatabase;

/**
 * Created by alexa on 18/03/2018.
 */

public class BasicApp extends Application {

    private AppExecutors mAppExecutors;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppExecutors = new AppExecutors();
    }

    public AppDatabase getDatabase() {
        return AppDatabase.getInstance(this, mAppExecutors);
    }
}
