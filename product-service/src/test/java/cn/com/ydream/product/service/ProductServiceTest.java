package cn.com.ydream.product.service;

import cn.com.ydream.product.client.UserFeignClient;
import cn.com.ydream.product.domain.Product;
import cn.com.ydream.product.repository.ProductRepository;
import cn.com.ydream.product.service.impl.ProductServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class ProductServiceTest {

    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private UserFeignClient userFeignClient;

    @Mock
    private ProductRepository productRepository;

    @Before
    public void setup() {
        initMocks(this);
    }

    @Test
    public void shouldFindProductById(){

        Product product = new Product();
        product.setProductId(1001);

        when(productService.findProductById(product.getProductId())).thenReturn(product);
        Product found = productService.findProductById(product.getProductId());

        assertEquals(product, found);

        verify(userFeignClient, times(2)).getUser(1003);
        verify(productRepository, times(1)).findById(product.getProductId()).get();
    }
}
