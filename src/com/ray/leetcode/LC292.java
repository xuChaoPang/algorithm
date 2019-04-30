package com.ray.leetcode;

/**
 * Created by xuChaoPang on 2019/4/30.
 *
 * Nim Game -Level E
 * You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first turn to remove the stones.
 * Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can win the game given the number of stones in the heap.
 * Example:
 * Input: 4
 * Output: false
 * Explanation: If there are 4 stones in the heap, then you will never win the game;
 * No matter 1, 2, or 3 stones you remove, the last stone will always be
 * removed by your friend.
 */
public class LC292 {

    /*
     * 这道题 注意到 Example 基本就可以猜测出来了
     *
     * 如果出现4的时候 不能是自己拿，
     * 往上推就是 8的时候不能是自己拿
     * 再往上就是 16.....
     * 所以只要轮到自己都不能是4的倍数，并且控制对方遇到的都是4的倍数
     */
    public boolean canWinNim(int n) {
        //if (n <= 0) return true;
        return n % 4 > 0;
    }

    public static void main(String[] args) {
        System.out.println(new LC292().canWinNim(4));
    }

}
