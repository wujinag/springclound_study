package com.wuj.pojo;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Builder
@Accessors(chain = true)//链式写法
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Data
public class Dept implements Serializable {

    private long deptNo;//主键
    private String deptName;
    //一个微服务对应一个数据库
    private String dataSource;
    /**
     * 链式写法：Dept o = new Dept()
     * o.setXX().setXX();
     */
}
