package cn.com.ydream.user.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 类描述：
 * </p>
 *
 * @author chentz
 * @version 0.1
 * @since 2018/07/10.
 */
@Component
@Data
public class ServiceConfig {
    @Value("${example.property}")
    private String exampleProperty;
}
