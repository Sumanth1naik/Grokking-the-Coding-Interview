# Fruits into Baskets (medium)
**Problem Statement**
You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an array of characters where each character represents a different type of fruit tree. You want to collect as much fruit as possible, but you are only allowed to carry two types of fruits in your baskets.
You can start collecting fruits from any tree, but once you have started, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your two baskets. Once you reach a tree with fruit that cannot fit in your baskets, you must stop collecting.



**Example 1:**
```
Input: fruits = [1,2,1]
Output: 3
Explanation: We can pick from all 3 trees.
```
**Example 2:**
```markdown
Input: fruits = [0,1,2,2]
Output: 3
Explanation: We can pick from trees [1,2,2].
If we had started at the first tree, we would only pick from trees [0,1].
```
**Example 3:**
```markdown

Input: fruits = [1,2,3,2,2]
Output: 4
Explanation: We can pick from trees [2,3,2,2].
If we had started at the first tree, we would only pick from trees [1,2].
```
 

**Constraints:**

1 <= fruits.length <= 105  
0 <= fruits[i] < fruits.length  


# Approach
1. Use a sliding window approach to traverse the array of fruits.
2. Use a hash map to store the frequency of fruit types in the current window.
3. Expand the window by adding fruits to the right until the number of distinct fruit types exceeds 2.
4. When the number of distinct fruit types exceeds 2, shrink the window from the left until the number of distinct fruit types is less than or equal to 2.
5. Keep track of the maximum length of the window that satisfies the condition of having no more than 2 distinct fruit types.
6. Return the maximum length found.


**time complexity**: O(N), where N is the number of fruits in the input array. The outer loop runs for all fruits, and the inner loop processes each fruit at most once.  
**space complexity**: O(1), as we need to store a maximum of 3 fruit types in the hash map.