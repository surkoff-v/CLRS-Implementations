package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class PriorityQueue {

    public static int heapMaximum(int[] arr){
        return arr[0];
    }

     static int heapExtractMax(int[] arr,AtomicInteger heapSize){
        if (heapSize.intValue()<1){
            throw new RuntimeException("no elements");
        }
        int max = arr[0];
        arr[0]=arr[heapSize.decrementAndGet()];
        HeapSort.max_heapify(arr, heapSize.intValue(),0);
        return max;
    }

    static int parent(int i){
        return (int) Math.floor(i/2);
    }

     static int heapIncreaseKey(List<Integer> arr, int i, int key){
         if (arr.get(i) > key) {
             throw new RuntimeException("key Error");
         }

         while (i>0 && arr.get(parent(i)) < key){
             arr.set(i,arr.get(parent(i)));
             i = parent(i);
         }
         arr.set(i,key);


        return i;
    }

      static int maxHeapInsert(List<Integer> arr, int key){
          arr.add(Integer.MIN_VALUE);
          int heapSize = arr.size();
          heapIncreaseKey(arr, heapSize - 1, key);
          return heapSize;
      }

      static void heapDelete(int[] arr,int i,AtomicInteger heapSize){
            arr[i] = arr[heapSize.decrementAndGet()];
            HeapSort.max_heapify(arr,i,heapSize.intValue());
      }


    public static void main(String ...sarr){
        List<Integer> arr = new ArrayList<>();

        maxHeapInsert(arr,1);
        maxHeapInsert(arr,3);
        maxHeapInsert(arr,7);
        maxHeapInsert(arr,4);

        int[] ints = arr.stream().mapToInt(i -> i).toArray();

        AtomicInteger heapSize = new AtomicInteger(ints.length);


        heapDelete(ints,2, heapSize);

        System.out.println(heapExtractMax(ints,heapSize));
        System.out.println(heapExtractMax(ints,heapSize));
        System.out.println(heapExtractMax(ints,heapSize));
        System.out.println(heapExtractMax(ints,heapSize));

    }

}
