package com.go2going;

import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * 项目名称：  testcode<br>
 * 类名称：  JSONTest<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2018/2/1 0001 9:59
 */
public class JSONTest {

    public static void main(String[] args) {


        Human human = JSON.parseObject("{\n" +
                "  \"Name\": \"wq\",\n" +
                "  \"Age\": 12,\n" +
                "  \"Baby\":{\n" +
                "    \"ids\":122,\n" +
                "    \"cc\":\"wqdwd\"\n" +
                "  }\n" +
                "}", Human.class);

        System.out.println(human);
    }


}
@Data
class Human {
    private String name;
    private int age;
    private Baby baby;

}
@Data
class Baby {
    private String ids;
}



