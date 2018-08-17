package leetcode;

/**
 * Author:   Fan(Aaron) Hu
 * Date:     2018/8/17 11:01
 * Description: Merge k Sorted Lists
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */
public class Leetcode_23 {
    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l1_next = new ListNode(4);
        l1_next.next = new ListNode(5);
        l1.next = l1_next;

        ListNode l2 = new ListNode(1);
        ListNode l2_next = new ListNode(3);
        l2_next.next = new ListNode(4);
        l2.next = l2_next;

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists =new ListNode[3];
        lists[0] = l1;
        lists[1] = l2;
        lists[2] = l3;


//        ListNode[] lists = new ListNode[1];
//        lists[0]=null;

        Leetcode_23 leetcode_23 = new Leetcode_23();

        ListNode result = leetcode_23.mergeKLists(lists);
        while (result!=null){
            System.out.println(result.val);
            result = result.next;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        int N = lists.length;
        if(0!=N){
            // 就是利用归并排序的思想
            for(int length = 1; length < N; length = length+length){
                for(int i = 0; i < N - length; i+=(length + length)){//如果N%2!=0,则将剩余的list放到下一次的排序中
                    lists[i] = mergeTwoLists(lists[i],lists[i+length]);
                }
            }
            return lists[0];
        }else
            return null;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3 = null;
        ListNode temp = null;
        ListNode theSmaller = null;
        int isSmaller = 0;
        int isInit = 0;
        // ListNode temp = l3;
        while(l1!=null && l2!=null){
            if(l1.val <= l2.val){
                theSmaller = l1;
                isSmaller = 0;
            }else{
                theSmaller = l2;
                isSmaller = 1;
            }
            if(isInit == 0){
                l3 = theSmaller;
                temp = l3;
                isInit = 1;
            }else if(isInit == 1){
                temp.next = theSmaller;
                temp = temp.next;
            }
            if(isSmaller == 0){
                l1 = l1.next;
            }else if(isSmaller == 1){
                l2 = l2.next;
            }
        }

        while(l1!=null || l2!=null) {
            if(l1==null){
                if(isInit==1){
                    temp.next = l2;
                    temp=temp.next;
                }else if(isInit==0){
                    l3 = l2;
                    temp = l3;
                    isInit = 1;
                }
                l2=l2.next;

            }else if(l2 == null){
                if(isInit==1){
                    temp.next = l1;
                    temp=temp.next;
                }else if(isInit==0){
                    l3 = l1;
                    temp = l3;
                    isInit = 1;
                }
                l1=l1.next;
            }
        }

        return l3;
    }
}
