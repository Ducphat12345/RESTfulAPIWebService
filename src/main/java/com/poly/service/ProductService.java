package com.poly.service;

import com.poly.entity.Product;
import com.poly.repository.ProductRepository;

import java.util.List;

public class ProductService {
    ProductRepository productRepository = new ProductRepository();
    public List<Product> getAllProduct(){
        return productRepository.getAllProduct();
    }
    public Product getProductByID(int id){
        return productRepository.getProductByID(id);
    }
    public boolean addProduct(Product product){
        List<Product> products = productRepository.getAllProduct();
        products.sort((p1, p2) -> p1.getId() < p2.getId() ? 1 : -1);
        if (product.getName() != null){
            return productRepository.addProduct(product);
        }
        return false;
    }
    public boolean updateProduct(Product product){
        List<Product> products = productRepository.getAllProduct();
        for (Product productList : products) {
            if (productList.getId() == product.getId()){
                return productRepository.updateProduct(product);
            }
        }
        return false;
    }
    public boolean deleteProduct(int id){
        List<Product> products = productRepository.getAllProduct();
        for (Product product : products) {
            if (product.getId() == id){
                return productRepository.deleteProduct(id);
            }
        }
        return false;
    }
}
