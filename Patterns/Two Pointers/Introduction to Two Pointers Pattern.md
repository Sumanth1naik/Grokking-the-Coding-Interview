## Definition

**Two Pointers**: A technique that uses two indices (pointers) traversing a sequence to solve problems in linear or near-linear time by exploiting ordering or relative relationships between elements.
When To Use

**Sorted input**: array is sorted or can be processed in sorted order.  
**Relative comparisons**: Problem reduces to comparing pairs/triples (sum, difference, distance).  
**In-place linear/time goal**: Improve from O(n^2) brute force to O(n) or O(n log n).
Core Techniques

**Opposite-direction pointers**: Use left and right at two ends, move inward based on comparisons (common for pair-sum).
Same-direction (slow/fast): Use slow and fast to find windows, remove duplicates, or detect cycles.
Sliding window variant: Expand/contract window with two pointers for subarray sums, lengths, or averages.
Three-pointer extension: Fix one index and use two-pointer for remaining pair (e.g., 3-sum).

***Pseudocode Template (opposite ends, target sum)***

``` python
Initialize left = 0, right = n-1.
While left < right:
s = arr[left] + arr[right]
If s == target: return result (or record then adjust pointers)
If s < target: left += 1
Else: right -= 1
```

# Worked example (intuition)

For sorted [1,2,4,6,7] and target=10: start left=0 (1), right=4 (7) → sum=8 (<10) so left++ → check 2+7=9 → left++ → 4+7=11 (>10) so right-- → 4+6=10 → found. Moves only inward, O(n).

## Complexity
Time: O(n) for two-pointer linear scans (or O(n log n) if you must sort first).
Space: O(1) extra (in-place), unless you collect many results.

**Common Pitfalls**  
Unsorted input: Two-pointer requires order/monotonicity; sorting changes indices.
Handling duplicates: When collecting all pairs/triples, advance pointers carefully to avoid duplicates.
Pointer update logic: Ensure you always move at least one pointer each iteration to avoid infinite loops.
Tips

When target comparisons are monotonic in pointer movement, two-pointer applies.
For subarray problems prefer sliding-window variant.
For k-sum, sort and reduce to (k-1)-sum with two pointers.