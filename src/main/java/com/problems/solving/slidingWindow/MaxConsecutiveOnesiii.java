package com.problems.solving.slidingWindow;

public class MaxConsecutiveOnesiii {

    public static int longestOnes(int[] nums, int k) {
        int i = 0;
        int j = 0;
        while(i < nums.length){
            if(nums[i] == 0) {
                k--;
            }
            if(k < 0) {
                if (nums[j] == 0) {
                    k++;
                }
                j++;
            }
            i++;
        }
        return i-j;
    }

    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
    }
}
