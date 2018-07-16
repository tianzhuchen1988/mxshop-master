package cn.com.ydream.user.mq;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface UserChangeSource {

    String OUTPUT = "userChangeOutput";

    @Output(OUTPUT)
    MessageChannel output();

}
