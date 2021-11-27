package com.example.datatructure.sort;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 选择排序
 * 数据从头到尾以此假设为最小值
 * 进行遍历比较
 * 把比较以后的真正的最小值放在假设的最小值的位置,
 * 假设的最小值赋给实际的最小值的位置
 */
public class SelectSort {
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
        sort(arr);
        Date after = new Date();
        System.out.println(simpleDateFormat.format(after));
        /*for (int i : arr) {
            System.out.print(i+" ");
        }*/
    }


    public static void sort(int[] arr){
        for (int i=0;i<arr.length-1;i++){
            int min = arr[i];
            int minIndex = i;
            for (int j=i+1;j<arr.length;j++){
                if (min>arr[j]){
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex!=i){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }

    }

}
