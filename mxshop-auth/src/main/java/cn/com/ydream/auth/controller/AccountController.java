package cn.com.ydream.auth.controller;

import cn.com.ydream.auth.domain.Account;
import cn.com.ydream.auth.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping(value = "/users")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/current", method = RequestMethod.GET)
    public Principal currentUser(Principal principal){
        return principal;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createNewUser(@Valid @RequestBody Account account){
        accountService.createUser(account);
    }
}
