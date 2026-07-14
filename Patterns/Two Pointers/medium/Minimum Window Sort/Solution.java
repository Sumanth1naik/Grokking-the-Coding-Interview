class Solution {
     // Function to find the smallest subarray
    // sorting which makes whole array sorted
    public int findUnsortedSubarray(int[] arr) {
        // find the leftmost and rightmost index
        // from where the array is not sorted
        int n = arr.length;
        int left = n + 1, right = -1;
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]>arr[i+1]){
                left = i;
                break;
            }
        }
        //Edge case if array is alredy sorted
        if(left == n+1) return 0;

      
        for(int i=n-1;i>0;i--){
            if(arr[i]<arr[i-1]){
                right = i;
                break;
            }
        }
        // find the maximum and minimum element
        int mini = arr[left];
        int maxi = arr[left];
        for(int i=left+1;i<=right;i++){
            maxi = Math.max(maxi,arr[i]);
            mini = Math.min(mini,arr[i]);
        }
        // find the correct position 
        // of the minimum element
        for(int i=0;i<left;i++){
            if(arr[i]>mini){
                left = i;
                break;
            }
        }
        // find the correct position
        // of the maximum element
        for(int i=n-1;i>right;i--){
            if(arr[i]<maxi){
                right = i;
                break;
            }
        }
        return right-left+1;
    }
    public static void main(String[] args) {
        int[] arr = {2,3,3,2,4};
        Solution obj = new Solution();
        System.out.println(obj.findUnsortedSubarray(arr));
    }
}