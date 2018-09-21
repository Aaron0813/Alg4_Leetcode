package leetcode;

/**
 * Author:   Fan(Aaron) Hu
 * Date:     9/21/2018
 * Description: Search in Rotated Sorted Array
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 */
public class Leetcode_33 {
    class Solution {
        public int search(int[] nums, int target) {
            int length = nums.length;
            if(nums == null || nums.length == 0){
                return -1;
            }


            if(length == 1){
                if(nums[0] != target){
                    return -1;
                }else{
                    return 0;
                }
            }else{
                // Judge whether is rotated
                int lo = 0;
                int hi = length - 1;
                if(nums[0] > nums[length - 1]){//Yes
                    int pivot = findPivot(nums);
                    return (binarySearch(nums, lo, pivot, target) + binarySearch(nums, pivot+1, hi, target) + 1);
                }else{//Binary Search
                    return binarySearch(nums, lo, hi, target);
                }
            }
        }

        public int binarySearch(int[] nums, int lo, int hi, int target){
            if(lo > hi){//>= or > ?
                return -1;
            }
            int mid = (lo + hi) / 2;
            if(nums[mid] < target){
                return binarySearch(nums, mid + 1, hi, target);
            }else if(nums[mid] > target){
                return binarySearch(nums, lo, mid - 1, target);
            }else{
                return mid;
            }
        }

        public int findPivot(int[] nums){
            int length = nums.length;
            return find(nums, 0, length - 1);
        }

        public int find(int[] nums, int lo, int hi){
            int mid = (lo + hi) / 2;
            if(hi - lo >= 2){
                if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]){//get the pivot
                    return mid;
                }
                if(nums[lo] > nums[mid] && nums[mid] < nums[hi]){
                    return find(nums, lo, mid);
                }else if(nums[lo] < nums[mid] && nums[mid] > nums[hi]){
                    return find(nums, mid, hi);
                }else{
                    System.out.println("There are some exceptions");
                    return -1;
                }
            }else{
                return lo;
            }

        }
    }
}
