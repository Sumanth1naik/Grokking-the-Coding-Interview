# Maximum CPU Load from the given list of jobs
Given an array of jobs with different time requirements, where each job consists of start time, end time and CPU load. 

The task is to find the maximum CPU load at any time if all jobs are running on the same machine.

**Examples:** 


```
Input: jobs[] = {{1, 4, 3}, {2, 5, 4}, {7, 9, 6}} 
Output: 7 
Explanation: 
In the above-given jobs, there are two jobs which overlaps. 
That is, Job [1, 4, 3] and [2, 5, 4] overlaps for the time period in [2, 4] 
Hence, the maximum CPU Load at this instant will be maximum (3 + 4 = 7).
```



```
Input: jobs[] = {{6, 7, 10}, {2, 4, 11}, {8, 12, 15}} 
Output: 15 
Explanation: 
Since, There are no jobs that overlaps. 
Maximum CPU Load will be - max(10, 11, 15) = 15  
```

# Approach
- Sort the jobs by start time.
- Use a min-heap to keep track of the jobs that are currently running. The heap will store the end time and CPU load of the jobs.
- Iterate through the sorted jobs and for each job:
  - Remove all jobs from the heap that have ended before the start time of the current job.
  - Add the current job to the heap.
  - Calculate the current CPU load by summing the CPU loads of all jobs in the heap.
  - Update the maximum CPU load if the current CPU load is greater than the previous maximum.



**Time Complexity** O(nlogn)
**Auxiliary Space** O(n) for the heap