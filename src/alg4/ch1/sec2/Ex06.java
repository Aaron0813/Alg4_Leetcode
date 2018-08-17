package alg4.ch1.sec2;

import edu.princeton.cs.algs4.StdIn;

/**
 * Author:   Fan(Aaron) Hu
 * Date:     2018/8/2 10:25
 * Description:
 */
public class Ex06 {
    public static void main(String[] args)
    {
        String s1="ACTGACG";
        String s2="TGACGAC";
        System.out.print("s: ");
        String s = StdIn.readLine();
        System.out.print("t: ");
        String t = StdIn.readLine();
        /**
         * s.concat(s)充分利用了回环变位的定义，很机智
         */
        if (s.length() == t.length() && s.concat(s).indexOf(t) >= 0) {
            System.out.println(s + " is the circular rotation of " + t);
        } else {
            System.out.println(s + " is not the circular rotation of " + t);
        }
    }

//    public static boolean judge(String s1, String s2)
//    {
//        assert s1.length()==s2.length();
//        for(int i = 0; i < s1.length(); i++)
//        {
//            if(!(s2.indexOf(s1.charAt(i))+1==s2.indexOf(s1.charAt(i+1))))
//            {
//                String s3 = s1.substring(i+1,s1.length())+s1.substring(0,i+1);
//                System.out.println(s3);
//                if(s2.equals(s3))
//                    return true;
//                else
//                    return false;
//            }
//        }
//        return false;

//        if(s1.length()==s2.length()&&())
//            s2.indexOf()

//    }

}
