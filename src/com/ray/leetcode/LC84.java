package com.ray.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by xuChaoPang on 2019/4/14.
 *
 * Largest Rectangle in Histogram  - Level H
 * Given n non-negative integers representing the histogram's bar height
 * where the width of each bar is 1,
 * find the area of largest rectangle in the histogram.
 */
public class LC84 {

    public int largestRectangleArea(int[] heights) {

        if (heights == null || heights.length < 1) {
            return 0;
        }


        return largestRectangleArea2(heights);
//        return largestRectangleArea3(heights);
    }

    /*
     * 暴力求解 ---超时
     * 利用 临时变量纪录 遍历过的最小高度
     */
    public int largestRectangleArea1 (int[] heights ) {

        int maxRtn = 0;
        for (int i = 0; i < heights.length; i++) {
            int curMinHeight = heights[i];
            for (int j = i; j < heights.length; j++) {
                if (curMinHeight > heights[j]) {
                    curMinHeight = heights[j];
                }
                maxRtn = Math.max(curMinHeight * (j + 1 - i), maxRtn);
            }
        }
        return maxRtn;
    }
    /*
     * 默认取全部， 如果要出现更大的面积 只可能出现在去掉最小高度的情况下
     */
    public  int largestRectangleArea2(int[] heights) {
        return largestRectangleArea2(heights, 0, heights.length - 1 , 0);
    }

    private  int largestRectangleArea2(int[] heights, int start, int end ,int maxS) {

        if (end < start) {
            return maxS;
        }
        int currLen = end + 1 - start;
        int minLocal = getMin(heights, start,end);
        int currS = currLen * heights[minLocal];

        if (currS > maxS) {
            maxS = currS;
        }

        int leftS = largestRectangleArea2(heights, start, minLocal - 1, maxS);
        int rightS = largestRectangleArea2(heights, minLocal + 1, end, maxS);


        if (maxS < leftS) {
            maxS = leftS;
        }
        if (maxS < rightS) {
            maxS = rightS;
        }
        return maxS;
    }

    private int getMin (int[] heights, int start, int end) {
        if (start > end ) {
            return -1;
        }
        if (start == end) {
            return start;
        }

        int curr = start;

        for (int i = start; i <= end; i++) {
            if (heights [i] < heights [curr]) {
                curr = i;
            }
        }

        return curr;
    }
    //利用单调栈处理 --暂时没看懂
    public  int largestRectangleArea3(int[] heights) {
        int heightn[] =new int[heights.length+1];
        for (int i = 0; i < heights.length; i++) {
            heightn[i] = heights[i];
        }
        heightn[heights.length] = 0;   //最后增加个高度为0 的柱子，以便把单调栈里面的都弹出去。
        Deque<Integer> stack =new ArrayDeque<Integer>(); //存储序号
        int maxS=0;
        for (int i = 0; i < heightn.length;i++) {
            while (!stack.isEmpty() && heightn[i] < heightn[stack.peek()]){  //一直出栈 直到遇见小的

                int temp=stack.pop();

                int curS = ( stack.isEmpty()?i:(i-stack.peek()-1) )*heights[temp];
                maxS= Math.max(maxS, curS);
            }
            stack.push(i); //入栈
        }
        return maxS;
    }





    public static void main(String[] args) {
        int[] s = {2,1,5,6,2,3};
        int[] s1 = {4,2};
        System.out.println(new LC84().largestRectangleArea(s1));
    }


}
