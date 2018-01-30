package com.go2going.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 项目名称：  testcode<br>
 * 类名称：  MyBeanUtils<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2018/1/30 0030 15:33
 */
public class MyBeanUtils {


    /**
     * 将POJO的属性放到map当中，map的key为属性名称
     * @param object
     * @return
     */
    public Map<String, Object> convertPOJOAttrToMap(Object object) {

        Map<String, Object> map = new HashMap<>(16);
        Class<?> aClass = object.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        try {
            for (Field field : declaredFields) {
                field.setAccessible(true);
                String name = field.getName();
                char[] chars = name.toCharArray();
                //首字母小写
                chars[0]= Character.toLowerCase(chars[0]);
                String pascalName = new String(chars);
                Method method = aClass.getMethod("get" + name, null);
                Object invoke = method.invoke(object, null);
                map.put(pascalName, invoke);
            }
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return map;
    }
}
