package cn.com.ydream.user.service.impl;

import cn.com.ydream.user.client.ProductFeignClient;
import cn.com.ydream.user.config.ServiceConfig;
import cn.com.ydream.user.domain.Product;
import cn.com.ydream.user.domain.User;
import cn.com.ydream.user.mapper.UserMapper;
import cn.com.ydream.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public User findUserById(Integer id) {
        User u = new User();
        u.setUserId(1001);
        //u.setUserName(serviceConfig.getExampleProperty());
        u = userMapper.selectOne(u);
        return u;
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
