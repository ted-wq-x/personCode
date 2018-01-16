package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_77<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2018/1/16 0016 14:26
 */
public class LeetCode_77 {

    List<List<Integer>> returnList = new ArrayList<>();

    /**
     * 回溯法，值得思考
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {

        get(new ArrayList<>(), k,1,n);

        return returnList;
    }


    /**
     * 没有顺序要求，所以直接可以室友start的方式，如果包含顺序的话，那就需要一个单独存储的容器存放未使用的数据
     * @param res
     * @param k
     * @param start
     * @param n
     */
    private void get(List<Integer> res, int k,int start,int n) {

        //这个判断对性能有巨大的提升，也就是我要取的数的个数，从start开始没有这么多，就直接return
        if (start + k > n+1) {
            return;
        }

        if (k == 0) {
            returnList.add(new ArrayList<>(res));
            return;
        }

        for (int i = start; i <=n; i++) {
            res.add(i);
            get(res, k - 1,i+1,n);
            res.remove(res.size() - 1);
        }
    }



}
