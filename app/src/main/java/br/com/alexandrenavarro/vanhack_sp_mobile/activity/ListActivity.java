package br.com.alexandrenavarro.vanhack_sp_mobile.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import br.com.alexandrenavarro.vanhack_sp_mobile.R;
import br.com.alexandrenavarro.vanhack_sp_mobile.ViewModelFactory;
import br.com.alexandrenavarro.vanhack_sp_mobile.adapter.ProdListAdapter;
import br.com.alexandrenavarro.vanhack_sp_mobile.databinding.ListActivityBinding;
import br.com.alexandrenavarro.vanhack_sp_mobile.viewmodel.ListProductViewModel;

/**
 * Created by alexa on 18/03/2018.
 */

public class ListActivity extends AppCompatActivity {

    private ListProductViewModel viewmodel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewmodel = ViewModelProviders.of(this, new ViewModelFactory(getApplication())).get(ListProductViewModel.class);
        final ListActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.list_activity);
        binding.setViewmodel(viewmodel);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(new ProdListAdapter(this));
        viewmodel.loadProducts(this);
    }
}