package leetcode;

import java.util.Stack;

/**
 * Author:   Fan(Aaron) Hu
 * Date:     2018/8/16 9:59
 * Description: Valid Parentheses
 * https://leetcode.com/problems/valid-parentheses/description/
 */
public class Leetcode_20 {
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
        Leetcode_20 validParentheses = new Leetcode_20();
        System.out.println(validParentheses.isValid(")("));

    }
}
