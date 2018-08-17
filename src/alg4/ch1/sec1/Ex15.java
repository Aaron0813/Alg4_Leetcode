package alg4.ch1.sec1;
/**
 * Author:   Fan(Aaron) Hu
 * Date:     2018/8/2 11:19
 * Description: 计算一个数组中每个元素出现的次数
 */
import java.util.Arrays;

public class Ex15 {
    public static void main(String[] args)
    {
        int[] a={8,8,1,2,2,2,3,4,4,4,5,9};
        int[] array=histogram(a,10);
        for(int i = 0; i < array.length; i++)
            System.out.print(array[i]+"\t");
    }

    public static int[] histogram(int[] a, int M)
    {
        int[] array = new int[M];
        for(int i = 0; i < M; i++)
            array[i]=0;
//        Arrays.sort(a);
        for(int i=0;i<a.length;i++)
        {
            array[a[i]]+=1;
//            int j = i;
//            while((j<a.length-1)&&a[j]==a[j+1])
//            {
//                array[a[i]]+=1;
//                j++;
//            }
        }
        return array;
    }
}
