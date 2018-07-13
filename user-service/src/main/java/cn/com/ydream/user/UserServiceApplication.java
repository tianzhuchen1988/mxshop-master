package cn.com.ydream.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * <p>
 * 类描述：
 * </p>
 *
 * @author chentz
 * @version 0.1
 * @since 2018/07/10.
 */
@SpringBootApplication
@RefreshScope
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
@EnableResourceServer
public class UserServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }
}
