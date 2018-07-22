package cn.com.ydream.user.client;

import cn.com.ydream.user.domain.Account;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "mxshop-auth")
public interface AuthFeignClient {

    @RequestMapping(value = "/uaa/users", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    void createNewUser(Account account);
}
