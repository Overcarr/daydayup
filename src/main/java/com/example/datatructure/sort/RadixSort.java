package com.example.datatructure.sort;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 基数排序(空间换时间)
 */
public class RadixSort {
    public static void main(String[] args) {
       // int[] arr = {101,34,119,1,6,90,123};
        int[] arr = new int[8000000];
        for (int i=0;i<arr.length;i++){
            arr[i] = (int)(Math.random()*8000000);
        }
        System.out.println("排序前");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date before = new Date();
        System.out.println(simpleDateFormat.format(before));
        sort(arr);
        Date after = new Date();
        /*for (int i : arr) {
            System.out.print(i+" ");
        }*/
        System.out.println();
        System.out.println(simpleDateFormat.format(after));
    }


    private static void sort(int[] arr){

        //获取最大值
        int max=arr[0];
        for (int i=1;i<arr.length;i++){
            if (max<arr[i]){
                max = arr[i];
            }
        }
        //最大值的位数
        int maxLength = (max+"").length();
        int bucket[][] = new int[10][arr.length];
        int[] bucketElementCounts = new int[10];
        for (int i=0,n=1;i<maxLength;i++,n=n*10){
            //放桶
            for (int j=0;j<arr.length;j++){
                int index = arr[j] /n %10;
                bucket[index][bucketElementCounts[index]] = arr[j];
                bucketElementCounts[index]++;
            }
            //取桶
            int x = 0;
            for (int k=0;k<bucketElementCounts.length;k++){
                int elementCount = bucketElementCounts[k];
                if (elementCount !=0){
                   for (int l=0;l<elementCount;l++){
                        arr[x++] = bucket[k][l];
                    }
                }
                bucketElementCounts[k] = 0;
            }
        }

    }
}
