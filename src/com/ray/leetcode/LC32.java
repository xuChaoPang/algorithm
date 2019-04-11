package com.ray.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by xuChaoPang on 2019/4/10.
 * Longest Valid Parentheses
 * Given a string containing just the characters '(' and ')',
 * find the length of the longest valid (well-formed) parentheses substring.
 */
public class LC32 {
    public int longestValidParentheses(String s) {

        if (s == null || s.length() <= 1) {
            return 0;
        }
        if (!s.contains("(") &&!s.contains(")") ) {
            return 0;
        }
        return longestValidParentheses1(s);
    }

    /*
     * 暴力破解
     */
    private int longestValidParentheses1(String s) {

        if (s == null || s.length() <= 1) {
            return 0;
        }
        int maxLen = 0;
        Stack<Character>  stack = new Stack<Character>();
        char [] sc = s.toCharArray();
        for (int i = 0; i < sc.length; i++) {

            if (sc[i] == ')') {
                continue;
            }
            int curLen = 0;
            int point = i;

            //可能有些需要等后面遍历完才知道是否要计入长度，作为临时变量保存
            int curOLen = 0;
            while (true) {
                if (point >= sc.length) {
                    stack.clear();
                    break;
                }
                if ( sc[point] == '(') {
                    stack.push(sc[point]);
                    point++;
                    continue;
                } else /* ')'的情况*/{
                    if (stack.isEmpty() ) {
                        break;
                    } else {
                        stack.pop();
                        curOLen += 2;
                        point++;
                        if (stack.isEmpty() ) {
                            curLen += curOLen;
                            curOLen = 0;
                        }

                    }

                }
            }
            if (curLen > maxLen) {
                maxLen = curLen;
            }


        }
        return maxLen;
    }



    public static void main(String[] args) {
        String s = "()";
        System.out.println(new LC32().longestValidParentheses(s));
    }
}
