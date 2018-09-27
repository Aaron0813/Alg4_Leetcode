package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author:   Fan(Aaron) Hu
 * Date:     9/27/2018 9:57 AM
 * Description:
 */
public class Leetcode_40 {
    /**
     * 自己的解答
     */
    List<List<Integer>> results;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        results = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return results;
        }
        Arrays.sort(candidates);
        // findSum(new ArrayList<Integer>(), candidates, 0, target, results);
        findSum(new ArrayList<Integer>(), candidates, 0, target);
        return results;
    }

    // private void findSum(List<Integer> subResult,int[] candidates, int startIndex, int target, List<List<Integer>> results){
    private void findSum(List<Integer> subResult, int[] candidates, int startIndex, int target) {
        if (0 < target) {
            for (int i = startIndex; i < candidates.length && candidates[i] <= target; i++) {
                subResult.add(candidates[i]);
                findSum(subResult, candidates, i + 1, target - candidates[i]);
                subResult.remove(subResult.size() - 1);
            }  // end of for
        } else if (0 == target) {
            if (!results.contains(subResult)) {
                results.add(new ArrayList<Integer>(subResult));
            }
        } else {
            return;
        }
    }
}
/**
 * 速度最快的解答
 */
class Solution40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length == 0)return res;
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        helper(res, list, candidates, target, 0);
        return res;
    }
    public void helper(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int pos) {
        if(target == 0) {
            res.add(new ArrayList(list));
        }
        for(int i = pos; i< candidates.length; i++) {
            if(candidates[i] > target) {
                break;
            }
            if(i != pos && candidates[i-1] == candidates[i]) {
            /*
            高明啊，很棒的去重方法--i==pos说明现在只是第一次访问到这个数值，可以重复,否则就要去重。得到的效果就是，
            对于[1,1,1,2,7,7,7,6] 9 这样的组合来说，[1,1,1,6]不会漏掉，但不会出现多个[2,7]- i == pos 很重要，还是要好好理解
            */
                continue;
            }
            list.add(candidates[i]);
            helper(res, list, candidates, target-candidates[i], i+1);
            list.remove(list.size()-1);
        }
    }
}