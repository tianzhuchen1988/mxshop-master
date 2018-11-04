package cn.com.ydream.user.domain;

import com.esotericsoftware.kryo.NotNull;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
public class Demo implements Serializable {

    private static final long serialVersionUID = 6380161494122702748L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "demo_id")
    private Integer demoId;

    @Column(name = "demo_name")
    @NotNull
    @Length(min = 5, max = 20)
    private String demoName;

    @Column(name = "demo_status")
    private DemoStatusEnum demoStatus;

    @Column(name = "create_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @Column(name = "create_id")
    private Integer createId;

    @Column(name = "update_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    @Column(name = "update_id")
    private Integer updateId;
}

