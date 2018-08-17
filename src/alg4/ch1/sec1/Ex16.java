package alg4.ch1.sec1;
/**
 * Author:   Fan(Aaron) Hu
 * Date:     2018/8/2 11:19
 * Description: 递归+字符串拼接
 */
public class Ex16 {
    public static String exR1(int n) {
        if (n <= 0) {
            return "";
        }
        return exR1(n - 3) + n + exR1(n - 2) + n;
    }

    public static void main(String[] args) {
        System.out.println(exR1(6));
    }
}
