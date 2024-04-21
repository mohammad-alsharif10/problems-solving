package com.problems.solving.mapSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDifferenceTwoArrays {

//    Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:
//
//    answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
//            answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
//    Note that the integers in the lists may be returned in any order.
//
//
//
//            Example 1:
//
//    Input: nums1 = [1,2,3], nums2 = [2,4,6]
//    Output: [[1,3],[4,6]]
//    Explanation:
//    For nums1, nums1[1] = 2 is present at index 0 of nums2, whereas nums1[0] = 1 and nums1[2] = 3 are not present in nums2. Therefore, answer[0] = [1,3].
//    For nums2, nums2[0] = 2 is present at index 1 of nums1, whereas nums2[1] = 4 and nums2[2] = 6 are not present in nums2. Therefore, answer[1] = [4,6].
//    Example 2:
//
//    Input: nums1 = [1,2,3,3], nums2 = [1,1,2,2]
//    Output: [[3],[]]
//    Explanation:
//    For nums1, nums1[2] and nums1[3] are not present in nums2. Since nums1[2] == nums1[3], their value is only included once and answer[0] = [3].
//    Every integer in nums2 is present in nums1. Therefore, answer[1] = [].

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        res.add(list1);
        res.add(list2);
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        int length = nums1.length > nums2.length ? nums1.length : nums2.length;
        for (int i = 0; i <length; i++) {
            if(i<nums1.length){
                map1.put(nums1[i], i);
            }
            if (i < nums2.length) {
                map2.put(nums2[i], i);
            }
        }
        map1.forEach((k, v) -> {
            if (!map2.containsKey(k)) {
                list1.add(k);
            }
        });
        map2.forEach((k, v) -> {
            if (!map1.containsKey(k)) {
                list2.add(k);
            }
        });
        System.out.println();
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findDifference(new int[]{-68, -80, -19, -94, 82, 21, -43}, new int[]{-63}));
    }
}
