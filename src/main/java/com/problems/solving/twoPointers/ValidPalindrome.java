package com.problems.solving.twoPointers;

public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
        s = s.replaceAll("\\s", "").toLowerCase();
        if (s.length() == 0) return true;

        int left = 0;
        int right = s.length() - 1;
        boolean isPalindrome = true;
        while (left <= right) {

            while (right>-1&& !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            while (left<s.length()&& !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            if (left > right) {
                break;
            } else {
                if (s.charAt(left) != s.charAt(right)) {
                    isPalindrome = false;
                    break;
                }
            }
            ++left;
            --right;
        }
        return isPalindrome;
    }

    public static String reformString(String s) {
        return s.replaceAll("\\s", "").toLowerCase();
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("."));
    }
}
