/*
https://leetcode.com/problems/peak-index-in-a-mountain-array/submissions/


一开始试图用mid, lo 以及hi三个值进行判断,分别缩进左边界和右边界,后来发现这种做法很麻烦,速度也不好
参照别人的思路之后发现用mid, mid - 1以及mid + 1效果更好;应该紧紧抓住题目对于山的这个定义来做的

*/
//初始做法
class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int lo = 0, hi = A.length -1;
        while(lo + 1 < hi){
            int mid = lo + (hi - lo) / 2;
            int lo_bak = lo, hi_bak = hi;
            if(A[mid] <= A[hi_bak]){
                lo = mid;
            }else if(A[mid] > A[hi_bak]){
                hi--;
            }
            
            if(A[mid] <= A[lo_bak]){
                hi = mid;
            }else if(A[mid] > A[lo_bak]){
                lo++;
            }
        }
        return A[lo] < A[hi] ? hi : lo;
        
    }
}


// 改进做法
class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int lo = 0, hi = A.length -1;
        while(lo + 1 < hi){
            int mid = lo + (hi - lo) / 2;
            if(A[mid] > A[mid - 1] && A[mid] > A[mid + 1]){
                lo = mid;
                break;
            }else if(A[mid] > A[mid - 1] && A[mid + 1] > A[mid]){
                lo = mid;
            }else{
                hi = mid;
            }
        }
        return A[lo] < A[hi] ? hi : lo;
    }
}
