//Add Two numbers represnted by the linked list in reverse order

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        ListNode temp=null, head=null, tail=null;
        int carry=0,data=0;
        while(l1!=null && l2!=null){
            data = l1.val+l2.val+carry;
            temp = new ListNode(data%10);
            if(head == null){
                head = temp;
                tail = head;
            }
            else{
                tail.next = temp;
                tail = tail.next;
            }
            if(data>9)
                carry = 1;
            else
                carry=0;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        
        while(l1!=null)
        {
            data = l1.val+carry;
            temp = new ListNode(data%10);
            
            tail.next = temp;
            tail = tail.next;
            
            if(data>9)
                carry = 1;
            else
                carry=0;
            l1 = l1.next;
        }
        
        while(l2!=null)
        {
            data = l2.val+carry;
            temp = new ListNode(data%10);
            
            tail.next = temp;
            tail = tail.next;
            
            if(data>9)
                carry = 1;
            else
                carry=0;
            l2 = l2.next;
        }
        if(carry==1){
            temp = new ListNode(1);
            tail.next = temp;
            tail = tail.next;
        }
        tail.next = null;
        return head;
    }
    public void addSingleList(ListNode l1, ListNode head, ListNode tail, int carry){
        ListNode temp = null;
        
        while(l1!=null){
            int data = l1.val+carry;
            temp = new ListNode(data%10);
            
            tail.next = temp;
            tail = tail.next;
            
            if(data>9)
                carry = 1;
            else
                carry=0;
            l1 = l1.next;
        }
    }
}
