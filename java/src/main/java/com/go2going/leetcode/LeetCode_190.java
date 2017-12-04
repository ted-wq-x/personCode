package com.go2going.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_190<br>
 * 描述：对于bit的操作很陌生
 *
 * @author wangqiang
 * 创建时间：  2017/12/4 0004 9:06
 */
public class LeetCode_190 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;

        //思考的时候不要考虑result是十进制的数
        for (int i = 0; i < 32; i++) {
            result += n & 1;//取最后一位,二进制的位数
            n >>>= 1;//无符号右移一位
            if (i < 31) // CATCH: for last digit, don't shift!
                result <<= 1;//左移，用于接纳下一次循环取出的位数，result存储的是十进制
        }

        return result;
    }

    //缓存每个byte在翻转之后的十进制数字
    Map<Byte, Integer> cache = new HashMap<>();


    public int reverseBits1(int n) {

        byte[] bytes = new byte[4];

        for (int i = 0; i < 4; i++) {
            //将原有的32位分为4个字节bytes（每个字节8位byte）
            bytes[i] = (byte) ((n >>> i * 8) & 0xFF);
        }

        int result = 0;

        for (int i = 0; i < 4; i++) {

            result += reverseByte(bytes[i]);

            if (i != 3) {
                result <<= 8;
            }
        }

        return result;
    }

    /**
     * byte:-128-->127(共8位，有符号位)
     *
     * @param b
     * @return
     */
    public int reverseByte(byte b) {
        Integer integer = cache.get(b);

        if (integer != null) {
            return integer;
        }

        integer = 0;

        for (int i = 0; i < 8; i++) {
            integer += (b >>> i) & 1;//取每一位

            if (i != 7) {
                integer <<= 1;//和上面的注释是一样的
            }
        }

        cache.put(b, integer);
        return integer;
    }
}
