# Circular Array Loop

You are playing a game involving a circular array of non-zero integers nums. Each ```nums[i]``` denotes the number of indices forward/backward you must move if you are located at index i:

If ```nums[i]``` is positive, move ```nums[i]``` steps forward, and
If ```nums[i]``` is negative, move ```abs(nums[i])``` steps backward.
Since the array is circular, you may assume that moving forward from the last element puts you on the first element, and moving backwards from the first element puts you on the last element.

A cycle in the array consists of a sequence of indices seq of length k where:

Following the movement rules above results in the repeating index sequence ```seq[0] -> seq[1] -> ... -> seq[k - 1] -> seq[0] -> ...```
Every ```nums[seq[j]]``` is either all positive or all negative.
```k > 1```
Return ```true``` if there is a cycle in ```nums```, or ```false``` otherwise.

 

**Example 1**:

```
Input: nums = [2,-1,1,2,2]
Output: true
Explanation: The graph shows how the indices are connected. White nodes are jumping forward, while red is jumping backward.
We can see the cycle 0 --> 2 --> 3 --> 0 --> ..., and all of its nodes are white (jumping in the same direction).
```
**Example 2**:


```Input: nums = [-1,-2,-3,-4,-5,6]
Output: false
Explanation: The graph shows how the indices are connected. White nodes are jumping forward, while red is jumping backward.
The only cycle is of size 1, so we return false.
```
**Example 3:**

```
Input: nums = [1,-1,5,1,4]
Output: true
Explanation: The graph shows how the indices are connected. White nodes are jumping forward, while red is jumping backward.
We can see the cycle 0 --> 1 --> 0 --> ..., and while it is of size > 1, it has a node jumping forward and a node jumping backward, so it is not a cycle.
We can see the cycle 3 --> 4 --> 3 --> ..., and all of its nodes are white (jumping in the same direction).
 ```

**Constraints:**  
1 <= nums.length <= 5000  
-1000 <= nums[i] <= 1000  
nums[i] != 0  


# Approach
1. We can use the **Fast and Slow Pointers** technique to find a cycle in the circular array. The slow pointer moves one step at a time, while the fast pointer moves two steps at a time. If there is a cycle, the fast pointer will eventually meet the slow pointer.
2. We need to ensure that the cycle is valid, meaning that all the numbers in the cycle are either all positive or all negative. If we find a cycle, we can check the sign of the numbers in the cycle to determine if it is valid.
3. If we find a valid cycle, we return true. If we finish traversing the array without finding a valid cycle, we return false.
4. To avoid infinite loops, we can mark the visited indices by changing their values to 0 after checking them. This way, we won't revisit them in future iterations.
5. We can also use a helper function to calculate the next index based on the current index and the value at that index, taking care to wrap around the array using modulo operation.
6. We need to handle the case where the next index is the same as the current index, which would indicate a cycle of length 1. In this case, we should return false since we are looking for cycles of length greater than 1.

**Time Complexity:** O(n), where n is the number of elements in the array. We traverse the array to find a cycle and check its validity.  
**Space Complexity:** O(1), as we are using only a constant amount of extra space for pointers and variables.