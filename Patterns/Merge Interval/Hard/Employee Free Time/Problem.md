# Employee Free Time (hard)
Problem Statement
For ‘K’ employees, we are given a list of intervals representing each employee’s working hours. Our goal is to determine if there is a free interval which is common to all employees.

**Example 1:**
```
Input: Employee Working Hours=[[[1,3], [5,6]], [[2,3], [6,8]]]
Output: [3,5]
Explanation: All the employees are free between [3,5].
```

**Example 2:**
```
Input: Employee Working Hours=[[[1,3], [9,12]], [[2,4]], [[6,8]]]
Output: [4,6], [8,9]
Explanation: All employees are free between [4,6] and [8,9].
```

# Approach
- We can use a min-heap to keep track of the working hours of all employees. We can insert the first working hour of each employee in the min-heap. Once we have the working hours in the min-heap, we can compare the top two elements of the heap to see if there is a free interval between them. If there is a free interval, we can add it to our result list. We will then remove the top element from the heap and insert the next working hour of that employee in the heap. We will repeat this process until we have processed all working hours of all employees.


**Time Complexity** O(NlogK) where N is the total number of working hours and K is the number of employees.  
**Auxiliary Space** O(K) for the heap