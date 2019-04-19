package com.ray.leetcode;

/**
 * Created by xuChaoPang on 2019/4/19.
 *
 * Jump Game II -Level H
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 */
public class LC45 {

    /*
     * 从头开始走 每次找出距离起始点最近的 能到达结尾的点n
     * 接下来 以n为结尾重复上述操作 直到 n 为0
     */
    public int jump(int[] nums) {

        if ( nums == null || nums.length <= 1) {
            return 0;
        }

        int end = nums.length - 1;
        int start = 0;
        int jumps = 0;
        while (true) {

            if (start == end) {
                break;
            }
            if (nums[start] + start >= end) {
                jumps ++;
                end = start;
                start = 0;
            } else {
                start ++;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2,3,1,1,4};
        System.out.println(new LC45().jump(nums));
    }
}
