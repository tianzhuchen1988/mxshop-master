package cn.com.ydream.user.service.impl;

import cn.com.ydream.user.client.ProductFeignClient;
import cn.com.ydream.user.config.ServiceConfig;
import cn.com.ydream.user.domain.User;
import cn.com.ydream.user.mq.sender.UserChangeSender;
import cn.com.ydream.user.repository.UserRepository;
import cn.com.ydream.user.service.UserService;
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
    private UserRepository userRepository;

    @Autowired
    private ProductFeignClient productFeignClient;

    @Autowired
    private UserChangeSender userChangeSender;

    @Override
    public User findUserById(Integer id) {

        randomlyRunLong();

        //u.setUserName(serviceConfig.getExampleProperty());
        User u = userRepository.findOne(id);

        /*测试循环调用，结论：出现循环调用的话，会马上抛HystrixRuntimeException*/
        /*Product p = productFeignClient.getProduct(1001);
        Assert.notNull(p, "can't find product");*/

        return u;
    }

    /**
     * 测试断路器HystrixCommand使用，随机三分之一机会睡眠11秒，断路器默认2秒超时并报错，保护远程调用
     */
    private void randomlyRunLong(){
        Random rand = new Random();
        int randomNum = rand.nextInt((3 - 1) + 1) + 1;
        if (randomNum==3) sleep();
    }
    private void sleep(){
        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public User saveUser(User user) {
        /*测试分布式事务（结论是：在Service层调用，且加上事务注解，且没有跨数据库，则事务可回滚）*/
        user = userRepository.save(user);
        //调用远程服务product-service新增商品
        /*Product p = new Product();
        p.setProductName("testFood");
        productFeignClient.saveProduct(p);*/

        //测试基于stream的消息发送
        userChangeSender.publish(user);

        return user;
    }
}
