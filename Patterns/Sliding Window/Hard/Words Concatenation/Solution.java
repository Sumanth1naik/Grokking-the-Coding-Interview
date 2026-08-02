import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] word) {
        // Step 1: Calculate basic dimensions
        int wordLen = word[0].length();
        int wordcount = word.length;
        int totalLen = wordLen * wordcount;
        int n = s.length();
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        // Edge case: If the main string is smaller than the required total length, return empty
        if (s.length() < totalLen) return ans;
        
        // Step 2: Build a frequency map of all the target words we need to match
        HashMap<String, Integer> wordMap = new HashMap<>();
        for (int i = 0; i < wordcount; i++) {
            wordMap.put(word[i], wordMap.getOrDefault(word[i], 0) + 1);
        }
        
        // Step 3: Iterate through 'wordLen' offsets to cover all possible alignments
        for (int i = 0; i < wordLen; i++) {
            int start = i; // Left boundary of our sliding window
            int end = i;   // Right boundary of our sliding window
            int count = 0; // Tracks how many valid target words are currently in our window
            
            // Map to track the frequencies of words inside our current sliding window
            HashMap<String, Integer> windMap = new HashMap<>();
            
            // Step 4: Slide the window across the string, jumping by 'wordLen' chunks
            while (end + wordLen <= n) {
                // Extract the next word-sized chunk from the string
                String val = s.substring(end, end + wordLen);
                end += wordLen; // Advance the right pointer
                
                // Case A: The extracted word is a part of our target 'wordMap'
                if (wordMap.containsKey(val)) {
                    // Add it to our current window's map and increment the matched word count
                    windMap.put(val, windMap.getOrDefault(val, 0) + 1);
                    count++;
                    
                    // If we have more occurrences of 'val' than required, shrink the window from the left
                    while(windMap.get(val) > wordMap.get(val)) {
                        String leftWord = s.substring(start, start + wordLen);
                        count--; // We are removing a word, so decrease the matched count
                        windMap.put(leftWord, windMap.get(leftWord) - 1);
                        start += wordLen; // Advance the left pointer to shrink the window
                    }

                    // If we have successfully matched the exact number of required words, save the start index
                    if (count == wordcount) {
                        ans.add(start);
                    }
                    
                } 
                // Case B: The extracted word is NOT in our target 'wordMap'
                else {
                    // The sequence is broken. Reset the window map, count, and jump the start pointer
                    windMap.clear();
                    count = 0;
                    start = end;
                }
            }
        }
        
        return ans;
    }
  public static void main(String[] args) {
  Solution ob = new Solution();
  String s = "barfoothefoobarman";
  String words [] = {"foo","bar"};
  ob.findSubstring(s,words);
  }
}