# Problem Statement
Given an array of unsorted numbers and a target number, find all unique quadruplets in it, whose sum is equal to the target number.

**Example 1:**
```
Input: [4, 1, 2, -1, 1, -3], target=1
Output: [-3, -1, 1, 4], [-3, 1, 1, 2]
Explanation: Both the quadruplets add up to the target.
```
**Example 2:**
```
Input: [2, 0, -1, 1, -2, 2], target=2
Output: [-2, 0, 2, 2], [-1, 0, 1, 2]
Explanation: Both the quadruplets add up to the target.
```
**Constraints:**  
1 <= nums.length <= 200  
-109 <= nums[i] <= 109  
-109 <= target <= 109  

## Approach
1. Sort the input array.
2. Iterate through the array with two nested loops, using variables `i` and `j` to represent the first two numbers of the quadruplet.
3. For each pair of numbers represented by `i` and `j`, use two pointers `left` and `right` to find the remaining two numbers such that their sum equals the target.
4. If the sum of the quadruplet is equal to the target, add it to the result list and move both pointers to find other potential quadruplets.
5. If the sum is less than the target, move the `left` pointer to the right to increase the sum. If the sum is greater than the target, move the `right` pointer to the left to decrease the sum.
6. Continue this process until all unique quadruplets are found.