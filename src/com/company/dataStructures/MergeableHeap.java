package com.company.dataStructures;

/**
 * Problem 10.2
 * Mergeable heaps using linked lists
 * Lists are sorted.
 */
class Node{
    int key;
    Node next;

    public Node(int key) {
        this.key = key;
    }

    public Node() {

    }
}

class Heap {

    Node head;

    public Heap(int key) {
        this.head = new Node(key);
    }

    public Heap() {

    }

    public void pushSorded(int key){
       Node cr = this.head;

       if (cr.key > key){
           Node n = new Node(key);
           n.next = head;
           head = n;
           return;
       }

       while (cr.next!=null && cr.next.key < key){
           cr = cr.next;
       }

       Node n= new Node(key);
       n.next = cr.next;
       cr.next = n;
    }

    public void printHeap(){
        Node cr = this.head;
        while (cr!=null){
            System.out.print(" "+cr.key+" ");
            cr = cr.next;
        }

        System.out.println();
    }

}

public class MergeableHeap {

     public Heap mergeSorted(Node h1,Node h2){
         Heap heap = new Heap();
         Node n = new Node();
         heap.head = n;

         while (h1!=null && h2!=null){
             if (h1.key < h2.key){
               n.next = h1;
               h1=h1.next;
               n=n.next;
             } else {
               n.next = h2;
               h2=h2.next;
               n=n.next;
             }
         }

         if (h1!=null){
             n.next = h1;
         } else {
             n.next = h2;
         }

         heap.head = heap.head.next;
         return heap;
     }

    public static void main(String ...args){
        Heap h1 = new Heap(1);
        h1.pushSorded(3);
        h1.pushSorded(5);
        h1.pushSorded(7);
        h1.pushSorded(9);
        h1.pushSorded(11);
        h1.pushSorded(13);
        h1.pushSorded(15);
        h1.pushSorded(17);

        h1.printHeap();

        Heap h2 = new Heap(2);
        h2.pushSorded(4);
        h2.pushSorded(6);
        h2.pushSorded(8);
        h2.pushSorded(10);
        h2.pushSorded(12);
        h2.pushSorded(14);
        h2.pushSorded(16);
        h2.pushSorded(18);

        h2.printHeap();

        MergeableHeap mergeableHeap = new MergeableHeap();
        Heap heap = mergeableHeap.mergeSorted(h1.head, h2.head);

        heap.printHeap();


    }


}