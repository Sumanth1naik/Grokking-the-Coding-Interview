class Solution{

    public static int sumCalc(int n){
        int sum = 0;
        // Compute the sum of squares of digits.
        while(n!=0){
            int val = n%10;
            sum += val*val;
            n = n/10;
        }
        return sum;
    }

    public static boolean reachesOne(int n){
        int slow = n;
        int fast = n;
        do{
            // Detect a cycle using Floyd's cycle-finding
        // algorithm.
            slow = sumCalc(slow);
            fast = sumCalc(sumCalc(fast));
        }
        while(slow!=fast);
        // The sequence reaches 1 iff the detected cycle
        // contains 1.
            return slow == 1;
        }

        public static void main(String[] args) {
            int n = 81;
            System.out.println(reachesOne(n));
        }
}