package cn.com.ydream.user.client;

import cn.com.ydream.user.domain.Product;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "product-service")
public interface ProductFeignClient {
    @RequestMapping(value = "/product/saveProduct", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Product saveProduct(Product product);

    @RequestMapping(value = "/product/{productId}", method = RequestMethod.GET)
    Product getProduct(@PathVariable("productId") Integer productId);

}
