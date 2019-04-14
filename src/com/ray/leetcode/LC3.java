package com.ray.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuChaoPang on 2019/4/14.
 *
 * Longest Substring Without Repeating Characters -Level E
 *
 * Given a string, find the length of the longest substring without repeating characters.
 *
 */
public class LC3 {
    /*
     * 1、记录变量子串的起始坐标，将位置记录进Map
     * 2、遍历到重复的 ，记录子串长度，舍弃掉子串中重复字符之前的 字符串
     *   即从重复的字符串后面开始继续统计，同时对比当前记录的最长长度
     */
    public int lengthOfLongestSubstring(String s) {

        if (s == null && s.length() < 1) {
            return  0;
        }
        if (s.length() == 1) {
            return  1;
        }

        int point = 0; //表示标记的子串开始节点
        Map<Character, Integer> pointMap = new HashMap<Character, Integer>();
        int currPoint = 0; //遍历子串记录的临时变量
        int maxLen = 0;
        int currLen = 0;
        while (currPoint < s.length()) {
            char c = s.charAt(currPoint);
            Integer currCharPoint = pointMap.get(c);
            if (currCharPoint != null && currCharPoint >= point ) {
                if (maxLen < currLen) {
                    maxLen = currLen;
                }
                //重复的字符 前面的长度全部舍弃 -- 这里没有把本身的重复的位置减去是因为新加一个一样的字符
                currLen = currLen - (currCharPoint - point) ;
                //起始位置变更成 重复字符的后一个位置开始
                point = pointMap.get(c) + 1;
            } else {
                currLen ++;
                if (currPoint == s.length() - 1 && maxLen <= currLen) {
                   maxLen = currLen;
                }
            }
            pointMap.put(c, currPoint);
            currPoint ++;

        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new LC3().lengthOfLongestSubstring("au"));
    }
}
