package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_636<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2018/2/7 0007 13:55
 */
public class LeetCode_636 {


    /**
     * https://www.youtube.com/watch?v=Oi68_8xkxI4
     * 需要注意的点是，比如end在6，那么其实是终止在7之前，6到7这段时间也是算上的
     *
     * @param n
     * @param logs
     * @return
     */
    public int[] exclusiveTime(int n, List<String> logs) {
        //直接在数组中进行累和
        int[] ints = new int[n];
        //记录id
        Stack<Integer> stack = new Stack<>();
        //记录时间点
        int pre = 0;
        for (String log : logs) {
            String[] split = log.split(":");
            int id = Integer.parseInt(split[0]);
            int time = Integer.parseInt(split[2]);
            if (split[1].equals("start")) {
                //start
                if (!stack.isEmpty()) {
                    //记录之前的start的id使用了多久,也就是多个start之间
                    ints[stack.peek()] += time - pre;
                }
                //将当前的id放到栈中
                stack.push(id);
                pre = time;
            } else {
                //end，注意+1
                ints[stack.pop()] += time - pre + 1;
                pre = time + 1;
            }

        }

        return ints;
    }

    public static void main(String[] args) {
        LeetCode_636 leetCode_636 = new LeetCode_636();
        ArrayList<String> logs = new ArrayList<>();
        logs.add("0:start:0");
        logs.add("1:start:2");
        logs.add("1:end:5");
        logs.add("0:end:6");
        int[] ints = leetCode_636.exclusiveTime(2, logs);

        System.out.println(Arrays.toString(ints));
    }

}
