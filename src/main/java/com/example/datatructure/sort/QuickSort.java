package com.example.datatructure.sort;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 快速排序
 * 选择一个点，作为中间点，递归排序
 * 从尾开始，比中间点大，就往下走，小的话，就替换头，然后从左递归
 */
public class QuickSort {
    public static void main(String[] args) {
       //int[] arr = {101,34,119,1,-1,90,123};
        int[] arr = new int[80000];
        for (int i=0;i<arr.length;i++){
            arr[i] = (int)(Math.random()*8000000);
        }
        System.out.println("排序前");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date before = new Date();
        System.out.println(simpleDateFormat.format(before));
        sort(arr,0,arr.length-1);
        Date after = new Date();
        /*for (int i : arr) {
            System.out.print(i+" ");
        }*/
        System.out.println(simpleDateFormat.format(after));
    }

    public static void sort(int[] arr,int left,int right){
        if (left<right){
            int i,j,x;
            i=left;
            j=right;
            x=arr[i];

            while (i<j){
                while (i<j && arr[j]>x){
                    j--;
                }
                arr[i] = arr[j];
                while (i<j && arr[i]<x){
                    i++;
                }
                arr[j] = arr[i];
            }

            arr[i] = x;
            sort(arr,left,i-1);
            sort(arr,i+1,right);

        }
    }
}
