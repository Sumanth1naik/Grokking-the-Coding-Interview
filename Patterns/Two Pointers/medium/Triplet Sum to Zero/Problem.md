# Problem Statement
Given an array of unsorted numbers, find all unique triplets in it that add up to zero.

# Examples
**Example 1**
```
Input: [-3, 0, 1, 2, -1, 1, -2]
Output: [[-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]]
Explanation: There are four unique triplets whose sum is equal to zero.
```
**Example 2**
```
Input: [-5, 2, -1, -2, 3]
Output: [[-5, 2, 3], [-2, -1, 3]]
Explanation: There are two unique triplets whose sum is equal to zero.
```
**Constraints:**  
3 <= arr.length <= 3000  
-105 <= arr[i] <= 105



# Approach:
```
1. Sort the input array.
2. Iterate through the array and for each element, use two pointers to find pairs that sum up to the negative of the current element.
3. Skip duplicate elements to ensure unique triplets are found.
4. Return the list of unique triplets that sum to zero.
```