package com.go2going.validation;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.lang.annotation.*;

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
    @Min(value = 2, message = "年龄必须在2到14岁之间",groups = {GroupTest1.class})
    @Max(value = 15, message = "年龄必须在2到14岁之间",groups = {GroupTest1.class})
    private Integer age;
    @Valid
    @LocationValidation(message = "location 不ok", maxX = 12, maxY = 22,groups = {GroupTest2.class})
    private Location location;
}

@Data
@AllArgsConstructor
class Location {
    private int x;
    private int y;
}


/**
 * 校验的注解
 */
@Target({ElementType.FIELD})
@Constraint(validatedBy = {Temp.class})
@Documented
@Retention(RetentionPolicy.RUNTIME)
@interface LocationValidation {

    // 约束注解验证时的输出消息
    String message() default "";

    // 约束注解在验证时所属的组别
    Class<?>[] groups() default {};

    // 约束注解的有效负载
    Class<? extends Payload>[] payload() default {};
    int maxX() ;
    int maxY() ;

}

/**
 * 标记性接口，进行分组使用
 */
interface GroupTest1 {
}

interface GroupTest2 {
}


/**
 * 自己定义一些方法添加额外的拓展空间,这样在注解中传入参数，在验证时使用
 */
class MyRule implements Payload {

    public boolean isOk(){
        return true;
    }

}