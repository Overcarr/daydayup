package com.example.datatructure.search;


import java.util.ArrayList;
import java.util.List;

/**
 * 二分查找法
 * 有序的数组
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr={1,12,43,43,46,56,57};
        int search = search(arr, 0, arr.length - 1, 43);
        System.out.println(search);
        List<Integer> integers = search2(arr, 0, arr.length - 1, 43);
        integers.forEach(System.out::print);
        System.out.println();
        int insertSearch = search(arr, 0, arr.length - 1, 46);
        System.out.println(insertSearch);
    }

    private static int search(int[] arr,int left,int right,int temp){
        if (left>right){
            return -1;
        }
        int mid = (left+right)/2;
        int midVaule = arr[mid];
        if (midVaule ==temp){
            return mid;
        }
        else if (midVaule > temp){
           return search(arr,left,mid-1,temp);
        }else {
            return search(arr,mid+1,right,temp);
        }
    }

    private static List<Integer> search2(int[] arr, int left, int right, int temp){
        if (left>right){
            return new ArrayList<>();
        }
        int mid = (left+right)/2;
        int midVaule = arr[mid];
        if (midVaule ==temp){
            ArrayList<Integer> integers = new ArrayList<>();
            for (int i=mid-1;i>=0;i--){
                if (arr[i]==temp){
                    integers.add(i);
                }else {
                    break;
                }
            }
            integers.add(mid);
            for (int j=mid+1;j<=right;j++){
                if (arr[j]==temp){
                    integers.add(j);
                }else {
                    break;
                }
            }
            return integers;
        }
        else if (midVaule > temp){
            return search2(arr,left,mid-1,temp);
        }else {
            return search2(arr,mid+1,right,temp);
        }
    }


    /**
     * 插值查找法
     * @param arr
     * @param left
     * @param right
     * @param temp
     * @return
     */
    private static int insertSearch(int[] arr,int left,int right,int temp){
        if (left>right || arr[left] > temp || arr[right] <temp){
            return -1;
        }
        //位置
        int mid = left+(right-left)*(temp-arr[left])/(arr[right]-arr[left]);
        int midVaule = arr[mid];
        if (midVaule==temp){
            return mid;
        }else if (midVaule>temp){
            return insertSearch(arr,mid+1,right,temp);
        }else {
            return insertSearch(arr,left,mid-1,temp);
        }
    }







}
