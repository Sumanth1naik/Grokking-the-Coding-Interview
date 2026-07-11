
import java.util.*;
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Step 1: Sort the array to enable two-pointer logic and easy duplicate handling
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            // Optimization: If the current number is greater than 0, 
            // the sum can never be 0 since the array is sorted.
            if (nums[i] > 0) {
                break;
            }
            
            // Skip duplicates for our fixed pointer 'i'
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // Step 2: Initialize two pointers
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    // Step 3: Triplet found!
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Move both pointers inward
                    left++;
                    right--;
                    
                    // Skip duplicates for the 'left' pointer
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    
                    // Skip duplicates for the 'right' pointer
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    // Sum is too small, need a larger number
                    left++;
                } else {
                    // Sum is too large, need a smaller number
                    right--;
                }
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        Solution obj  = new Solution();
        int nums [] = {-5, 2, -1, -2, 3};
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        ans = obj.threeSum(nums);
        for(int i=0;i<ans.size();i++){
            System.out.print("[");
        for(int val:ans.get(i)){
            System.out.print(val+",");
        }
        System.out.print("]");
        System.out.println();
    }
    }
}