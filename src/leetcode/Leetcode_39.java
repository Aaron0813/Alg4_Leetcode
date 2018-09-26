package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author:   Fan(Aaron) Hu
 * Date:     9/25/2018 9:15 PM
 * Description: Combination Sum - 经典的DFS问题，for loop的位置很重要，过一阵子要再写一次
 * https://leetcode.com/problems/combination-sum/description/
 */
public class Leetcode_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if(candidates == null || candidates.length == 0){
            return results;
        }
        Arrays.sort(candidates);
        findSum(new ArrayList<Integer>(), candidates, 0, target, results);
        return results;
    }

    private void findSum(List<Integer> subResult,int[] candidates, int startIndex, int target, List<List<Integer>> results){
        // for(int i = startIndex; i < candidates.length; i++){//之前最大的失误在于for循环位置写错了，写在了判断target值的最外面-导致出现了很多的重复解
        if(0 < target){
            for(int i = startIndex; i < candidates.length; i++){//之前最大的失误在于for循环位置写错了，写在了判断target值的最外面
                subResult.add(candidates[i]);
                // List<Integer> preResult = new ArrayList(subResult);
                // target = target - candidates[i]; // 不能在循环内部直接进行相减，这样的话会影响下一次循环的target赋值情况
                findSum(subResult, candidates, i, target - candidates[i], results);
                // findSum(preResult, candidates, i, target - candidates[i], results); //也不需要在循环里就进行两次操作，毕竟i是可以向下++的，会自动把duplicate的情况考虑进去
                subResult.remove(subResult.size() - 1);
            }  // end of for
        }else if(0 == target){
            results.add(new ArrayList<Integer>(subResult));
        }else{
            return ;
        }
        // }
    }
    /**
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if(candidates == null || candidates.length == 0){
            return results;
        }
        Arrays.sort(candidates);
        findSum(new ArrayList<Integer>(), candidates, 0, target, results);
        return results;
    }

    private void findSum(List<Integer> subResult,int[] candidates, int startIndex, int target, List<List<Integer>> results){
        for(int i = startIndex; i < candidates.length; i++){
//            System.out.println("i="+i);
            if(candidates[i] < target){
                subResult.add(candidates[i]);
                List<Integer> preResult = new ArrayList(subResult);
                target = target - candidates[i];
                findSum(subResult, candidates, i, target, results);
                findSum(preResult, candidates, i + 1, target, results);

                int size1 = subResult.size();
                if(size1 > 0){
                    subResult.remove(size1 - 1);
                }

                int size2 = subResult.size();
                if(size2 > 0){
                    preResult.remove(size2 - 1);
                }
            }else if(candidates[i] == target){
                subResult.add(candidates[i]);
                // for(int j : subResult){
                //     System.out.println(j);
                // }
                results.add(new ArrayList<Integer>(subResult));
            }else{
                int size = subResult.size();
                // System.out.println("size = "+size);
                if(size > 0){
                    subResult.remove(subResult.size() - 1);
                }
                // exceed
            }
        }
    }
     */
    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }
    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }
    public static String int2dListToString(List<List<Integer>> nums) {
        StringBuilder sb = new StringBuilder("[");
        for (List<Integer> list: nums) {
            sb.append(integerArrayListToString(list));
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args){
        int[] input = new int[]{2,3,5};
        int target = 8;
        Leetcode_39 leetcode_39 = new Leetcode_39();
        List<List<Integer>> result = leetcode_39.combinationSum(input, target);
        System.out.print(int2dListToString(result));
    }
}
