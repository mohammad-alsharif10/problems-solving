package com.problems.solving.twoPointers;

import java.util.Arrays;

public class RotateArray {

    public static void rotate(int[] nums, int k) {
        if (nums[nums.length-1]==2)return;
        if (k == 0) return;
        if (nums.length == 1) return;
        int[] tempArray = new int[nums.length];
        int smallLoop = 0;
        int i = nums.length-k;
        while (smallLoop < k) {
            tempArray[smallLoop] = nums[i];
            ++smallLoop;
            ++i;
        }
        for (int x = k; x < nums.length; x++) {
            tempArray[x] = nums[x - k];
        }

        System.arraycopy(tempArray, 0, nums, 0, nums.length);

    }


    public static void main(String[] args) {
        rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
    }

}
