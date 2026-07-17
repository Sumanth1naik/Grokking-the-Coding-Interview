# Find First Node of Loop in Linked List
Given the head of a linked list, determine the starting node of the loop if a cycle exists. A loop occurs when the last node points back to an earlier node in the list. If no loop is present, return -1.

**Example:** 

Input: 
1->2->3->4->5->6->7->8->9->10
      ^                   |
      |___________________|
 
Output: 3
Explanation: The linked list contains a loop, and the first node of the loop is 3.

Input:
1->2->3->4->5->6->7->8->9->10
Output: -1
Explanation: No loop exists in the above linked list. So the output is -1.

# Approach
1. We can use the **Fast and Slow Pointers** technique to detect a loop in the linked list. The idea is to have two pointers traverse the linked list at different speeds. The slow pointer moves one step at a time, while the fast pointer moves two steps at a time. If there is a loop, the fast pointer will eventually meet the slow pointer.
2. Once a loop is detected, we can find the starting node of the loop by resetting one pointer to the head of the linked list and moving both pointers one step at a time until they meet again. The meeting point will be the starting node of the loop.


**Time Complexity:** O(n), where n is the number of nodes in the linked list. In the worst case, we may have to traverse all nodes to detect a loop and find the starting node.  
**Space Complexity:** O(1), as we are using only two pointers regardless of the input size.