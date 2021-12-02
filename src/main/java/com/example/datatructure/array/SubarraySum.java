package com.example.datatructure.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 和为 K 的子数组
 * @author overcare
 */
public class SubarraySum {
    int[] preSum;

    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        preSum = new int[n+1];

        int res = 0;
        for (int i = 0; i < n; i++) {
            preSum[i+1] = preSum[i] + nums[i];
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n + 1; j++) {
                if (k == preSum[j] - preSum[i]) {
                    res++;
                }
            }
        }
        return res;
    }

    public int subarraySum2(int[] nums, int k) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        int n = nums.length;
        preSum = new int[n+1];
        int res = 0;

        hashMap.put(0, 1);

        for (int i = 0; i < n; i++) {
            preSum[i+1] = preSum[i] + nums[i];

            int sum = preSum[i+1] - k;
            if (hashMap.containsKey(sum)) {
                res += hashMap.get(sum);
            }
            hashMap.put(preSum[i+1], hashMap.getOrDefault(preSum[i+1], 0) + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        SubarraySum subarraySum = new SubarraySum();
        int[] nums = {1, 1, 1};
        System.out.println(subarraySum.subarraySum2(nums, 2));
    }
}
