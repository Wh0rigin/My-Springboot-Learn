package com.who.springboot.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

@Data
@TableName(value="t_product")
public class Product {
    private Long id;
    private String name;
    private Integer price;

    // 标识乐观锁版本号字段
    @Version
    private Integer version;
}
