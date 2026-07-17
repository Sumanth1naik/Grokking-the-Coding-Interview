class Solution {
    public boolean circularArrayLoop(int[] nums) {
        // Iterate through each element of the array to find a cycle
        for (int i = 0; i < nums.length; i++) {
            // If the current element is 0, it means it has been visited or marked as a dead end, so we skip it
            if (nums[i] == 0)
                continue;
            // Initialize two pointers, fast and slow, both starting at the current index i
            int fast = i;
            int slow = i;
            // Determine the direction of movement based on the sign of nums[i]
            boolean isForward = nums[i] > 0;
            // Use a while loop to move the fast and slow pointers until they meet or one of them reaches a dead end
            while (true) {
                // Move the slow pointer one step forward
                slow = NextIndexFinder(nums, slow, isForward);
                // if the slow pointer reaches a dead end, break the loop
                if (slow == -1)
                    break;
                // Move the fast pointer two steps forward
                fast = NextIndexFinder(nums, fast, isForward);
                if (fast != -1) {
                    fast = NextIndexFinder(nums, fast, isForward);
                }
                // if the fast pointer reaches a dead end, break the loop
                if (fast == -1)
                    break;
                //  Check if the fast and slow pointers meet, indicating a cycle
                if (fast == slow)
                    return true;
            }
            // Optimization: If the cycle starting at 'i' failed,
            // all nodes on this path will also fail. Mark them as 0 to save time.
            int curr = i;
            while (nums[curr] != 0 && (nums[curr] > 0) == isForward) {
                int next = nextRawIndex(nums, curr);
                nums[curr] = 0; // Mark as visited/dead end
                curr = next;
            }
        }
        return false;
    }
/* Helper function to find the next index */
    public int NextIndexFinder(int nums[], int index, boolean isforward) {
        // Check if the current direction is the same as the direction of nums[index]
        if (isforward != nums[index] > 0) {
            return -1;
        }
        // Calculate the next index using the nextRawIndex function
        int nextIndex = nextRawIndex(nums, index);
        //  Check if the next index is the same as the current index, which would indicate a single-element loop
        if (nextIndex == index)
            return -1;
        return nextIndex;
    }
/* Helper function to calculate the next index in the circular array */
    public int nextRawIndex(int nums[], int index) {
        // Calculate the next index in the circular array using modulo operation
        int val = (index + nums[index]) % nums.length;
        // If the calculated index is negative, adjust it to wrap around the array
        if (val < 0) {
            val = nums.length + val;
        }
        return val;
    }

    public static void main(String[] args) {
        int nums[] = { -1, -2, -3, -4, -5, 6 };
        Solution obj = new Solution();
        System.out.println(obj.circularArrayLoop(nums));

    }
}