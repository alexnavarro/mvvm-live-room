package br.com.alexandrenavarro.vanhack_sp_mobile.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;

import br.com.alexandrenavarro.vanhack_sp_mobile.AppExecutors;
import br.com.alexandrenavarro.vanhack_sp_mobile.db.dao.CartDAO;
import br.com.alexandrenavarro.vanhack_sp_mobile.model.Product;

/**
 * Created by alexa on 18/03/2018.
 */

@Database(entities = {Product.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase sInstance;

    @VisibleForTesting
    public static final String DATABASE_NAME = "cart-db";

    public abstract CartDAO cartDAO();

    public static AppDatabase getInstance(final Context context, final AppExecutors executors) {
        if (sInstance == null) {
            synchronized (AppDatabase.class) {
                if (sInstance == null) {
                    sInstance = buildDatabase(context.getApplicationContext(), executors);
//                    sInstance.updateDatabaseCreated(context.getApplicationContext());
                }
            }
        }
        return sInstance;
    }

    private static AppDatabase buildDatabase(final Context applicationContext, final AppExecutors executors) {
        return Room.databaseBuilder(applicationContext, AppDatabase.class, DATABASE_NAME)
                .addCallback(new Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        executors.diskIO().execute(() -> {
                            // Add a delay to simulate a long-running operation
                            AppDatabase database = AppDatabase.getInstance(applicationContext, executors);
                            // notify that the database was created and it's ready to be used
                        });
                    }
                }).build();
    }
}