# Longest Substring with Same Letters after Replacement (hard)
**Problem Statement**
Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters with any letter, find the length of the longest substring having the same letters after replacement.

**Example 1:**
```
Input: str="aabccbb", k=2  
Output: 5  
Explanation: Replace the two 'c' with 'b' to have a longest repeating substring "bbbbb".
```
**Example 2:**
```
Input: str="abbcb", k=1  
Output: 4  
Explanation: Replace the 'c' with 'b' to have a longest repeating substring "bbbb".
```
**Example 3:**
```
Input: str="abccde", k=1  
Output: 3
```


# Approach
1. This problem follows the Sliding Window pattern and we can use a similar strategy as discussed in Longest Substring with K Distinct Characters.
2. We can use a HashMap to remember the count of each letter we have in the current window. We also need to remember the count of the letter that has the maximum frequency in the current window.
3. At any time, we know that we can replace the remaining letters in the window with the letter that has the maximum frequency. If the remaining letters are more than ‘k’, we should shrink the window as we are not allowed to replace more than ‘k’ letters.
4. We can remember the maximum length of the substring that we have found so far while we are processing all the letters in the string.



**time complexity**: The above algorithm’s time complexity will be O(N), where ‘N’ is the number of letters in the input string. The outer for loop runs for all letters, and the inner while loop processes each letter only once; therefore, the time complexity of the algorithm will be O(N + N) = O(N).
**space complexity**: The algorithm runs in constant space O(1) as there can be a maximum of 26 letters in the input string.