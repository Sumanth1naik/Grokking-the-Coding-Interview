import java.util.*;
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        //sort the array
        Arrays.sort(nums);
        //Set ans and difference to max values
        int ans = Integer.MAX_VALUE;
        int diff = Integer.MAX_VALUE;
        //Iterate through the array untill last 2 indexes because last two index are used by left and right pointer in last iteration
        for(int i=0;i<nums.length-2;i++){
            //set left pointer to next to the start pointer
            int left = i+1;
            //set right pointer to end of the array
            int right = nums.length-1;
            //iterate through the array two find possible combination of triplet for start pointer(nums[i]) 
            while(left<right){
                //calculate the sum
            int tempAns = nums[i]+nums[left]+nums[right];
            // if sum and target are equal no need to find other matches because you found the optimal triplet
            if(tempAns == target) return tempAns;
            //Calculate the absolute difference between target and tempAns
            int absDiff = Math.abs(target-tempAns);
            //Check can we include the current triplet group based on the last difference value we got
            if(absDiff<=diff){
                //if newly calculated difference and old difference are matching choose the one with the smaller sum
                //ex: if target = 3 then triplet [-1,1,2] = 2 and [-1,2,3] = 4
                //  in this case both triplets absolute value to target(3) will be 1 so 
                // you have to choose the triplet [-1,1,2] because its sum is smaller
                if(absDiff == diff)
                {
                    ans = Math.min(ans,tempAns);
                }
                //else update the latest ans
                else{
                    ans = tempAns;
                }
                //Update the differnce value to minimum differnce
                diff = Math.min(diff,absDiff);
            }
            // if the calculated sum of triplet is more than target, Shrink the array from right
            if(tempAns >= target){
                right--;
            }
            //if sum is smaller move the left pointer towards right
            else{
                left++;
            }
            }
        }
        //Finally return the optimal answer
        return ans;
    }
    public static void main(String[] args) {
        Solution obj = new Solution();
        int nums [] = {-1,2,1,-4};
        int target = 1;
        System.out.println(obj.threeSumClosest(nums, target));
    }
}