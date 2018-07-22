package cn.com.ydream.auth.service.impl;

import cn.com.ydream.auth.domain.Account;
import cn.com.ydream.auth.repository.AccountRepository;
import cn.com.ydream.auth.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    private static final BCryptPasswordEncoder encode = new BCryptPasswordEncoder();

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void createUser(Account account) {
        Account existing = accountRepository.findByAccountName(account.getAccountName());

        Assert.isNull(existing, "用户名已存在" + account.getAccountName());

        String hash = encode.encode(account.getPassword());
        account.setAccountPassword(hash);

        accountRepository.save(account);

        log.info("创建了新用户：{}", account.getAccountName());

    }
}
