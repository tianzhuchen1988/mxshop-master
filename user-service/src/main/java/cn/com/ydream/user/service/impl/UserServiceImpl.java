package cn.com.ydream.user.service.impl;

import cn.com.ydream.user.config.ServiceConfig;
import cn.com.ydream.user.domain.User;
import cn.com.ydream.user.mapper.UserMapper;
import cn.com.ydream.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public User findUserById(Integer id) {
        User u = new User();
        u.setUserId(1001);
        //u.setUserName(serviceConfig.getExampleProperty());
        u = userMapper.selectOne(u);
        return u;
    }
}
