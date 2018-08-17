package alg4.ch1.sec1;
/**
 * Author:   Fan(Aaron) Hu
 * Date:     2018/8/2 11:19
 * Description: 数组转置
 */
public class Ex13 {
    public static void main(String[] args)
    {
        int[][] arrays={{1,2,3},{4,5,6}};
        Convert(arrays);
    }

    public static void Convert(int[][] arrays)
    {
        for(int j=0;j<arrays[0].length;j++)
        {
            for(int i = 0; i < arrays.length; i++)
            {
                System.out.print(arrays[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
