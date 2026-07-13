class Solution {
    public void sortColors(int[] arr) {
         // Set low and mid to start of array and high to end of array
        int low = 0;
        int mid = 0;
        int high=arr.length-1;
        //Iterate till mid is less than equal to high
        while(mid<=high){
            //if mid == 0 means swap the mid and low values and increment both of them
            if(arr[mid]==0){
                swap(arr,mid,low);
                mid++;
                low++;
            }
            //if mid == 1 means value is already in correct position that is mid just increment the mid
            else if(arr[mid]==1){
                mid++;
            }
            // if mid == 2 them swap the high and mid; Only decrement the high
            // because swapped mid elment is not examined yet
            else{
                swap(arr,mid,high);
                high--;
            }
        }
    }
    //Helper function to swap the values
    public static void swap(int arr[],int a,int b){
        int temp=0;
        temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        int arr [] = {1,0,1,0,2,2,2,1,1,0,0};
        obj.sortColors(arr);
        for(int val: arr){
            System.out.print(val+" ");
        }

    }
}