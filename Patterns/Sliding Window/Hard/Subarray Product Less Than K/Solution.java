class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // Edge case: Since all nums[i] >= 1, product can never be less than k if k <= 1.
        if (k <= 1) {
            return 0;
        }

        int count = 0;
        int left = 0;
        int product = 1;

        // Iterate through the array with the right pointer
        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];

            // If the product is too large, shrink the window from the left
            while (product >= k && left <= right) {
                product /= nums[left];
                left++;
            }

            // Add the number of valid subarrays ending at the current right pointer
            count += (right - left + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        int nums [] = {2,5,3,10};
        int k = 30;

        System.out.println(obj.numSubarrayProductLessThanK(nums, k));
    }
}