package alg4.ch1.sec2;

import edu.princeton.cs.algs4.Queue;

/**
 * Author:   Fan(Aaron) Hu
 * Date:     2018/8/2 17:29
 * Description: Josephus--环形链表
 */
public class Ex37_Josephus {
    public static void main(String[] args)
    {
        /**
         * Solution 1
         */
//        Ex37_Josephus ex37_josephus = new Ex37_Josephus();
//        int N = 100;
//        int M = 3;
//        Node<Integer> head = ex37_josephus.init(N);
//
//        ex37_josephus.Josephus(head, N, M);
//        Node<Integer> temp = head;
        /**
         * 为什么两个地方打印出来结果不一样？
         */
//        for(int i = 0; i < 7;i++)
//        {
//            System.out.println("In main"+temp.item);
//            temp=temp.next;
//        }
//        System.out.println("Finally Safe:"+head.item);

////////////////////////////////////////////////////////////////////////////////////////////////
        /**
         * Solution 2
         */
        solution2();
    }

    public static void solution2()
    {
        int N = 100;
        int M = 3;
        Queue<Integer> queue = new Queue<>();
        for (int i = 0; i < N; i++) {
            queue.enqueue(i);
        }
        while (!queue.isEmpty()) {
            for (int i = 0; i < M - 1; i++) {
                queue.enqueue(queue.dequeue());
            }
            System.out.print(queue.dequeue() + " ");
        }
        System.out.println();
    }
    public Node<Integer> init(int N)
    {
        Node<Integer> head = new Node<>(0);
        Node<Integer> node =head;
        int count = 0;
        while(count<N-1)
        {
//            node.item=count;
            Node<Integer> next = new Node<>(count+1);
            node.next=next;
            node=next;
            count++;
        }
        node.next=head;
        return head;
    }

    public void Josephus(Node head, int N, int M)
    {
        Node<Integer> node = head;
        System.out.println("Item = "+node.item);
        int count = N;
        while (count>1)
        {
            int count2=1;
            while(count2!=M-1)
            {
                // 报数
                System.out.println("Safe "+node.item);
                count2++;
                node=node.next;

            }


            //第M个数字出现-当前指针指向M数字的前一个节点
            Node<Integer> temp = node.next;
            node.next=temp.next;
            node=node.next;
            System.out.println("Delete "+temp.item);
            count--;
        }
        System.out.println("Finally Safe:"+node.item);
        for(int i = 0; i < 7;i++)
        {
        System.out.println(node.item);
        node=node.next;
    }
    }
}

class Node<Item>
{
    Item item;
    Node next;
    public Node(Item item)
    {
        this.item = item;
        next = null;
    }

    public Node()
    {
        this.item = null;
        next = null;
    }
}
