package com.ray.leetcode;

/**
 * Created by RayXu on 2019/4/1.
 */
public class LC29 {
    /**
     * 使用减法计算
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {

        boolean isPositive = true;
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE  && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (divisor == 1) {
            return dividend;
        }
        if ((dividend < 0 && divisor > 0)  || (dividend > 0 && divisor < 0) ) {
            isPositive = false;
        }
        int ret = 0;
        dividend = dividend * (dividend < 0 ? 1 : -1);
        divisor = divisor * (divisor < 0 ? 1 : -1);
        while (dividend <= divisor) {
            dividend = dividend - divisor;
            ret ++;
        }
        return ret * (isPositive ? 1 : -1);
    }



    public static void main (String [] args) {
        System.out.print(new LC29().divide(-7 , 3));
//        System.out.print(new LC29().divide(-2147483648 , 1));

    }
}
