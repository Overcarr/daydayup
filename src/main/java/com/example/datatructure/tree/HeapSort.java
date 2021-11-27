package com.example.datatructure.tree;


/**
 * 堆排序
 */
public class HeapSort {
    public static void main(String[] args) {
        int arr[]= {4,6,8,5,9};

        heapSort(arr);

        for (int i : arr) {
            System.out.print(i);
        }
    }

    public static void heapSort(int arr[]){
        // 首先构建一个父节点都大于子节点的堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            sort(arr, i, arr.length);
        }

        // 构建大顶堆
        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            sort(arr, 0, i);

            System.out.format("第 %d 趟: \t", arr.length - i);
        }
    }


    public static void sort(int arr[], int index, int length){
        int temp = arr[index];
        for (int k = 2 * index + 1; k < length; k = k * 2 + 1) {
            // 左右子节点相互比较 取大值
            if (k + 1 < length && arr[k] < arr[k+1]) {
                k++;
            }
            // 如果子节点大于父节点，则交换值，并继续往下遍历
            if (arr[k] > temp) {
                arr[index] = arr[k];
                index = k;
            } else {
                break;
            }
        }

        arr[index] = temp;
    }


}



