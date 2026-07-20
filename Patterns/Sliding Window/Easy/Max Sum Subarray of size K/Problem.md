# Max Sum Subarray of size K
Given an array of integers arr[]  and a number k. Return the maximum sum of a subarray of size k.

Note: A subarray is a contiguous part of any given array.

**Examples:**
```
Input: arr[] = [100, 200, 300, 400], k = 2
Output: 700
Explanation: arr2 + arr3 = 700, which is maximum.
```
```
Input: arr[] = [1, 4, 2, 10, 23, 3, 1, 0, 20], k = 4
Output: 39
Explanation: arr1 + arr2 + arr3 + arr4 = 39, which is maximum.
```
```
Input: arr[] = [100, 200, 300, 400], k = 1
Output: 400
Explanation: arr3 = 400, which is maximum.
```

**Constraints:**
1 ≤ arr.size() ≤ 106  
0 ≤ arr[i] ≤ 106  
1 ≤ k ≤ arr.size()  



# Approach 1: Brute Force
1. Initialize a variable `max_sum` to store the maximum sum found so far.
2. Iterate through the array from index 0 to `arr.size() - k` (inclusive) to consider all possible subarrays of size k.
3. For each starting index `i`, calculate the sum of the subarray of size k starting at index `i`.
4. Update `max_sum` if the current subarray sum is greater than the previous `max_sum`.


# Approach 2: Sliding Window
1. Initialize two variables: `max_sum` to store the maximum sum found so far and `window_sum` to store the sum of the current window of size k.
2. Calculate the sum of the first k elements and assign it to both `max_sum`
and `window_sum`.
3. Iterate through the array starting from index k to the end of the array.
4. For each index `i`, update the `window_sum` by adding the current element `arr[i]` and subtracting the element that is leaving the window `arr[i - k]`.
5. Update `max_sum` if the current `window_sum` is greater than the previous `max_sum`.

# 
**time complexity:** O(n)  
**space complexity:** O(1)