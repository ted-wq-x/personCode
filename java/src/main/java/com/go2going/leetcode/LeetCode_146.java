package com.go2going.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Least Recently Used
 */
public class LeetCode_146 {
    ///////////////////////////////////////////////////////////////////////////
    // 使用HashMap和双向链表，达到get和put时间复杂度都为O(1)
    // LinkedHashMap该类内部也是采用HashMap+双向链表实现的
    ///////////////////////////////////////////////////////////////////////////

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
class LRUCache2 {
    private static Map<Integer, Entry> map;

    //链表的开始和结束都是0,0

    /**
     * 链表尾部
     */
    private final Entry tail;

    /**
     * 链表头部
     */
    private final Entry head;

    private final int maxCapacity;


    /**
     * time: O(1)
     *
     * 使用HashMap的get实现O(1),链表实现put时O(1)的时间排序
     *
     * 链表头部存放最老的值，尾部存放最新的值
     *
     * @param capacity
     */
    public LRUCache2(int capacity) {
        map = new HashMap<>(capacity);
        tail = new Entry(0, 0);
        head = new Entry(0, 0);
        head.next = tail;
        tail.pre = head;
        this.maxCapacity = capacity;
    }

    /**
     * Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
     *
     * @param key
     * @return
     */
    public int get(int key) {
        if (map.containsKey(key)) {
            Entry entry = map.get(key);
            //移动到尾部
            popToTail(entry);
            return entry.value;
        }
        return -1;
    }

    /**
     * Set or insert the value if the key is not already present.
     * When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
     *
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Entry entry = map.get(key);
            entry.value = value;
            //移动到尾部
            popToTail(entry);

        } else {
            Entry entry = new Entry(key, value);
            if (map.size() >= maxCapacity) {
                Entry re = removeFirst();
                map.remove(re.key);
            }
            //放到尾部
            addToTail(entry);
            map.put(key, entry);
        }
    }

    /**
     * 链表
     */
    class Entry {
        int key;
        int value;
        Entry pre;
        Entry next;

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // 链表操作
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 将entry移动到链表末端(从链表中截取一个entry，插入到倒数第二个当中)
     * @param entry
     */
    private void popToTail(Entry entry) {
        Entry p = entry.pre;
        Entry n = entry.next;
        p.next = n;
        n.pre = p;
        Entry last = tail.pre;
        last.next = entry;
        entry.pre = last;
        entry.next = tail;
        tail.pre = entry;
    }

    /**
     * 删除头结点（其实是第二个）
     * @return
     */
    private Entry removeFirst() {

        Entry entry = head.next;
        Entry next = entry.next;
        head.next = next;
        next.pre = head;

        return entry;
    }

    /**
     * 添加到尾部（其实是插入到倒数第二的位置）
     * @param entry
     */
    private void addToTail(Entry entry) {
        Entry pre = tail.pre;

        pre.next = entry;
        entry.pre = pre;
        entry.next = tail;

        tail.pre = entry;
    }

}

class LRUCache {

    private static Map<Integer, Integer> map;

    /**
     * time: O(1)
     *
     * @param capacity
     */
    public LRUCache(int capacity) {
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }

    /**
     * Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
     *
     * @param key
     * @return
     */
    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    /**
     * Set or insert the value if the key is not already present.
     * When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
     *
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        map.put(key, value);
    }
}