package cn.com.ydream.user.controller;

import cn.com.ydream.user.domain.User;
import cn.com.ydream.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/saveUser", method = RequestMethod.PUT)
    public int saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }
}
