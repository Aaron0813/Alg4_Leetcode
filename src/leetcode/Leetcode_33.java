package leetcode;

/**
 * Author:   Fan(Aaron) Hu
 * Date:     9/21/2018
 * Description: Search in Rotated Sorted Array
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 */


public class Leetcode_33 {
    public int search(int[] nums, int target) {
        int length = nums.length;
        if (nums == null || nums.length == 0) {
            return -1;
        }


        if (length == 1) {
            if (nums[0] != target) {
                return -1;
            } else {
                return 0;
            }
        } else {
            // Judge whether is rotated
            int lo = 0;
            int hi = length - 1;
            if (nums[0] > nums[length - 1]) {//Yes
                int pivot = findPivot(nums);
                return (binarySearch(nums, lo, pivot, target) + binarySearch(nums, pivot + 1, hi, target) + 1);
            } else {//Binary Search
                return binarySearch(nums, lo, hi, target);
            }
        }
    }

    public int binarySearch(int[] nums, int lo, int hi, int target) {
        if (lo > hi) {//>= or > ?
            return -1;
        }
        int mid = (lo + hi) / 2;
        if (nums[mid] < target) {
            return binarySearch(nums, mid + 1, hi, target);
        } else if (nums[mid] > target) {
            return binarySearch(nums, lo, mid - 1, target);
        } else {
            return mid;
        }
    }

    public int findPivot(int[] nums) {
        int length = nums.length;
        return find(nums, 0, length - 1);
    }

    public int find(int[] nums, int lo, int hi) {
        int mid = (lo + hi) / 2;
        if (hi - lo >= 2) {
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {//get the pivot
                return mid;
            }
            if (nums[lo] > nums[mid] && nums[mid] < nums[hi]) {
                return find(nums, lo, mid);
            } else if (nums[lo] < nums[mid] && nums[mid] > nums[hi]) {
                return find(nums, mid, hi);
            } else {
                System.out.println("There are some exceptions");
                return -1;
            }
        } else {
            return lo;
        }

    }

}

class Solution33 {
    public int search(int[] nums, int target) {
 /*
 如果target比A[mid]值要小
 如果A[mid]右边有序（A[mid]<A[high])
 那么target肯定不在右边（target比右边的都得小），在左边找
 如果A[mid]左边有序
 那么比较target和A[low]，如果target比A[low]还要小，证明target不在这一区，去右边找；反之，左边找。
 如果target比A[mid]值要大
 如果A[mid]左边有序（A[mid]>A[low]）
 那么target肯定不在左边（target比左边的都得大），在右边找
 如果A[mid]右边有序
 那么比较target和A[high]，如果target比A[high]还要大，证明target不在这一区，去左边找；反之，右边找。

 如果左边有序 left < mid:
 if left < target <= mid: 肯定在左边
 else 右边
 else右边有序：
 if mid < target <= right: 肯定在右边
 else 左边
 */

        if (nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1, mid = 0;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[left] < nums[mid]) { // 左侧有序
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { // 右侧有序
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        if (nums[left] == target) {
            return left;
        }
        if (nums[right] == target) {
            return right;
        }
        return -1;
    }
}

