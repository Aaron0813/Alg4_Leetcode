package alg4.ch1.sec2;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Author:   Fan(Aaron) Hu
 * Date:     2018/8/2 15:26
 * Description: 补全括号
 */
public class Ex09 {
    public static void main(String[] args)
    {
        String input = "1+2)*3-4)*5-6)))";
        Stack<String> numbers = new Stack<String>();
        Stack<String> operator = new Stack<String>();
        int i = 0;
//        while(!StdIn.isEmpty())
        while(i < input.length())
        {
            String s = String.valueOf(input.charAt(i));
            if(s.equals("+"))
                operator.push(s);
            else if(s.equals("-"))
                operator.push(s);
            else if(s.equals("*"))
                operator.push(s);
            else if(s.equals("/"))
                operator.push(s);
            else if(s.equals(")"))
            {
                String op = operator.pop();
                String num2 = numbers.pop();
                String num1 = numbers.pop();
                String num= "("+num1+op+num2+")";
                numbers.push(num);
            }else numbers.push(s);
            i++;
        }
        StdOut.println(numbers.pop());

    }


}
