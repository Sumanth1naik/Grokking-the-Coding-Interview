import java.util.*;
class twosum {

    /**
     * Checks whether any two numbers in the array add up to the given target.
     * Uses the two-pointer technique after sorting the array.
     *
     * Note: this method sorts the input array in-place (it mutates `arr`).
     */
    boolean twoSum(int arr[], int target) {
        // Sort the array so we can use two pointers (one at start, one at end)
        Arrays.sort(arr); // O(n log n) time, mutates the input array

        int r = arr.length - 1;
        int l = 0;

        // Move pointers towards each other until they cross
        while (l < r) {
            // Current sum of the two pointed elements
            int sum = arr[r] + arr[l];

            // If we found the target sum, return true
            if (sum == target) return true;

            // If current sum is greater than target, decrease sum by moving right pointer left
            else if (sum > target) r--;

            // If current sum is less than target, increase sum by moving left pointer right
            else l++;
        }

        // No pair found that adds up to target
        return false;
    }

    public static void main(String[] args) {
        // Create an instance of the class to call the instance method
        twosum obj = new twosum();
        int arr[] = {-3, 0, 1, -2, 4};
        int target = -2;
        System.out.println(obj.twoSum(arr, target));
    }
}

