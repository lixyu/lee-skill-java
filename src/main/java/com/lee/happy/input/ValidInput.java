package com.lee.happy.input;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

/**
 * @author lee
 * @date 2019/2/14
 */
@Data
@NoArgsConstructor
public class ValidInput {

    @NotNull(message = "姓名不能为空")
    private String name;
    @Size(min = 3,max = 10,message = "地址长度不规范")
    private String address;
    @Min(value = 7,message = "小了")
    @Max(value = 13,message = "大了")
    private int age;
    @Email(message = "电子邮件不规范")
    private String email;
    @Pattern(regexp = "^1\\d{10}$",message = "手机号不正确")
    private String mobile;

    public ValidInput(String name,String address,int age, String email, String mobile) {
        this.name = name;
        this.address = address;
        this.age = age;
        this.email = email;
        this.mobile = mobile;
    }
}
