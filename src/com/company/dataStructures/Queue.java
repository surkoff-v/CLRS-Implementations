package com.company.dataStructures;

public class Queue {

    static int head = Integer.MIN_VALUE;
    static int tail = 0;

    static int[] arr = new int[6];

    public static void enqueue(int x) {

        if (tail == head) {
            throw new RuntimeException("owerflow");
        }

        if (head == Integer.MIN_VALUE) {
            head = tail;
        }

        arr[tail] = x;
        if (tail == arr.length - 1) {
            tail = 0;
        } else {
            ++tail;
        }

        // printarr();
    }

    public static int dequeue() {

        if (head == Integer.MIN_VALUE) {
            throw new RuntimeException("underflow");
        }

        int res = arr[head];
        if (head == arr.length - 1) {
            head = 0;
        } else {
            ++head;
        }

        if (head == tail) {
            head = Integer.MIN_VALUE;
        }


        return res;
    }

    static void printarr() {

        System.out.println("head " + head + " tail " + tail);


        for (int i = 0; i < arr.length; i++) {
            if (head == Integer.MIN_VALUE) {
                System.out.print(" _ ");
            } else if (head < tail) {
                if (i < head) {
                    System.out.print(" _ ");
                } else if (head <= i && i < tail) {
                    System.out.print(" " + arr[i] + " ");
                } else
                    System.out.print(" _ ");
            } else if (head == tail) {
                System.out.print(" " + arr[i] + " ");
            } else {
                if (i < tail) {
                    System.out.print(" " + arr[i] + " ");
                } else if (i >= tail && i < head) {
                    System.out.print(" _ ");
                } else {
                    System.out.print(" " + arr[i] + " ");
                }
            }

        }
        System.out.println();
    }

    public static void main(String... arr) {
        enqueue(1);
        enqueue(2);
        enqueue(3);
        enqueue(4);
        enqueue(5);
        enqueue(6);
        dequeue();
        dequeue();
        enqueue(7);
        enqueue(8);
        dequeue();
        dequeue();
        dequeue();
        dequeue();
        dequeue();
        dequeue();
        printarr();
    }
}
