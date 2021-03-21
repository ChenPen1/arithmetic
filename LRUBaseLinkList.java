package com.southwind.DataStrcture;

import java.util.Scanner;

/**
 * implements a linkedlist function
 * @author hotwind
 */
public class LinkTable {
    /**
     * head 哨兵节点
     * tail 尾节点
     * capacity 为链表的最大容量
     * size 为链表长度
     * DEFAULT_CAPACITY
     */
    private Node head;
    private Node tail;
    private int capacity;
    private int size = 0;
    private final static int DEFAULT_CAPACITY=5;

    /**
     * 构造函数，创造一个head的哨兵节点，
     * @param n
     */
    public LinkTable(int n){
        head = new Node();
        tail = head;
        this.capacity = n;
    }
    public LinkTable(){
        head = new Node();
        tail = head;
        this.capacity=DEFAULT_CAPACITY;
    }

    /**
     * 向链表中插入数据，首先判断是否存在
     * @param value
     */
    public void add(int value){

        Node p;
        Node head1;
        if((p=checkUo(value))!=null){
            //删除
            deleteNode(p);
            //插入
            insertNode(value);
        }else {
            if (size >= capacity) {
                deleteTail();
            }
            insertNode(value);

        }

    }
    public void insertNode(int value){
        Node head1 = head.next;
        Node node = new Node(value);
        node.next = head1;
        head.next = node;
        size++;
    }
    public void deleteTail(){
        Node sencondNode = head;
        while (sencondNode.next.next!=null){
            sencondNode = sencondNode.next;

        }
        sencondNode.next=null;
    }
    public void deleteNode(Node p){
        Node head1 = head;
        while (head1.next!=p){
            head1 = head1.next;
        }
        head1.next = p.next;
        p=null;
    }

    /**
     * 遍历链表，是否有重复元素
     * @param i
     */
    public Node checkUo(int i){
        Node head1 = head.next;
        while (head1!=null){
            if(head1.value==i){
                return head1;
            }
            head1 = head1.next;
        }
        return null;
    }
    public void printAll(){
        Node head1 = head.next;
        while (head1!=null){
            System.out.print(head1.value+",");
            head1=head1.next;
        }
    }
    public static void main(String[] args) {
        LinkTable linkTable = new LinkTable();
        Scanner scanner = new Scanner(System.in);
        while (true){
            linkTable.add(scanner.nextInt());
            linkTable.printAll();

        }

    }
    public class Node {
    public int value;
    public Node next;
    public Node(){ }
    public Node(int value){ this.value=value; }
}


}
