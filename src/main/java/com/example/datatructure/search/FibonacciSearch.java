package com.example.datatructure.search;


import java.util.Arrays;

/**
 * 斐波那契查找算法(不是很懂)
 */
public class FibonacciSearch {

    private static final int max = 20;
    public static void main(String[] args) {

    }

    /**
     * 构建斐波那契函数
     * @return
     */
    private static int[] flb(){
        int[] flb = new int[max];
        flb[0] = 0;
        flb[1] = 1;
        for (int i=2;i<max;i++){
            flb[i] = flb[i-2]+flb[i-1];
        }
        return flb;
    }

    /**
     * 查找
     * @param arr
     * @param temp
     * @return
     */
    private static int search(int[] arr,int temp){
        int left = 0;
        int right = arr.length-1;
        int k=0;
        int[] flb = flb();
        while (right>flb[k]){
            k++;
        }
        //总长度是满足斐波那契函数的
        int[] ints = Arrays.copyOf(arr, flb[k]);
        for (int i = right+1;i<ints.length;i++){
            ints[i] = arr[right];
        }
        while (left<=right){
            int mid = left + flb[k-1]-1;
            if (ints[mid]>temp){
                right = mid-1;
                k--;
            }else if (ints[mid]<temp){
                left = mid+1;
                k -=2;
            }else {
                return -mid;
            }
        }
        return -1;
    }


}
