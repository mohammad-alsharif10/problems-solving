package com.problems.solving.twoPointers;

public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int area = 0;
        int left = 0;
        int right = height.length - 1;

        while (right>left) {
            int tempArea = Math.min(height[left], height[right]) * (right-left);
            if (tempArea > area) {
                area = tempArea;
            }
            if (height[left] > height[right]) {
                --right;
            } else {
                ++left;
            }
        }
        return area;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
