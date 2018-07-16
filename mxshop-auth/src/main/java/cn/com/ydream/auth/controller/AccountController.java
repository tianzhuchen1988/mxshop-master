package cn.com.ydream.auth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping(value = "/users")
public class AccountController {

    @RequestMapping(value = "/current", method = RequestMethod.GET)
    public Principal currentUser(Principal principal){
        return principal;
    }
}
