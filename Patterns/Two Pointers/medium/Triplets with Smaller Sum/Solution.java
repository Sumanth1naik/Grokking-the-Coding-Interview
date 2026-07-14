import java.util.Arrays;
class Solution {
    int countTriplets(int sum, int arr[]) {
        // Sort the array to unable the two pointer approach
        Arrays.sort(arr);
        int ans = 0;
        int tempSum = 0;
        int n = arr.length;
        // iterate through the array till n-2
        for(int i=0;i<n-2;i++){
            //set left pointer ahead of start pointer
            int left = i+1;
            //Set right pointer to the end of array
            int right = n-1;
            //iterate through the array 
            while(left<right){
                //calculate the sum for the choosen triplet
                tempSum = arr[i]+arr[left]+arr[right];
                // if temp sum is less than the target means every value between 
                // left and right pointer will be less than the target 
                //Update the ans and shrink the array from left
                if(tempSum < sum){
                   ans +=right-left;
                   left++;
            }
            else{
                // if temp sum is greater shrink the array from right 
                right--;
            }
        }
        
    }
    return ans;
}
public static void main(String[] args) {
    Solution obj = new Solution();
    int target = 5;
    int arr[] = {-1,4,2,1,3};
    System.out.println(obj.countTriplets(target, arr));
}
}