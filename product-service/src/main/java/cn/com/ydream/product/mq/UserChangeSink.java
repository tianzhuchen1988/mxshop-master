package cn.com.ydream.product.mq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface UserChangeSink {
    String INPUT = "userChangeInput";
    @Input(INPUT)
    SubscribableChannel input();
}
