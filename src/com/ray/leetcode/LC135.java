package com.ray.leetcode;

/**
 * Created by xuChaoPang on 2019/4/25.
 *
 * Candy -Level H
 *
 * There are N children standing in a line. Each child is assigned a rating value.
 * You are giving candies to these children subjected to the following requirements:
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 *
 * What is the minimum candies you must give?
 */
public class LC135 {
    /*
     *  由于临近的小朋友分数高的糖果要多 并且至少要有一个糖果
     *  那么可以换成找到正向递增的子数组依次递增一个糖果
     *
     *  如下          1 2 2 3 2 1
     *  默认初始化为   1 1 1 1 1 1
     *  正向扫描之后为 1 2 1 2 1 1
     *  来一次逆向扫描 1 2 1 3 2 1
     *  逆向的时候需要注意 如果是本身前一个的糖果大于后面那个小朋友的糖果 那么不需要在后面小朋友的基础上加1
     *  如上例子 如果 倒数第二个小朋友分数为 1的划 对应的结果应该是 1 2 1 2 1 1
     *
     *  也就是如果在遍历方向上是递增的就是 在前面的基础上加一 如果相等那就维持1
     */
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }

        if (ratings.length == 1) {
            return 1;
        }
        int sum = 0;
        int[] candys = new int[ratings.length];

        //正向遍历
        candys[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            candys[i] = 1;
            if (ratings[i] > ratings [i-1]) {
                candys[i] = candys[i - 1] + 1;
            }

        }

        //反向遍历
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings [i+1] && candys[i] <=  candys[i + 1 ]) {
                candys[i] = candys[i + 1 ] + 1;
            }
        }

        for (int i = 0; i < candys.length; i++) {
            sum += candys[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        int [] i = new int[] {1,2,2};
        System.out.println(new LC135().candy(i));
    }

}
