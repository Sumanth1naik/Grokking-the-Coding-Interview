import java.util.*;
class Solution {
public int minMeetingRooms(int[][] meetings) {
    if (meetings == null || meetings.length == 0) return 0;

    // 1. Sort by start time
    Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

    // 2. Min-heap stores end times of active meetings
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    for (int[] meeting : meetings) {
        // If the earliest finishing meeting has ended, reuse its room
        if (!minHeap.isEmpty() && meeting[0] >= minHeap.peek()) {
            minHeap.poll();
        }
        // Allocate room (push current meeting's end time)
        minHeap.offer(meeting[1]);
    }

    // Peak size of heap = minimum rooms needed
    return minHeap.size();
}
public static void main(String[] args) {
    Solution solution = new Solution();
    int[][] meetings = {{0, 30}, {5, 10}, {15, 20}};
    int result = solution.minMeetingRooms(meetings);
    System.out.println("Minimum number of meeting rooms required: " + result);
}
}