package cn.com.ydream.product.service;

import cn.com.ydream.product.domain.Product;

public interface ProductService {
    Product findProductById(Integer id);
    int saveProduct(Product p);
}
