package com.rin.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
@Data
@NoArgsConstructor
@ApiModel(description = "用户实体")
public class User {

    @Id
    @GeneratedValue
    @ApiModelProperty("用户编号")
    private long id;

    @NotNull
    @Size(min = 2,max = 10)
    @ApiModelProperty("用户姓名")
    private String name;

    @NotNull
    @Min(10)
    @Max(100)
    @ApiModelProperty("用户年龄")
    private Integer age;

    @NotNull
    @Email
    @ApiModelProperty(value = "用户邮箱",example = "wangyi@163.com")
    private String email;

    public User(String name, Integer age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
}
