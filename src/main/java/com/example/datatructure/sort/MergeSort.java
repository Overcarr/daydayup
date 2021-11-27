package com.example.datatructure.sort;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 归并排序
 * 利用递归先分再合 借助一数组
 */
public class MergeSort {
    public static void main(String[] args) {
        //int[] arr = {101,34,119,1,-1,90,123};
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

    public static void sort(int []arr){
        int []temp = new int[arr.length];//在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        sort(arr,0,arr.length-1,temp);
    }
    private static void sort(int[] arr,int left,int right,int []temp){
        if (left<right){
            int mid = (left+right)/2;
            sort(arr,left,mid,temp);
            sort(arr,mid+1,right,temp);
            merge(arr,left,mid,right,temp);
        }
    }

    private static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i=left;
        int j=mid+1;
        int k=0;
        while (i<=mid&&j<=right){
            if (arr[i]<=arr[j]){
                temp[k++] = arr[i++];

            }
            else{
                temp[k++] = arr[j++];
            }
        }

        while (i<=mid){
            temp[k++] = arr[i++];
        }

        while (j<=right){
            temp[k++] = arr[j++];
        }

        int a = left;
        int index = 0;
        while (a<=right){
            arr[a++] = temp[index++];
        }

    }

}
