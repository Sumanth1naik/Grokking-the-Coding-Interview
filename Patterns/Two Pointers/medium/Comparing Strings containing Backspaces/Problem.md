# Problem Statement
Given two strings containing backspaces (identified by the character ‘#’), check if the two strings are equal.

**Example 1:**
```
Input: str1="xy#z", str2="xzz#"
Output: true
Explanation: After applying backspaces the strings become "xz" and "xz" respectively.
```
**Example 2:**
```
Input: str1="xy#z", str2="xyz#"
Output: false
Explanation: After applying backspaces the strings become "xz" and "xy" respectively.
```
**Example 3:**
```
Input: str1="xp#", str2="xyz##"
Output: true
Explanation: After applying backspaces the strings become "x" and "x" respectively.
```

# Approach
1. Initialize two pointers, `i` and `j`, to point to the end of `str1` and `str2` respectively.
2. While `i` is greater than or equal to 0 or `j` is greater than or equal to 0, do the following:
   - Initialize two counters, `backspaceCount1` and `backspaceCount2`, to 0.
   - For `str1`, move the pointer `i` backwards while counting the number of backspaces. If a backspace is encountered, increment `backspaceCount1`. If a non-backspace character is encountered and `backspaceCount1` is greater than 0, decrement `backspaceCount1` and continue moving the pointer backwards.
   - Repeat the same process for `str2` with pointer `j` and counter `backspaceCount2`.
3. After processing both strings, compare the characters at the current positions of `i` and `j`. If they are not equal, return false.
4. If both pointers are valid (i.e., not out of bounds), move both pointers backwards to compare the next characters.
5. If the loop completes without finding any mismatches, return true, indicating that the two strings are equal after applying backspaces.
