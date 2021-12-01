package com.example.datatructure.array;

/**
 * 303. 区域和检索 - 数组不可变
 *  数组前缀和
 */
class NumArray {

    int[] p;

    public NumArray(int[] nums) {
        p = new int[nums.length+1];
        for (int i = 1; i < p.length; i++) {
            p[i] = p[i-1] + nums[i-1];
        }
    }
    
    public int sumRange(int left, int right) {
        return p[right+1] - p[left];
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(1, 2));
    }
}