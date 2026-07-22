import java.util.ArrayList;

class Solution{
    public ArrayList<Integer> findAnagram(String s, String p){
        ArrayList <Integer> ans = new ArrayList<>();
        int st = 0;
        int end = 0;
        int len = p.length();
        int arr [] = new int[26];

        //Update the arr with frequency of the p characters
        for(int i=0;i<len;i++){
            arr[p.charAt(i)-'a']+=1;
        }
        int diff = len;
        //Now evaluate the first window in s wheather it is an anagram or not
        for(end =0;end<len;end++){
            arr[s.charAt(end)-'a']+=-1;
            if(arr[s.charAt(end)-'a']>=0){
                diff--;
            }
        }
        //if diff is 0 then it means the first window is an anagram of p so we can add the starting index to the ans
        if(diff == 0){
            ans.add(0);
        }

        //Now we have the fixed window so now we can move the window
        //end will be always ahead of the start so we will move the start and end together and check for anagrams
        while(end<s.length()){
            //first we will check weather the  leaving character is in the p or not if it is then we will increase the diff by 1 and also update the arr for that character
            if(arr[s.charAt(st)-'a']>=0){
                diff++;
            }
            // now we will update the arr for the leaving character and also move the start pointer ahead
            arr[s.charAt(st)-'a']+=1;
            st++;
            
            //Now we will add the next character to the window and check if it is in the p or not if it is then we will decrease the diff by 1 and also update the arr for that character
            arr[s.charAt(end)-'a']+=-1;
            //if the added character is in the p then we will decrease the diff by 1
            if(arr[s.charAt(end)-'a']>=0){
                diff--;
            }
            end++;
            //if diff is 0 then it means the current window is an anagram of p so we can add the starting index to the ans
            if(diff == 0){
                ans.add(st);
            }


        }
        return ans;
    }
  public static void main(String[] args) {
    Solution obj = new Solution();
    String s = "cbadecba";
    String p = "abc";
    ArrayList<Integer> ans = obj.findAnagram(s, p);
    for(int val:ans){
        System.err.println(val);
    }
  }  
}