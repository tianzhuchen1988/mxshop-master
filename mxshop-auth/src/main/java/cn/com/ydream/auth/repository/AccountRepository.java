package cn.com.ydream.auth.repository;

import cn.com.ydream.auth.domain.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Integer> {

    Account findByAccountName(String accountName);

}
