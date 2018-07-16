package cn.com.ydream.product.repository.impl;

import cn.com.ydream.product.domain.User;
import cn.com.ydream.product.repository.UserRedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
public class UserRedisRepositoryImpl implements UserRedisRepository {

    private static final String HASH_NAME = "user";
    private HashOperations hashOperations;

    @Autowired
    private RedisTemplate redisTemplate;

    @PostConstruct
    private void init(){
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void saveUser(User user) {
        hashOperations.put(HASH_NAME, user.getUserId(), user);
    }

    @Override
    public void updateUser(User user) {
        hashOperations.put(HASH_NAME, user.getUserId(), user);
    }

    @Override
    public void deleteUser(Integer userId) {
        hashOperations.delete(HASH_NAME, userId);
    }

    @Override
    public User findUser(Integer userId) {
        return (User) hashOperations.get(HASH_NAME, userId);
    }
}
