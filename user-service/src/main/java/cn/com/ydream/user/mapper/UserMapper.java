package cn.com.ydream.user.mapper;

import cn.com.ydream.user.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper extends MyMapper<User>{
}
