package alg4.ch1.sec2;

import edu.princeton.cs.algs4.StdIn;

/**
 * Author:   Fan(Aaron) Hu
 * Date:     2018/8/2 11:19
 * Description: 字符串逆序
 */
public class Ex07 {
    public static String mystery(String s) {
        int N = s.length();
        if (N <= 1) {
            return s;
        }
        String a = s.substring(0, N / 2);
        String b = s.substring(N / 2, N);
        return mystery(b) + mystery(a);
    }

    public static void main(String[] args) {
        System.out.println(mystery(StdIn.readLine()));
    }
}
