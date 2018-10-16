package leetcode;

/**
 * Author:   Fan(Aaron) Hu
 * Date:     2018/8/19 15:35
 * Description: Next Permutation
 * https://leetcode.com/problems/next-permutation/description/
 */
public class Leetcode_31 {

    public void nextPermutation(int[] nums) {
        int length = nums.length;
        if(length > 1){
            int j = length -1;
            while(j > 1 && nums[j-1] >= nums[j]){
                j--;
            }
            System.out.println("J = "+j+", nums[i] = "+nums[j-1]+",nums[j] = "+nums[j]);
            if(j == 1 && nums[j-1] > nums[j]){
                reverse(nums,0);
            }else{
                int k = length -1;
                while(k > 0 && nums[j-1] >= nums[k]){
                    k--;
                }
                swap(nums,j-1,k);
                System.out.println(j);
                reverse(nums,j);
            }
        }
    }

    public void swap(int[] nums, int i, int k){
        int temp = nums[i];
        nums[i] = nums[k];
        nums[k] = temp;
    }

    public void reverse(int[] nums, int start){
        int end = nums.length - 1;
        while(start<=end){
            swap(nums,start,end);
            start++;
            end--;
        }
    }

    public static void main(String[] args){
        int[] test = new int[]{5,1,1};
        Leetcode_31 leetcode_31 = new Leetcode_31();
        leetcode_31.nextPermutation(test);
        for (int i = 0; i < test.length; i++) {
            System.out.print(test[i]+" ,");
        }
    }
}
