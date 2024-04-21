package com.problems.solving.slidingWindow;

public class MaximumAverageSubarrayI {


    public static double findMaxAverage(int[] nums, int k) {

        if (nums == null || nums.length == 0) {
            return Double.NaN;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        double currentSum = 0;
        double maxAva = 0;
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }
        maxAva = currentSum / k;
        for (int i = 1; i < nums.length - (k - 1); i++) {
            currentSum = currentSum - nums[i - 1] + nums[i + (k - 1)];
            double ava = currentSum / k;
            if (ava > maxAva) {
                maxAva = ava;
            }
        }
        return maxAva;
    }

    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{4, 2, 1, 3, 3}, 2));
    }
}
