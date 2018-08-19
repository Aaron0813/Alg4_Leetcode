package leetcode;

/**
 * Author:   Fan(Aaron) Hu
 * Date:     2018/8/19 10:14
 * Description: Remove Duplicates from Sorted Array
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 */
public class Leetcode_26 {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        int count = 1;
        int index = 0;
        int isNoLarger = 0;
        int isChange = 0;
        for(int i = 0; i<length; i++){
            // index = i+1;
            isNoLarger = 0;
            isChange = 0;
            while(index < length && nums[count-1] >= nums[index]){
                index++;
                isNoLarger = 1;
            }
            if(index == length)
                break;
            if(isNoLarger == 1){
                nums[count] = nums[index];
                if(index == length - 1){
                    count+=1;
                    break;
                }
                isChange = 1;
            }

            if( nums[count-1] < nums[index] && isNoLarger == isChange)
                count++;

        }
        return count;
    }

    /**
     * Version 2 双层循环变单层循环，真的很骚啊
     */
    /**
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int start = 0;
        int curr = start + 1;
        while (curr < nums.length) {
            if (nums[start] != nums[curr]) {
                nums[++start] = nums[curr];
            }
            curr ++;
        }
        return start + 1;
    }
     */

    public static void main(String[] args){
        int[] nums = new int[]{1,2,3};
//        int[] nums = new int[]{1,2,2};
//        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        Leetcode_26 leetcode_26 = new Leetcode_26();
        int result = leetcode_26.removeDuplicates(nums);
        for(int i = 0; i<nums.length;i++){
            System.out.println(nums[i]);
        }
        System.out.println("Number = "+result);
}
    }
