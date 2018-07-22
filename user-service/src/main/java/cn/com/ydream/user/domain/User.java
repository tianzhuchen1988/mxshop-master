package cn.com.ydream.user.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
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
@Entity
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "age")
    @Range(min = 1, max = 110)
    private Integer age;

    @Column(name = "gender")
    private Gender gender;

    public User(){}
}
