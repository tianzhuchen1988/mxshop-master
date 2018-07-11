package cn.com.ydream.auth.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class ServiceConfig {
    @Value("${user.service.password}")
    private String userServicePassord;

    @Value("${product.service.password}")
    private String productServicePassword;
}
