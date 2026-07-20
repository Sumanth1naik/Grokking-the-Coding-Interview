class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // Initialize two pointers, 'i' and 'j', to represent the current window of the subarray
        int i=0;
        int j=0;
        // Initialize 'sum' to keep track of the sum of the current window and 'res' to store the minimum length found
        int sum =0;
        int res =Integer.MAX_VALUE;
        // Use a while loop to slide the window through the array
        while(j<nums.length)
        {
            // Add the current element to the sum
            sum=sum+nums[j];
            // Check if the sum is less than sum then just increment the right pointer
            if(sum<target)
            {
                j++;
            }
            // Check if the sum is equal to the target, update the result and increment the right pointer
            else if(sum==target)
            {
                res=Math.min(res,j-i+1);
                j++;
            }
            // If the sum is greater than the target, shrink the window from the left until the sum is less than or equal to the target
            else if(sum>target)
            {
                // Use a while loop to shrink the window from the left until the sum is less than or equal to the target
                while(sum>target)
                {
                    res=Math.min(res,j-i+1);
                    sum=sum-nums[i];
                    i++;
                }
                //  Check if the sum is equal to the target after shrinking the window, update the result and increment the right pointer
                if(sum==target)
                {
                    res=Math.min(res,j-i+1);
                }
                j++;
            }
        }
        // If no valid subarray was found, return 0; otherwise, return the minimum length found
        if(res==Integer.MAX_VALUE)
        {
            return 0;
        }
        return res;
        
    }

    public static void main(String[] args) {
        int target = 7;
        int nums[] = {2,3,1,2,4,3};
        Solution obj = new Solution();
        System.out.println(obj.minSubArrayLen(target,nums));
    }
}