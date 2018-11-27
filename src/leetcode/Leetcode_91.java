/*
 *https://leetcode.com/problems/decode-ways/description/
 */

/*Correct Answer*/
public int numDecodings(String s) {
    int n = s.length();
    if (n == 0) return 0;
    /*n+1这个设计比较难以理解*/
    int[] memo = new int[n+1];
    /*基底情况*/
    memo[n]  = 1;
    memo[n-1] = s.charAt(n-1) != '0' ? 1 : 0;
    /*从后往前走可以避免数组越界--在去substring的时候*/
    for (int i = n - 2; i >= 0; i--)
        if (s.charAt(i) == '0') continue;
        /*这个程序不会立即中断,而是一直把答案传递下去*/
        else memo[i] = (Integer.parseInt(s.substring(i,i+2))<=26) ? memo[i+1]+memo[i+2] : memo[i+1];
        /*修改,当发现意外情况立即中断*/
        if(memo[i] == 0) return 0;
        
    return memo[0];
}

/*Wrong and ugly answer*/
class Solution {
    public int numDecodings(String s) {
        int length = s.length();
        if(s == null || length == 0){
            return 0;
        }
        
        
        if(length == 1){
            if(s.charAt(0) == '0'){
                return 0;
            }else{
                return 1;
            }
            
        }
        if(length == 2){
            if(s.charAt(0) == '0')
                return 0;
            if(s.charAt(length - 1) == '0')
                return 1;
            if(Integer.valueOf(s) <= 26){
                return 2;
            }else{
                return 1;
            }
        }
        
        if(s.charAt(0) == '0' || (s.charAt(length - 1) == '0'))
            return 0;
        int[] res = new int[s.length()];
        res[0] = 1;
        int temp = Integer.valueOf(s.substring(0, 2)); // 注意边界检测
        res[1] = res[0];
        if(temp <= 26){
            res[1] += 1;
        }
        
        for(int i = 2; i < length - 1; i++){
            int val = Integer.valueOf(s.substring(i - 1, i + 1)); // 注意数组越界
            if(s.charAt(i) != '0'){
                res[i] = res[i - 1];
            }
            if(val <= 26){
                res[i] += res[i - 2];
            }
            
            if(res[i] == 0){
                return 0;
            }
        }
        res[length - 1] = res[length - 2];
        if(Integer.valueOf(s.substring(length - 1)) <= 26){
            res[length - 1] += res[length - 3];
        }
        
        return res[length - 1];
    }
}