package com.ray.leetcode;

/**
 * Created by RayXu on 2019/4/8.
 *
 * Container With Most Water
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 */
public class LC11 {
    public int maxArea(int[] height) {

        if (height == null || height.length < 2) {
            return 0;
        }
        return maxArea2(height);
    }
    /*
     * 暴力求解
     * 求出所有面积  取出最大值
     */
    private int maxArea1(int[] height) {

        return 0;
    }

    /*
     * 贪心算法
     * 从两端开始 往中间走
     * 首先要知道是算面积是取最短的那个边 * （右边坐标 - 左边坐标）
     * 所以 如果要向中间移动是 优先考虑保留较长边，
     * 因为宽减少了，长只有增加才能增大面积
     */
    private int maxArea2(int[] height) {

        int l = 0;
        int r = height.length -1;
        int maxArea = 0;
        while (l < r) {
            maxArea = Math.max(maxArea, Math.min(height [l] ,height [r] ) * (r - l) );

            //往可能存在最值的方向进行
            if (height [l] > height [r]) {
                r --;
            } else {
                l ++;
            }
        }
        return maxArea;
    }
}
