# Longest Substring with K Distinct Characters (medium)
**Problem Statement**
Given a string, find the length of the longest substring in it with no more than K distinct characters.

You can assume that K is less than or equal to the length of the given string.

**Example 1:**
```
Input: String="araaci", K=2  
Output: 4  
Explanation: The longest substring with no more than '2' distinct characters is "araa".
```
**Example 2:**
```
Input: String="araaci", K=1  
Output: 2  
Explanation: The longest substring with no more than '1' distinct characters is "aa".
```
**Example 3:**
```
Input: String="cbbebi", K=3  
Output: 5
```

# Approach
1. Use a sliding window approach to traverse the string.
2. Use a hash map to store the frequency of characters in the current window.
3. Expand the window by adding characters to the right until the number of distinct characters exceeds K.
4. When the number of distinct characters exceeds K, shrink the window from the left until the number of distinct characters is less than or equal to K.
5. Keep track of the maximum length of the window that satisfies the condition of having no more than K distinct characters.
6. Return the maximum length found.


**time complexity**: O(N), where N is the number of characters in the input string. The outer loop runs for all characters, and the inner loop processes each character at most once.  
**space complexity**: O(K), as we need to store a maximum of K+1 characters in the hash map.
