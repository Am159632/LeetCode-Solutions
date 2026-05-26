/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res=new ListNode();
        ListNode temp=res;
        int x=0,c=0;
        while(l1!=null && l2!=null){
            x=l1.val+l2.val+c;
            c=x/10;x=x%10;
            temp.next=new ListNode(x);
            temp=temp.next;
            l1=l1.next;
            l2=l2.next;
        }
       
        while(l1!=null){
            x=l1.val+c;
            c=x/10;x=x%10;
            temp.next=new ListNode(x);
            temp=temp.next;
            l1=l1.next;
        }
         while(l2!=null){
            x=l2.val+c;
            c=x/10;x=x%10;
            temp.next=new ListNode(x);
            temp=temp.next;
            l2=l2.next;
        }
        if(c==1)  temp.next=new ListNode(1);
        return res.next;   
    }
}