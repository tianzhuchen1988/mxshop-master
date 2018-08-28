package cn.com.ydream.user.service;

import cn.com.ydream.user.client.AuthFeignClient;
import cn.com.ydream.user.client.ProductFeignClient;
import cn.com.ydream.user.domain.User;
import cn.com.ydream.user.repository.UserRepository;
import cn.com.ydream.user.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private ProductFeignClient productFeignClient;

    @Mock
    private AuthFeignClient authFeignClient;

    @Mock
    private Environment env;

    @Before
    public void setup() {
        initMocks(this);
    }

    @Test
    public void shouldFindById(){
        final User user = new User();
        user.setUserId(1003);

        User find = userService.findUserById(user.getUserId());

        assertNull(find);
    }

}
