package leetcode;

/**
 * Author:   Fan(Aaron) Hu
 * Date:     9/23/2018 2:06 PM
 * Description: Find First and Last Position of Element in Sorted Array
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 */
public class Leetcode_34 {
    public int[] searchRange(int[] nums, int target) {
        int length = nums.length;

        if(null == nums || length == 0){
            return new int[]{-1, -1};
        }else{
            int index = binarySearch(nums, 0, length - 1, target);
            if(index != -1){
                int[] result = new int[2];
                int loIndex = index;
                int hiIndex = index;
                while(loIndex > 0 && nums[loIndex - 1] == nums[loIndex]){
                    loIndex --;
                }
                while(hiIndex < length - 1 && nums[hiIndex] == nums[hiIndex + 1]){
                    hiIndex ++;
                }
                result[0] = loIndex;
                result[1] = hiIndex;
                return result;
            }else{
                return new int[]{-1, -1};
            }
        }
    }
    // Faster
    public int binarySearch(int[] nums, int lo, int hi, int target){
        if(lo > hi){
            return -1;
        }
        int mid = lo + ((hi - lo) >> 1);
        if(nums[mid] > target){
            return binarySearch(nums, lo, mid - 1, target);
        }else if(nums[mid] < target){
            return binarySearch(nums, mid + 1, hi, target);
        }else{
            return mid;
        }
    }

    // public int binarySearch(int[] nums, int lo, int hi, int target){
    //     int mid;
    //     while(lo <= hi){
    //         mid = lo + (hi - lo) / 2;
    //         if(nums[mid] > target){
    //             hi = mid - 1;
    //         }else if(nums[mid] < target){
    //             lo = mid + 1;
    //         }else{
    //             return mid;
    //         }
    //     }
    //     return -1;
    // }
}
