class Solution {
    
    /**
     * Squares each element of a sorted array and returns a new array 
     * containing the squares sorted in non-decreasing order.
     * 
     * Since the input array is sorted but can contain negative numbers, 
     * the largest squares will be at the extreme ends of the array. 
     * A two-pointer approach is used to compare the absolute values 
     * at both ends and fill the result array from back to front.
     *
     * @param nums The input array of integers, sorted in non-decreasing order.
     * @return A new array containing the squares of the input elements, sorted.
     */
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        
        // Array to store our sorted squared results
        int[] arr = new int[n];
        
        // Pointers for the start (left) and end (right) of the input array
        int left = 0;
        int right = n - 1;
        
        // Pointer to keep track of where to place the next largest square in the result array
        int idx = n - 1;
        
        // Iterate until all elements have been processed
        while (left <= right) {
            // Compare the absolute values of elements at the left and right pointers.
            // The larger absolute value will yield the larger square.
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                // If the left element is larger in absolute value, square it and place it
                arr[idx] = nums[left] * nums[left];
                // Move the left pointer forward
                left++;
                // Decrement the index for the next largest square
                idx--;
            } else {
                // If the right element is larger or equal in absolute value, square it and place it
                arr[idx] = nums[right] * nums[right];
                // Move the right pointer backward
                right--;
                // Decrement the index for the next largest square
                idx--;
            }
        }
        
        return arr;
    }

    /**
     * Main method to test the sortedSquares logic.
     */
    public static void main(String[] args) {
        Solution obj = new Solution();
        
        // Test case with negative and positive numbers
        int[] nums = {-4, -1, 0, 3, 10};
        
        // Get the sorted squares array
        int[] ans = obj.sortedSquares(nums);
        
        // Print the results
        for (int val : ans) {
            System.out.println(val);
        }
    }
}