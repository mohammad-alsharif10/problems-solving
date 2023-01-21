package com.problems.solving.twoPointers;

public class ReverseString {

    public void reverseString(char[] s) {
        if (s.length == 1) return;
        int left = 0;
        int right = s.length - 1;
        while (left <= right) {
            char temp = s[right];
            s[right] = s[left];
            s[left] = temp;
            --right;
            ++left;
        }
    }
}
