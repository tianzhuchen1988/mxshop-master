package cn.com.ydream.product.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * 限制仅有经过身份验证的用户有权访问
 */
@Configuration
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    /**
     * 访问规则设置为：只有通过auth认证服务器授权，并传递有效令牌才能访问该服务
     * @param httpSecurity
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeRequests()
                .anyRequest().authenticated();
    }

    /**
     * 访问规则为：管理员角色才能进行DELETE方法的调用
     */
    /*@Override
    public void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers(HttpMethod.DELETE, "/v1/organizations/**")
                .hasRole("ADMIN")
                .anyRequest()
                .authenticated();
    }*/
}
