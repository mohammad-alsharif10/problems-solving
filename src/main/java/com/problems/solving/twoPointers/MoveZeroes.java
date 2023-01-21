package com.problems.solving.twoPointers;

public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        if (nums.length <= 1) return;
        int index = 0;
        int firstZero = -1;
        while (index < nums.length) {
            if (nums[index] == 0 && firstZero == -1) {
                firstZero = index;
            } else if (nums[index] != 0 && firstZero != -1) {
                swap(nums, firstZero, index);
                firstZero = findNextZero(nums, firstZero);
            }
            index++;
        }
        System.out.println();
    }

    private static int findNextZero(int[] nums, int previousPosition) {
        int nextZer0Position = 0;
        int index = previousPosition + 1;
        while (index < nums.length) {
            if (nums[index] == 0) {
                nextZer0Position = index;
                break;
            }
            ++index;
        }
        return nextZer0Position;
    }

    private static void swap(int[] nums, int firstZero, int index) {
        nums[firstZero] = nums[index];
        nums[index] = 0;
    }

    public static void main(String[] args) {
        moveZeroes(new int[]{0,1,0,3,12});
    }
}
