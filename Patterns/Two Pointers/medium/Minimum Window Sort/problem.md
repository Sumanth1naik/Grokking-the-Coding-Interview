# Problem Statement
Given an array, find the length of the smallest subarray in it which when sorted will sort the whole array.

**Example 1:**
```
Input: [1, 2, 5, 3, 7, 10, 9, 12]
Output: 5
Explanation: We need to sort only the subarray [5, 3, 7, 10, 9] to make the whole array sorted
```
**Example 2:**
```
Input: [1, 3, 2, 0, -1, 7, 10]
Output: 5
Explanation: We need to sort only the subarray [1, 3, 2, 0, -1] to make the whole array sorted
```

**Example 3:**
```
Input: [1, 2, 3]
Output: 0
Explanation: The array is already sorted
```
**Example 4:**
```
Input: [3, 2, 1]
Output: 3
```

# Approach
1. Find the first number out of sorting order from the beginning of the array. Let's call its index `low`.
2. Find the first number out of sorting order from the end of the array. Let's call its index `high`.
3. Find the maximum and minimum of the subarray between `low` and `high`.
4. Extend the `low` index to the left as long as the numbers are greater than the minimum of the subarray.
5. Extend the `high` index to the right as long as the numbers are smaller than the maximum of the subarray.
6. The length of the required subarray will be `high - low + 1`.
