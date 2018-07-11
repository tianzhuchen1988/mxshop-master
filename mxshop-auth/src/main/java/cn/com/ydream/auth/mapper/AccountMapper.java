package cn.com.ydream.auth.mapper;

import cn.com.ydream.auth.domain.Account;
import cn.com.ydream.common.mybatis.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface AccountMapper extends MyMapper<Account> {
}
