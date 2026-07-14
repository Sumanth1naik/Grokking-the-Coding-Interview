import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        
        // Step 1: Sort the array
        Arrays.sort(nums);
        
        // Step 2: Fix the first pointer
        for (int i = 0; i < n - 3; i++) {
            // Skip duplicates for the first pointer
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            // Step 3: Fix the second pointer
            for (int j = i + 1; j < n - 2; j++) {
                // Skip duplicates for the second pointer
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                
                // Step 4: Two-pointer approach for the remaining two numbers
                int left = j + 1;
                int right = n - 1;
                
                while (left < right) {
                    // Use long to prevent integer overflow during addition
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    
                    if (sum == target) {
                        // Found a valid quadruplet
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        
                        // Move both pointers inward
                        left++;
                        right--;
                        
                        // Skip duplicates for the left pointer
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        
                        // Skip duplicates for the right pointer
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    } else if (sum < target) {
                        // Sum is too small, shrink from the left
                        left++;
                    } else {
                        // Sum is too large, shrink from the right
                        right--;
                    }
                }
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        int arr[] = {1,0,-1,0,-2,2};
        int target = 0;
        List<List<Integer>> ans = new ArrayList<>();
        ans = obj.fourSum(arr, target);
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