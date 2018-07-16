package cn.com.ydream.product.mq.receiver;

import cn.com.ydream.product.domain.User;
import cn.com.ydream.product.mq.UserChangeSink;
import cn.com.ydream.product.repository.UserRedisRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * <p>
 * 类描述：使用stream消费消息
 * </p>
 *
 * @author chentz
 * @version 0.1
 * @since 2018/07/16.
 */
@Slf4j
@EnableBinding(UserChangeSink.class)
public class UserChangeReceiver {

    @Autowired
    private UserRedisRepository userRedisRepository;

    @StreamListener(UserChangeSink.INPUT)
    public void handle(User user){
        log.info("使用stream消费消息测试：消息内容 {}", user.getUserName());
        log.info("更新redis缓存中的用户信息, {}", user.getUserId());
        userRedisRepository.updateUser(user);
    }
}
