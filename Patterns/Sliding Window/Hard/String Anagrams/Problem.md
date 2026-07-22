# Find All Anagrams in a String

Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

 

**Example 1:**
```
Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
```
**Example 2:**
```
Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 
```
**Constraints:**  
1 <= s.length, p.length <= 3 * 104  
s and p consist of lowercase English letters.  



# Approach
1. Create an array of size 26 to store the frequency of characters in p.
2. Create a variable `diff` to store the number of characters that are different between the current window in s and p.
3. Initialize two pointers `st` and `end` to represent the start and end of the current window in s.
4. Iterate through the first window of size `len(p)` in s and update the frequency array and `diff` accordingly.
5. If `diff` is 0, it means the first window is an anagram of p, so add the starting index to the answer list.
6. Move the window by incrementing both `st` and `end` pointers, and update the frequency array and `diff` accordingly.



**time complexity**: O(n) where n is the length of s.  
**space complexity**: O(1) since the frequency array is of fixed size 26.