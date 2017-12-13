package com.go2going.spi;

import java.sql.*;

/**
 * 项目名称：  testcode<br>
 * 类名称：  Main<br>
 * 描述：spi的配置文件的位置位于jar包的 "META-INF/services/"下，参考mysql的jar,名称是全限定名
 * 参考：http://cxis.me/2017/04/17/Java%E4%B8%ADSPI%E6%9C%BA%E5%88%B6%E6%B7%B1%E5%85%A5%E5%8F%8A%E6%BA%90%E7%A0%81%E8%A7%A3%E6%9E%90/
 *
 * @author wangqiang
 * 创建时间：  2017/12/12 0012 20:57
 */
public class Main {
    public static void main(String[] args) {
        try {
            /**
             * spi的调用在DriverManager中的静态代码块，都是由jdk提供的。
             *
             */
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/cachedb?useSSL=false",
                    "cache", "cache");

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM HTM_HOTEL_PRICE_1");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getString("fk_hotel_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
