# Subarray Product Less Than K

Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.

 

**Example 1:**
```
Input: nums = [10,5,2,6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are:
[10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
```
**Example 2:**
```
Input: nums = [1,2,3], k = 0
Output: 0
 
```
**Constraints:**

1 <= nums.length <= 3 * 104
1 <= nums[i] <= 1000
0 <= k <= 106


# Intuition
Since all numbers in the array are positive integers, the product of any subarray will strictly increase as we add more elements and strictly decrease as we remove them. This monotonic behavior tells us that a sliding window approach will be perfectly efficient, saving us from having to recalculate products from scratch like we would in a brute-force method.

# Approach
**Edge Case:** If $k \le 1$, we can immediately return 0. Since the problem constraints state that all elements are at least 1, a product can never be strictly less than 1.    
**Expand the Window:** Use a for loop to move a right pointer across the array, continuously multiplying the current element into our product variable.  
**Shrink the Window:** If the product becomes greater than or equal to $k$, our current window is invalid. We use a while loop to divide the product by nums[left] and increment the left pointer until the product is strictly less than $k$ again.  
**Count Subarrays:** Once we have a valid window ending at the right pointer, the number of valid contiguous subarrays ending at this exact position is mathematically right - left + 1. We add this length to our total count.  

# Complexity
- **Time complexity:**$O(N)$Where $N$ is the length of the nums array. Both the left and right pointers only travel forward. Every element is multiplied at most once (by right) and divided at most once (by left), resulting in linear time performance.
- **Space complexity:**$O(1)$We only use a few primitive integer variables (count, left, right, product), requiring constant extra space regardless of the input array size.