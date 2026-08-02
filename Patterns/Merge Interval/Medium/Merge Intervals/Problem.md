# Merge Intervals

Given an array of intervals where `intervals[i] = [starti, endi]`, merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

**Example 1:**
```
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
```
**Example 2:**
```
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
```
**Example 3:**
```
Input: intervals = [[4,7],[1,4]]
Output: [[1,7]]
Explanation: Intervals [1,4] and [4,7] are considered overlapping.
 ```

**Constraints:**  
1 <= intervals.length <= 104  
intervals[i].length == 2  
0 <= starti <= endi <= 104  



# Approach
1. Sort the intervals based on the start time.
2. Initialize an empty list to hold the merged intervals.
3. Iterate through the sorted intervals and for each interval, check if it overlaps with the last interval in the merged list.
4. If it does overlap, merge them by updating the end time of the last interval in the merged list.
5. If it does not overlap, simply add the current interval to the merged list.


**time complexity:** O(n log n) due to sorting the intervals.  
**space complexity:** O(n) for storing the merged intervals.