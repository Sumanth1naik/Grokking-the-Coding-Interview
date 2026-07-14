class Solution {
    public boolean backspaceCompare(String s, String t) {
        //Initialise the pointer to iterate through the character in s string
        int sn = s.length();
        int sr = sn-1;
        //Initialise the pointer to iterate through the character in t string
        int rn = t.length();
        int rr = rn-1;
        //Initialise the counter for the counting the backspaces in the s string
        int counts = 0;
        //Initialise the counter for the counting the backspaces in the t string
        int countt = 0;
        //iterate till both the string reaches its limit
        while(sr>=0 || rr >=0){
            //iterate through the s string and update the sr counter to have a remaining string after removing the backspace character
            while(sr>=0){
                //if the current char is # means update the backspace counter and decrement the sr pointer
            if(s.charAt(sr)=='#'){
                    
                    counts++;
                    sr--;
                    
                }
                //once you evalute the # pointer you have to remove the actula character that going to removed by the backspace right
                //so if counter is greater than 0 means you have to skip the currrent character because it will be deleted by backspace
                //so decrement the sr counter and decrement the backspace counter
                else if(counts>0){
                    counts-=1;
                    sr-=1;
                }
                //if this is not the case means you can break out of the loop
                else break;
            }
            //iterate through the t string and update the sr counter to have a remaining string after removing the backspace character
            while(rr>=0){
                //if the current char is # means update the backspace counter and decrement the rr pointer
                if(t.charAt(rr) == '#'){
                    countt++;
                    rr--;
                    
                }
                //once you evalute the # pointer you have to remove the actula character that going to removed by the backspace right
                //so if counter is greater than 0 means you have to skip the currrent character because it will be deleted by backspace
                //so decrement the rr counter and decrement the backspace counter
                else if(countt>0){
                    countt--;
                    rr--;
                }
                //if this is not the case means you can break out of the loop
                else break;
            }
            //Edge case: After you evaluate the both the string and verify the remaining string is matching or not
            if(sr>=0 && rr>=0 && s.charAt(sr)!=t.charAt(rr))return false;
            
            //If either of the string length is not matching means strings are not matching
            else if((rr>=0)!= (sr>=0)){
                return false;
            }
            rr--;
            sr--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        String s = "ab##";
        String t = "a#b#";
        System.out.println(obj.backspaceCompare(s, t));
    }
}