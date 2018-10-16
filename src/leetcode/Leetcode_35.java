package leetcode;

/**
 * Author:   Fan(Aaron) Hu
 * Date:     9/23/2018 2:07 PM
 * Description: Search Insert Position
 * https://leetcode.com/problems/search-insert-position/description/
 */
public class Leetcode_35 {
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            throw new ArrayIndexOutOfBoundsException();
        if(nums.length == 1){
            if(nums[0] >= target)
                return 0;
            else
                return 1;
        }
        return binaryFind(nums, target);
    }

    public int binaryFind(int[] nums, int target){
        int lo = 0;
        int hi = nums.length - 1;
        int mid;
        while(lo <= hi){
            mid = lo + (hi - lo) / 2;
            if(nums[mid] < target){
                lo = mid + 1;
            }else if(nums[mid] > target){
                if(mid > 0 && nums[mid - 1] < target){
                    return mid;
                }else if(mid == 0)
                    return 0;
                hi = mid - 1;
            }else{
                return mid;
            }
        }
        if(nums[hi] < target){
            return hi+1;
        }else{
            return 0;
        }
    }
}
