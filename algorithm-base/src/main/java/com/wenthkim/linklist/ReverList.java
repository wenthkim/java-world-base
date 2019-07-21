package com.wenthkim.linklist;

/**
 * 反转链表
 */
public class ReverList {


    public static void main(String[] args) {

        Node<Integer> node5 = new Node<>(5,null);
        Node<Integer> node4 = new Node<>(4,node5);
        Node<Integer> node3 = new Node<>(3,node4);
        Node<Integer> node2 = new Node<>(2,node3);
        Node<Integer> node1 = new Node<>(1,node2);

        Node head = reversion(node1,null);




        while (head != null) {
            System.out.print(head.getT() + "->");
            head = head.getNext();
        }
        System.out.print("null");

    }

    /**
     * 反转链表，3指针
     * @param head
     * @return
     */
    public static Node reverList(Node head) {
       Node pre = null;
       //记录当前指针
       Node cur = head;

       while (cur != null) {
           //先把cur.next记录
           Node temp = cur.getNext();
           cur.setNext(pre);
           pre = cur;
           cur = temp;
       }
       return pre;
    }

    /**
     * 递归
     * @param head
     * @param pre
     * @return
     */
    public static Node reversion(Node head,Node pre) {

        if (head == null) {
            return pre;
        }
        //记录当前指针
        Node next = head.getNext();
        head.setNext(pre);
        pre = head;
        head = next;
        return reversion(head,pre);
    }

}
