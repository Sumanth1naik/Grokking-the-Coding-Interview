# Minimum Size Subarray Sum

Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

 

**Example 1:**
```
Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
```
**Example 2:**
```
Input: target = 4, nums = [1,4,4]
Output: 1
```
**Example 3:**
```
Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0
```

**Constraints:**
1 <= target <= 109  
1 <= nums.length <= 105  
1 <= nums[i] <= 104  


# Approach 1: Brute Force
1. Initialize a variable `min_length` to store the minimum length found so far, set it to a large value (e.g., `Integer.MAX_VALUE`).
2. Iterate through the array from index 0 to `nums.length - 1` (inclusive) to consider all possible starting points of subarrays.
3. For each starting index `i`, initialize a variable `current_sum` to 0 and iterate through the array from index `i` to `nums.length - 1` (inclusive) to consider all possible ending points of subarrays.
4. For each ending index `j`, add `nums[j]` to `current_sum and check if `current_sum` is greater than or equal to `target`. If it is, update `min_length` with the length of the current subarray (`j - i + 1`) if it's smaller than the previous `min_length`.        


# Approach 2: Sliding Window
1. Initialize two pointers, `start` and `end`, both set to 0, to represent the current window of elements.
2. Initialize a variable `current_sum` to 0 to keep track of the sum of the elements in the current window.
3. Initialize a variable `min_length` to store the minimum length found so far, set it to a large value (e.g., `Integer.MAX_VALUE`).
4. Iterate through the array using the `end` pointer. For each element at index `end`, add `nums[end]` to `current_sum`.
5. While `current_sum` is greater than or equal to `target`, update `min_length` with the length of the current window (`end - start + 1`) if it's smaller than the previous `min_length`. Then, subtract `nums[start]` from `current_sum` and increment the `start` pointer to shrink the window from the left.



#
**time complexity:** O(n)  
**space complexity:** O(1)
 