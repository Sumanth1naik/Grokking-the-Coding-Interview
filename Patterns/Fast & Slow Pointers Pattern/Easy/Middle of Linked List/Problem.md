# Middle Node in a Linked List  
Given the head of singly linked list, find middle node of the linked list.
If the number of nodes is odd, return the middle node.
If the number of nodes is even, there are two middle nodes, so return the second middle node.
**Example:**
```
Input: 
[1,2,3,4,5] 
Output: 3 
Explanation: There are 5 nodes in the linked list and there is one middle node whose value is 3.
```
```
Input:
[10,20,30,40,50,60]
Output: 40
Explanation: There are 6 nodes in the linked list, so we have two middle nodes: 30 and 40, but we will return the second middle node which is 40.
```

# Approach
1. We can use the **Fast and Slow Pointers** technique to find the middle node of a linked list. The idea is to have two pointers traverse the linked list at different speeds. The slow pointer moves one step at a time, while the fast pointer moves two steps at a time. When the fast pointer reaches the end of the list, the slow pointer will be at the middle node.


**Time Complexity:** O(n), where n is the number of nodes in the linked list. In the worst case, we may have to traverse all nodes to find the middle node.  
**Space Complexity:** O(1), as we are using only two pointers regardless of the input size.