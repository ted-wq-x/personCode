package com.go2going.datastructue;

/**
 * 项目名称：  testcode<br>
 * 类名称：  Node<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/11/8 0008 16:51
 */
public class Node<T> {
    public T value;
    public Node<T> next;

    public Node(T value) {
        this.value = value;
    }
}
