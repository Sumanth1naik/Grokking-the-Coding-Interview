# Meeting rooms - Find minimum meeting rooms

Given two arrays start[] and end[] such that start[i] is the starting time of ith meeting and end[i] is the ending time of ith meeting. Task is to find minimum number of rooms required to attend all meetings.

Note: A person can also attend a meeting if it's starting time is same as the previous meeting's ending time.

**Examples:**
```
Input: start[] = [1, 10, 7], end[] = [4, 15, 10]
Output: 1
Explanation: Since all the meetings are held at different times, it is possible to attend all the meetings in a single room.
```
```
Input: start[] = [2, 9, 6], end[] = [4, 12, 10]
Output: 2
Explanation: 1st and 2nd meetings can be attended at one room but for 3rd meeting another room is required.
```

# Approach
- Use the min-heap to keep track of the end time of meetings. For each meeting, check if the room due to free up the earliest is free before the meeting starts. If so, assign that room to this meeting. If not, allocate a new room. At the end, the size of the heap tells us the minimum rooms required for all the meetings.

##
**Time Complexity** O(nlogn)  
**Auxiliary Space** O(n) for the heap