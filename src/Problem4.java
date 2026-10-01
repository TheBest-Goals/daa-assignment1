import java.util.*;
public class Problem4 {
    public double minDistBrute(double [][] p){
        // your code here
         if (p == null || p.length < 2) {
            return 0.0;
        }

        double minDist = Double.MAX_VALUE;
        int n = p.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double d = dist(p[i], p[j]);
                if (d < minDist) {
                    minDist = d;
                }
            }
        }

        return minDist;
    }

    public double minDistSmart(double [][] p){
        // your code here
          if (p == null || p.length < 2) {
            return 0.0;
        }

        double[][] Px = p.clone();
        Arrays.sort(Px, (a, b) -> Double.compare(a[0], b[0]));

        double[][] Py = p.clone();
        Arrays.sort(Py, (a, b) -> Double.compare(a[1], b[1]));

        return closestPairRec(Px, Py);
    }

        private double closestPairRec(double[][] Px, double[][] Py) {
        int n = Px.length;

        if (n <= 3) {
            return minDistBrute(Px);
        }

        int mid = n / 2;
        double[] midPoint = Px[mid];

        double[][] PxL = Arrays.copyOfRange(Px, 0, mid);
        double[][] PxR = Arrays.copyOfRange(Px, mid, n);

        Set<double[]> leftSet = new HashSet<>(Arrays.asList(PxL));
        double[][] PyL = new double[PxL.length][2];
        double[][] PyR = new double[PxR.length][2];
        int l = 0, r = 0;

        for (int i = 0; i < n; i++) {
            if (leftSet.contains(Py[i]) && l < PxL.length) {
                PyL[l++] = Py[i];
            } else {
                PyR[r++] = Py[i];
            }
        }

        double d1 = closestPairRec(PxL, PyL);
        double d2 = closestPairRec(PxR, PyR);
        double d = Math.min(d1, d2);

        List<double[]> strip = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (Math.abs(Py[i][0] - midPoint[0]) < d) {
                strip.add(Py[i]);
            }
        }

        int stripSize = strip.size();
        for (int i = 0; i < stripSize; i++) {
            for (int j = i + 1; j < stripSize && (strip.get(j)[1] - strip.get(i)[1]) < d; j++) {
                double distance = dist(strip.get(i), strip.get(j));
                if (distance < d) {
                    d = distance;
                }
            }
        }

        return d;
    }

    private double dist(double[] p1, double[] p2) {
        double dx = p1[0] - p2[0];
        double dy = p1[1] - p2[1];
        return Math.sqrt(dx * dx + dy * dy);
    }

    static void main() {
        // you can test your code here.
        var solver = new Problem4();
        System.out.println(solver.minDistBrute(new double[][]{{0, 0}, {3, 4}, {5, 3}}));
        System.out.println(solver.minDistSmart(new double[][]{{0, 0}, {3, 4}, {5, 3}}));
    }
}
