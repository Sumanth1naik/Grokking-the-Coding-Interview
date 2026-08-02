import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    // This function merges overlapping intervals in a given array of intervals.
    public int[][] merge(int[][] intervals) {
        // Sort the intervals based on their starting points to facilitate merging.
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));

        // Create a list to hold the merged intervals.
        ArrayList<int []> ans = new ArrayList<>();
        // Initialize the previous interval to the first interval in the sorted list.
        int prevInt[]= intervals[0];
        ans.add(prevInt);
        // Iterate through the sorted intervals starting from the second interval.
        for(int i=1;i<intervals.length;i++){
            // Get the current interval to compare with the previous one.
            int curInt []= intervals[i];
            // Check if the current interval overlaps with the previous interval.
            if(curInt[0] <= prevInt[1]){
                prevInt[1] = Math.max(prevInt[1],curInt[1]);
            }
            // If there is no overlap, update the previous interval to the current one and add it to the result list.
            else{
                
                prevInt = curInt;
                ans.add(prevInt);
            }
        }
        // Convert the list of merged intervals back to a 2D array and return it.
        return ans.toArray(new int[ans.size()][]);
    }
    public static void main(String[] args) {
        Solution obj = new Solution();
        int intervals [][] = {{1,3},{2,6},{8,10},{15,18}};
        int ans [][] = obj.merge(intervals);
        for(int i=0;i<ans.length;i++){
            System.out.println(Arrays.toString(ans[i]));
        }
    }
}