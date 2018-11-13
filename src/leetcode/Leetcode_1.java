class Solution {
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < length; i++){
            map.put(nums[i],i);
        }
        Arrays.sort(nums);
        int start = 0;
        int end = length - 1;
        while(start < end){
            if(nums[start] + nums[end] < target){
                start++;
            }else if (nums[start] + nums[end] > target){
                end--;
            }else{
                break;
            }   
        }
        return new int[]{map.get(nums[start]), map.get(nums[end])};
    }
}


/**Passed**/
/*HashMap 存储相同Integer对象时,是怎么存储的*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        int start = 0;
        int end = length - 1;
//         while(True){
            
//         }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < length; i++){
            map.put(nums[i],i);
        }
        Integer res = null;
        // int stat
        for(int i = 0; i < length; i++){
            res = map.get(target - nums[i]);
            if(res != null && res != i){
                start = i;
                break;
            }
        }
        return new int[]{start, res};
        // if(map.get(target - nums))
        // Arrays.sort(nums);
        // int start = 0;
        // int end = length - 1;
        // while(start < end){
        //     if(nums[start] + nums[end] < target){
        //         start++;
        //     }else if (nums[start] + nums[end] > target){
        //         end--;
        //     }else{
        //         break;
        //     }   
        // }
        // return new int[]{map.get(nums[start]), map.get(nums[end])};
    }
    
    // public int binarySearch(int[] nums, target){
    //     int start = 0;
    //     int end = nums.length - 1;
    //     while(start + 1 < end){
    //         int mid = start + (end - start)/2;
    //         if(nums[mid] < target)
    //     }
    // }
}


//////////////////
class Solution {
    public int[] twoSum(int[] nums, int target){
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < length; i++){
            //当第一次访问的时候,因为这个值还没有放进去,所以不会出现重复;
            //当第二次检查的时候,之前的值就已经存进去了,这时候就可以了
            if(map.containsKey(target - nums[i])){
                int start = map.get(target - nums[i]);
                int end = i;
                 return new int[]{start, end};  
            }else{
                map.put(nums[i],i);
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }  
}