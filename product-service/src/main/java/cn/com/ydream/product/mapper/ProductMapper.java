package cn.com.ydream.product.mapper;

import cn.com.ydream.common.mybatis.MyMapper;
import cn.com.ydream.product.domain.Product;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ProductMapper extends MyMapper<Product> {
}
