package br.com.alexandrenavarro.vanhack_sp_mobile.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.text.NumberFormat;

/**
 * Created by alexa on 18/03/2018.
 */

@Entity(tableName = "products")
public class Product {

    @PrimaryKey
    private int id;
    private int storeId;
    private  String name;
    private  String description;
    private  double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return formatter.format(price);
    }

    public void setPrice(double price) {
        this.price = price;
    }
}