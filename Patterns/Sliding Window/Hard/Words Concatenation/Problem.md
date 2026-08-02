# Substring with Concatenation of All Words
You are given a string s and an array of strings words. All the strings of words are of the same length.

A concatenated string is a string that exactly contains all the strings of any permutation of words concatenated.

For example, if words = `["ab","cd","ef"]`, then `"abcdef"`, `"abefcd"`, `"cdabef"`, `"cdefab"`, "efabcd", and "efcdab" are all concatenated strings. "acdbef" is not a concatenated string because it is not the concatenation of any permutation of words.
Return an array of the starting indices of all the concatenated substrings in s. You can return the answer in any order.

 

**Example 1:**
```
Input: s = "barfoothefoobarman", words = ["foo","bar"]

Output: [0,9]

Explanation:

The substring starting at 0 is "barfoo". It is the concatenation of ["bar","foo"] which is a permutation of words.
The substring starting at 9 is "foobar". It is the concatenation of ["foo","bar"] which is a permutation of words.
```
**Example 2:**
```
Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]

Output: []

Explanation:

There is no concatenated substring.
```
**Example 3:**
```
Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]

Output: [6,9,12]

Explanation:

The substring starting at 6 is "foobarthe". It is the concatenation of ["foo","bar","the"].
The substring starting at 9 is "barthefoo". It is the concatenation of ["bar","the","foo"].
The substring starting at 12 is "thefoobar". It is the concatenation of ["the","foo","bar"].
```
 

**Constraints:**
1 <= s.length <= 104  
1 <= words.length <= 5000  
1 <= words[i].length <= 30  
s and words[i] consist of lowercase English letters.  

# Approach: Sliding Window with Word Alignment (Offsets)
**1. Core Concept**
Because all words in the target array are of the exact same length (wordLen), we don't need to check every single character index sequentially inside our main scanning loop. Instead, we can divide the string into "lanes" or "offsets." There are exactly wordLen possible starting alignments. By iterating our outer loop wordLen times and making our inner loop jump by wordLen steps, we guarantee that we evaluate every possible substring combination efficiently without redundant checks.

**2. Step-by-Step Execution**

Initialization: First, calculate the lengths needed and create a baseline frequency map (wordMap) that stores the count of each word present in the words array.

Setting the Offsets (Outer Loop): Run a for loop from 0 to wordLen - 1. Each iteration represents a new starting alignment.

Sliding the Window (Inner Loop): For each offset, initialize a start and end pointer. Slide the end pointer forward by wordLen chunks, extracting the current word.

**Evaluating Words:**

Valid Word: If the extracted word exists in wordMap, add it to our current window's frequency map (windMap) and increment our valid word count.

Overshooting Frequency: If adding this word causes its count in windMap to exceed the count in wordMap, the window is invalid. We shrink the window from the left by moving the start pointer forward by wordLen and decreasing counts until the frequency is valid again.

Invalid Word: If the extracted word is completely missing from wordMap, the current window is broken. We clear the windMap, reset the count to 0, and immediately move the start pointer to the current end.

Recording the Answer: If our count exactly equals the total number of words in the array, we have found a valid concatenated substring. We record the start index.


