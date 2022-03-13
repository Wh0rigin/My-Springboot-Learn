package com.who.springboot.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.*;

//@NoArgsConstructor // 无参构造
//@AllArgsConstructor // 含所有的构造方法
//// 添加 get set 方法
//@Getter
//@Setter

// 直接生成以上注释的所有
@Data
@TableName("user")
public class User {
    // 将属性所对应的字段指定为主键
    @TableId(value="id",type = IdType.AUTO)
    private Long id;

    // 锁定属性所对应字段名
    @TableField("name")
    private String name;

    @TableField("age")
    private Integer age;

    @TableField("email")
    private String email;

    // 逻辑删除字段
    @TableLogic
    private Integer isDelete;
}
