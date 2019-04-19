package com.ray.leetcode;

/**
 * Created by xuChaoPang on 2019/4/18.
 *
 * Climbing Stairs -Level E
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * Note: Given n will be a positive integer.
 */
public class LC70 {
    public int climbStairs(int n) {

        return climbStairs1(n);
    }

    /*
     *  递推的实现
     *  如果是 n (n > 2)的情况，第一步走一阶 剩下就是 求 n-1，第一步走2阶的情况 那么剩下的就是求 n - 2
     *  所以推导出 f (n) = f(n - 1) + f (n -2)
     */
    private  int climbStairs1(int n) {
        int [] ways = new int[n + 1];
        if (n == 1 ) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        ways[1] = 1;
        ways[2] = 2;
        for (int i = 3; i < n + 1; i++) {
           ways [i] = ways[i-1] + ways[i-2];
        }
        return  ways [n];
    }

    public static void main(String[] args) {
        System.out.println(new LC70().climbStairs(3));
    }
}
