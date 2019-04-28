package com.ray.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuChaoPang on 2019/4/28.
 *
 * Find the Closest Palindrome -LeveL H
 * Given an integer n, find the closest integer (not including itself), which is a palindrome.
 * The 'closest' is defined as absolute difference minimized between two integers.
 *
 * Example 1:
 * Input: "123"
 * Output: "121"
 *
 * Note:
 * The input n is a positive integer represented by string, whose length will not exceed 18.
 * If there is a tie, return the smaller one as answer.
 */
public class LC564 {

    /*
     * 直接锁定 最近的几个候选值是最快的
     *
     * 特殊数据优先处理
     * 个位数的直接返回 n - 1
     * 本身为回文数的 取中间（奇数1位，偶数2位）减一 （如果为0就加一，为什么是减一 加一的和减一的距离是一样的取最小的数）
     * 接下来计算可以成为候选的数
     * 取n的前半截对称替换后半截 （奇数的划  中间数不处理）生成新的数m (候补数 1)
     * 取m的中间（奇数1位，偶数2位）减一（为0则没有）生成新数 k （候选数 2）
     * 取n的中间（奇数1位，偶数2位）减一（为9则没有）生成新数 k （候选数 3）
     * 特殊候选数
     * 如果 n是以 1开头的 候选数 加上 9....9（位数为n的位数减一）
     * 如果 n是以9开头的 候选数 加上 10....01 (位数为n的位数加一)
     * 最后比较最近的候选数，如果距离相同取小的那个数
     */
    public String nearestPalindromic(String n) {

        if (n.length() == 1) return (Integer.getInteger(n) - 1) + "";

        char[] nc = n.toCharArray();


        //本身是回文串
        if (isPalindromic(nc)) {
            //奇数的时候替换一个

            if (nc.length % 2 == 1) {
                int mid = (nc.length-1) /2;
                char midn =  nc [mid];

                if (midn == '0') {
                    nc[mid] = '1';
                } else {
                    nc[mid] = Character.forDigit ((Integer.getInteger(midn + "")+ 1), 0) ;
                }
            } else {
                int midL = (nc.length-1) /2;
                char midnL =  nc [midL];
                int midR = (nc.length-1) /2 + 1;
                char midnR =  nc [midR];
                if (midnL == '0') {
                    nc[midnL] = '1';
                    nc[midnR] = '1';
                } else {
                    nc[midL] = Character.forDigit ((Integer.getInteger(midnL + "")+ 1), 0) ;
                    nc[midR] = Character.forDigit ((Integer.getInteger(midnR + "")+ 1), 0) ;
                }

            }
            return nc.toString();
        }


        int nNum = Integer.getInteger(n);
        List<Integer> nestNums = new ArrayList();
        int left = 0;
        int right = nc.length - 1;
        while ( true ) {
            if (left >= right) {
               break;
            }
            nc [right --] = nc[left ++];
        }
        nestNums.add(Integer.getInteger(nc.toString()));//候选数1

        //候选数2

        //候选数3

        //特殊候选

        //比较大小

        return null;
    }

    private boolean isPalindromic (char[] nc) {

        int left = 0;
        int right = nc.length - 1;
        while (true) {
            if (left >= right) {
                return true;
            }
            if (nc[left ++] != nc [right --]) {
                return false;
            }
        }
    }
}
