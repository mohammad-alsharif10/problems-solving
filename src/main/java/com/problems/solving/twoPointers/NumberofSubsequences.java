package com.problems.solving.twoPointers;

import java.util.Arrays;

public class NumberofSubsequences {

    public static int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int MOD = (int) (Math.pow(10,9)+7);
        int index = 0;
        int numOfSubsequences = 0;
        while (index < nums.length) {
            if (nums[index] * 2 > target || nums[index] == 0) {
                ++index;
                continue;
            }
            numOfSubsequences = (numOfSubsequences(index, nums, target) % MOD) + (numOfSubsequences)%MOD;
            ++index;
        }
        return numOfSubsequences%MOD;
    }

    static int numOfSubsequences(int index, int[] nums, int target) {
        int last = nums.length - 1;
        int power = 0;
        while (last >= index) {
            if (nums[index] + nums[last] <= target) {
                power = last - index;
                break;
            }
            --last;
        }
        return (int) Math.pow(2, power);
    }

    public static void main(String[] args) {
        System.out.println(numSubseq(new int[]{3, 5,0, 6, 7}, 9));
    }

}
