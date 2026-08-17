import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {

    /**
     * APPROACH 1: Monotonic Decreasing Stack
     * 
     * Time Complexity:  O(N) - Each node is pushed and popped at most once.
     * Space Complexity: O(N) - Stack holds at most N nodes.
     *
     * @param head Head node of the singly linked list.
     * @return Head of the modified linked list with nodes removed.
     */
    public ListNode removeNodesStack(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // ArrayDeque is preferred over java.util.Stack for performance (no sync overhead)
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode current = head;

        // Step 1: Traverse the list and maintain a monotonically decreasing stack
        while (current != null) {
            // If current node's value is greater than the stack top,
            // the stack top has a greater element to its right and must be removed.
            while (!stack.isEmpty() && stack.peek().val < current.val) {
                stack.pop();
            }
            // Push current node candidate
            stack.push(current);
            current = current.next;
        }

        // Step 2: Reconstruct the linked list from the remaining nodes in the stack.
        // Elements popped from stack come out in reverse order (rightmost to leftmost).
        ListNode newHead = null;
        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            node.next = newHead; // Point current node to the previously reconstructed head
            newHead = node;      // Move newHead backward to current node
        }

        return newHead;
    }

    /**
     * APPROACH 2: In-Place Reverse & Running Maximum (Space-Optimized)
     * 
     * Time Complexity:  O(N) - Three passes (reverse, filter, reverse back).
     * Space Complexity: O(1) - Constant auxiliary memory.
     *
     * @param head Head node of the singly linked list.
     * @return Head of the modified linked list.
     */
    public ListNode removeNodesOptimalSpace(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Step 1: Reverse the list so right-hand lookups become left-hand lookups
        head = reverse(head);

        // Step 2: Traverse from right-to-left tracking the maximum value seen
        ListNode current = head;
        int maxVal = current.val;

        while (current != null && current.next != null) {
            if (current.next.val < maxVal) {
                // Next node is strictly smaller than max seen so far -> skip/delete it
                current.next = current.next.next;
            } else {
                // Next node is >= maxVal -> update maxVal and step forward
                current = current.next;
                maxVal = current.val;
            }
        }

        // Step 3: Reverse back to restore original relative order
        return reverse(head);
    }

    /**
     * Utility helper to reverse a singly linked list in-place.
     */
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        return prev;
    }

    /**
     * APPROACH 3: Post-Order Recursion
     * 
     * Time Complexity:  O(N) - Visits each node once.
     * Space Complexity: O(N) - Recursion call stack depth up to N frames.
     *
     * @param head Head node of the singly linked list.
     * @return Head of the modified linked list.
     */
    public ListNode removeNodesRecursive(ListNode head) {
        // Base case: end of list
        if (head == null || head.next == null) {
            return head;
        }

        // Recurse to the end of the list first (bottom-up traversal)
        head.next = removeNodesRecursive(head.next);

        // If the right neighbor is strictly greater, drop the current node
        if (head.val < head.next.val) {
            return head.next;
        }

        return head;
    }
}