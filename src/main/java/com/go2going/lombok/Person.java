package com.go2going.lombok;

import lombok.*;

/**
 * 项目名称：  testcode
 * 类名称：  Person
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/9/22 0022 15:34
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {
    @NonNull
    private String name;
    private String school;
    private Integer age;
}
