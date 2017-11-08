package com.go2going.datastructue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 项目名称：  testcode<br>
 * 类名称：  Bag<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/11/8 0008 16:57
 */
public class Bag<T> implements Iterable<T> {
    /** 起始节点 */
    private Node<T> first;

    /** 元素的个数 */
    private int size;

    public Bag() {
        first = null;
        size = 0;
    }

    /**
     * Returns true if this bag is empty.
     *
     * @return {@code true} if this bag is empty;
     * {@code false} otherwise
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Returns the number of items in this bag.
     *
     * @return the number of items in this bag
     */
    public int size() {
        return size;
    }

    /**
     * Adds the item to this bag in first
     *
     * @param value the item to add to this bag
     */
    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.next = first;
        first = newNode;
        size++;
    }



    @Override
    public Iterator<T> iterator() {
        return new ListIterator<T>(first);
    }

    /**
     * 迭代的元素
     * @param <T>
     */
    private class ListIterator<T> implements Iterator<T> {
        private Node<T> current;

        public ListIterator(Node<T> current) {
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public T next() {

            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }

            T item = current.value;
            current = current.next;
            return item;
        }
    }

}
