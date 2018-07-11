package cn.com.ydream.product.controller;

import cn.com.ydream.product.domain.Product;
import cn.com.ydream.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/{productId}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable("productId")Integer productId){
        return productService.findProductById(productId);
    }

    @RequestMapping(value = "/saveProduct", method = RequestMethod.PUT)
    public int saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

}
