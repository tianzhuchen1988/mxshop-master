package cn.com.ydream.product.client;

import cn.com.ydream.product.domain.User;
import cn.com.ydream.product.repository.UserRedisRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * 使用restTemplate的方式调用远程服务
 */
@Component
@Slf4j
public class UserRestTemplateClient {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserRedisRepository userRedisRepository;

    public User getUser(Integer userId){
        log.info("商品服务中，调用用户服务，获取用户{}", userId);

        User user = checkRedisCache(userId);

        if(user != null){
            log.info("成功从缓存中获取用户{}", userId);
            return user;
        }

        log.info("缓存中没有该用户{}，调用远程服务获取用户", userId);

        ResponseEntity<User> restExchange = restTemplate.exchange(
                "http://mxshop-gateway:4000/user/{userId}",
                HttpMethod.GET,
                null,
                User.class,
                userId
        );

        user = restExchange.getBody();

        if(user != null){
            cacheUser(user);
        }

        return user;
    }

    private User checkRedisCache(Integer userId){
        try{
            return userRedisRepository.findUser(userId);
        }catch(Exception e){
            log.error("从缓存中取用户信息时出错了", e);
            return null;
        }
    }

    private void cacheUser(User user){
        try{
            userRedisRepository.saveUser(user);
        }catch(Exception e){
            log.error("将用户信息缓存到redis时出错了", e);
        }
    }



}
