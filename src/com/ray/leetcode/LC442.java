package com.ray.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuChaoPang on 2019/4/17.
 *
 * Find All Duplicates in an Array -Level M
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array),
 * some elements appear twice and others appear once.
 * Find all the elements that appear twice in this array.
 * Could you do it without extra space and in O(n) runtime?
 */
public class LC442 {

    /*
     * 利用原来的数组来保存 对应的数是否已存在（或者已遍历过）
     * 但同时不能影响原来数组对应位置的数的记录
     * 所以直接将数组对应位置的数 变为负数（*-1）记录即可，取值的时候直接取绝对值
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> rs = new ArrayList<Integer>();
        for(int i = 0; i < nums.length;i ++) {
            //Math.abs(nums[i])-1  表示i位置上保存的数字j 记录到j - 1 的坐标下
            //第二次发现为小于0的情况说明遍历过了
            if (nums[Math.abs(nums[i])-1] < 0) {
                rs.add(Math.abs(nums[i]));
            } else {
            //第一次遍历到的数都是通过这里来转置成负数
                nums[Math.abs(nums[i])-1] *= -1;
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        int []i ={4,3,2,7,8,2,3,1};
        System.out.println(new LC442().findDuplicates(i));
    }
}
