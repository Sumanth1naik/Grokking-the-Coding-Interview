# Remove Nodes From Linked List

## 1. Problem Statement
Given the `head` node of a singly linked list, modify the list such that any node that has a node with a strictly greater value anywhere to its right is removed. Return the head of the modified linked list.

---

## 2. Examples & Tracing

### Example 1
* **Input:** `head = [5, 2, 13, 3, 8]`
* **Output:** `[13, 8]`
* **Explanation:**
  * Node `5` is removed because `13` is to its right ($13 > 5$).
  * Node `2` is removed because `13` is to its right ($13 > 2$).
  * Node `13` is kept because no node to its right is greater than $13$.
  * Node `3` is removed because `8` is to its right ($8 > 3$).
  * Node `8` is kept because no node to its right is greater than $8$.

### Example 2
* **Input:** `head = [1, 1, 1, 1]`
* **Output:** `[1, 1, 1, 1]`
* **Explanation:** Every node has equal values to its right; no strictly greater value exists.

### Example 3
* **Input:** `head = [5, 4, 3, 2, 1]`
* **Output:** `[5, 4, 3, 2, 1]`
* **Explanation:** The list is already strictly decreasing; no node has a greater value to its right.

---

## 3. Approaches

### Approach 1: Monotonic Stack (Optimal Time, $\mathcal{O}(N)$ Space)
* **Core Idea:** Maintain a **monotonically decreasing stack** of nodes[cite: 1].
* **Mechanism:**
  1. Iterate through the linked list from left to right[cite: 1].
  2. For each node, pop all smaller nodes from the top of the stack because the current node is greater than them and appears to their right[cite: 1].
  3. Push the current node onto the stack[cite: 1].
  4. After traversing, the stack holds only the nodes that survive. Rebuild the list from right to left by popping elements and wiring their `.next` pointers[cite: 1].

### Approach 2: Reverse Linked List (Optimal Space, $\mathcal{O}(1)$ Space)
* **Core Idea:** The condition "has a greater element to the right" becomes "is smaller than the maximum seen so far" when traversing from **right to left**.
* **Mechanism:**
  1. Reverse the input linked list.
  2. Traverse the reversed list while tracking the running maximum value (`maxVal`).
  3. If `curr.next.val < maxVal`, delete the node (`curr.next = curr.next.next`).
  4. If `curr.next.val >= maxVal`, update `maxVal = curr.next.val` and advance `curr`.
  5. Reverse the modified list back to its original relative orientation and return.

### Approach 3: Post-Order Recursion (Implicit Call Stack)
* **Core Idea:** Process the list bottom-up on the return unwinding phase of recursion.
* **Mechanism:**
  1. Recurse down to the end of the list.
  2. When the call stack unwinds from right to left, check if `head.val < head.next.val`.
  3. If true, skip `head` and return `head.next`.
  4. Otherwise, link `head.next = recursive_result` and return `head`.

---

## 4. Complexity Comparison

| Approach | Time Complexity | Auxiliary Space Complexity | Mutates Nodes In-Place? |
| :--- | :--- | :--- | :--- |
| **Monotonic Stack** | $\mathcal{O}(N)$[cite: 1] | $\mathcal{O}(N)$[cite: 1] | Yes |
| **List Reversal** | $\mathcal{O}(N)$ | $\mathcal{O}(1)$ | Yes |
| **Recursion** | $\mathcal{O}(N)$ | $\mathcal{O}(N)$ (call stack) | Yes |