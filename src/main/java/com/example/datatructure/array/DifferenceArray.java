package com.example.datatructure.array;

import javax.lang.model.element.VariableElement;

/**
 * 差分数组
 * @author overcare
 */
public class DifferenceArray {
    private int[] diff;

    public DifferenceArray(int[] arr) {
        diff = new int[arr.length];
        diff[0] = arr[0];

        for (int i = 1; i <arr.length; i++) {
            diff[i] = arr[i] - arr[i-1];
        }
    }

    /**
     * 复原数组
     *
     * @return
     */
    public int[] recoverArray() {
        int[] arr = new int[diff.length];
        arr[0] = diff[0];

        for (int i = 1; i < diff.length; i++) {
            arr[i] = arr[i-1] + diff[i];
        }

        return arr;
    }

    /**
     *
     *
     * @param left
     * @param right
     * @param k
     */
    public void increment(int left, int right, int k) {
        diff[left] += k;
        if (right + 1 < diff.length) {
            diff[right+1] -= k;
        }
    }

    private static int[] corpFlightBookings(int[][] bookings, int n) {
        int[] arr = new int[n];

        DifferenceArray array = new DifferenceArray(arr);

        for (int[] booking : bookings) {
            int l = booking[0];
            int r = booking[1];
            int k = booking[2];
            array.increment(l-1, r-1, k);
        }

        return array.recoverArray();
    }

    public static boolean carPooling(int[][] trips, int capacity) {
        int[] arr = new int[1001];

        DifferenceArray differenceArray = new DifferenceArray(arr);

        for (int[] trip : trips) {
            int k = trip[0];
            int l = trip[1] - 1;
            int r = trip[2] - 1;
            differenceArray.increment(l, r, k);
        }

        int[] res = differenceArray.recoverArray();
        for (int re : res) {
            if (re > capacity) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int[][] arr = {{2, 1, 5}, {3, 3, 7}};
        System.out.println(carPooling(arr, 5));
    }

}


