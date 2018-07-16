package cn.com.ydream.product.service;

import cn.com.ydream.product.domain.Product;
import cn.com.ydream.product.domain.User;

public interface ProductService {
    Product findProductById(Integer id);
    Product saveProduct(Product p);
    User getUserFromCache(Integer userId);
}
