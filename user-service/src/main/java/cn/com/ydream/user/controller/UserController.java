package cn.com.ydream.user.controller;

import cn.com.ydream.user.domain.User;
import cn.com.ydream.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

/**
 * <p>
 * 类描述：
 * </p>
 *
 * @author chentz
 * @version 0.1
 * @since 2018/07/10.
 */
@RestController
@RefreshScope
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Value("${example.property}")
    private String exampleProperty;

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public User getUser(@PathVariable("userId")Integer userId){
        return userService.findUserById(userId);
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.PUT)
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    public String demo(){

        //TODO 测试配置更新, 目前spring cloud版本没测试成功，待测！
        logger.info("exampleProperty: {}", exampleProperty);

        return "Hello oauth2";
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
    public void updateUser(Principal principal, @Valid @RequestBody User user){
        userService.updateUser(principal.getName(), user);
    }

    public String getExampleProperty() {
        return exampleProperty;
    }

    public void setExampleProperty(String exampleProperty) {
        this.exampleProperty = exampleProperty;
    }
}
