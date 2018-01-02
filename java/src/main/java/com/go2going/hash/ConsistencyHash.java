package com.go2going.hash;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 项目名称：  testcode<br>
 * 类名称：  ConsistencyHash<br>
 * 描述：一致性hash算法
 *
 * @author wangqiang
 * 创建时间：  2018/1/2 0002 16:09
 */
public class ConsistencyHash {

    private static final String[] ip = new String[]{"192.168.1.1", "192.168.1.2", "192.168.1.3", "192.168.1.4"};

    //使用红黑树存储hash和ip
    private static final SortedMap<Integer, String> hashIp = new TreeMap<>();


    static {
        for (int i = 0; i < ip.length; i++) {
            hashIp.put(getHash(ip[i]), ip[i]);
        }
    }

    /**
     * 匹配ip
     * @param name
     * @return
     */
    private static String matchServer(String name) {
        SortedMap<Integer, String> subMap = hashIp.tailMap(getHash(name));
        if (subMap.size() == 0) {
            return hashIp.get(hashIp.firstKey());
        }
        Integer integer = subMap.firstKey();
        return subMap.get(integer);
    }



    public static void main(String[] args) {

        String[] nodes = {"127.0.0.1:1111", "221.226.0.1:2222", "10.211.0.1:3333"};
        for (int i = 0; i < nodes.length; i++) {
            System.out.println("[" + nodes[i] + "]的hash值为" + getHash(nodes[i]) + ",被路由到的服务器为["
                    + matchServer(nodes[i]) + "]");
        }
    }
    /**
     * 使用FNV1_32_HASH算法计算hash值
     * @return
     */
    private static int getHash(String str){

        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < str.length(); i++) {
            hash = (hash ^ str.charAt(i)) * p;
        }
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;

        // 如果算出来的值为负数则取其绝对值
        if (hash < 0)
            hash = Math.abs(hash);
        return hash;
    }
}
