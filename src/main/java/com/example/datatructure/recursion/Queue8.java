package com.example.datatructure.recursion;

public class Queue8 {

    int max = 8;
    int arr[] = new int[max];
    static int count;
    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.println(count);
    }

    public void check(int n){
        if (n==8){
            print();
            return;
        }

        for (int i=0;i<max;i++){
            arr[n] = i;
            if (judge(n)){
                check(n+1);
            }
        }
    }


    public void print(){
        count++;
        for (int i : arr) {
            System.out.print(i +" ");
        }
        System.out.println();
    }

    public boolean judge(int n){
        //判断是否在同一列
        //判断是否在同一斜线
        for (int i=0;i<n;i++){
            if (arr[n]==arr[i] || Math.abs(n-i) ==Math.abs(arr[n]-arr[i])){
                return false;
            }
        }
        return true;

    }
}
