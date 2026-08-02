class Solution {
    public String minWindow(String s, String t) {
        // Edge cases
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }

        // Use a 128-size array to easily handle both uppercase and lowercase ASCII letters
        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }

        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        int diff = t.length(); // Represents how many characters we still need to match

        // Expand the window to the right
        while (right < s.length()) {
            char cRight = s.charAt(right);
            
            // If the character is needed (part of t), decrement our 'diff' requirement
            if (map[cRight] > 0) {
                diff--;
            }
            // Decrement the frequency in our map (unneeded characters will become negative)
            map[cRight]--;
            right++;

            // When diff == 0, the current window contains all characters of t
            while (diff == 0) {
                // Update the minimum window if the current one is smaller
                if (right - left < minLen) {
                    minLen = right - left;
                    minStart = left;
                }

                char cLeft = s.charAt(left);
                
                // Put the left character back into the map as we shrink the window
                map[cLeft]++;
                
                // If the frequency becomes > 0, it means we removed a necessary character
                if (map[cLeft] > 0) {
                    diff++;
                }
                
                // Shrink the window from the left
                left++;
            }
        }

        // If minLen was never updated, no valid window was found
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
    public static void main(String[] args) {
        Solution obj = new Solution();
        String s = "aabdec";
        String t = "abc";
        System.out.println(obj.minWindow(s, t));
    }
}