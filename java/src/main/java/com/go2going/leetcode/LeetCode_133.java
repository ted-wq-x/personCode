package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * medium 还是很简单的
 */
public class LeetCode_133 {
    //保存被clone的对象
    Map<Integer, UndirectedGraphNode> map = new HashMap<>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        UndirectedGraphNode mapNode = map.get(node.label);
        if (mapNode != null) {
            return mapNode;
        }
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(node.label, clone);
        List<UndirectedGraphNode> neighbors = node.neighbors;
        for (UndirectedGraphNode neighbor : neighbors) {
            //递归clone
            clone.neighbors.add(cloneGraph(neighbor));
        }
        return clone;
    }



    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }


}
