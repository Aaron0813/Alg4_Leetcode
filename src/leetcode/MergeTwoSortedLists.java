package leetcode;

/**
 * Author:   Fan(Aaron) Hu
 * Date:     2018/8/16 10:46
 * Description: https://leetcode.com/problems/merge-two-sorted-lists/description/
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class MergeTwoSortedLists {
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
//        ListNode theRest = null;
//        if(l1 == null && l2!=null){
//            theRest = l2;
//        }else if(l2 == null && l1!=null){
//            theRest = l1;
//        }else{
//            theRest = null;
//        }
//
//        while(theRest!=null){
//            if(isInit == 1){
//                temp.next=theRest;
//            }else{
//                l3 = theRest;
//                temp = l3;
//                isInit = 1;
//            }
//
//            theRest = theRest.next;
//            temp = temp.next;
//        }
//        return l3;

//         if(l1 == null){
//             while(l2!=null){
//                 temp.next=l2;
//                 temp = temp.next;
//                 l2 = l2.next;
//             }


//         }

//         if(l2 == null){
//             while(l1!=null){
//                 temp.next=l1;
//                 temp = temp.next;
//                 l1 = l1.next;
//             }
//         }

//         return l3;
    }

    public static void main(String[] args){
        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        ListNode l1 = new ListNode(-9);
        l1.next = new ListNode(3);
        ListNode l2 = null;
//        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(7);
        ListNode l3 =mergeTwoSortedLists.mergeTwoLists(l1,l2);
        while(l3!=null){
            System.out.println(l3.val);
            l3=l3.next;
        }

    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }