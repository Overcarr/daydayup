package com.example.datatructure.dynamic;

/**
 * 零钱兑换（无限背包问题）
 * @author overcare
 */
public class ChangeExchange {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int change = change2(5, coins);
        System.out.println(change);
    }

    private static int change(int amount, int[] coins) {
        // 硬币面值的总类
        int m = coins.length;
        // 能组成amount的组合次数
        int[][] dp = new int[m+1][amount+1];

        for (int j = 0; j <= m; j++) {
            dp[j][0] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (coins[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }

        return dp[m][amount];
    }

    private static int change2(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < dp.length; j++) {
                if (j >= coins[i]) {
                    dp[j] = dp[j] + dp[j-coins[i]];
                }
            }
        }

        return dp[amount];
    }
}
