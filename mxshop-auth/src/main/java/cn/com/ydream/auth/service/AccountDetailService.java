package cn.com.ydream.auth.service;

import cn.com.ydream.auth.domain.Account;
import cn.com.ydream.auth.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AccountDetailService implements UserDetailsService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public UserDetails loadUserByUsername(String accountName) throws UsernameNotFoundException {

        Account account = new Account();
        account.setAccountName(accountName);
        account = accountMapper.selectOne(account);

        if(account == null){
            throw new UsernameNotFoundException(accountName);
        }

        return account;
    }
}
