package cn.com.ydream.auth.security;

import cn.com.ydream.auth.config.ServiceConfig;
import cn.com.ydream.auth.service.AccountDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

/**
 * OAuth2Config定义了什么应用程序可以使用你所保护的服务
 */
@Configuration
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {

    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    @Autowired
    private AccountDetailService userDetailsService;

    @Autowired
    private ServiceConfig serviceConfig;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // @formatter:off
        clients.inMemory()
                .withClient("browser")
                .authorizedGrantTypes("refresh_token", "password")
                .scopes("ui")
        .and()
                .withClient("user-service")
                .secret(serviceConfig.getUserServicePassord())
                .authorizedGrantTypes("client_credentials", "password", "refresh_token")
                .scopes("server")
        .and()
                .withClient("product-service")
                .secret(serviceConfig.getProductServicePassword())
                .authorizedGrantTypes("client_credentials", "password", "refresh_token")
                .scopes("server");
        // @formatter:on
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService);
    }
}
