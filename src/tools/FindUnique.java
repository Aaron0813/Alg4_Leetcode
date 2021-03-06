package tools;

import java.util.*;

/**
 * Author:   Fan(Aaron) Hu
 * Date:     2018/8/16 18:22
 * Description:
 */
public class FindUnique {
    public  static void main(String args[]){
// 注意：一定要使用创建对象的格式创建数组
        String[] a = new String[] {"()()()()()","(()()()())","()(())(())","(())(())()","((())(()))","()(()()())","(()()())()","((()()()))","()()(()())","()(()())()","(()(()()))","(()())()()","((()())())","()((()()))","((()()))()","(((()())))","()()()(())","()()(())()","(()()(()))","()(())()()","(()(())())","()(()(()))","(()(()))()","((()(())))","(())()()()","((())()())","()((())())","((())())()","(((())()))","()()((()))","()((()))()","(()((())))","((()))()()","(((()))())","()(((())))","(((())))()","((((()))))"};
        String[] b = new String[] {"((((()))))","(((()())))","(((())()))","(((()))())","(((())))()","((()(())))","((()()()))","((()())())","((()()))()","((())(()))","((())()())","((())())()","((()))(())","((()))()()","(()((())))","(()(()()))","(()(())())","(()(()))()","(()()(()))","(()()()())","(()()())()","(()())(())","(()())()()","(())((()))","(())(()())","(())(())()","(())()(())","(())()()()","()(((())))","()((()()))","()((())())","()((()))()","()(()(()))","()(()()())","()(()())()","()(())(())","()(())()()","()()((()))","()()(()())","()()(())()","()()()(())","()()()()()"};
        List _a = Arrays.asList(a);
        List _b = Arrays.asList(b);
// 创建集合
        Collection realA = new ArrayList<String>(_a);
        Collection realB = new ArrayList<String>(_b);
// 求交集
//        realA.retainAll(realB);
//        System.out.println("交集结果：" + realA);
//        Set result = new HashSet();
// 求全集
//        result.addAll(_a);
//        result.addAll(_b);
//        System.out.println("全集结果：" + result);
// 求差集：结果
        Collection aa = new ArrayList(realA);
        Collection bb = new ArrayList(realB);
        bb.removeAll(aa);
        System.out.println("最终结果：" + bb);
    }
}
