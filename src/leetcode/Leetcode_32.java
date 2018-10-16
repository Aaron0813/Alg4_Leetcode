package leetcode;

import java.util.Stack;

/**
 * Author:   Fan(Aaron) Hu
 * Date:     2018/8/21 11:13
 * Description: Longest Valid Parentheses
 * https://leetcode.com/problems/longest-valid-parentheses/description/
 */
public class Leetcode_32 {
    public int longestValidParentheses(String s) {
        Stack parentheses = new Stack();
        int length = s.length();
        int p_length = 0;
        int left_length = 0;
        int right_length = 0;
        int current_length = 0;
        int count = 0;//记录左括号的压栈情况-"()(()"
        for(int i = 0; i < length; i++){//循环结束时，要清算最大长度
            char temp = s.charAt(i);
            if(temp == '('){//左括号，压入栈
                parentheses.push(temp);
                count++;
            }else if(temp == ')'){//右括号
                try{
                    char current_top = (char)parentheses.peek();
                    if(current_top == '('){//如果和栈顶元素匹配，则弹栈，计数器加2
                        parentheses.pop();
                        count--;
                        if(count == 0)
                            left_length += 2;
                        else
                            right_length +=2;
                    }else{//如果不匹配，则记录当前最大长度，并继续向后进行扫描
                        parentheses.push(temp);
                        current_length = left_length;
                        left_length = 0;
                    }
                }catch(java.util.EmptyStackException e){//当前栈顶为空-")()())"-跳过，读取下一个
                    parentheses.push(temp);
                    current_length = left_length;
                    left_length = 0;
                }

            }
        }
        if(count==0)
            p_length = Math.max(current_length,left_length ) + right_length;
        else
            p_length = Math.max(Math.max(Math.max(left_length,current_length),right_length),p_length);//ready to change
        return p_length;
    }

    public static void main(String[] args){
        String s = ")()(((())))(";
        Leetcode_32 leetcode_32 = new Leetcode_32();
        System.out.println(leetcode_32.longestValidParentheses(s));
    }
}
