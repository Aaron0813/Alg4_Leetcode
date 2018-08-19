package leetcode;

/**
 * Author:   Fan(Aaron) Hu
 * Date:     2018/8/17 14:31
 * Description: Swap Nodes in Pairs
 * https://leetcode.com/problems/swap-nodes-in-pairs/description/
 */
public class Leetcode_24 {
//    private int isSwapInit = 0;
//    private int isInit = 0;

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        //借助dummy会让链表的处理变得简单一些
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        while(current.next != null && current.next.next != null){
            ListNode first = current.next;
            ListNode second = current.next.next;
            first.next = second.next;
            current.next = second;
            current.next.next = first;
            current = current.next.next;
        }
        return dummy.next;
    }
//    public ListNode swapPairs(ListNode head) {
//        ListNode temp = head;
//        ListNode newHead = null;
//        ListNode[] lists = new ListNode[2];
//        ListNode[] backup;
//        while(temp!=null){
//            System.out.println(temp.val);
//            swap(temp,lists);
//            temp = lists[0];
//            if(isInit == 0){
//                isInit = 1;
//                newHead = lists[1];
//            }
//        }
//
//        return newHead;
//    }



//    /**
//     *  l2->l1->l3->l4  ---------->l2->l1->l4->l3
//     *  swap l3, l4 now
//     * @param head = l1
//     * @param lists lists[0]=l3; lists[1]在初次交换时，存储新链表的头
//     * @return
//     */
//     public void swap(ListNode head,ListNode[] lists){
////     public ListNode[] swap(ListNode head,ListNode[] lists){
////     public ListNode[] swap(ListNode head, ListNode previous, ListNode[] lists){
//         ListNode pointer = null;
//         ListNode swap1 = null;
//         ListNode swap2 = null;
//         ListNode last = null;
//         if(head.next!=null){
//             pointer = head;
//             if(isSwapInit == 0){
//                 swap1 = pointer;
//                 swap2 = swap1.next;
//
//                 swap1.next = swap2.next;
//                 swap2.next = swap1;
//             }else{
//                 swap1 = pointer.next;
//                 swap2 = swap1.next;
//                 last = swap2.next;
//
//                 //swap
//                 swap1.next = swap2.next;
//                 swap2.next = swap1;
//                 pointer.next = swap1;
//             }
//
//
//             lists[0] = swap1;
//             if(isSwapInit!=0){
//                 lists[1] = null;
//             }else{
//                 lists[1] = swap2;
//                 isSwapInit = 1;
//             }
////             return lists;
//
//         }else{
//             lists[0] = head;
//             if(isSwapInit!=0){
//                 lists[1] = null;
//             }else{
//                 lists[1] = head;
//                 isSwapInit = 1;
//             }
////             return lists;
//         }
//     }

    public static void main(String[] args){
        ListNode listNode = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
//        ListNode l5 = new ListNode(5);

        listNode.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = null;


        Leetcode_24 leetcode_24 = new Leetcode_24();
        ListNode result = leetcode_24.swapPairs(listNode);
        while(result!=null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
