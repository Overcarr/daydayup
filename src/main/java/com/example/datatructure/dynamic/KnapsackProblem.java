package com.example.datatructure.dynamic;

/**
 * 01背包问题
 * @author overcare
 */
public class KnapsackProblem {
    public static void main(String[] args) {
        int[] w = {1, 4, 3};
        int[] val = {1500, 3000, 2000};
        // 背包的容量
        int m = 4;
        // 物品的个数
        int n = w.length;


        int[][] v =new int[n+1][m+1];
        int[][] path = new int[n+1][m+1];

        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[0].length; j++) {
                if (j >= w[i-1]) {
                    if (v[i-1][j] < val[i-1] + v[i-1][j - w[i-1]]) {
                        v[i][j] = val[i-1] + v[i-1][j - w[i-1]];
                        path[i][j] = 1;
                    } else {
                        v[i][j] = v[i-1][j];
                    }
                } else {
                    v[i][j] = v[i-1][j];
                }
            }
        }

        for (int[] ints : v) {
            for (int j = 0; j < v[0].length; j++) {
                System.out.print(ints[j] + "\t");
            }
            System.out.println();
        }

        int i = path.length - 1;
        int j = path[0].length - 1;
        while (i > 0 && j > 0) {
            if (path[i][j] == 1) {
                System.out.printf("第%d个物品放入背包\n", i);
                j -= w[i-1];
            }
            i--;
        }

    }
}
