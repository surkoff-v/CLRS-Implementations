package com.company.sorting;

/*
  Prtitioning return first and last index iqual pivots
 */
public class QuickSortEqualPivot {

    static int[] patritioning(int[] a,int p,int r){
        int x = a[p];
        int i = p;
        int h = p;

        for (int j=p+1;j<=r;j++){
            if (a[j] < x){
                int y = a[j];
                a[j] = a[h+1];
                a[h+1] = a[i];
                a[i] = y;
                ++h;
                ++i;
            } else if (a[j]==x) {
                int buf = a[j];
                a[j] = a[h+1];
                a[h+1] = buf;
                ++h;
            }
        }

        return new int[]{i,h};
    }

    static void quickSort(int[] a, int p, int r){
        if (p<r) {
            int[] pivot = patritioning(a, p, r);
            quickSort(a, p, pivot[0] - 1);
            quickSort(a, pivot[1] + 1, r);
        }
    }

    public static void printArr(int[] a,int r,int p){
        for (int i=r;i<=p;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }


    public static void main(String ...arr){
        int a[] = {8, 3, 8, 1, 9, 3};
        quickSort(a,0,a.length-1);
        printArr(a,0,a.length-1);

    }

}
