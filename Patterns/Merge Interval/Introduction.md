# Overlapping Interval Patterns: A Complete Guide

The **Overlapping Intervals** pattern is one of the core algorithm patterns in technical interviews and system design logic. It applies to problems involving time durations, scheduling, resource allocation, and continuous range operations (e.g., calendar meetings, CPU task execution, memory allocation).

---

## 1. Core Concept & Mathematical Condition

An interval is defined as a range $[start, end]$ where $start \le end$.

Two intervals $A = [start_A, end_A]$ and $B = [start_B, end_B]$ overlap if and only if:

$$\text{Overlap Condition: } \max(start_A, start_B) \le \min(end_A, end_B)$$

If we pre-sort the intervals such that $A$ starts before or at the same time as $B$ ($start_A \le start_B$), the condition simplifies to:

$$start_B \le end_A$$

### Visual Representation

```text
Interval A:  [=======]          (start_A to end_A)
Interval B:      [=======]      (start_B to end_B)
Overlap:         [===]          (max(start_A, start_B) to min(end_A, end_B))
```

---

## 2. The Universal Golden Rule: Sorting First

Almost every interval problem becomes significantly easier once you **sort the intervals by their start times** (or end times in specific greedy scenarios).

- **Why?** Unsorted intervals require comparing every interval with every other interval ($O(N^2)$). Sorting puts overlapping intervals adjacent to one another, reducing processing to an $O(N)$ linear scan.
- **Time Complexity:** $O(N \log N)$ (dominated by the sorting step).
- **Space Complexity:** $O(N)$ or $O(1)$ depending on whether sorting is done in-place or on a copied collection.

---

## 3. The 4 Primary Interval Problem Categories

### Type A: Merge Overlapping Intervals
* **Goal:** Combine all overlapping intervals into a consolidated set of non-overlapping intervals.
* **Algorithm:**
  1. Sort intervals by `start` time.
  2. Iterate through intervals, maintaining a `last_merged` interval.
  3. If `current.start <= last_merged.end`, they overlap. Update `last_merged.end = max(last_merged.end, current.end)`.
  4. Otherwise, push `current` to the output list.

```java
public int[][] merge(int[][] intervals) {
    if (intervals.length <= 1) return intervals;

    // 1. Sort by start time ascending
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

    List<int[]> result = new ArrayList<>();
    int[] current = intervals[0];
    result.add(current);

    // 2. Linear scan and merge
    for (int[] next : intervals) {
        if (next[0] <= current[1]) { 
            // Overlap -> extend end boundary
            current[1] = Math.max(current[1], next[1]);
        } else { 
            // Disjoint -> advance pointer
            current = next;
            result.add(current);
        }
    }
    return result.toArray(new int[result.size()][]);
}
```

---

### Type B: Insert New Interval
* **Goal:** Insert a new interval into an already sorted list of non-overlapping intervals, merging if necessary.
* **Algorithm (3-Phase Loop):**
  1. **Phase 1 (Before):** Add all intervals that end before `newInterval` starts (`interval.end < newInterval.start`).
  2. **Phase 2 (Overlap):** Merge all overlapping intervals (`interval.start <= newInterval.end`) by updating `newInterval` bounds.
  3. **Phase 3 (After):** Add all remaining intervals that start after `newInterval` ends.

---

### Type C: Non-overlapping / Minimum Removals
* **Goal:** Find the minimum number of intervals to remove to eliminate all overlaps.
* **Greedy Twist:** Sort by **END time** instead of start time.
* **Rationale:** Picking intervals that end early leaves the maximum possible space for future intervals.

```java
public int eraseOverlapIntervals(int[][] intervals) {
    if (intervals.length == 0) return 0;

    // Sort by end time ascending
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

    int count = 0;
    int prevEnd = intervals[0][1];

    for (int i = 1; i < intervals.length; i++) {
        if (intervals[i][0] < prevEnd) {
            // Overlap -> remove current interval (greedy choice)
            count++;
        } else {
            prevEnd = intervals[i][1];
        }
    }
    return count;
}
```

---

### Type D: Meeting Rooms II (Min Concurrent Intervals)
* **Goal:** Determine the maximum number of concurrent overlapping intervals (e.g., minimum meeting rooms required).
* **Strategy:** Min-Heap (Priority Queue) or Two-Pointer line-sweep.
  1. Sort intervals by `start` time.
  2. Use a Min-Heap to track the end times of ongoing events.
  3. For each event, if `heap.peek() <= current.start`, pop the top element (room liberated).
  4. Push `current.end` onto the heap.
  5. The heap size at the end represents peak concurrency.

---

## 4. Cheat Sheet Summary

| Variant | Sorting Order | Core Strategy | Time | Space |
| :--- | :--- | :--- | :--- | :--- |
| **Merge Intervals** | Start time $\uparrow$ | Linear scan + `Math.max(end)` | $O(N \log N)$ | $O(N)$ |
| **Insert Interval** | Pre-sorted | 3-Phase linear traversal | $O(N)$ | $O(N)$ |
| **Non-overlapping** | End time $\uparrow$ | Greedy selection | $O(N \log N)$ | $O(1)$ |
| **Meeting Rooms II** | Start time $\uparrow$ | Min-Heap for end times | $O(N \log N)$ | $O(N)$ |
| **Interval Intersection**| Pre-sorted | Two-pointer sweep | $O(N + M)$ | $O(N + M)$ |