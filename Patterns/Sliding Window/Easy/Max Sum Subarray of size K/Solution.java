class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        // Initialize the sum of the first 'k' elements
        int ans = 0;
        for(int i=0;i<k;i++){
            ans += arr[i];
        }
        // Initialize two pointers, 'left' and 'right', to represent the current window of size 'k'
        int left  =0;
        int right = k;
        int n = arr.length;
        // Initialize 'MaxAns' to keep track of the maximum sum found so far
        int MaxAns = ans;
        // Use a while loop to slide the window through the array
        while(right<n){
            // Update the sum by subtracting the element going out of the window and adding the new element coming into the window
            ans = ans-arr[left]+arr[right];
            // Update 'MaxAns' if the new sum is greater than the current maximum
            MaxAns = Math.max(MaxAns,ans);
            // Move the window forward by incrementing both 'left' and 'right' pointers
            right++;
            left++;
        }
        // Return the maximum sum of any subarray of size 'k' found in the array
        return MaxAns;
    }
    public static void main(String[] args) {
        int arr[] = {2, 1, 5, 1, 3, 2};
        int k = 3;
        Solution obj = new Solution();
        System.out.println(obj.maxSubarraySum(arr,k));
    }
}