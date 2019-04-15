package com.ray.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by  xuChaoPang on 2019/4/15.
 *
 * First Missing Positive -Level H
 * Given an unsorted integer array, find the smallest missing positive integer.
 *
 */
public class LC41 {

    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums .length == 0 || nums.length == 1 && nums[0] != 1) {
            return 1;
        }
        Set<Integer> numSet = new HashSet<Integer>();
        int findNum = 1;
        for (int i = 0; i < nums.length; i++) {
            while (numSet.contains(findNum ) || nums[i] == findNum) {findNum ++;}

            numSet.add(nums[i]);
        }
        return findNum;
    }

    public static void main(String[] args) {
        int[] nums = {2,5,1,3,6,8};
        System.out.println(new LC41().firstMissingPositive(nums));
    }
}
