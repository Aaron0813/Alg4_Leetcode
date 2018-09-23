package leetcode;

/**
 * Author:   Fan(Aaron) Hu
 * Date:     9/23/2018 2:11 PM
 * Description: Find Minimum in Rotated Sorted Array
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
 */
public class Leetcode_153 {
    public int findMin(int[] nums) {
        int length = nums.length;
        if(nums == null || length == 0){
            return -1;
        }
        if(length == 1){
            return nums[0];
        }
        int lo = 0;
        int hi = length - 1;
        while(lo + 1 < hi){
            //真的是逼我用位移
            int mid = lo + ((hi - lo) >> 1);
            if(nums[mid] < nums[lo] && nums[mid] < nums[hi]){
                if(nums[lo] < nums[hi]){
                    lo = mid;
                }else{
                    hi = mid;
                }
            }else{
                if(nums[lo] < nums[hi]){
                    hi = mid;
                }else{
                    lo = mid;
                }
            }
        }
        return Math.min(nums[lo], nums[hi]);
    }
}
