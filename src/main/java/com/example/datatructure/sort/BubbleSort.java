package com.example.datatructure.sort;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 冒泡排序
 * 数据从头到尾一个一个比较，数小的放前面，数大的放后面，每一轮把数组尾的值去掉（当前数组最大值）作为新数组再进行排序
 */
public class BubbleSort {
    public static int count=0;
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

    public static void sort(int[] old){
        int size = old.length;
        int s = size;
        boolean flag = false;
        for (int i=0;i<size-1;i++){
            for (int j=0;j<s;j++){
                if (j==s-1){
                    break;
                }
                if (old[j]>old[j+1]){
                    int x = old[j+1];
                    old[j+1]= old[j];
                    old[j] = x;
                    flag = true;
                }
            }
            if (flag){
                flag = false;
            }else {
                break;
            }
            count++;
            s--;
        }
    }
}
