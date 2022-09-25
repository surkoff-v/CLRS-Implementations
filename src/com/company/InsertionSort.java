package com.company;

public class InsertionSort {

    public static void insertionSort(int[] a){
        for (int j=1;j<a.length;j++){
            int i = j-1;
            int key = a[j];
            while (i>=0 && a[i]>key){
                a[i+1]=a[i];
                --i;
            }
            a[i+1] = key;
        }
    }

    public static void main(String ...arr){
        int[] a = {5,6,1,4,9,2,7,11,0};
        insertionSort(a);
        for(int i =0; i<a.length; i++){
            System.out.print(a[i]+" ");
        }

    }
}
