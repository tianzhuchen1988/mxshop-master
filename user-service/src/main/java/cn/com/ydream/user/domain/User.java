package cn.com.ydream.user.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 类描述：
 * </p>
 *
 * @author chentz
 * @version 0.1
 * @since 2018/07/10.
 */
@Data
public class User implements Serializable{
    private Integer userId;
    private String userName;
}
