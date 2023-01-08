package com.problems.solving.prefixSum;

import java.util.Arrays;

public class PivotIndex {

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
