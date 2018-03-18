package br.com.alexandrenavarro.vanhack_sp_mobile.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.com.alexandrenavarro.vanhack_sp_mobile.databinding.ListProductItemBinding;
import br.com.alexandrenavarro.vanhack_sp_mobile.model.Product;
import br.com.alexandrenavarro.vanhack_sp_mobile.repository.ChartRepository;
import br.com.alexandrenavarro.vanhack_sp_mobile.viewmodel.ListProductViewModel;

/**
 * Created by alexa on 18/03/2018.
 */

public class ProdListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Product> products = new ArrayList<>();
    private Activity context;
    private ListProductViewModel viewModel;

    public ProdListAdapter(Activity context, ListProductViewModel viewModel) {
        this.context = context;
        this.viewModel = viewModel;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ProductHolder(ListProductItemBinding.inflate(context.getLayoutInflater(), parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ProductHolder) holder).setModel(products.get(position));
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public void addProducts(List<Product> products) {
        this.products.clear();
        this.products.addAll(products);
        notifyDataSetChanged();
    }

    static class ProductHolder extends RecyclerView.ViewHolder {
        final ListProductItemBinding binding;

        ProductHolder(ListProductItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void setModel(final Product product) {
            binding.setModel(product);
            binding.button.setOnClickListener(view -> {
                new ChartRepository(view.getContext().getApplicationContext()).insertProduct();
            });
        }
    }
}