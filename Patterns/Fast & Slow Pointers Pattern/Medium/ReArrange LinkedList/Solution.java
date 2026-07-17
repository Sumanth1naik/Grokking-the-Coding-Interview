
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class Solution {
    public static void reorderList(ListNode head) {
        //Find the middle of linked list to seperate the two halfs
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //Reverse the linked list
        ListNode cur = slow.next;
        ListNode prev = null;
        ListNode next = slow.next;
        //Once assinging done break the link between two halfs
        slow.next = null;
        while(cur!=null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        //So prev will be the new head of reversed linked list
        //Use two temp head and form the zig zag connction between two lists
        ListNode head1 = head;
        ListNode head2 = prev;
        ListNode next1 = head1;
        ListNode next2 = head2;
        while(head1!=null && head2!=null){
            next1 = head1.next;
            next2 = head2.next;
            head1.next = head2;
            head2.next = next1;
            head1 = next1;
            head2 = next2;
        }
        
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5); 

        reorderList(node);
        while(node!=null){
            System.out.print(node.val+"-->");
            node = node.next;
        }
        System.out.print("null");
    }
}