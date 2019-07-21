package com.wenthkim.linklist;

public class Node<T> {

    /**
     * 值
     */
    private T t;

    /**
     * 下一个
     */
    private Node next;


    public Node(T t, Node next) {
        this.t = t;
        this.next = next;
    }


    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
