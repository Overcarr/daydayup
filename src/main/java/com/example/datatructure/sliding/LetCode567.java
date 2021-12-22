package com.example.datatructure.sliding;

/**
 * 字符串的排列
 * @author overcare
 */
public class LetCode567 {

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidboaoo"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        char[] char1 = s1.toCharArray();
        char[] char2 = s2.toCharArray();
        int len1 = s1.length();
        int len2 = s2.length();
        int[] charCount = new int[26];
        for (char c : char1) {
            charCount[c - 'a']++;
        }

        int l = 0; int r = 0;
        while (l <= len2 - len1) {
            while (r - l < len1 && charCount[char2[r] - 'a'] >= 1) {
                charCount[char2[r] - 'a']--;
                r++;
            }

            if (r - l == len1) {
                return true;
            }

            charCount[char2[l] - 'a']++;
            l++;
        }
        return false;
    }
}
