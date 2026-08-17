# Monotonic Stack Pattern in Data Structures & Algorithms

## 1. Overview
A **Monotonic Stack** is a specialized stack data structure that enforces a strict ordering among its elements—either **monotonically increasing** or **monotonically decreasing** from the bottom of the stack to the top.

Whenever a newly inspected element violates the stack's monotonic property, elements are popped from the top until the invariant is restored.

---

## 2. Core Classification & Invariants

The direction of monotonicity (increasing vs. decreasing) dictates what type of boundary, nearest element, or range extent can be queried in $\mathcal{O}(1)$ amortized time.

| Stack Type (Bottom $\to$ Top) | Invariant Maintained | Pop Condition | Primary Lookup / Use Case |
| :--- | :--- | :--- | :--- |
| **Monotonically Decreasing** | Elements decrease ($10, 7, 4, 2, \dots$) | `stack.peek() <= current` | Finding **Next Greater Element (NGE)** or **Previous Greater Element (PGE)** |
| **Monotonically Increasing** | Elements increase ($2, 4, 7, 10, \dots$) | `stack.peek() >= current` | Finding **Next Smaller Element (NSE)** or **Previous Smaller Element (PSE)** |

---

## 3. Complexity Analysis

### Time Complexity: $\mathcal{O}(N)$
* Naive brute-force checks for the next greater/smaller element take $\mathcal{O}(N^2)$ by scanning the rest of the array for every index.
* With a monotonic stack:
  * Each element is pushed onto the stack **at most once**.
  * Each element is popped from the stack **at most once**.
  * Across the entire execution of $N$ iterations, total push and pop operations are bounded by $2N$.
  * Hence, the amortized time complexity is **$\mathcal{O}(N)$**.

### Space Complexity: $\mathcal{O}(N)$
* Requires an auxiliary stack to hold elements/indices, consuming $\mathcal{O}(N)$ memory in the worst case (e.g., strictly monotonic input).

---

## 4. Standard Templates (Java)

### A. Next Greater Element (Right-to-Left Traversal)
Storing elements or indices while scanning backwards from $N-1$ down to $0$:

```java
import java.util.ArrayDeque;
import java.util.Deque;

public class MonotonicStackNGE {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Deque<Integer> stack = new ArrayDeque<>(); // Stores values (or indices)

        for (int i = n - 1; i >= 0; i--) {
            // 1. Maintain invariant: pop smaller or equal elements
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }

            // 2. Stack top is the next greater element
            result[i] = stack.isEmpty() ? -1 : stack.peek();

            // 3. Push current element
            stack.push(nums[i]);
        }

        return result;
    }
}
```

### B. Next Greater Element (Left-to-Right Traversal Storing Indices)
Traversing forwards ($0$ to $N-1$) and resolving indices whenever an element larger than the top is encountered:

```java
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MonotonicStackIndices {
    public int[] nextGreaterElementIndices(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        
        Deque<Integer> stack = new ArrayDeque<>(); // Stores indices

        for (int i = 0; i < n; i++) {
            // While current element is greater than stack top element, resolve it
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                int resolvedIndex = stack.pop();
                result[resolvedIndex] = nums[i];
            }
            stack.push(i);
        }

        return result;
    }
}
```

---

## 5. Summary of Traversal Directions

| Goal | Traversal Direction | Stack Monotonicity |
| :--- | :--- | :--- |
| **Next Greater Element (NGE)** | Right-to-Left ($N-1 \to 0$) | Decreasing |
| **Previous Greater Element (PGE)** | Left-to-Right ($0 \to N-1$) | Decreasing |
| **Next Smaller Element (NSE)** | Right-to-Left ($N-1 \to 0$) | Increasing |
| **Previous Smaller Element (PSE)** | Left-to-Right ($0 \to N-1$) | Increasing |

---

## 6. Classic Problem Archetypes

1. **Direct Lookups & Distance Calculations:**
   * *Daily Temperatures* (LeetCode 739)
   * *Next Greater Element I & II* (LeetCode 496, 503)
   * *Online Stock Span* (LeetCode 901)
2. **Subarray Boundary Extents:**
   * *Largest Rectangle in Histogram* (LeetCode 84)
   * *Maximal Rectangle* (LeetCode 85)
   * *Sum of Subarray Minimums* (LeetCode 907)
3. **Bounded Trapping / Area Troughs:**
   * *Trapping Rain Water* (LeetCode 42)