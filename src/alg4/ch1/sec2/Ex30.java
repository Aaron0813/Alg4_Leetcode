package alg4.ch1.sec2;

/**
 * Author:   Fan(Aaron) Hu
 * Date:     2018/8/2 16:41
 * Description: 链表反转
 */
public class Ex30 {
    class Node
    {
        Node item;
        Node next;
        public Node()
        {
            item = null;
            next = null;
        }
    }
    public Node reverse_iterate(Node head)
    {
        /**
         * 迭代版本
         */
        Node first = head;
        Node second;
        Node reverse = null;
        while (first!=null)
        {
            second = first.next;
            first.next = reverse;
            reverse = first; // 更新结果链表
            first = second;
        }
        return reverse;
    }

    public Node reverse_recurse(Node first)
    {
        if(first==null) return null;    //这个情况会发生吗--当上一步进行到尾节点时会发生
        if(first.next==null) return first;
        Node second = first.next;
        Node rest = reverse_recurse(second);
        second.next = first;
        return rest;



    }
}
