package cn.com.ydream.product.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private static final long serialVersionUID = 2160874953824386281L;
    private Integer userId;
    private String userName;

    public User(){}
}
