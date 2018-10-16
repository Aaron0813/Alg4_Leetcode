package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Author:   Fan(Aaron) Hu
 * Date:     2018/8/16 16:48
 * Description: Generate Parentheses
 * https://leetcode.com/problems/generate-parentheses/description/
 */
public class Leetcode_22 {
    public List<String> generateParentheses_verson1(int n){
        if(n == 1){
           List<String> lists = new ArrayList<>();
           lists.add("()");
           return lists;
        }else{
            Set<String> setBefore = new HashSet<>();
            Set<String> setAfter = new HashSet<>();
            String[] results = new String[3];
            List<String> lists = new ArrayList<>();
            List<String> subLists = generateParentheses_verson1(n-1);
//            if(n%2==0){//这个不能漏
//                List<String> subHalfLists = generateParentheses_verson1(n/2);
//                for(String subHalfResult: subHalfLists){
//                    if(!setAfter.contains(subHalfResult+""+subHalfResult)){
//                        setAfter.add(subHalfResult+""+subHalfResult);
//                        lists.add(subHalfResult+subHalfResult);
//                    }
//                }
//            }else{
                List<String> subHalfListsBigger = generateParentheses_verson1(n-n/2);
                List<String> subHalfListsSmaller = generateParentheses_verson1(n/2);
                for(String subResultBigger: subHalfListsBigger){
                    for(String subResultSmaller:subHalfListsSmaller){
                        if(!setAfter.contains(subResultBigger+""+subResultSmaller)){
                            setAfter.add(subResultBigger+""+subResultSmaller);
                            lists.add(subResultBigger+subResultSmaller);
                        }else if(!setAfter.contains(subResultSmaller+subResultBigger)){
                            setAfter.add(subResultSmaller+subResultBigger);
                            lists.add(subResultSmaller+subResultBigger);
                        }
                    }
                }
//            }

            for (String subResult: subLists) {
//                if(!setBefore.contains(subResult)){
//                    setBefore.add(subResult);
                    results[0] = "()"+subResult;
                    results[1] = subResult+"()";
                    results[2] = "("+subResult+")";
                    for (int i = 0; i < results.length; i++) {
                        if(!setAfter.contains(results[i])){
                            setAfter.add(results[i]);//这里可能会出问题
                            lists.add(results[i]);
                        }
                    }
//                }
            }
            return lists;
        }
    }

    public List<String> generateParentheses_verson2(int n){
        if(n == 1){
            List<String> lists = new ArrayList<>();
            lists.add("()");
            return lists;
        }else{
//            Set<String> setBefore = new HashSet<>();
//            Set<String> setAfter = new HashSet<>();
            String[] results = new String[3];
            List<String> lists = new ArrayList<>();
            List<String> subLists = generateParentheses_verson2(n-1);
            for (String subResult: subLists) {
                results[0] = "()"+subResult;
                results[1] = subResult+"()";
                results[2] = "("+subResult+")";
                for (int i = 0; i < results.length; i++) {
                    lists.add(results[i]);
                }


//                if(!setBefore.contains(subResult)){
////                    setBefore.add(subResult);
////                    results[0] = "()"+subResult;
////                    results[1] = subResult+"()";
////                    results[2] = "("+subResult+")";
////                    for (int i = 0; i < results.length; i++) {
////                        if(!setAfter.contains(results[i])){
////                            setAfter.add(results[i]);//这里可能会出问题
////                            lists.add(results[i]);
////                        }
////                    }
////                }
            }
            return lists;
        }
    }

    /**
     *  Output: 13
     ["()()()()()","(()()()())","()(())(())","(())(())()","((())(()))","()(()()())","(()()())()","((()()()))","()()(()())","()(()())()","(()(()()))","(()())()()","((()())())","()((()()))","((()()))()","(((()())))","()()()(())","()()(())()","(()()(()))","()(())()()","(()(())())","()(()(()))","(()(()))()","((()(())))","(())()()()","((())()())","()((())())","((())())()","(((())()))","()()((()))","()((()))()","(()((())))","((()))()()","(((()))())","()(((())))","(((())))()","((((()))))"]
     *  Expected 14
     ["((((()))))","(((()())))","(((())()))","(((()))())","(((())))()","((()(())))","((()()()))","((()())())","((()()))()","((())(()))","((())()())","((())())()","((()))(())","((()))()()","(()((())))","(()(()()))","(()(())())","(()(()))()","(()()(()))","(()()()())","(()()())()","(()())(())","(()())()()","(())((()))","(())(()())","(())(())()","(())()(())","(())()()()","()(((())))","()((()()))","()((())())","()((()))()","()(()(()))","()(()()())","()(()())()","()(())(())","()(())()()","()()((()))","()()(()())","()()(())()","()()()(())","()()()()()"]
     */
    public static void main(String[] args){
        Leetcode_22 leetcode_22 = new Leetcode_22();
        int n = 5;
        /**
         * Test for version 1
         */
        List<String> results1 = leetcode_22.generateParentheses_verson1(n);
        Set<String> sets1 = new HashSet<>();
        int count1=0;
        int counts1=0;
        for (String result:results1) {
            if(!sets1.contains(result)){
                sets1.add(result);
                System.out.println(result);
                count1++;
            }else{
                System.out.println("---------------Redundant-------------------------");
            }
            counts1++;
        }

        System.out.println("Count 0: "+count1);
        System.out.println("Count 1: "+counts1);

        /**
         * Test for version 2
         */

//        List<String> results = leetcode_22.generateParentheses_verson2(n);
//        Set<String> sets = new HashSet<>();
//        int count=0;
//        int counts=0;
//        for (String result:results) {
//            if(!sets.contains(result)){
//                sets.add(result);
//                System.out.println(result);
//                count++;
//            }else{
//                System.out.println("---------------Redundant-------------------------");
//            }
//            counts++;
//        }
//
//        System.out.println("Count 0: "+count);
//        System.out.println("Count 1: "+counts);
    }
}
