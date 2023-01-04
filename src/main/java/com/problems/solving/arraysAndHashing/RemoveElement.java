package com.problems.solving.arraysAndHashing;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int size =0;
        for (int index=0;index<nums.length;index++){
            if (nums[index]!=val){
                nums[size]=nums[index];
                ++size;
            }
        }
        return size;
    }
}
