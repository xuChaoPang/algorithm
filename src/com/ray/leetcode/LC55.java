package com.ray.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuChaoPang on 2019/4/10.
 *  Jump Game
 *  Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *  Each element in the array represents your maximum jump length at that position.
 *  Determine if you are able to reach the last index.
 */
public class LC55 {
    /*
     * 暴力破解 可以考虑广度优先 和深度优先
     * 这里考虑贪心算法
     * 1、无法达到最后说明踩0了 可以分成 第一个位置是0 ， 不是第一个位置是0，最后一位是0
     * 2、不是第一个位置为0的情况说明  只需要确保如下1点就可以不踩到0
     *    0前面的那个数大于1，如果是1 ，1前面的那个数大于2 ....依次类推
     */
    public boolean canJump(int[] nums) {

        if (nums == null || nums.length < 2) {
            return true;
        }
        //长度大于1 并且第一个位置为0的情况
        if  (nums[0] == 0) {
            return false;
        }
        List<Integer> zeroPs = new ArrayList<Integer>();

        //找出所有的0
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroPs.add(i);
            }
        }
        if (zeroPs.size() <= 0) {
            return true;
        }
        //找出每一个0前面能跳过它的坐标 如果不存在就说明踩0了
        for (Integer position : zeroPs ) {
            int prePosition = 1;
            //如果 0是最后一位  不需要考虑
            if (position == nums.length - 1) {
                continue;
            }
            while (true) {
                if (position - prePosition < 0) {
                    return false;
                }
                if (nums[position - prePosition] > prePosition) {
                    //找到可以跳过0的点
                    break;
                }
                //如果发现 0的前 n位的数字 小于等于n 说明这个位置不行 往前找
                prePosition ++;

            }

        }
        return  true;
    }

    public static void main(String [] args) {

//        int [] i = new int[] {2,3,1,1,4};
        int [] i = new int[] {3,2,1,0,4};
        System.out.print(new LC55().canJump(i));
    }
}
