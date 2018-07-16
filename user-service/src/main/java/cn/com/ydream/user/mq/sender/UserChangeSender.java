package cn.com.ydream.user.mq.sender;

import cn.com.ydream.user.domain.User;
import cn.com.ydream.user.mq.UserChangeSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;

/**
 * <p>
 * 类描述：使用stream发送消息
 * </p>
 *
 * @author chentz
 * @version 0.1
 * @since 2018/07/16.
 */
@EnableBinding(UserChangeSource.class)
public class UserChangeSender {

    private static final Logger logger = LoggerFactory.getLogger(UserChangeSender.class);

    @Autowired
    private UserChangeSource source;

    public void publish(User user){
        logger.info("使用stream发送消息测试：消息内容 {}", user.getUserName());
        source.output().send(MessageBuilder.withPayload(user).build());
    }

}
