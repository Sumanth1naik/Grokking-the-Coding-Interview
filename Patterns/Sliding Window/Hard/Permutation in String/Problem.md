# Permutation in String

Given two strings `s1` and `s2`, return true if `s2` contains a permutation of `s1`, or false otherwise.

In other words, return true if one of `s1's` permutations is the substring of `s2`.

 

**Example 1:**
```
Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
```
**Example 2:**
```
Input: s1 = "ab", s2 = "eidboaoo"
Output: false
 ```

**Constraints:** 
1 <= s1.length, s2.length <= 104  
s1 and s2 consist of lowercase English letters.  


# Approach
1. Edge Case Check: If s1 is longer than s2, return false immediately.
2. Frequency Arrays (Better than HashMaps here): Since there are only 26 lowercase letters, use two arrays of size 26 (e.g., s1_count and s2_count).
3. Initialize the First Window: Loop from 0 to s1.length - 1.
4. Count the frequencies of characters for s1.
5. Count the frequencies of characters for the first window of s2.
6. Slide the Window:
7. Start a loop from s1.length to the end of s2.
8. At each step, check if s1_count equals s2_count. If they match, you found a permutation! Return true.
9. Slide Right: Add the new character at the right edge of the window to s2_count.
10. Slide Left: Remove the character that just fell out of the left edge of the window from s2_count.
11. Final Check: After the loop ends, check one last time if the arrays match (to account for the very last window). Return false if no match was found.



**time complexity**: The time complexity of the above algorithm is O(N), where ‘N’ is the number of characters in the input string s2. The outer for loop runs for all characters, and the inner while loop processes each character only once; therefore, the time complexity of the algorithm will be O(N + N) = O(N).
**space complexity**: The algorithm runs in constant space O(1) as we are using only two arrays of size 26 to keep track of the frequency of characters.