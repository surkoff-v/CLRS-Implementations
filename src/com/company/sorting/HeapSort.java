package com.company.sorting;

import java.util.PriorityQueue;

public class HeapSort {


    /**
     * 6.2.5
     * @param arr
     * @param i
     * @return
     */
    static int[] max_heapify(int[] arr,int heap_size, int i){
        int largest = Integer.MIN_VALUE;
        if (i<heap_size && (2*i+1)<heap_size && arr[2*i+1]>arr[i]){
            largest = 2*i+1;
        } else {
            largest = i;
        }
        if (i<heap_size && (2*i+2)<heap_size && arr[2*i+2]>arr[largest]) {
            largest = 2 * i + 2;
        }

        if (largest!=i) {
            int buf = arr[i];
            arr[i]=arr[largest];
            arr[largest]=buf;

            max_heapify(arr,heap_size,largest);
        }
        return arr;
    }

    static int[] build_max_heap(int[] arr){
        int heap_size = arr.length;
        for (int i = (int)Math.floor(arr.length/2)-1; i >= 0;i--){
            max_heapify(arr, heap_size, i);
        }
        return arr;
    }

    static int[] heap_sort(int[] arr){
        build_max_heap(arr);
        int heap_size = arr.length;
        for (int i=arr.length-1;i>=1;i--){
            int buf = arr[i];
            arr[i]=arr[0];
            arr[0]=buf;
            --heap_size;
            max_heapify(arr, heap_size, 0);
        }
        return arr;
    }


    public static void main(String ...arr){

    int[] res = heap_sort(new int[]{9,8,7,6,5,4,3,2,1});

    for (int i = 0;i< res.length; i++) {
        System.out.print(res[i]+" ");
        }
    }
}
