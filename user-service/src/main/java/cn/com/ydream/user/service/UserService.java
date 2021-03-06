package cn.com.ydream.user.service;

import cn.com.ydream.user.domain.Account;
import cn.com.ydream.user.domain.User;

public interface UserService {
    User findUserById(Integer id);
    User saveUser(User user);
    void updateUser(String userName, User user);
    User createNewUser(Account account);
}
