/*
https://leetcode.com/problems/add-binary/description/
*/
/*示例解法-should be passed*/
public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() -1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
}
/*虽然是个Easy级别的题目,但是两次都没有写对.
第一次思路不对,想的太复杂了,导致费时费力不讨好,也没有写过.
第二次思路虽然是对的(还是参照了示例解法的),但是细节还是频频出错
(
1.length没有减一,这个错误最近经常犯
2.其次是如果直接用char进行Integer.valueOf,那得到的值是对应的ASCII码而不是数值,
想直接得到数值需要通过String来获取,但是这样就存在切割字符子串的问题,还是实例代码里面用-'0'的方法来取值,是真的机智
3.),这样在以后的面试里面也是不够的
作为一道FB的高频题,如果不能快速AC,那真的是一点希望都没有的
*/

/* 第一次的解法*/
class Solution {
    public String addBinary(String a, String b) {
        int length_a = a.length();
        int length_b = b.length();
        String result = "";
        int length = Math.min(length_a, length_b);
        char c ='0';
        for(int i = 0; i < length; i++){
            char a_char = a.charAt(length_a - length);
            char b_char = b.charAt(length_b - length);
            String temp = add(a_char, b_char, c);
            if(temp == "11"){
                result = "1" + result;
                c = '1';
            }else if(temp == "10"){
                result = "0" + result;
                c = '1';
            }else if(temp == "01"){
                result = "1" + result;
                c = '0';
            }else{
                result = "0" + result;
                c = '0';
            }
        }
        while(length_a > length){
            length++;
            if(c == '1'){
                if(a.charAt(length_a - length) == '1'){
                    result = "0" + result;
                    c = '1';
                }else{
                    result = "1" + result;
                    c = '0';
                }
            }else{
                result = String.valueOf(a.charAt(length_a - length)) + result;
                c = '0';
            }
        }
//         if(c == '1'){
//             result = "1"+result;
//         }
            
        
        while(length_b > length){
            length++;
            if(c == '1'){
                if(b.charAt(length_b - length) == '1'){
                    result = "0" + result;
                    c = '1';
                }else{
                    result = "1" + result;
                    c = '0';
                }
            }else{
                result = String.valueOf(b.charAt(length_b - length)) + result;
                c = '0';
            }
        }
        if(c == '1'){
            result = "1"+result;
        }
        return result;
        
    }
    
    private String add(char a, char b, char c){
        String result = "";
        if(a=='1' && b=='1' && c=='1'){
            result = "11";
            return result;
        }else if(a=='1' && b=='1' && c=='0'){
            result = "10";
            return result;
        }else if(a=='0' && b=='0' && c=='0'){
            result = "00";
            return result;
        }else if((a=='1' || b=='1') && c=='1'){
            result = "10";
            return result;
        }else{
            result = "01";
            return result;
        }
    }
}



/*第二次的解法*/
class Solution {
    public String addBinary(String a, String b) {
        int length_a = a.length();
        int length_b = b.length();
        int carry = 0;
        String res = "";
        int index = 0;
        for(; index < length_a && index < length_b; index++){
            int temp_a = Integer.valueOf(a.charAt(index)), temp_b = Integer.valueOf(b.charAt(index));
            int result = (temp_a + temp_b + carry) % 2;
            carry = (temp_a + temp_b + carry) / 2;
            res = String.valueOf(result) + res;
        }
        while(index < length_a){
            int temp_a = Integer.valueOf(a.charAt(index));
            int result = (temp_a + carry) % 2;
            carry = (temp_a + carry) / 2;
            res = String.valueOf(result) + res;
            index++;
        }
        
        while(index < length_b){
            int temp_b = Integer.valueOf(b.charAt(index));
            int result = (temp_b + carry) % 2;
            carry = (temp_b + carry) / 2;
            res = String.valueOf(result) + res;
            index++;
        }
        System.out.println(carry);
        if(carry == 1){
            res = "1" + res;
        }
        return res;
        
    }
}