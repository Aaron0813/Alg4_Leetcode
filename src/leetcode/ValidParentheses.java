package leetcode;

import java.util.Stack;

/**
 * Author:   Fan(Aaron) Hu
 * Date:     2018/8/16 9:59
 * Description: https://leetcode.com/problems/valid-parentheses/description/
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> Parentheses = new Stack<Character>();
        int length = s.length();
        for (int i = 0; i < length; i++)
        {
            char temp = s.charAt(i);
            Character pair;
            try{
                switch (temp){
                    case '(':
                    case '{':
                    case '[':
                        Parentheses.push(temp);
                        break;
                    case ')':
                        pair = Parentheses.pop();
                        if(!(pair.charValue()==('(')))
                            return false;
                        else
                            break;
                    case ']':
                        pair = Parentheses.pop();
                        if(!(pair.charValue()==('[')))
                            return false;
                        else
                            break;
                    case '}':
                        pair = Parentheses.pop();
                        if(!(pair.charValue()==('{')))
                            return false;
                        else
                            break;
                }
            }catch(java.util.EmptyStackException e){
                return false;
            }

        }
        if(Parentheses.isEmpty())
            return true;
        else
            return false;

    }

    public static void main(String[] args){
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid(")("));

    }
}
