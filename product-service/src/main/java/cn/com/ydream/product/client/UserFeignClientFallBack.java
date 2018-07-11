package cn.com.ydream.product.client;

import cn.com.ydream.product.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserFeignClientFallBack implements UserFeignClient{
    @Override
    public User getUser(Integer userId) {
        //远程调用出现异常时，进行服务降级时，需要注意结合实际业务返回信息，防止误导，如查询余额，降级处理时，就不应该返回0，这样会导致歧义
        System.out.println("远程调用失败，进入降级处理");
        return null;
    }
}
