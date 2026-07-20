import java.util.HashMap;
class Solution {
    public int totalFruit(int[] fruits) {
        // Initialize two pointers, 'i' and 'j', to represent the current window of the subarray
        int i =0;
        int j=0;
        // Initialize a HashMap to keep track of the frequency of each fruit type in the current window
        HashMap<Integer,Integer> fs = new HashMap<>();
        int n= fruits.length;
        int ans = 0;
        // Use a while loop to slide the window through the array
        while(j<n){
            // Add the current fruit type to the HashMap and increment its frequency
            fs.put(fruits[j],fs.getOrDefault(fruits[j],0)+1);
            // If the number of distinct fruit types in the current window exceeds 2, shrink the window from the left until the number of distinct fruit types is less than or equal to 2
                while(fs.size()>2){
                    // Decrement the frequency of the fruit type at the 'i' pointer in the current window
                fs.put(fruits[i],fs.getOrDefault(fruits[i],0)-1);
                // If the frequency of the fruit type at the 'i' pointer becomes 0, remove it from the HashMap
                if(fs.get(fruits[i])==0){
                fs.remove(fruits[i]);
                }
                i++;
                }
                // If the number of distinct fruit types in the current window is less than or equal to 2, update 'ans' to store the length of the longest subarray found so far
                 ans = Math.max(ans,j-i+1);
                 j++;
            }
            
          // Return the length of the longest subarray found  
        return ans;
        
    }
    public static void main(String[] args) {
        int fruits[] = {1,2,1};
        Solution obj = new Solution();
        System.out.println(obj.totalFruit(fruits));
    }
}