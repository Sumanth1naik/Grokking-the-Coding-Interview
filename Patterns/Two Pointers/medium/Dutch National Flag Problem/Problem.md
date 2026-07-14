# Problem Statement
Given an array containing 0s, 1s and 2s, sort the array in-place. You should treat numbers of the array as objects, hence, we can’t count 0s, 1s, and 2s to recreate the array.

The flag of the Netherlands consists of three colors: red, white and blue; and since our input array also consists of three different numbers that is why it is called Dutch National Flag problem.

## Examples
**Example 1**
```
Input: arr = [1, 0, 2, 1, 0]
Output: [0, 0, 1, 1, 2]
Explanation:
All 0s are moved to the front, 1s in the middle, and 2s at the end.
The relative order within each group doesn't matter.
```
**Example 2**
```
Input: arr= [2, 2, 0, 1, 2, 0]
Output: [0, 0, 1, 2, 2, 2]
Explanation:
All 0s come first, followed by the 1, and then all 2s at the end.
Sorting is done in-place without using extra space or counting.
```
**Constraints:**  
n == arr.length  
1 <= n <= 300  
arr[i] is either 0, 1, or 2.  

# Approach
1. Initialize three pointers: `low`, `mid`, and `high`. Set `low` and `mid` to the start of the array (index 0) and `high` to the end of the array (index n-1).
2. Iterate through the array while `mid` is less than or equal to `high`.
   - If `arr[mid]` is 0, swap `arr[low]` and `arr[mid]`, then increment both `low` and `mid`.
   - If `arr[mid]` is 1, just increment `mid`.
   - If `arr[mid]` is 2, swap `arr[mid]` and `arr[high]`, then decrement `high`.