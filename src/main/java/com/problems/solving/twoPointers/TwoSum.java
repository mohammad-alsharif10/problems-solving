package com.problems.solving.twoPointers;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int leftPointer = 0;
        int rightPointer = nums.length - 1;

        while (leftPointer < nums.length && rightPointer > -1) {
            if (nums[leftPointer] + nums[rightPointer] == target) {
                res[0] = leftPointer + 1;
                res[1] = rightPointer + 1;
                break;
            } else if (nums[leftPointer] + nums[rightPointer] > target) {
                --rightPointer;
            } else {
                ++leftPointer;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        twoSum(new int[]{3, 2, 4}, 6);
    }
}
