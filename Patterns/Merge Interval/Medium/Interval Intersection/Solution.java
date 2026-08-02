import java.util.ArrayList;
class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        // Two pointers
        int l = 0;
        int r = 0;
        int n = firstList.length;
        int m = secondList.length;
        //Temp memory to store the result
        ArrayList<int[]> ans = new ArrayList<>();
        //Traverse both the list
        while(l<n && r<m){
            //Find the max boundary for the left bound
            int min = Math.max(firstList[l][0],secondList[r][0]);
            //Find the min boundary for the right bound
            int max = Math.min(firstList[l][1],secondList[r][1]);

            //Verify the intersection point is valid or not
            if(min<=max){
                int temp[] = {min,max};
                ans.add(temp);
            }
            // Based on the max boundary increment the respective two pointer
            if(firstList[l][1]<secondList[r][1]){
                l++;
            }
            else{
                r++;
            }
        }

        //Conver the arraylist to 2D array to return the result
        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] firstList = {{0, 2}, {5, 10}, {13, 15}, {16, 19}};
        int[][] secondList = {{1, 4}, {7, 8}, {10, 12}, {15, 16}};
        int[][] result = solution.intervalIntersection(firstList, secondList);
        for (int[] interval : result) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
    }
}