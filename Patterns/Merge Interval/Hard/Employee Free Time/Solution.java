import java.util.*;
class Solution {
    static class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "[" + start + ", " + end + "]";
        }
    }
    public static List<Interval> findEmployeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> result = new ArrayList<>();
        PriorityQueue<Interval> minHeap = new PriorityQueue<>((a, b) -> a.start - b.start);

        // add all the intervals to the min heap
        for (List<Interval> employee : schedule) {
            for (Interval interval : employee) {
                minHeap.offer(interval);
            }
        }

        // get the first interval from the min heap
        Interval previousInterval = minHeap.poll();
        while (!minHeap.isEmpty()) {
            Interval currentInterval = minHeap.poll();
            // check if there is a gap between the previous and current intervals
            if (previousInterval.end < currentInterval.start) {
                result.add(new Interval(previousInterval.end, currentInterval.start));
                previousInterval = currentInterval;
            } else { // overlapping intervals, update the previous interval if needed
                if (previousInterval.end < currentInterval.end)
                    previousInterval = currentInterval;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        // Example usage
        List<List<Interval>> schedule = new ArrayList<>();
        schedule.add(Arrays.asList(new Interval(1, 3), new Interval(5, 6)));
        schedule.add(Arrays.asList(new Interval(2, 3), new Interval(6, 8)));
        List<Interval> freeTime = findEmployeeFreeTime(schedule);
        System.out.println(freeTime); // Output: [3, 5]
    }
}