public class Problem3 {
    public int maxSumBrute(int [] A){
        // your code here
        if (A == null || A.length == 0) return 0;

        int maxSum = Integer.MIN_VALUE;
        int n = A.length;

        for (int i = 0; i < n; i++) {
            int currentSum = 0;
            for (int j = i; j < n; j++) {
                currentSum += A[j];
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                }
            }
        }
        return maxSum;
    }

    public int maxSumSmart(int [] A){
        // your code here
         if (A == null || A.length == 0) {
            return 0;
        }
        return maxSumRec(A, 0, A.length - 1);
    }

    private int maxSumRec(int[] A, int low, int high) {

        if (low == high) {
            return A[low];
        }

        int mid = low + (high - low) / 2;

        int leftMax = maxSumRec(A, low, mid);
        int rightMax = maxSumRec(A, mid + 1, high);
        int crossMax = maxCrossingSum(A, low, mid, high);

        return Math.max(Math.max(leftMax, rightMax), crossMax);
    }

    private int maxCrossingSum(int[] A, int low, int mid, int high) {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= low; i--) {
            sum += A[i];
            if (sum > leftSum) {
                leftSum = sum;
            }
        }

        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        for (int i = mid + 1; i <= high; i++) {
            sum += A[i];
            if (sum > rightSum) {
                rightSum = sum;
            }
        }


        return leftSum + rightSum;
    }

    static void main() {
        // you can test your code here
        Problem3 p3 = new Problem3();

        int[] A = {-17, 5, 3, -10, 6, 1, 4, -3, 8, 1, -13, 4};

        System.out.println("Problem3 Brute: " + p3.maxSumBrute(A));
        System.out.println("Problem3 Smart: " + p3.maxSumSmart(A));
    }

}
