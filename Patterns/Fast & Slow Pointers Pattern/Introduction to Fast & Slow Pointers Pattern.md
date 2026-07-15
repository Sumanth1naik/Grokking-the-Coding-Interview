# Fast & Slow Pointers pattern
The Fast & Slow Pointers pattern (also known as the "Hare & Tortoise" algorithm) uses two pointers moving through a sequence or data structure at different speeds. It is highly efficient for determining cycle properties or finding specific positions in data like arrays and linked lists, operating in O(n) time and O(1) space.  
**Core Concept**  
Two pointers start at the beginning of a sequence. The slow pointer advances incrementally (usually by 1 step), while the fast pointer progresses more rapidly (usually by 2 or more steps). This speed differential solves problems using fewer resources, like avoiding nested loops or memory-heavy data structures.  
**Common Use Cases**
```
1. Cycle Detection 
If a linked list loops back onto itself, the fast pointer will eventually "lap" the slow pointer within the loop, causing both to point to the same node. If no loop exists, the fast pointer will simply reach the end of the structure. This is the basis of Floyd's cycle-finding algorithm. 

• Key Use: Use this pattern to detect loops in linked lists or to determine if a number is a "happy number". [6, 7, 8]  

2. Finding the Middle of a List 
When you need to find the middle of a linked list but do not know its length in advance, you can use the speed difference. Because the fast pointer travels twice as fast as the slow pointer, the slow pointer will rest exactly on the middle node the moment the fast pointer reaches the end. [2, 9]  
3. Starting Point of a Cycle 
Once a cycle is detected, you can find exactly where the loop begins. By starting a new pointer at the head and moving it alongside the slow pointer (both at 1 step per iteration), the node where they meet indicates the start of the cycle. [2, 7]  
```

