/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/*
https://leetcode.com/problems/merge-k-sorted-lists/description/
*/
class Solution {
    /*Solution 1 - 两两merge*/
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;
        int start = 0;
        int index = 0;
        int end = lists.length;
        while(end > 1){
            index = 0;
            for(int i = 0; i + 1 < end; i += 2){
                lists[index] = mergeTwoSortedList(lists[i], lists[i + 1]);
                index++;
            }
            if (end % 2 == 1) {
                lists[index] = lists[end - 1];
                index++;
            }
            end = index;
                
        }
        return lists[0];        
    }


    /*Solution 2 Divide and Conquer--类似于归并排序*/
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;
        int start = 0;
        int end = lists.length - 1;
        if(start < end){
            int mid = (end + start) / 2;
            ListNode left = mergeHelper(lists, start, mid);
            ListNode right = mergeHelper(lists, mid + 1, end);
            return mergeTwoSortedList(left, right);
        }else{
            return lists[0];
        }
        
    }
    private ListNode mergeHelper(ListNode[] lists, int start, int end){
        if(start + 1 < end){
            ListNode left = mergeHelper(lists, start, (end + start) / 2);
            ListNode right = mergeHelper(lists, (end + start) / 2 + 1, end);
            return mergeTwoSortedList(left, right);
        }else{
            if(start == end) return lists[start];
            return mergeTwoSortedList(lists[start], lists[end]);
        }
    }
    
    private ListNode mergeTwoSortedList(ListNode left, ListNode right){
        ListNode dummyNode = new ListNode(0);
        ListNode head = dummyNode;
        while(left != null && right != null){
            if(left.val < right.val){
                head.next = left;
                left = left.next;
                head = head.next;
            }else{
                head.next = right;
                right = right.next;
                head = head.next;
            }   
        }        
                    
        while(left != null){
            head.next = left;
            left = left.next;
            head = head.next;
        }
            
        while(right != null){
            head.next = right;
            right = right.next;
            head = head.next;
        }
        return dummyNode.next;
    }
}
    /*Solution 3 -- With Heap*/
    /*
    private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>(){
            public int compare(ListNode left, ListNode right){
                return left.val - right.val;
            }
        };
    
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;
        // if(lists.length == 1 && lists[0] == null)
        //     return null;
        Queue<ListNode> minHeap = new PriorityQueue<ListNode>(ListNodeComparator);
        int length = lists.length;
        for(int i = 0; i < length; i++){
            if(lists[i] != null)
                minHeap.offer(lists[i]);// put node but not value
        }
        
        ListNode dummyNode = new ListNode(0);
        ListNode head = dummyNode;
        while(!minHeap.isEmpty()){
            ListNode minNode = minHeap.poll();
            // minHeap.poll();
            head.next = minNode;
            head = head.next;
            if(minNode.next != null)
                minHeap.offer(minNode.next);
        }
        
        return dummyNode.next;
        
    }
*/