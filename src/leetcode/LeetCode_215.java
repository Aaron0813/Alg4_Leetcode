/**
https://leetcode.com/problems/kth-largest-element-in-an-array/description/
貌似还有一个快速排序的做法
*/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int size = k;
        Queue<Integer> queue = new PriorityQueue<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(queue.size() < k){
                queue.offer(nums[i]);
            }else{
                if(nums[i] > queue.peek()){
                    queue.poll();
                    queue.offer(nums[i]);
                }
            }
            
        }
        return queue.peek();
    }
}
