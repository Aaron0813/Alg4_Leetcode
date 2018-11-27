/**
 * https://leetcode.com/problems/move-zeroes/description/
 */
/*Correct answer*/
public void moveZeroes(int[] nums) {

    int j = 0;
    for(int i = 0; i < nums.length; i++) {
        if(nums[i] != 0) {
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
            j++;
        }
    }
}
/*
        int zero = 0,  ptr = 0;
        while(ptr < nums.length){
            if(nums[ptr] != 0){
                int tmp = nums[zero];
                nums[zero++] = nums[ptr];
                nums[ptr++] = tmp;
            }else{
                ptr++;
            }
        }
*/
/*stupid and wrong answer*/
/*
对于
[4,2,4,0,0,3,0,5,1,0]
这样的输入,i会在j的后面,这样会导致顺序出错
*/
class Solution{
    public void moveZeroes(int[] nums) {
        int length = nums.length;
        if(nums == null || length == 0 || length == 1)
            return;
        
        int i = 0, j = 1;
        while(j < length){
            while(i < length && nums[i] != 0) i++;
            while(j < length && nums[j] == 0) j++;
            if(j < length && i < length){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
                j++;
            }else{
                break;
            }
        }
        return;
    }
    
}