class Solution {
    // Function to find the length of the longest substring with at most K distinct characters
    public int longestKSubstr(String s, int k) {
        // Create an array to keep track of the frequency of each character in the current window
         int arr[] = new int [26];
        int n = s.length();
        // Initialize two pointers, 'left' and 'right', to represent the current window of the substring
        int left = 0;
        int right = 0;
        // Initialize 'temp' to keep track of the number of distinct characters in the current window and 'ans' to store the length of the longest substring found
        int temp = k;
        int ans = -1;
        // Use a while loop to slide the window through the string
        while(right<n && left<=right){
            // Get the character at the 'right' pointer and check if it is already in the current window
            char ch = s.charAt(right);
            // If the character is not in the current window, decrement 'temp' to indicate that we have one more distinct character
            if(temp>=0){
                int idx = ch-'a';
                // If the character is not in the current window, decrement 'temp' to indicate that we have one more distinct character
                if(arr[idx]==0){
                    temp--;
                }
                // Increment the frequency of the character in the current window and move the 'right' pointer to the next character
                arr[idx]+=1; 
                right++;
            }
            // If the number of distinct characters in the current window exceeds K, shrink the window from the left until the number of distinct characters is less than or equal to K
            else{
                // Use a while loop to shrink the window from the left until the number of distinct characters is less than or equal to K
                while(temp<0){
                    char lch = s.charAt(left);
                    int lidx = lch-'a';
                    // Decrement the frequency of the character at the 'left' pointer in the current window
                    arr[lidx]+=-1;
                    // If the frequency of the character at the 'left' pointer becomes 0, increment 'temp' to indicate that we have one less distinct character
                    if(arr[lidx]==0){
                        temp++;
                    }
                    left++;
                }
            }
            // If the number of distinct characters in the current window is equal to K, update 'ans' to store the length of the longest substring found so far
            if(temp == 0){
                ans = Math.max(ans,right-left);
            }
        }
        // If no valid substring was found, return -1; otherwise, return the length of the longest substring found
        return ans;
    }

    public static void main(String[] args) {
        String s = "araaci";
        int k = 2;
        Solution obj = new Solution();
        System.out.println(obj.longestKSubstr(s,k));
    }
}