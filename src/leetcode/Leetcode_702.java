/*
> LC 702
```
Given an integer array sorted in ascending order, write a function to search target in nums.  If target exists, then return its index, otherwise return -1. However, the array size is unknown to you. You may only access the array using an ArrayReader interface, where ArrayReader.get(k) returns the element of the array at index k (0-indexed).

You may assume all integers in the array are less than 10000, and if you access the array out of bounds, ArrayReader.get will return 2147483647.
```

>Example 1:
```
Input: array = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4
```
> Example 2:
```
Input: array = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1
```
> Note:
```
You may assume that all elements in the array are unique.
The value of each element in the array will be in the range [-9999, 9999].
```
*/

// 初始版本
/*
几个坑点:
一开始想的是把hi置为target,然后动态增加或者减少.但是会遇到的问题是
 > target可能为0, 所以加了个2
 > target可能为负数,所以加了Math.abs()
 
 后来发现几个比较好的做法是,先把hi置为1,然后用
 while (reader.get(high) < target){
            high *= 2;
 }
 这个写法比我的优雅,而且能够适应无限长度的数组,有人用
  while (reader.get(high) != 2147483647){
            high *= 2;
 }
 但这个显然无法适应无限长度的数组,且在数组长度较大的时候,target数值比较小时,无法取得很好的效果
*/
class Solution {
    public int search(ArrayReader reader, int target) {
        int lo = 0, hi = Math.abs(target) + 2;
        while(lo + 1 < hi){
            int mid = lo + (hi - lo) / 2;
            int value = reader.get(mid);
            if(value == target){
                hi = mid;
                break;
            }else if(value < target){
                lo = mid;
                hi = hi + mid;
            }else if(value > target){
                hi = mid;
            }
            /*
            else if(value == 2147483647){
                hi = mid;
            }*/
        }
        if(reader.get(lo) == target){
            return lo;
        }
        
        if(reader.get(hi) == target){
            return hi;
        }
        
        return -1;
    }
}
