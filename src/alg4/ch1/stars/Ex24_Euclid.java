package alg4.ch1.stars;
/**
 * Author:   Fan(Aaron) Hu
 * Date:     2018/8/2 11:19
 * Description: 欧几里得算法求最大公约数
 */
public class Ex24_Euclid {
    public static void main(String[] args)
    {
        System.out.println(entrance(1111111, 1234567));
    }

    /**
     * 该版本没有做好边界处理
     * @param a
     * @param b
     * @return
     */
    public static int entrance(int a,int b)
    {
        return ex24(a, b);
    }
    public static int ex24(int a, int b)
    {
        int r = a%b;
        if (r==0) return b;
        else return ex24(b, r);
//        return 0;
    }

    /**
     * 该版本做好了边界处理
     * @param p
     * @param q
     * @return
     */
    public static int euclid(int p, int q) {
        if (p == 0 || q == 0) {
            return 1;
        }
        p = Math.abs(p);
        q = Math.abs(q);
        if (p < q) {
            int t = p;
            p = q;
            q = t;
        }
        if (p % q == 0) {
            return q;
        } else {
            return euclid(q, p % q);
        }
    }
}
