/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

//Merge k sorted List
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        int j = 0;
        if(len==0)
            return null;
        for(j=len-1;j>0;j=j/2){
            for(int i=0;i<=j/2;i++){
                if(i!=(j-i))
                    lists[i] = mergeTwoLists(lists[i], lists[j-i]);
            }
        }
        return lists[0];
        
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        if(l2 == null)
            return l1;
        if(l1.val<l2.val){
            l1.next=mergeTwoLists(l1.next,l2);
            return l1;
        }
        else{
            l2.next=mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
}
