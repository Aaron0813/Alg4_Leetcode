package leetcode;

import java.util.*;

/**
 * Author:   Fan(Aaron) Hu
 * Date:     2018/8/12 14:31
 * Description: Three Sum
 * https://leetcode.com/problems/3sum/description/
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */

/**
 * 在书本中，作者用的是两个for循环加一个二分查找实现的，算法的复杂度为N^2*lgN
 * 但在本例中，算法的复杂度为N^2,虽然没有使用二分查找，但是速度快了很多
 * 且二分查找在应对数组中有重复元素时，会出现错误
 */
public class Leetcode_15 {
        public List<List<Integer>> threeSum(int[] nums) {
            Set<String> set = new HashSet<String>();
            List<List<Integer>> lists = new ArrayList<List<Integer>>();
            //排序
            Arrays.sort(nums);
            for(int i=0;i<nums.length;i++)
            {
                int key = 0 - nums[i];
                int left = (i==nums.length-1)?nums.length-1:i+1;
                int right = nums.length - 1;
                while(left<right)
                {
                    int temp = nums[left]+nums[right];
                    if(temp < key) left++;
                    else if(temp > key) right--;
                    else{
                        String solution = nums[i]+""+nums[left]+""+nums[right];
                        if(!set.contains(solution)){
                            set.add(solution);
                            lists.add(Arrays.asList(nums[i],nums[left],nums[right]));
                        }
                        right = nums.length - 1;//这句是否必要有待商榷
                        left++;

                    }

                }
            }
            return lists;
        }
}


/**
 * 课本提供的解法，对于[0,0,0]的输入会出错，主要错误在二分查找这一步
 */
class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        //排序
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                int key = -(nums[i]+nums[j]);
                if(!set.contains(key))
                {
                    int k = BinSearch(key,nums);
                    //找那个c
                    if(k>j)//找到了
                    {
                        List<Integer> subList = new ArrayList<Integer>();
                        subList.add(nums[i]);
                        subList.add(nums[j]);
                        subList.add(nums[k]);
                        lists.add(subList);
                        set.add(key);
                    }
                }

            }
        }
        return lists;

    }
    //Solution 1
//     private int BinSearch(int key, int[] a)
//     {
//         return BinSearch(key,a,0,a.length-1);
//     }

//     private int BinSearch(int key, int[] a, int lo, int hi)
//     {
//         if(lo > hi) return -1;
//         int mid = lo + (hi-lo)/2;
//         if(a[mid]>key) return BinSearch(key, a, lo, mid - 1);
//         else if(a[mid] < key) return BinSearch(key, a, mid + 1, hi);
//         else return mid;
//     }

    private int BinSearch(int num,int[] nums)
    {
        int lo = 0;
        int hi = nums.length-1;
        int mid;
        while(lo<=hi)//必须是等于
        {
            mid = lo+(hi-lo)/2;//这两个没太大区别吧
            // mid = (lo+hi)/2;
            if(nums[mid]>num) hi = mid-1;//这个加一减一不能省，否则会直接影响计算结果
            else if(nums[mid]<num) lo = mid+1;//
            else return mid;

        }
        return -1;
    }
}
