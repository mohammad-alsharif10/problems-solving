package com.problems.solving.prefixSum;

public class RunningSumof1dArray {

    public static int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i==0){
                result[0]=nums[0];
            }else {
                result[i]=nums[i]+result[i-1];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3};
        System.out.println(a.length);
        int[] b = new int[a.length];
        System.out.println(b.length);
    }
}
