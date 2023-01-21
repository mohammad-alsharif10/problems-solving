package com.problems.solving.twoPointers;

public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, nums2.length);
            return;
        }
        if (n==0) return;

        int secondArrayPointer = nums2.length - 1;
        int firstArrayPointer = m - 1;
        int insertionPosition = nums1.length - 1;
        while (secondArrayPointer >= 0) {
            if (firstArrayPointer == -1) {
                while (secondArrayPointer >= 0) {
                    nums1[insertionPosition] = nums2[secondArrayPointer];
                    --secondArrayPointer;
                    --insertionPosition;
                }
                break;
            }
            if (nums2[secondArrayPointer] <= nums1[firstArrayPointer]) {
                nums1[insertionPosition] = nums1[firstArrayPointer];
                nums1[firstArrayPointer] = 0;
                --firstArrayPointer;
            } else {
                nums1[insertionPosition] = nums2[secondArrayPointer];
                --secondArrayPointer;
            }
            --insertionPosition;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
//        merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
        merge(new int[]{2,0}, 1, new int[]{1}, 1);
    }


}
