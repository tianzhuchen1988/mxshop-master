package cn.com.ydream.user.controller;

import cn.com.ydream.user.domain.User;
import cn.com.ydream.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public User getUser(@PathVariable("userId")Integer userId){
        return userService.findUserById(userId);
    }
}
