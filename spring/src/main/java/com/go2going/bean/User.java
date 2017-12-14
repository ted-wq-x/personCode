package com.go2going.bean;

import lombok.*;

/**
 * 项目名称：  testcode<br>
 * 类名称：  User<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/12/13 0013 15:18
 */
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class User {
    @NonNull
    private String name;
    private Integer age;
}
