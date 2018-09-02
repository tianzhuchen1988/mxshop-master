package cn.com.ydream.product.client;

import cn.com.ydream.product.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "user-service", fallback = UserFeignClientFallBack.class)
public interface UserFeignClient {

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    User getUser(@PathVariable("userId")Integer userId);
}
