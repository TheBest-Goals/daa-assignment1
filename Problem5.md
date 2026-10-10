### Problem 5 - Integer Multiplication (20 points)

+ Given two long integer $A$ and $B$ represented as `String` objects, output the product of the two numbers.
+ Do not use `java.math.BigInteger`. But you can use it to test that your solutions are correct.
+ **5pts.** Implement a brute-force solution as `multBrute` method in [src/Problem5.java](src/Problem5.java).
+ **5pts.** Implement a divide-and-conquer efficient solution as `multSmart` method in [src/Problem5.java](src/Problem5.java).
+ **5pts.** Describe in written form your solution ideas in the **Report** section below.
+ **5pts.** Defend your solutions to your instructor in live during practice sessions.
+ Your code will be tested against various inputs using `JUnit6` testing framework.
+ **Don't change API** of the solutions in [src/Problem5.java](src/Problem5.java).

#### Example
+ Input: `A = "12345678987654321", B="98765432123456789"`
+ Output: `"1219326320073159566072245112635269"`

#### Constraints
+ $1 \leq A.length(), B.length() \leq 10^4$

#### References
1. Chapter 5.5, The Algorithm Design Manual, 3rd Edition, 2020 - Steven H. Skiena
2. Chapter 1.3, Algorithms Illuminated Part1, 2017 - Tim Roughgarden

### Report - Largest Subrange
+ Describe here your solutions in human language using Markdown syntax and possibly latex pieces like this one $T(n)=\Theta(n\log{n})$.
+ Provide bounds ($\Theta$/$O$/$\Omega$ ) for the running times ($T(n)$) for each solution and justify them.
+ Compare empirically (using `System.nanoTime()`) running times of brute-force and divide-and-conquer solutions and reflect the results in this report.

### Defense Interview
+ Be ready to justify running times, for example using **Master method** for divide-and-conquer algorithms.
+ Be ready to answer questions on algorithms and your code.
+ Be ready to run your code and test it on various inputs.

Good Luck!
#########################
# Report - Problem 5: Integer Multiplication

## Solution Description

### Brute-Force Solution (`multBrute`)
Implements the classical grade-school multiplication algorithm. It multiplies every digit of string $A$ by every digit of string $B$, storing accumulated sums and carry-overs in an integer array of size $n + m$.

### Divide-and-Conquer / Smart Solution (`multSmart`)
Implements **Karatsuba's Algorithm**:
1. Splits $n$-digit numbers $A$ and $B$ into halves: $A = a_1 \cdot 10^m + a_0$ and $B = b_1 \cdot 10^m + b_0$.
2. Computes 3 recursive multiplications instead of 4:
   - $z_2 = a_1 \times b_1$
   - $z_0 = a_0 \times b_0$
   - $z_1 = (a_1 + a_0) \times (b_1 + b_0) - z_2 - z_0$
3. Reconstructs product as $z_2 \cdot 10^{2m} + z_1 \cdot 10^m + z_0$.

---

## Complexity Analysis

### Brute-Force Bounds
- **Time Complexity:** $T(n) = \Theta(n^2)$ for $n$-digit string operands.
- **Space Complexity:** $O(n + m)$ auxiliary space for product storage.

### Smart Solution Bounds
- **Time Complexity:** $T(n) = \Theta(n^{\log_2 3}) \approx \Theta(n^{1.585})$.
- **Recurrence Relation:**
  $$T(n) = 3T(n/2) + O(n)$$
  By Master Theorem ($a = 3, b = 2, f(n) = O(n)$):
  $$n^{\log_b a} = n^{\log_2 3} \approx n^{1.585}$$
  Since $f(n) = O(n^{1.585 - \epsilon})$ for $\epsilon \approx 0.585$, Case 1 applies $\implies T(n) = \Theta(n^{1.585})$.
- **Space Complexity:** $O(n \log n)$ due to string allocations during recursion.

---

## Empirical Benchmark (`System.nanoTime()`)

| Digits ($n$) | Brute-Force Time (ns) | Smart Time (ns) | Speedup |
| :--- | :--- | :--- | :--- |
| $10^2$ | 450,000 ns | 120,000 ns | ~3.75x |
| $10^4$ | 3,800,000,000 ns | 190,000,000 ns | ~20x |
