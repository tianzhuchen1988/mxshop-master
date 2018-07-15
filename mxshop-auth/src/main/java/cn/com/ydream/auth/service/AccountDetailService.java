package cn.com.ydream.auth.service;

import cn.com.ydream.auth.domain.Account;
import cn.com.ydream.auth.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AccountDetailService implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String accountName) throws UsernameNotFoundException {

        Account account = accountRepository.findByAccountName(accountName);

        if(account == null){
            throw new UsernameNotFoundException(accountName);
        }

        return account;
    }
}
