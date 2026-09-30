public class Problem2 {
    public double getMedianBrute(int[]A, int [] B){
       // your code here
       int n = (A != null) ? A.length : 0;
        int m = (B != null) ? B.length : 0;
        int total = n + m;

        if (total == 0) {
            return 0.0;
        }

        int[] merged = new int[total];
        
        int i = 0, j = 0, k = 0;
        while (i < n && j < m) {
            if (A[i] <= B[j]) {
                merged[k++] = A[i++];
            } else {
                merged[k++] = B[j++];
            }
        }
        while (i < n) merged[k++] = A[i++];
        while (j < m) merged[k++] = B[j++];
        
        if (total % 2 == 1) {
            return merged[total / 2];
        } else {
            return (merged[total / 2 - 1] + merged[total / 2]) / 2.0;
        }
    }
    
    public double getMedianSmart(int[]A, int [] B){
        // your code here
        int n = (A != null) ? A.length : 0;
        int m = (B != null) ? B.length : 0;
        
        if (n > m) {
            return getMedianSmart(B, A);
        }

        int low = 0;
        int high = n;

        while (low <= high) {
            int partA = low + (high - low) / 2;
            int partB = (n + m + 1) / 2 - partA;

            int maxLeftA  = (partA == 0) ? Integer.MIN_VALUE : A[partA - 1];
            int minRightA = (partA == n) ? Integer.MAX_VALUE : A[partA];

            int maxLeftB  = (partB == 0) ? Integer.MIN_VALUE : B[partB - 1];
            int minRightB = (partB == m) ? Integer.MAX_VALUE : B[partB];

            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                if ((n + m) % 2 == 1) {
                    return Math.max(maxLeftA, maxLeftB);
                } else {
                    return (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2.0;
                }
            } else if (maxLeftA > minRightB) {
                high = partA - 1;
            } else {
                low = partA + 1;
            }
        }

        return 0.0;
    }
    

    public static void main() {
        // you can test your code here.
        Problem2 p = new Problem2();
        System.out.println(p.getMedianBrute(new int[]{1, 2, 3}, new int[]{3, 4, 5}));
        System.out.println(p.getMedianSmart(new int[]{1, 2, 3}, new int[]{3, 4, 5}));
}
}
