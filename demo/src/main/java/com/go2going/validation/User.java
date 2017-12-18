package com.go2going.validation;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 项目名称：  testcode<br>
 * 类名称：  User<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/9/29 0029 9:41
 */
@Data
@AllArgsConstructor
public class User {
    @NotNull(message = "用户的姓名不能为空")
    private String name;
    @NotNull(message = "年龄不能为空")
    @Min(value = 2,message = "年龄必须在2到14岁之间")
    @Max(value = 14,message = "年龄必须在2到14岁之间")
    private Integer age;
}
