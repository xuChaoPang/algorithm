package com.ray.leetcode;

/**
 * Created by xuChaoPang on 2019/4/21.
 *
 * Median of Two Sorted Arrays -Level H
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * You may assume nums1 and nums2 cannot be both empty.
 */
public class LC4 {

    /*
     * 参考 https://blog.csdn.net/chen_xinjia/article/details/69258706
     *
     * 在不受 O(log (m+n)) 的情况下 可以使用遍历 或者借助 list
     *
     * 在看到这个时间复杂度限制，想到的是 二分法
     *
     * 如果 X的所有数都大于（或者小于）Y （设X的长度大于Y）那么 中位数定是在X数组中
     *
     * A、小于的情况 可以在X 前面减去Y.length 然后取剩下的数的中位数
     * B、大于的情况 可以在X 后面减去Y.length 然后取剩下的数的中位数
     *
     *
     * 下面开始题解
     *
     * 设Z为 最终解, X Y分别为2个有序数组 （长度分别为 n m） 设 n<m
     *
     * 即 X1 X2...Xn 与 Y1 Y2 . ..Ym （这里先不考虑奇偶）
     *
     * 因为Z为最终解 那么 Z的左边与右边的数 一定是相同数量的
     * 注 X Y 后面跟的数和公式是下标
     * 如：  X1 |  X2 .....Xn
     *      Y1  Y2......Y(m+n)/2 -1 | Y(m+n)/2 ...Ym
     * 其中|表示 X Y被分割成左右部分
     *
     * 也就是如果Z 是中位数  X1 < Y (m+n)/2  而且 Y （m+n）/2 -1 < X2
     *
     * 如果不满足 需要如下调整
     *
     * 1、  X1 > Y (m+n)/2  那么 X的切点需要向左边切
     * 2、  Y （m+n）/2 -1 < X2  那么X的切点需要向右边移动
     *
     * 因为是 lg级别采用 2分来处理 也就是每一次都选择中间切
     *
     * 也就是一开始从X的中间切入， 然后每次往下次需要切的那一段中间切
     *
     * 设K为切点 也就是 X k-1  > Y (m+n)/2 +k  &  Y （m+n）/2 -k < X k+1
     *
     * 下面是奇偶讨论
     *
     * 如果X 为偶数 Y为偶数
     *    那么 取 最终满足等式 的4个节点 X k-1， Y (m+n)/2 +k  ，Y （m+n）/2 -k ， X k+1
     *    其中2个最靠近中心的 求平均数
     *
     * 如果X 为奇数 Y为奇数
     *    那么k所在的位置一点是节点上 那么就是取 X 上的k节点以及Y 上对应的节点 求平均数
     *
     * 如果X 为偶数 Y为奇数
     *    那么X上 K上的点 与 Y上切点左右2个数 最近一个  取min
     *
     * 如果X 为奇数 Y为偶数
     *    同上一种情况 至少Y上为一个点
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {


        return 0d;
    }
}
