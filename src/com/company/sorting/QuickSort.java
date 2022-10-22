package com.company.sorting;

/*
 Two way partionting Lomuto and Hoare
 */
public class QuickSort {


    static int hoarePartitioning(int[] a,int p,int r) {

        printArr(a,p,r);

        int i = p-1;
        int j = r+1;
        int x = a[p];
        while (true) {
            do {
                --j;
            } while (a[j] > x);

            do {
                ++i;
            } while (a[i] < x);

            if (i < j) {
                int buf = a[i];
                a[i] = a[j];
                a[j] = buf;
            } else {
                printArr(a,p,r);
                System.out.println(String.format("p=%s r=%s pivot=%s a[pivot]=%s",p,r,j,a[j]));
                return j;
            }
        }
    }


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

           /* for (int k=0;k<a.length;k++){
                System.out.print(a[k]+" ");
            }
            System.out.println();*/
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

    static void quickSortHoare(int[] a, int p, int r){
        if (p<r) {

            int pivot = hoarePartitioning(a, p, r);

            quickSortHoare(a, p, pivot);
            quickSortHoare(a, pivot + 1, r);
        }

    }

    public static void printArr(int[] a,int r,int p){
        for (int i=r;i<=p;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }


    public static void main(String ...arr){
/*
        int a[] = {5,11,2,7,3,9,10,1,8};
        quickSort(a,0,a.length-1);
        for (int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
*/
        int a[] = {13,19,9,5,12,8,7,4,11,2,6,21};
       // int a[] = {13,11,12};
        quickSortHoare(a,0,a.length-1);

        printArr(a,0,a.length-1);

    }


}
