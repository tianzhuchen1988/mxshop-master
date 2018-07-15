package cn.com.ydream.product.service;

import cn.com.ydream.product.domain.Product;

public interface ProductService {
    Product findProductById(Integer id);
    Product saveProduct(Product p);
}
