package com.company.dataStructures;

/**
 * Exercise 10.3.2
 * Write the procedures ALLOCATE-OBJECT
 * and FREE-OBJECT for a homogeneous collection of objects implemented by the single-array representation.
 * not finished
 */
public class LinkedListInSingleArray {
    int MAX = 10;
    int[] arr = new int[MAX*3];
    int freeTop;
    int head = -1;
    int tail = -1;

    public LinkedListInSingleArray(){
        arr[next(0)] = -1;
        for (int i = 3;i<MAX*3;i+=3){
            arr[next(i)] = i-3;
        }
        freeTop = MAX*3-3;
    }

    public void printArr(){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" "+arr[i]+" ");
        }
        System.out.println();
    }


    int next(int i){
        return i+2;
    }

    int prev(int i){
        return i;
    }

    int key(int i){
        return i+1;
    }

    int insert(int key){
        int n = allocNew();

        if (tail!=-1){
            arr[next(arr[prev(tail)])] = n;
        }

        arr[prev(n)] = tail;
        arr[key(n)] = key;
        arr[next(n)] = -1;
        tail = n;
        return n;
    }

    public int allocNew(){
        int n;
        if (arr[freeTop] == -1){
            throw new RuntimeException("array is full");
        } else {
             n = freeTop;
             freeTop = arr[next(freeTop)];
        }
        return n;
    }

    void free(int i){
        arr[key(i)] = 0;
        arr[next(i)]=freeTop;
        freeTop = i;
    }

    int delete(int i){
        if (arr[prev(i)]!=-1) {
            arr[next(arr[prev(i)])] = arr[next(i)];
        } else {
            arr[next(arr[prev(i)])] = -1;
        }

        if (arr[next(i)]!=-1) {
            arr[prev(arr[next(i)])] = arr[prev(i)];
        } else {
            arr[prev(arr[next(i)])] = -1;
        }

        free(i);
        return 0;
    }

    public static void main(String ...arr){
        LinkedListInSingleArray l = new LinkedListInSingleArray();
        l.printArr();
        l.insert(100);
        l.insert(101);
        l.insert(102);
        l.printArr();
    }

}
