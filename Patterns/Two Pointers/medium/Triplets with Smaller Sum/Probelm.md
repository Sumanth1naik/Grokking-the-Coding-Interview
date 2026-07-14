# Problem Statement
Given an array arr of unsorted numbers and a target sum, count all triplets in it such that `arr[i]` + `arr[j]` + `arr[k]` < target where i, j, and k are three different indices. Write a function to return the count of such triplets.

**Example 1:**
```
Input: [-1, 0, 2, 3], target=3 
Output: 2
Explanation: There are two triplets whose sum is less than the target: [-1, 0, 3], [-1, 0, 2]
```
**Example 2:**
```
Input: [-1, 4, 2, 1, 3], target=5 
Output: 4
Explanation: There are four triplets whose sum is less than the target: 
[-1, 1, 4], [-1, 1, 3], [-1, 1, 2], [-1, 2, 3]
```
**Constraints:**  
n == arr.length  
0 <= n <= 3500  
-100 <= arr[i] <= 100  
-100 <= target <= 100  


# Approach
1. Sort the input array.
2. Iterate through the array with a variable `i` from 0 to n-2
3. For each `i`, use two pointers `left` and `right` to find pairs such that arr[i] + arr[left] + arr[right] < target.
4. If the sum of the triplet is less than the target, all elements from `left` to `right` will form valid triplets with `arr[i]`. Count these triplets and move the `left` pointer to the right.
5. If the sum is greater than or equal to the target, move the `right` pointer to the left to reduce the sum.
6. Continue this process until `left` is less than `right`.
7. Return the total count of triplets found.