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
        int carry=0;
        ListNode first=l1;
        ListNode second=l2;
        ListNode head=new ListNode(0);
        ListNode result=head;
        while(first!=null && second!=null){
            ListNode temp=new ListNode(0);
            int sum=first.val+second.val+carry;
            if(sum>9){
                carry=1;
                temp.val=sum%10;
            }
            else{
                carry=0;
                temp.val=sum;
            }
            first=first.next;
            second=second.next;
            result.next=temp;
            result=result.next;
            System.out.println(sum);
        }
        while(first!=null ){
            ListNode temp=new ListNode(0);
            int sum=first.val+carry;
            if(sum>9){
                carry=1;
                temp.val=sum%10;
            }
            else{
                carry=0;
                temp.val=sum;
            }
            first=first.next;
            result.next=temp;
            result=result.next;

        }
        while(second!=null){
            ListNode temp=new ListNode(0);
            int sum=second.val+carry;
            if(sum>9){
                carry=1;
                temp.val=sum%10;
            }
            else{
                carry=0;
                temp.val=sum;
            }
            second=second.next;
            result.next=temp;
            result=result.next;

        }
        if(carry==1){
            ListNode temp=new ListNode(1);
            result.next=temp;
            result=result.next;
        }
        return head.next;
    }
}