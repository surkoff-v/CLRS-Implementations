package com.company.dataStructures;

public class SingleLinkedListRevers {

    public Node nill = null;

    public SingleLinkedListRevers(){
        nill = new Node();
        nill.next = nill;
    }

    private static class Node{
        Node next;
        int key;
    }

    public void insert(int x){
        Node newnode = new Node();
        newnode.key = x;
        newnode.next = nill.next;
        nill.next = newnode;
    }

    void revers(){
        Node next;
        Node c = nill.next;
        Node prev = nill;
        while (c!=nill){
            next = c.next;
            c.next=prev;
            prev = c;
            c=next;
        }
        nill.next = prev;
    }

    public void prlist(){
        Node c = nill.next;
        while (c!=nill){
            System.out.print(c.key+"->");
            c = c.next;
        }
        System.out.println();
    }

    public static void main(String ...arr){
        SingleLinkedListRevers list = new SingleLinkedListRevers();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        list.prlist();

        list.revers();
        list.prlist();

    }

}
