import java.util.Arrays;
class Solution {
    // Function to check if s2 contains a permutation of s1
    public boolean checkInclusion(String s1, String s2) {
        // Get the lengths of the two strings
        int n = s1.length();
        int m = s2.length();
        // If the length of s1 is greater than the length of s2, return false since s2 cannot contain a permutation of s1
        if(n>m)return false;
        // Create two arrays to keep track of the frequency of each character in s1 and the current window of s2
        int s1_c[] = new int[26];
        int s2_c[] = new int[26];
        // Initialize two pointers, 'l' and 'r', to represent the current window of the substring in s2
        int l =0;
        int r =n;
        // Populate the frequency arrays for s1 and the first window of s2
        for(int i=0;i<n;i++){
            s1_c[s1.charAt(i)-'a']+=1;
            s2_c[s2.charAt(i)-'a']+=1;
        }
        // Use a while loop to slide the window through s2 and check if any window matches the frequency of s1
        while(r<m){
            if(Arrays.equals(s1_c,s2_c))return true;
            s2_c[s2.charAt(r)-'a']+=1;
            s2_c[s2.charAt(l)-'a']-=1;
            r++;
            l++;
        }
        // After sliding through all possible windows, check the last window for a match
        if(Arrays.equals(s1_c,s2_c))return true;
        return false;
    }
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        Solution obj = new Solution();
        System.out.println(obj.checkInclusion(s1,s2));
    }
}