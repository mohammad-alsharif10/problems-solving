package com.problems.solving.prefixSum;

import java.util.Arrays;

public class PivotIndex {

//    Given an array of integers nums, calculate the pivot index of this array.
//
//    The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.
//
//    If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.
//
//    Return the leftmost pivot index. If no such index exists, return -1.
//
//
//
//    Example 1:
//
//    Input: nums = [1,7,3,6,5,6]
//    Output: 3
//    Explanation:
//    The pivot index is 3.
//    Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
//    Right sum = nums[4] + nums[5] = 5 + 6 = 11
//    Example 2:
//
//    Input: nums = [1,2,3]
//    Output: -1
//    Explanation:
//    There is no index that satisfies the conditions in the problem statement.
//    Example 3:
//
//    Input: nums = [2,1,-1]
//    Output: 0
//    Explanation:
//    The pivot index is 0.
//    Left sum = 0 (no elements to the left of index 0)
//    Right sum = nums[1] + nums[2] = 1 + -1 = 0

    public static int pivotIndex(int[] nums) {
        int pivotIndex = -1;
        int total = Arrays.stream(nums).parallel().sum();
        int previousLeftSum = 0;
        for (int index = 0; index < nums.length; index++) {
            int rightSum;
            int leftSum;
            if (index == 0) {
                leftSum = 0;
                rightSum = getRightSUM(total, previousLeftSum, nums[0]);
            } else if (index == nums.length - 1) {
                rightSum = 0;
                leftSum = previousLeftSum + nums[index - 1];
                previousLeftSum = leftSum;
            } else {
                leftSum = previousLeftSum + nums[index - 1];
                rightSum = getRightSUM(total, leftSum, nums[index]);
                previousLeftSum = leftSum;
            }
            if (rightSum == leftSum) {
                pivotIndex = index;
                break;
            }
        }
        return pivotIndex;
    }

    static int getRightSUM(int total, int totalLeft, int pivot) {
        return total - (totalLeft + pivot);
    }

    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
    }
}
