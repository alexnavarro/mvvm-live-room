package br.com.alexandrenavarro.vanhack_sp_mobile.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.database.Observable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import br.com.alexandrenavarro.vanhack_sp_mobile.adapter.ProdListAdapter;
import br.com.alexandrenavarro.vanhack_sp_mobile.model.Product;
import br.com.alexandrenavarro.vanhack_sp_mobile.repository.ProductRepository;
import br.com.alexandrenavarro.vanhack_sp_mobile.util.SingleLiveEvent;

/**
 * Created by alexa on 18/03/2018.
 */

public class ListProductViewModel extends AndroidViewModel{

    public ObservableArrayList<Product> products = new ObservableArrayList<>();
    private final SingleLiveEvent<Product> mAddNewProductToCart = new SingleLiveEvent<>();

    private Application application;
    private ProductRepository productRepository;

    public ListProductViewModel(@NonNull Application application, ProductRepository productRepository) {
        super(application);
        this.application = application;
        this.productRepository = productRepository;
    }

    public void loadProducts(LifecycleOwner lifecycleOwner){
        MutableLiveData<List<Product>> mutableLiveData = productRepository.list();
        mutableLiveData.observe(lifecycleOwner, new Observer<List<Product>>() {
            @Override
            public void onChanged(@Nullable List<Product> products) {
                ListProductViewModel.this.products.clear();
                ListProductViewModel.this.products.addAll(products);
            }
        });
    }

    @BindingAdapter("app:products")
    public static void setProducts(RecyclerView view, List<Product> products) {
        RecyclerView.Adapter adapter = view.getAdapter();
        if (adapter instanceof ProdListAdapter) {
            ((ProdListAdapter) adapter).addProducts(products);
        }
    }
}