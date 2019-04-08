package com.ray.leetcode;

/**
 * Created by RayXu on 2019/4/1.
 */
public class LC29 {

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
//        if (divisor == 2) {
//            return dividend >> 1;
//        }
//
//        if (divisor == -2) {
//            return -dividend >> 1 ;
//        }
//        return divide1(dividend, divisor);
        if ((dividend < 0 && divisor > 0)  || (dividend > 0 && divisor < 0) ) {
            isPositive = false;
        }
        return divide2(dividend, divisor)  * (isPositive ? 1 : -1);
    }

    /**
     * 直接使用减法
     * @param dividend
     * @param divisor
     * @return
     */
    private int divide1(int dividend, int divisor) {

        int ret = 0;
        dividend = dividend * (dividend < 0 ? 1 : -1);
        divisor = divisor * (divisor < 0 ? 1 : -1);
        while (dividend <= divisor) {
            dividend = dividend - divisor;
            ret ++;
        }
        return ret ;
    }

    /**
     * 使用左移运算
     * @param dividend
     * @param divisor
     * @return
     */
    private int divide2(int dividend, int divisor) {

        dividend = dividend < 0 ?dividend : -dividend;
        divisor = divisor < 0 ?divisor : -divisor;
        int ret = 0;
        while (dividend <= divisor ) {
            int n = 0;
            while (dividend <= divisor << (n+1)  &&  (divisor << (n+1)  < 0 &&  divisor << (n+1) < divisor << n)) {
                n ++;
            }
            dividend = dividend - ( divisor << n );
            //为0的情况其实是减了一个divisor
            ret += 1 << n;

        }
        return ret ;
    }

    /*
     * 情况3 是否可以考虑转成 如下的计算方式
     *
     * 比如 3468 / 6 (当然还是不能用除法 可能结合 divide1)
     *  1、 计算34 / 6   得出5 余 4
     *  2、 5 加上后面的 6 变成56 / 6 得出 9 余 2
     *  3、 2加上 8 变成 28 / 6 得出4 余4
     *  4、 最后汇总 得到594
     */
    private int divide3(int dividend, int divisor) {
        return 0;
    }
    public static void main (String [] args) {
//        System.out.println(new LC29().divide(-7 , 3));
//        System.out.println(new LC29().divide(2147483647 , 1));
//        System.out.println(new LC29().divide( -2147483648 , 2));
//        System.out.println(new LC29().divide( 2 , 2));
        System.out.println(new LC29().divide( 1100540749, -1090366779));
//        System.out.print(new LC29().divide(-2147483648 , 1));


    }
}
