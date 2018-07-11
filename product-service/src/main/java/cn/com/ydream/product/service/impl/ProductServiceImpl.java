package cn.com.ydream.product.service.impl;

import cn.com.ydream.product.client.UserFeignClient;
import cn.com.ydream.product.domain.Product;
import cn.com.ydream.product.domain.User;
import cn.com.ydream.product.mapper.ProductMapper;
import cn.com.ydream.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private UserFeignClient userFeignClient;

    @Override
    public Product findProductById(Integer id) {
        Product p = new Product();
        p.setProductId(id);

        /*测试远程服务调用*/
        User u = userFeignClient.getUser(1001);
        System.out.println(u.getUserName());

        return productMapper.selectByPrimaryKey(p);
    }

    @Override
    public int saveProduct(Product p) {
        return productMapper.insert(p);
    }
}
