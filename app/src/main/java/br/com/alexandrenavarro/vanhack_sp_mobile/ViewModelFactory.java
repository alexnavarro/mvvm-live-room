package br.com.alexandrenavarro.vanhack_sp_mobile;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import br.com.alexandrenavarro.vanhack_sp_mobile.repository.LoginRepository;
import br.com.alexandrenavarro.vanhack_sp_mobile.repository.ProductRepository;
import br.com.alexandrenavarro.vanhack_sp_mobile.viewmodel.ListProductViewModel;
import br.com.alexandrenavarro.vanhack_sp_mobile.viewmodel.LoginViewModel;

/**
 * Created by alexa on 18/03/2018.
 */

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private final Application mApplication;

    public ViewModelFactory(Application application) {
        this.mApplication = application;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(LoginViewModel.class)) {
            return (T) new LoginViewModel(mApplication, new LoginRepository());
        }else if(modelClass.isAssignableFrom(ListProductViewModel.class)){
            return (T) new ListProductViewModel(mApplication, new ProductRepository());
        }

        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}