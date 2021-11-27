package com.example.datatructure.sort;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 插入排序
 * 假设数据头节点为最小值,后面的数据依次往前面进行比较插入，
 * 如果数据比插入数据大，把数据往后移一位，直到找到比数据小的位置，插在其后面
 */
public class InsertSort {
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
    }

    public static void sort(int[] arr){
        int insertVal = 0;
        int insertIndex = 0;

        for (int i=1;i<arr.length;i++){
            insertVal = arr[i];
            insertIndex = i-1;

            //把元素往后移
            while (insertIndex>=0 && insertVal <arr[insertIndex]){
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex--;
            }
            if (insertIndex+1 !=i){
                arr[insertIndex+1] = insertVal;
            }
        }
    }
}
