package com.example.datatructure.dac;

/**
 * 汉诺塔问题（分治算法）
 * @author overcare
 */
public class Hanoitower {
    public static void main(String[] args) {
        hanoiTower(10, 'A', 'B', 'C');
    }

    /**
     * 先拆分后合并结果
     *
     * @param n
     * @param a
     * @param b
     * @param c
     */
    private static void hanoiTower(int n, char a, char b, char c) {
        if (n == 1) {
            move(1, a, c);
        } else {
            hanoiTower(n - 1, a, c, b);
            move(n, a, c);
            hanoiTower(n - 1, b, a, c);
        }
    }

    private static void move(int n, char a, char c) {
        System.out.println("第" + n + "个盘从" + a + "->" + c);
    }
}
