    /*反转链表
    https://leetcode.com/problems/reverse-linked-list/
    */
    
    /** Version 1*/
    // 翻转链表这个操作,其实算是把链表拆成两段来操作了
    private Node reverseLinkedList(Node head) {
        if (head == null || head.next==null) {
            return head;
        }

        Node prev = null;
        Node next = null;
        while(head.next!=null){
            next = head.next;   //保存下一个节点
            head.next = prev;   //重置next
            prev = head;    //保存当前节点
            head = next;
        }
        head.next = prev;
        return head;
    }

    /*Version 2*/
    public ListNode reverseList (ListNode head) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        
        return reverse(dummyNode).next;
    }
    
    private ListNode reverse (ListNode head) {
        ListNode pointer = head.next;
        ListNode pre = null;
        ListNode next = null;
        
        while (pointer != null) {
            next = pointer.next;
            pointer.next = pre;
            pre = pointer;
            pointer = next;
        }
        head.next = pre;
        return head;
    }
