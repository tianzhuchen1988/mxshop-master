package cn.com.ydream.user.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Product implements Serializable {
    private static final long serialVersionUID = 203115408244789128L;

    private Integer productId;
    private String productName;

    public Product(){}
}
