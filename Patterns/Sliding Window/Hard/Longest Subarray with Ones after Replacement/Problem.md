# Longest Subarray with Ones after Replacement (hard)
**Problem Statement**
Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s, find the length of the longest contiguous subarray having all 1s.

**Example 1:**
```
Input: Array=[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2  
Output: 6  
Explanation: Replace the '0' at index 5 and 8 to have the longest contiguous subarray of 1s having length 6.
```
**Example 2:**
```
Input: Array=[0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1], k=3  
Output: 9
```


# Approach
1. This problem follows the Sliding Window pattern and we can use a similar strategy as discussed in Longest Substring with Same Letters after Replacement.
2. We can make use of the 'zero' temp variable to remember the count of 0s we have in the current window.
3. At any time, we know that we can replace the remaining 0s in the window with 1s. If the remaining 0s are more than ‘k’, we should shrink the window as we are not allowed to replace more than ‘k’ 0s.
4. We can remember the maximum length of the subarray that we have found so far while we are processing all the elements in the array.


**time complexity**: The above algorithm’s time complexity will be O(N), where ‘N’ is the number of elements in the input array. The outer for loop runs for all elements, and the inner while loop processes each element only once; therefore, the time complexity of the algorithm will be O(N + N) = O(N).  
**space complexity**: The algorithm runs in constant space O(1) as we are using only a few variables to keep track of the count of 0s and the maximum length of the subarray.