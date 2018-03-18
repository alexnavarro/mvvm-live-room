package br.com.alexandrenavarro.vanhack_sp_mobile.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.databinding.ObservableBoolean;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import br.com.alexandrenavarro.vanhack_sp_mobile.repository.LoginRepository;
import br.com.alexandrenavarro.vanhack_sp_mobile.util.Preferences;
import br.com.alexandrenavarro.vanhack_sp_mobile.util.SingleLiveEvent;

/**
 * Created by alexa on 17/03/2018.
 */

public class LoginViewModel extends AndroidViewModel{

    private Application application;
    private LoginRepository loginRepository;

    public final ObservableBoolean loading = new ObservableBoolean(false);
    private final SingleLiveEvent<Void> mOpenProductListEvent = new SingleLiveEvent<>();

    public LoginViewModel(@NonNull Application application, LoginRepository loginRepository) {
        super(application);
        this.application = application;
        this.loginRepository = loginRepository;
    }

    public void login(LifecycleOwner lifecycleOwner, String email, String password) {
        loading.set(true);
        MutableLiveData<String> auth = loginRepository.auth(email, password);
        auth.observe(lifecycleOwner, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String token) {
                loading.set(false);
                new Preferences(application).saveUserToken(token);
                mOpenProductListEvent.call();
            }
        });
    }

    public SingleLiveEvent<Void> getOpenProductListEvent() {
        return mOpenProductListEvent;
    }
}