package br.com.alexandrenavarro.vanhack_sp_mobile.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import br.com.alexandrenavarro.vanhack_sp_mobile.viewmodel.LoginViewModel;
import br.com.alexandrenavarro.vanhack_sp_mobile.R;
import br.com.alexandrenavarro.vanhack_sp_mobile.ViewModelFactory;
import br.com.alexandrenavarro.vanhack_sp_mobile.databinding.ActivityLoginBinding;
import br.com.alexandrenavarro.vanhack_sp_mobile.util.Preferences;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    private LoginViewModel viewmodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(new Preferences(getApplicationContext()).userIsLogged()){
            openListActivity();
        }

        viewmodel = ViewModelProviders.of(this, new ViewModelFactory(getApplication())).get(LoginViewModel.class);
        final ActivityLoginBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.setViewmodel(viewmodel);

        binding.emailSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewmodel.login(LoginActivity.this,
                        binding.email.getText().toString(), binding.password.getText().toString());
            }
        });

        viewmodel.getOpenProductListEvent().observe(this, new Observer<Void>() {
            @Override
            public void onChanged(@Nullable Void aVoid) {
                openListActivity();
            }
        });
    }

    private void openListActivity() {
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }
}