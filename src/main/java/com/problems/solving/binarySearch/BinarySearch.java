package com.problems.solving.binarySearch;

public class BinarySearch {

    public static int search(int[] nums, int target) {
        return recFind(target, 0, nums.length - 1, nums);
    }

    private static int recFind(long searchKey, int lowerBound, int upperBound, int[] nums) {
        int curIn;
        curIn = (lowerBound + upperBound) / 2;
        if (nums[curIn] == searchKey)
            return curIn; // found it
        else if (lowerBound > upperBound)
            return -1; // can’t find it
        else // divide range
        {
            if (nums[curIn] < searchKey) // it’s in upper half
                return recFind(searchKey, curIn + 1, upperBound, nums);
            else // it’s in lower half
                return recFind(searchKey, lowerBound, curIn - 1, nums);
        }
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 17, 18, 19, 20}, 16));
    }
}
