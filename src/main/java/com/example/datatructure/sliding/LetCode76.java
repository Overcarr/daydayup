package com.example.datatructure.sliding;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 最小覆盖字符串
 * 滑动窗口
 * @author overcare
 */
public class LetCode76 {
    public static void main(String[] args) {

    }

    public static String minWindow(String s, String t) {
        int[] need = new int[128];
        int[] have = new int[128];

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            need[c]++;
        }

        int l = 0;
        int r = 0;
        int valid = 0;
        int start = 0;
        int len = s.length() + 1;

        while (r < s.length()) {
            char c = s.charAt(r);

            if (need[c] == 0) {
                r++;
                continue;
            }

            if (have[c] < need[c]) {
                valid++;
            }

            have[c]++;
            r++;

            while (valid == t.length()) {
                if (r - l < len) {
                    start = l;
                    len = r - l;
                }

                char h = s.charAt(l);

                if (need[h] == 0) {
                    l++;
                    continue;
                }

                if (need[h] == have[h]) {
                    valid--;
                }
                l++;
                have[h]--;
            }

        }

        if (len == s.length() + 1) {
            return "";
        }

        return s.substring(start, start + len);
    }
}
