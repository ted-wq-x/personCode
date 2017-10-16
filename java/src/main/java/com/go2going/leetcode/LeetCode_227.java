package com.go2going.leetcode;

import java.util.Stack;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_227<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/10/16 0016 14:06
 */
public class LeetCode_227 {


    //将运算符号全变成+
    public int calculate(String s) {
        int len;
        if(s==null || (len = s.length())==0) return 0;
        Stack<Integer> stack = new Stack<>();
        int num = 0;

        //存储操作，第一个数就是+
        char sign = '+';
        for(int i=0;i<len;i++){

            //将字符串变成数字
            if(Character.isDigit(s.charAt(i))){
                num = num*10+s.charAt(i)-'0';
            }

            //1. 不是数字且部位空
            //2. 是最后一个数字
            if((!Character.isDigit(s.charAt(i)) &&' '!=s.charAt(i)) || i==len-1){
                if(sign=='-'){
                    stack.push(-num);
                }
                if(sign=='+'){
                    stack.push(num);
                }
                if(sign=='*'){
                    stack.push(stack.pop()*num);
                }
                if(sign=='/'){
                    stack.push(stack.pop()/num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }

        //将所有数累加
        int re = 0;
        for(int i:stack){
            re += i;
        }
        return re;
    }

}
