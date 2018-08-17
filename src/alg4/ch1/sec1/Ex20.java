package alg4.ch1.sec1;
/**
 * Author:   Fan(Aaron) Hu
 * Date:     2018/8/2 11:19
 * Description: 递归实现ln(N!)
 */
public class Ex20
{
    public static void main(String[] args)
    {
        int N = 50;
        System.out.println(ln(50));
    }

    public static double ln(int N)
    {
        if(N==1) return 0;
        else return (Math.log(N))+ln(N-1);
    }
}
