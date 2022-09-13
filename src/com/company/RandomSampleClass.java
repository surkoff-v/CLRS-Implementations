package com.company;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RandomSampleClass {
    /**
     * We want to create a random sample of the
     * set {1,2,3,…,n}, that is,
     * an m-element subset S, where n0≤m≤n,
     * such that each m-subset is equally likely to be created.
     * This method would make n calls to the RANDOM procedure.
     * @param m
     * @param n
     * @return
     */
    Set<Integer> randomSample(int m,int n){
        System.out.println(String.format("m=%s n=%s",m,n));
        if (m==0) {
            System.out.println("exit");
            return new HashSet<>();
        } else {
            System.out.println("else");
           Set<Integer> s = randomSample(m-1,n-1);
            System.out.print(String.format("min=%s max=%s",1,n));
           int i = new Random().nextInt(n-1 + 1) + 1;
            System.out.print(String.format(" i=%s ",i));
           if (s.contains(i)){
               System.out.println(String.format(" add n=%s ",n));
               s.add(n);
           } else {
               System.out.println(String.format(" add i=%s ",i));
               s.add(i);
           }
           return s;
        }
    }

     static int randomArraySearch(int[] arr,int x){
       int res = -1;
       var found = false;
       Set<Integer> badSat = new HashSet<>();
       do {
           int i = new Random().nextInt(arr.length);
           //System.out.println(String.format("i=%s",i));

           if (arr[i]==x) {
               res = i;
               found = true;
           } else {
               boolean add = badSat.add(i);
               if (add){
                   System.out.println(String.format("add=%s",i));
               }
           }

       } while(badSat.size()<arr.length && !found);

       return res;
    }

    /**
     * 6.2.5
     * @param arr
     * @param i
     * @return
     */
    static int[] heapify(int[] arr,int i){
        int largest = Integer.MIN_VALUE;
        if (i<=arr.length && (2*i+1)<=arr.length && arr[2*i+1]>arr[i]){
            largest = 2*i+1;
        } else {
            largest = i;
        }
        if (i<=arr.length && (2*i+2)<=arr.length && arr[2*i+2]>arr[i]) {
            largest = 2 * i + 2;
        }

        if (largest!=i) {
            int buf = arr[i];
            arr[i]=arr[largest];
            arr[largest]=buf;

            heapify(arr,largest);
        }
    return arr;

}


    public static void main(String ...arr){
        RandomSampleClass randomSample =new RandomSampleClass();
        //Set s= randomSample.randomSample(5,10);
        //s.forEach(ss-> System.out.println(ss));
        //int[] intArr = IntStream.range(0, 10).toArray();
        //System.out.println(randomArraySearch(intArr,11));
        int[] res =  heapify(new int[]{3,10,1,8,9,0},0);
        for (int i = 0;i< res.length; i++) {
            System.out.print(res[i]+" ");
        }
    }

}
