package com.company.sorting;

import java.util.ArrayList;

public class BucketSort {
    static void bucketSort(double[] a){

        ArrayList<Double>[] b = new ArrayList[a.length];
        for (int i = 0; i < b.length; i++) {
            b[i] = new ArrayList<>();
        }

        for (int i = 0; i < a.length; i++) {
            b[(int)Math.floor(a.length*a[i])].add(a[i]);
        }

        for (int i = 0; i < a.length; i++) {
            insertionSort(b[i]);
        }

        for (int j = 1; j < b.length; j++) {
            b[0].addAll(b[j]);
        }

        for(int j=0;j<b.length;j++){
            a[j] = b[0].get(j);
        }
    }

    static void printarr(double[] a){
        for (int i = 0; i < a.length; i++) {
                System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    static void insertionSort(ArrayList<Double> a){
        for (int i = 1;i<a.size();i++){
             Double key = a.get(i);
             int j = i-1;
             while (j>=0 && a.get(j)>key){
                 a.set(j+1,a.get(j));
                 j--;
             }
             a.set(j+1,key);
        }
    }

    public static void main(String ...arr){
        double[] a = {.17,.54,.87,.33,.9,.21,.63,.55,.14,.37};
        bucketSort(a);
        printarr(a);
    }
}
