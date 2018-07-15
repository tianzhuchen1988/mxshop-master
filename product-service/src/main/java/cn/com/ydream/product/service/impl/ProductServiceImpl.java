package cn.com.ydream.product.service.impl;

import cn.com.ydream.product.client.UserFeignClient;
import cn.com.ydream.product.domain.Product;
import cn.com.ydream.product.domain.User;
import cn.com.ydream.product.repository.ProductRepository;
import cn.com.ydream.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserFeignClient userFeignClient;

    @Override
    /*使用一个断路器包装一个远程资源调用，并设置断路器调用超时时间
    @HystrixCommand(commandProperties = {@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="10000")}) */
    public Product findProductById(Integer id) {
        //测试远程服务调用，当远程调用出现异常时，服务消费者使用fallback服务降级机制来处理
        User u = userFeignClient.getUser(1001);

        //Assert.notNull(u, "can't find user");

        return productRepository.findOne(id);
    }

    @Override
    public Product saveProduct(Product p) {
        return productRepository.save(p);
    }
}
