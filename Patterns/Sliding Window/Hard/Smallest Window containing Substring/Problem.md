# Minimum Window Substring

Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

 

**Example 1:**
```
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
```
**Example 2:**
```
Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
```
**Example 3:**
```
Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
 
```
**Constraints:**  

m == s.length  
n == t.length  
1 <= m, n <= 105  
s and t consist of uppercase and lowercase English letters.  

# Approach
1. Use a sliding window approach to traverse the string s.
2. Use a frequency array of 128 (to cover all ASCII characters) to store the frequency of characters in string t.
4. Now we can use the diff pointer to store the length of string t and use sliding window approach on the string s
5. First move the right pointer and check weather the char is part of string t ny using frequency array, if its a part then decrement the counter diff and array frequency
6. once the pointer diff reaches 0 means now we have all the characters of t in the window size of left and right in string s
7. Now start to shrink the left pointer in the string s, if the removing character at left is part of the string t, and removing will cause the break of window means increase the diff pointer and update the frequency by incrementing 
8. Use the minStart and the minLen to capture the minimum size of the valid substring and return it once the iteation is done


## Complexity Breakdown
**Time Complexity:** O(m + n)

We iterate through string t once to build the frequency map: O(n).

Both the left and right pointers only move strictly forward through string s. Each character in s is visited at most twice (once by right, once by left). This takes O(m) time.

Total Time: O(m + n).

**Space Complexity:** O(1)

The map array is of a fixed size 128 regardless of the lengths of s and t, making it constant extra space. The character arrays and substring take space proportional to the output, but the auxiliary working space is O(1).

 