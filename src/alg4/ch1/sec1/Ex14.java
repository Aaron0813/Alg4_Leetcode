package alg4.ch1.sec1;
/**
 * Author:   Fan(Aaron) Hu
 * Date:     2018/8/2 11:19
 * Description: 取对数
 */
/**
 * 如果对数的基是-2，就把数字换一下就好
 */
public class Ex14 {
    public static void main(String[] args)
    {
        int temp = -16;
        System.out.println(log(temp));
//        System.out.println(Math.log(-16)-Math.log(2));
    }

    public static int log(int arg)
    {
        int count = 0;
        while(arg/(-2)!=0)
        {
            arg/=-2;
            count++;
        }
        return count;
//        int shiftRightCount = 0;
//        do {
//            arg >>= 1;
//            shiftRightCount++;
//        } while (arg != 0);
//        return shiftRightCount - 1;
    }
}
