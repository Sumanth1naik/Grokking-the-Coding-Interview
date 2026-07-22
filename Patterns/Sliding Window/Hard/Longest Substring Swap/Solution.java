import java.util.HashMap;
class Solution {
    // Function to find the length of the longest substring with the same letters after replacement
    public int characterReplacement(String s, int k) {
        // Initialize two pointers, 'l' and 'r', to represent the current window of the substring
       int l =0;
       int r =0;
       // Initialize 'freq' to keep track of the frequency of the most common character in the current window and 'ans' to store the length of the longest substring found
       int freq = 0;
       int ans =0;
       int n = s.length();
       // Create a HashMap to keep track of the frequency of each character in the current window
       HashMap<Character,Integer> hp = new HashMap<>();
// Use a for loop to slide the window through the string
       for(r=0;r<n;r++){
        // Add the current character to the HashMap and increment its frequency
            hp.put(s.charAt(r),hp.getOrDefault(s.charAt(r),0)+1);
// Update 'freq' to keep track of the frequency of the most common character in the current window
            freq = Math.max(freq,hp.get(s.charAt(r)));
// If the number of characters that need to be replaced to make all characters in the current window the same exceeds 'k', shrink the window from the left until the number of characters that need to be replaced is less than or equal to 'k'
            if(r-l+1-freq>k){
                hp.put(s.charAt(l),hp.getOrDefault(s.charAt(l),0)-1);
                l++;
            }
// If the number of characters that need to be replaced to make all characters in the current window the same is less than or equal to 'k', update 'ans' to store the length of the longest substring found so far
            ans = Math.max(ans,r-l+1);
       }
       return ans;
}
public static void main(String[] args) {
    String s = "aabccbb";
    int k = 2;
    Solution obj = new Solution();
    System.out.println(obj.characterReplacement(s,k));
}
}