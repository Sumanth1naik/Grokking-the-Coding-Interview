class Solution {
    // Function to find the length of the longest contiguous subarray having all 1s after replacing no more than 'k' 0s with 1s
    public int maxOnes(int arr[], int k) {
        // Initialize two pointers, 'l' and 'r', to represent the current window of the subarray
        int l = 0;
        int r = 0;
        // Initialize 'zero' to keep track of the number of 0s in the current window and 'ans' to store the length of the longest subarray found
        int zero = 0;
        int ans = 0;
        int n = arr.length;
        // Use a for loop to slide the window through the array
        for(r=0;r<n;r++){
            // If the current element is 0, increment 'zero' to indicate that we have one more 0 in the current window
            if(arr[r]==0){
                zero++;
            }
            // If the number of 0s in the current window exceeds 'k', shrink the window from the left until the number of 0s is less than or equal to 'k'
            if(zero>k){
                while(zero>k){
                    if(arr[l]==0){
                        zero--;
                    }
                    l++;
                }
            }
            // If the number of 0s in the current window is less than or equal to 'k', update 'ans' to store the length of the longest subarray found so far
            ans = Math.max(ans,r-l+1);
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1};
        int k = 2;
        Solution obj = new Solution();
        System.out.println(obj.maxOnes(arr,k));
    }
}