package com.company;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

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

    public static void main(String ...arr){
        RandomSampleClass randomSample =new RandomSampleClass();
        Set s= randomSample.randomSample(5,10);
        s.forEach(ss-> System.out.println(ss));
    }

}
