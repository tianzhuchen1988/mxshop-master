package cn.com.ydream.user.service.impl;

import cn.com.ydream.user.client.ProductFeignClient;
import cn.com.ydream.user.config.ServiceConfig;
import cn.com.ydream.user.domain.Product;
import cn.com.ydream.user.domain.User;
import cn.com.ydream.user.mapper.UserMapper;
import cn.com.ydream.user.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

/**
 * <p>
 * 类描述：
 * </p>
 *
 * @author chentz
 * @version 0.1
 * @since 2018/07/10.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private ServiceConfig serviceConfig;

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ProductFeignClient productFeignClient;

    @Override
    //@HystrixCommand
    public User findUserById(Integer id) {

        randomlyRunLong();

        User u = new User();
        u.setUserId(id);
        //u.setUserName(serviceConfig.getExampleProperty());
        u = userMapper.selectOne(u);
        return u;
    }

    /**
     * 测试熔断器HystrixCommand使用，随机三分之一机会睡眠11秒，熔断器默认1秒超时并报错，保护远程调用
     */
    private void randomlyRunLong(){
        Random rand = new Random();
        int randomNum = rand.nextInt((3 - 1) + 1) + 1;
        if (randomNum==3) sleep();
    }
    private void sleep(){
        try {
            Thread.sleep(11000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveUser(User user) {
        /*测试分布式事务（结论是：在Service层调用，且加上事务注解，且没有跨数据库，则事务可回滚）*/
        int res = 0;
        res = userMapper.insert(user);
        //调用远程服务product-service新增商品
        Product p = new Product();
        p.setProductName("Orange");
        res = productFeignClient.saveProduct(p);

        return res;
    }
}
