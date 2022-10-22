package com.company.dataStructures;

public class Deque {

    static int[] arr = new int[6];

    static int head = 0;
    static int tail = 0;
    static int cnt = 0;

    /**
     * Head
     * @param x
     */
    static void addFirst(int x){

        if (cnt == arr.length) {
            throw new RuntimeException("owerflow");
        } else {
            --head;
            if (head < 0) {
                head = arr.length-1;
            }
            arr[head]=x;
            ++cnt;
        }
    }

    /**
     * Head
     */
    static int removeFirst(){
            if (cnt == 0) {
                throw new  RuntimeException("underflow");
            }
            int res=arr[head];
            arr[head]=Integer.MIN_VALUE;
            ++head;
            if (head==arr.length) {
                head=0;
            }
            --cnt;
            return res;
    }

    /**
     * Tail
     * @param x
     */
    static void addLast(int x){
        if (cnt==arr.length){
            throw new RuntimeException("owerflow");
        }
        arr[tail]=x;
        tail++;
        cnt++;
        if (tail==arr.length){
            tail = 0;
        }
    }

    /**
     * Tail
     */
    static int removeLast(){
           if (cnt == 0){
               throw new RuntimeException("underflow");
           }
           tail--;
           if(tail<0){
               tail = arr.length-1;
           }
           int res = arr[tail];
           arr[tail]=Integer.MIN_VALUE;
           --cnt;
           return res;
    }

    static void printarr(){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" "+arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String ...arr){
        addFirst(1);printarr();
        addFirst(4);printarr();
        addLast(2);printarr();
        addLast(3);printarr();
        removeFirst();printarr();
        removeLast();printarr();
        removeLast();printarr();
        removeLast();printarr();
        removeLast();printarr();
    }
}
