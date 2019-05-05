package com.ray.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuChaoPang on 2019/4/20.
 *
 * Dungeon Game -Level H
 * The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon.
 * The dungeon consists of M x N rooms laid out in a 2D grid.
 * Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.
 * The knight has an initial health point represented by a positive integer. I
 * f at any point his health point drops to 0 or below, he dies immediately.
 * Some of the rooms are guarded by demons, so the knight loses health (negative integers)
 * upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase
 * the knight's health (positive integers).
 * In order to reach the princess as quickly as possible,
 * the knight decides to move only rightward or downward in each step.
 * Write a function to determine the knight's minimum initial health
 * so that he is able to rescue the princess.
 * For example, given the dungeon below, the initial health of the knight must be at least 7
 * if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.
 * -2 (K)	-3	3
 * -5	   -10	1
 * 10	    30	-5 (P)
 * Note:
 * The knight's health has no upper bound.
 * Any room can contain threats or power-ups,
 * even the first room the knight enters and the bottom-right room where the princess is imprisoned.
 */
public class LC174 {
    /*
     *
     * 动态规划
     *
     * 骑士只向下或者右边走 所以每一个节点的最值受到其右边和下边的数据影响
     *
     *
     */
    public int calculateMinimumHP(int[][] dungeon) {

        if (dungeon == null) {
            return 1;
        }

        //
        int height = dungeon.length;
        int len = 0;
        if (dungeon[0] != null) {
            len = dungeon[0].length;
        }

        Integer [][] minHp = new Integer[height][len];

        for (int i = height - 1; i >= 0; i--) {
            for (int j = len -1 ; j >= 0; j--) {

                if (i == height -1 && j == len -1) {
                    //右下角 即最后一步
                    minHp [i][j] = getHp (dungeon [i][j] , 1);
                    continue;
                }
                int leftHp = Integer.MAX_VALUE;
                int bottomHp = Integer.MAX_VALUE;

                if (j + 1 < len) {
                    leftHp = getHp(dungeon [i][j], minHp[i][j + 1]);
                }
                if (i + 1 < height) {
                    bottomHp = getHp(dungeon [i][j], minHp[i + 1][j]);
                }
                minHp [i][j] = leftHp < bottomHp ? leftHp : bottomHp;
            }
        }

        return minHp[0][0];
    }

    /*
     * 根据点的前面需要的HP 计算当前需要的HP
     *
     * preHP 表示 节点的右边或者下边需要的最少HP
     */
    private int getHp ( int dungeon, int preHP) {


        if (dungeon < preHP ) { //dungeon < 0 || （dungeon > 0 && dungeon < preHP）
            return preHP - dungeon;
        }
        return 1;

    }

    public static void main(String[] args) {
        int[][] dungeon = new int [][] {{-2,-3,3},{-5,-10,1},{10,30,-5}};
        System.out.println(new LC174().calculateMinimumHP(dungeon));
    }


}
