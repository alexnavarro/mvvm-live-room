package br.com.alexandrenavarro.vanhack_sp_mobile.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;

/**
 * Created by alexa on 18/03/2018.
 */

public class Preferences {

    private SharedPreferences mPreferences;
    private Context mContext;

    public Preferences(Context context) {
        mPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        mContext = context;
    }

    public boolean userIsLogged() {
        return !TextUtils.isEmpty(mPreferences.getString("user_token", null));
    }

    public void saveUserToken(String userToken) {
        SharedPreferences.Editor editor = mPreferences.edit();
        editor.putString("user_token", userToken);
        editor.commit();
    }
}