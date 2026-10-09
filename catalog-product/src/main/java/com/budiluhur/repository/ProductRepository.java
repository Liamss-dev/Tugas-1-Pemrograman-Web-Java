package com.budiluhur.repository;

import com.budiluhur.model.Product;
import com.budiluhur.exception.ProductNotFoundException;
import java.util.*;
public class ProductRepository {
    private List<Product> productList = new ArrayList<>();

    public void addProduct(Product product) {
        productList.add(product);
    }

    public List<Product> findAll() {
        return productList;
    }
    public Product findById(String id) throws ProductNotFoundException {
        for (Product p : productList) {
            if (p.getId().equalsIgnoreCase(id)) {
                return p;
            }
        }
        throw new ProductNotFoundException("Produk dengan ID: " + id + " tidak ditemukan!");
    }

}
