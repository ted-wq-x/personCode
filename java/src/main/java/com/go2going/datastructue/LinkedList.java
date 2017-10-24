package com.go2going.datastructue;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LinkedList<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/10/23 0023 16:44
 */
public class LinkedList {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        Node<Integer> init = linkedList.init(10);
        System.out.println(init);
        System.out.println(reverseByRecur(init));
    }

    /**
     * 单链表
     * @param <E>
     */
    class Node<E> {

        E item;

        Node<E> next;

        //构造函数
        Node(E element) {
            this.item = element;
            this.next = null;
        }

        /**
         * 递归引用打印，没毛病
         * @return
         */
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            Node<E> next = this.next;
            E item = this.item;
            while (next != null) {
                sb.append(item);
                sb.append(",");
                item = next.item;
                next = next.next;
            }
            sb.append(item);
            sb.append("]");
            return sb.toString();
        }
    }


    /**
     * 链表的初始化
     * @param sum
     * @return
     */
    Node<Integer> init(int sum) {
        Node<Integer> node = new Node<>(0);
        Node<Integer> current=null;
        for (int i = 1; i < sum; i++) {
            Node<Integer> temp = new Node<>(i);
            if (i == 1) {
                node.next = temp;
            }else {
                current.next = temp;
            }
            current = temp;
        }
        return node;
    }


    /**
     * 优点绕脑子，mmp
     * @param head
     * @return
     */
    static Node<Integer> revList(Node<Integer> head) {

        if (head == null) {
            return null;
        }

        Node<Integer> ret=null,current=head;

        while (current != null) {
            Node<Integer> temp = current.next;
            current.next = ret;
            ret = current;
            current =temp;
        }
        return ret;
    }

    /**
     * 递归反转
     * 很难理解，mmp
     * 从最后往前理解，可以debug查看
     * @param current
     * @return
     */
    private static Node reverseByRecur(Node current) {
        if(current==null||current.next==null) return current;
        Node next = current.next;
        current.next = null;//结束递归的条件，将每个node解脱出来
        Node reverseByRecur = reverseByRecur(next);//递归的返回值为每个独立节点
        next.next=current ;//reverseByRecur返回总的链，在next.next上的赋值，由于next的引用地址和reverseByRecur中链的最后一个时相同的，所以在这上面新增就行
        return reverseByRecur;
    }
}
