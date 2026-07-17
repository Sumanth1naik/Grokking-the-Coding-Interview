# Palindrome Linked List
Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

 

**Example 1:**

```
Input: head = [1,2,2,1]
Output: true
```
**Example 2:**

```
Input: head = [1,2]
Output: false
```
 

**Constraints:**
The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 9

# Approach
1. We can use the **Fast and Slow Pointers** technique to find the middle of the linked list. The slow pointer moves one step at a time, while the fast pointer moves two steps at a time. When the fast pointer reaches the end of the list, the slow pointer will be at the middle.
2. Once we find the middle of the linked list, we can reverse the second half of the list.
3. After reversing the second half, we can compare the values of the nodes in the first half and the reversed second half. If all corresponding nodes have the same value, then the linked list is a palindrome; otherwise, it is not.  

#
**Time Complexity:** O(n), where n is the number of nodes in the linked list. We traverse the list to find the middle, reverse the second half, and compare the two halves.  
**Space Complexity:** O(1), as we are using only a constant amount of extra space for pointers.