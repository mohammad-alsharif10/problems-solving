package com.problems.solving.twoPointers;

import java.util.Arrays;

public class MaxNumberKSumPairs {


    public static int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0;
        int h = nums.length - 1;
        int count = 0;
        while (l < h) {
            int sum = nums[l] + nums[h];
            if (sum == k) {
                count++;
                l++;
                h--;
            } else if (sum < k) {
                l++;
            } else {
                h--;
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
