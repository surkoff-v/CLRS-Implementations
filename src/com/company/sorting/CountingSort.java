package com.company.sorting;

public class CountingSort {

    public static void countingSort(int[] a,int[] b,int k){
        int[] c = new int[k+1];

        for (int i=0;i<a.length;i++){
            c[a[i]] = c[a[i]]+1;
        }
        for (int i = 1;i<=k;i++){
            c[i]=c[i]+c[i-1];
        }
        for (int i = a.length-1;i>=0;i--){
            b[c[a[i]]-1] = a[i];
            c[a[i]]=c[a[i]]-1;
        }

    }

    static void printArr(int a[]){
        for (int i = 0; i<a.length; i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    public static void main(String ...arr){
        int[] a = {2,5,3,0,2,3,0,3};
        int[] b = new int[8];
        int k = 5;
        countingSort(a,b,k);
        printArr(b);
    }

}
