# LinkedList Cycle
Given the head of a singly linked list, determine whether the list contains a cycle. A cycle exists if, while traversing the list through next pointers, you encounter a node that has already been visited instead of eventually reaching nullptr.

**Examples:**
```
Input: head: 1 -> 3 -> 4 -> 3
Output: true
Explanation: The last node of the linked list does not point to NULL; instead, it points to an earlier node in the list, creating a cycle.
```
```
Input: head: 1 -> 8 -> 3 -> 4 -> NULL 
Output: false
Explanation: The last node of the linked list points to NULL, indicating the end of the list.
```

# Approach
To detect a cycle in a linked list, we can use the **Fast and Slow Pointers** technique. The idea is to have two pointers traverse the linked list at different speeds. The slow pointer moves one step at a time, while the fast pointer moves two steps at a time. If there is a cycle in the linked list, the fast pointer will eventually meet the slow pointer. If there is no cycle, the fast pointer will reach the end of the list (NULL).

**Time Complexity:** O(n), where n is the number of nodes in the linked list. In the worst case, we may have to traverse all nodes to determine if there is a cycle.  
**Space Complexity:** O(1), as we are using only two pointers regardless of the input size.