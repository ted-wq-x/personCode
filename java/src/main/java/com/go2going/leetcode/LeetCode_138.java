package com.go2going.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_138<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2018/1/25 0025 9:25
 */
public class LeetCode_138 {
    Map<Integer, RandomListNode> map = new HashMap<>();

    /**
     * 虽然性能不好，但是简洁明了
     * @param head
     * @return
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return head;
        }
        RandomListNode node = map.get(head.label);
        if (node == null) {
            node = new RandomListNode(head.label);
            map.put(head.label, node);
        } else {
            return node;
        }


        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);

        return node;
    }

    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }
}
