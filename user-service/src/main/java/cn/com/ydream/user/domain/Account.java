package cn.com.ydream.user.domain;

import com.esotericsoftware.kryo.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

@Data
public class Account implements Serializable {
    private static final long serialVersionUID = 8394931396561738603L;

    @NotNull
    @Length(min = 3, max = 20)
    private String accountName;

    @NotNull
    @Length(min = 6, max = 40)
    private String accountPassword;


}
