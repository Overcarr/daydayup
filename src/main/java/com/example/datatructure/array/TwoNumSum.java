package com.example.datatructure.array;

/**
 * 俩数之和
 * 左右指针
 * @author overcare
 */
public class TwoNumSum {

    public static int[] twoNumSum(int[] numbers, int target) {
        int length = numbers.length;
        int left = 0;
        int right = length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (target == sum) {
                return new int[]{left+1, right+1};
            } else if (target > sum) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }
}
