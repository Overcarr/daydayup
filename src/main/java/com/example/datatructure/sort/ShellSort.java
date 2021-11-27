package com.example.datatructure.sort;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 希尔排序
 * 分组然后进行插入排序
 */
public class ShellSort {
    public static void main(String[] args) {
        //int[] arr = {101,34,119,1,-1,90,123};
        int[] arr = new int[800000];
        for (int i=0;i<arr.length;i++){
            arr[i] = (int)(Math.random()*8000000);
        }
        System.out.println("排序前");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date before = new Date();
        System.out.println(simpleDateFormat.format(before));
        sort2(arr);
        Date after = new Date();
        /*for (int i : arr) {
            System.out.print(i+" ");
        }*/
        System.out.println(simpleDateFormat.format(after));
    }

    public static void sort(int[] arr){
        int length = arr.length;
        int temp = 0;
        for (int gap = length/2;gap>0;gap=gap/2){
            for (int i=gap;i<length;i++){
                for (int j=i-gap;j>=0;j-=gap){
                    if (arr[j] > arr[j+gap]){
                        temp = arr[j+gap];
                        arr[j+gap] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
    }

    public static void sort2(int[] arr){
        int length = arr.length;
        for (int gap = length/2;gap>0;gap=gap/2){
            for (int i=gap;i<length;i++){
                int j=i;
                int temp = arr[j];
                if (arr[j] < arr[j-gap]){
                    while (j-gap>=0&&temp<arr[j-gap]){
                        arr[j] = arr[j-gap];
                        j-=gap;
                    }
                    arr[j] = temp;
                }
            }
        }
    }
}
