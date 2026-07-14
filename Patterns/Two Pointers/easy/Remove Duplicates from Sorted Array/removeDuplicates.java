class removeDuplicates {
    /**
     * Removes duplicates from a sorted array in-place such that each unique element
     * appears only once. The relative order of the elements is kept the same.
     * * @param nums The input sorted integer array.
     * @return The number of unique elements in the array.
     */
    public int removeDuplicatesFromArray(int[] nums) {
        // If the array is empty, there are no unique elements
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 'left' is the slow pointer that tracks the index of the last unique element found
        int left = 0;
        
        // 'right' is the fast pointer used to scan through the array
        int right = 0;
        int n = nums.length;
        
        // Iterate through the array with the fast pointer
        while (right < n) {
            // When we find a new unique element (different from the last unique one)
            if (nums[left] != nums[right]) {
                // Move it to the position right after the last unique element
                nums[left + 1] = nums[right];
                // Advance the slow pointer to this new unique element's position
                left++;
            }
            // Always advance the fast pointer to check the next element
            right++;
        }
        
        // 'left' is the index of the last unique element. 
        // Since arrays are 0-indexed, the total count of unique elements is left + 1.
        return left + 1;
    }
    public static void main(String[] args) {
        removeDuplicates obj = new removeDuplicates();
        int nums[] = {1,1,2,2,3,4,4,4,5,5,9,9,9};
        System.out.println(obj.removeDuplicatesFromArray(nums));
    }
}