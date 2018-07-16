package cn.com.ydream.product.repository;

import cn.com.ydream.product.domain.User;

/**
 * user缓存操作
 */
public interface UserRedisRepository {
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(Integer userId);
    User findUser(Integer userId);
}
