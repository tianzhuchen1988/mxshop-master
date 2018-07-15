package cn.com.ydream.user.service;

import cn.com.ydream.user.domain.User;

public interface UserService {
    User findUserById(Integer id);
    User saveUser(User user);
}
