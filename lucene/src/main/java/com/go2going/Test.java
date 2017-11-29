package com.go2going;

import java.net.URISyntaxException;
import java.net.URL;

/**
 * 项目名称：  testcode<br>
 * 类名称：  Test<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/11/28 0028 11:14
 */
public class Test {
    public static void main(String[] args) throws URISyntaxException {
        URL resource = Test.class.getClass().getResource("/luceneIndexDir");

        System.out.println(resource.toURI().getPath());
    }
}
