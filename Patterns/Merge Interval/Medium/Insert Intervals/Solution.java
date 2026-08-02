import java.util.*;
class Solution {
    public ArrayList<int[]> insertInterval(int[][] intervals, int[] newInterval) {
        //Create a temp list to store the result
        ArrayList<int[]>  ans = new ArrayList<int[]> ();
        int n = intervals.length;
        //Handling the edge case
        if(n == 0){
            ans.add(newInterval);
        }
        int i = 0;
        //Iterate through the intervals
            //Phase 1 : add all the intervals that end time is lesser than the start time of the new Interval
            while(i<n && intervals[i][1] < newInterval[0]){
                ans.add(intervals[i]);
                i++;
            }
            //Phase 2 : Now merge the inervals so that start time of the intervals should be less than or equal to the end time of the new interval
            while(i<n && intervals[i][0]<=newInterval[1]){
                //Every time update the boundaries
                newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1],intervals[i][1]);
                i++;
            }
            //Once merging done add the new Interval to result set
            ans.add(newInterval);
            //Add the remaining intervals to the result
            while(i<n){
                ans.add(intervals[i]);
                i++;
            }
        return ans;
        
    }
    public static void main(String[] args) {
        Solution obj = new Solution();
        int intervals [][] = {{1, 3}, {4, 5}, {6, 7}, {8, 10}};
        int newInterval [] = {5, 6};
        ArrayList<int []> ans = obj.insertInterval(intervals,newInterval);
        for(int i=0;i<ans.size();i++){
            System.out.println(Arrays.toString(ans.get(i)));
        }
    }
}
