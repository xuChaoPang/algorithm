package com.ray.leetcode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by xuChaoPang on 2019/4/9.
 *
 * Spiral Matrix
 * Given a matrix of m x n elements (m rows, n columns),
 * return all elements of the matrix in spiral order.
 */
public class LC54 {

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> retList = new ArrayList<Integer>();
        if (matrix == null || matrix.length < 1) {
            return retList;
        }

        if ( matrix[0] == null ||  matrix[0].length < 1) {
            return retList;
        }
        int len = matrix[0].length;
        int hg =  matrix.length;

        /* 定义 左边距 右边距 上边距 下边距*/
        int left = 0;
        int top = 0;
        int right = len - 1;
        int bottom = hg - 1;

        int size = len * hg;
        while (size > 0) {
            //上边从左往右遍历
            int l = left;
            while (true) {
                if (l > right) {
                    top ++;
                    break;
                } else {
                    retList.add(matrix[top][l]);
                    size --;
                    l ++;
                }
            }

            if  (size <= 0) {
                break;
            }
            //右边从上往下遍历
            int t = top;
            while (true) {
                if (t > bottom) {
                    right --;
                    break;
                } else {
                    retList.add(matrix[t][right]);
                    size --;
                    t ++;
                }
            }
            if  (size <= 0) {
                break;
            }
            //下边从右往左遍历
            int r = right;
            while (true) {
                if (r < left) {
                    bottom --;
                    break;
                } else {
                    retList.add(matrix[bottom][r]);
                    size --;
                    r --;
                }
            }
            if  (size <= 0) {
                break;
            }
            //左边从下往上遍历
            int b = bottom;
            while (true) {
                if (b < top) {
                    left ++;
                    break;
                } else {
                    retList.add(matrix[b][left]);
                    size --;
                    b --;
                }
            }


        }
        return retList;
    }

    public static void main (String[] args) {

//        int [][] i = new int[][]{{1, 2, 3},{ 4, 5, 6 },{7, 8, 9}};
        int [][] i = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.print(new LC54().spiralOrder(i));
    }
}
