import java.math.BigInteger;

public class Problem5 {
    public String multBrute(String A, String B){
        // your code here
        if (A == null || B == null || A.isEmpty() || B.isEmpty()) {
            return "0";
        }

        A = removeLeadingZeros(A);
        B = removeLeadingZeros(B);

        if (A.equals("0") || B.equals("0")) {
            return "0";
        }

        int n = A.length();
        int m = B.length();
        int[] result = new int[n + m];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int mul = (A.charAt(i) - '0') * (B.charAt(j) - '0');
                int sum = mul + result[i + j + 1];

                result[i + j + 1] = sum % 10;
                result[i + j] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int digit : result) {
            if (!(sb.length() == 0 && digit == 0)) {
                sb.append(digit);
            }
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

    public String multSmart(String A, String B){
        // your code here
        if (A == null || B == null || A.isEmpty() || B.isEmpty()) {
            return "0";
        }

        A = removeLeadingZeros(A);
        B = removeLeadingZeros(B);

        if (A.equals("0") || B.equals("0")) {
            return "0";
        }

        int n = Math.max(A.length(), B.length());

        if (n <= 32) {
            return multBrute(A, B);
        }

        while (A.length() < n) A = "0" + A;
        while (B.length() < n) B = "0" + B;

        int m = n / 2;

        String a1 = A.substring(0, n - m);
        String a0 = A.substring(n - m);
        String b1 = B.substring(0, n - m);
        String b0 = B.substring(n - m);

        String z2 = multSmart(a1, b1);
        String z0 = multSmart(a0, b0);
        String z1 = multSmart(addStrings(a1, a0), addStrings(b1, b0));

        String mid = subtractStrings(subtractStrings(z1, z2), z0);

        String res = addStrings(addStrings(shiftLeft(z2, 2 * m), shiftLeft(mid, m)), z0);

        return removeLeadingZeros(res);
    }

    private String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) sum += num1.charAt(i--) - '0';
            if (j >= 0) sum += num2.charAt(j--) - '0';
            sb.append(sum % 10);
            carry = sum / 10;
        }

        return removeLeadingZeros(sb.reverse().toString());
    }

    private String subtractStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1, borrow = 0;

        while (i >= 0) {
            int sub = (num1.charAt(i--) - '0') - borrow;
            if (j >= 0) sub -= (num2.charAt(j--) - '0');

            if (sub < 0) {
                sub += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }
            sb.append(sub);
        }

        return removeLeadingZeros(sb.reverse().toString());
    }

    private String shiftLeft(String num, int zeros) {
        if (num.equals("0") || zeros == 0) return num;
        StringBuilder sb = new StringBuilder(num);
        for (int i = 0; i < zeros; i++) {
            sb.append('0');
        }
        return sb.toString();
    }

    private String removeLeadingZeros(String s) {
        int firstNonZero = 0;
        while (firstNonZero < s.length() - 1 && s.charAt(firstNonZero) == '0') {
            firstNonZero++;
        }
        return s.substring(firstNonZero);
    }

    static void main() {
        // you can test your code here
        BigInteger a = new BigInteger("12345678987654321");
        BigInteger b = new BigInteger("98765432123456789");
        System.out.println("BigInteger: " + a.multiply(b));

        Problem5 p5 = new Problem5();
        String strA = "12345678987654321";
        String strB = "98765432123456789";
        System.out.println("Brute:      " + p5.multBrute(strA, strB));
        System.out.println("Smart:      " + p5.multSmart(strA, strB));
    }
}
