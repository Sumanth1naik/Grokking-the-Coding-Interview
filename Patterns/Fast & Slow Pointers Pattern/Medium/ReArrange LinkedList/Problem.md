# Rearrange a LinkedList
Problem Statement
Given the head of a Singly LinkedList, write a method to modify the LinkedList such that the nodes from the second half of the LinkedList are inserted alternately to the nodes from the first half in reverse order. So if the LinkedList has nodes `1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null`, your method should return `1 -> 6 -> 2 -> 5 -> 3 -> 4 -> null`.

Your algorithm should use only constant space the input LinkedList should be modified in-place.

**Example 1:**
```
Input: 2 -> 4 -> 6 -> 8 -> 10 -> 12 -> null
Output: 2 -> 12 -> 4 -> 10 -> 6 -> 8 -> null 
```

**Constraints:**
- The number of nodes in the list is in the range [1, 10^5]


# Approach
1. We can use the **Fast and Slow Pointers** technique to find the middle of the linked list. The slow pointer moves one step at a time, while the fast pointer moves two steps at a time. When the fast pointer reaches the end of the list, the slow pointer will be at the middle.
2. Once we find the middle of the linked list, we can reverse the second half of the list.
3. After reversing the second half, we can merge the two halves of the linked list by alternating nodes from the first half and the reversed second half.


#
**Time Complexity:** O(n), where n is the number of nodes in the linked list. We traverse the list to find the middle, reverse the second half, and merge the two halves.  
**Space Complexity:** O(1), as we are using only a constant amount of extra space for pointers.
