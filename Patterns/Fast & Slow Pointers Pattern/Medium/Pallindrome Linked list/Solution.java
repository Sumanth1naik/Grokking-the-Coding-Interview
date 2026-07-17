class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
class Solution {
    public static boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        //Find the middle of the linked list;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //Slow will be in the middle
        //Reverse the second half of the linked list
        ListNode head1 = slow.next;
        slow.next = null;

        //Reversing the linked list
        ListNode next = head1;
        ListNode prev = null;
        ListNode cur = head1;
        while(cur!=null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        //Compare the both the linked list
        ListNode node1 = head;
        ListNode node2 = prev;
        while(node1!=null && node2!=null){
            if(node1.val!=node2.val)return false;
            node1 = node1.next;
            node2 = node2.next;
        }
        return true;


        
    }
    public static void main(String[] args) {

        // Linked list : 1->2->3->2->1
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);

        boolean result = isPalindrome(head);

        if (result)
            System.out.println("true");
        else
            System.out.println("false");
    }
}