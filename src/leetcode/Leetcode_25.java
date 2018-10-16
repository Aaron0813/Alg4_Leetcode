package leetcode;

/**
 * Author:   Fan(Aaron) Hu
 * Date:     2018/8/19 20:30
 * Description:Reverse Nodes in k-Group
 * https://leetcode.com/problems/reverse-nodes-in-k-group/description/
 */
public class Leetcode_25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k == 1)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        int count = 1;
        boolean result = false;
        while(current != null){
            result = judge(current,k);
            System.out.println(result);
            if(result)
                current = reverseK(current,k);
            else
                break;
        }
        return dummy.next;
    }

    public ListNode reverseK(ListNode head, int k){
        ListNode current = head;
        ListNode temp = head;
        ListNode[] pointers = new ListNode[k];
        for(int i = 0; i < k; i++){
            pointers[i] = temp.next;
            temp = temp.next;
        }
        for(int i = 0; i < k; i++){
            if(i == 0)
                pointers[i].next = pointers[k-1].next;
            else{
                pointers[i].next = pointers[i-1];
            }
        }
        current.next = pointers[k-1];
        return pointers[0];

    }

    public boolean judge(ListNode head, int k){
        int count = 0;
        ListNode current = head;
        while(current.next != null && count < k){
            current = current.next;
            count++;
        }
        if(count == k)
            return true;
        else
            return false;
    }
}
