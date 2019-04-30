package com.ray.leetcode;

/**
 * Created by xuChaoPang on 2019/4/30.
 *
 * Bulb Switcher -Level M
 * There are n bulbs that are initially off. You first turn on all the bulbs.
 * Then, you turn off every second bulb. On the third round,
 * you toggle every third bulb (turning on if it's off or turning off if it's on). For the i-th round,
 * you toggle every i bulb. For the n-th round, you only toggle the last bulb. Find how many bulbs are on after n rounds.
 */
public class LC319 {
    /*
     * 个人觉得这道题转的有点厉害
     * 一开始所有的灯泡都是暗的
     * 取灯泡P 设P 在第i轮是亮的 那么需要满足如下条件
     * 1、P被反转的次数一定是奇数次
     * 2、P能被反转的那一轮次 一定能被P整除
     *
     * 根据上面的分析 设 X < i 且X轮能反转P 也就是 P %X  == 0
     * 那么一定会出现一个数 Y 使得 X * Y = P 且 Y < i,P %Y  == 0
     * 也就是 P 有可能被反转的次数是2次 （暗 -> 亮 ->暗，也就是这种情况会作为组合出现，相互抵消使得灯泡回复初始的状态）
     * 但是有特殊情况 那就是 X == Y 此时 只会出现 （暗 -> 亮）
     *
     * 满足这种情况 的话也就是P必须是一个能开方的数
     * 好了 到这了 就可以将这个问题转化成 求 n 前面有多少个可以开方的数
     *
     * 如何判断 ？
     * 对于任意 >=1 的2个数 K、J， 如果 K 小于 J 那么K的开方一定小于J的开方
     * 所以求的是 所有小于 n的开方的 正整数！！！ 如果J不能开方 成整数 向下取整
     *
     */
    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }
}
