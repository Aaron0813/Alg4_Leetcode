package leetcode;

/**
 * Author:   Fan(Aaron) Hu
 * Date:     2018/8/17 16:16
 * Description: Remove  Element
 * https://leetcode.com/problems/remove-element/description/
 */
public class Leetcode_27 {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        int pointer = 0;
        int length = nums.length;
        for(int i = 0; i < nums.length; i++){
            if(val!=nums[i]){
                count++;
            }else{
                pointer = count + 1;
                while(pointer<length&&val==nums[pointer])
                    pointer++;
                if(pointer<length){
                    nums[count++] = nums[pointer];
                    nums[pointer] = val;
                }

            }
        }
        return count;
    }
}
