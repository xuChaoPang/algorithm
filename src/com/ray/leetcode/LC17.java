package com.ray.leetcode;

import java.util.*;

/**
 * Created by RayXu on 2019/4/1.
 */
public class LC17 {

    private static Map<Character ,List> numberMap = new HashMap<Character, List>();

    static{
        numberMap.put('2', Arrays.asList(new String[]{"a", "b", "c"}) );
        numberMap.put('3', Arrays.asList(new  String []{"d","e","f"}) );
        numberMap.put('4', Arrays.asList(new  String []{"g","h","i"}) );
        numberMap.put('5', Arrays.asList(new  String []{"j","k","l"}) );
        numberMap.put('6', Arrays.asList(new  String []{"m","n","o"}) );
        numberMap.put('7', Arrays.asList(new  String []{"p","q","r","s"}) );
        numberMap.put('8', Arrays.asList(new  String []{"t","u","v"}) );
        numberMap.put('9', Arrays.asList(new  String []{"w","x","y","z"}) );
    }

    public List<String> letterCombinations(String digits) {
        List<String> retVec = new ArrayList<String>();
        Map<String ,List> currencyMap = new HashMap<String ,List>();
        if (digits == null || digits.length() <= 0) {
            return retVec;
        }
        for  (int j = 0 ; j < digits.length() ; j ++) {

            char num = digits.charAt(j);

            if (j == 0) {
                currencyMap.put(num + "", numberMap.get(num));
                continue;
            }
            List<String> numsVector = numberMap.get(num);
            String preFix = digits.substring(0, j);
            List<String> prefixVector = currencyMap.get(preFix);
            String newPreFix =  digits.substring(0, j + 1);
            currencyMap.put(newPreFix, new ArrayList<String>());
            for (int i = 0 ; i < prefixVector.size(); i ++) {
                for (String str : numsVector) {
                    currencyMap.get(newPreFix).add(i, prefixVector.get(i) + str);
                }
            }
        }
        return currencyMap.get(digits);
    }

    public static void main (String [] args) {
        System.out.print(new LC17().letterCombinations("23"));
    }
}
