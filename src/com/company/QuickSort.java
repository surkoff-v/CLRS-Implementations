package com.company;

import java.sql.SQLOutput;

public class QuickSort {



    static int patritioning(int[] a,int p,int r){
        int i=p-1;
        int x = a[r];
        int j=p;
        while (j<=r-1){
            if (a[j] <= x){
                ++i;
                int buf = a[i];
                a[i] = a[j];
                a[j] = buf;
            }
            ++j;

            for (int k=0;k<a.length;k++){
                System.out.print(a[k]+" ");
            }
            System.out.println();
        }

        int buf = a[i+1];
        a[i+1] = a[r];
        a[r] = buf;

        System.out.println();

        for (int k=0;k<a.length;k++){
            System.out.print(a[k]+" ");
        }


        return i+1;
    }

    static void quickSort(int[] a, int p, int r){
        if (p<r) {
            int pivot = patritioning(a, p, r);
            quickSort(a, p, pivot - 1);
            quickSort(a, pivot + 1, r);
        }

    }

    public static void main(String ...arr){
        int a[] = {5,11,2,7,3,9,10,1,8};
        quickSort(a,0,a.length-1);
        for (int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }

    }

}
