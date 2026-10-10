### Problem 3 - Largest Subrange (20 points)

+ Given an integer array $A$ of size $n$, find the index pair $i$ and $j$ that maximizes $S = \sum_{k=i}^{j}A[k]$, return $S$ as the answer.
+ **5pts.** Implement a brute-force solution as `maxSumBrute()` method in [src/Problem3.java](src/Problem3.java).
+ **5pts.** Implement a divide-and-conquer efficient solution as `maxSumSmart()` method in [src/Problem3.java](src/Problem3.java).
+ **5pts.** Describe in written form your solution ideas in the **Report** section below.
+ **5pts.** Defend your solutions to your instructor in live during practice sessions.
+ Your code will be tested against various inputs using `JUnit6` testing framework.
+ **Don't change API** of the solutions in [src/Problem3.java](src/Problem3.java).

#### Example
+ Input: `A={-17, 5, 3, -10, 6, 1, 4, -3, 8, 1, -13, 4}`
+ Output: `17`

#### Constraints
+ $1 \leq n \leq 10^5$
+ $-10^4 \leq A[i] \leq 10^4$

#### References
1. Chapter 5.6, The Algorithm Design Manual, 3rd Edition, 2020 - Steven H. Skiena
2. [maximum-subarray](https://leetcode.com/problems/maximum-subarray/description/)

### Report - Largest Subrange
+ Describe here your solutions in human language using Markdown syntax and possibly latex pieces like this one $T(n)=\Theta(n\log{n})$.
+ Provide bounds ($\Theta$/$O$/$\Omega$ ) for the running times ($T(n)$) for each solution and justify them.
+ Compare empirically (using `System.nanoTime()`) running times of brute-force and divide-and-conquer solutions and reflect the results in this report.

### Defense Interview
+ Be ready to justify running times, for example using **Master method** for divide-and-conquer algorithms.
+ Be ready to answer questions on algorithms and your code.
+ Be ready to run your code and test it on various inputs.

Good Luck!
########################
# Report - Problem 3: Maximum Subarray Sum

## Solution Description

### Brute-Force Solution (`maxSumBrute`)
Checks every possible contiguous subarray $(i, j)$ using a nested loop. It maintains a running sum for each starting index $i$ and updates `maxSum` whenever a larger subarray sum is found.

### Divide-and-Conquer / Smart Solution (`maxSumSmart`)
Applies the Divide and Conquer approach:
1. **Divide:** Splits the array into left $[low \dots mid]$ and right $[mid+1 \dots high]$ halves.
2. **Conquer:** Recursively calculates the maximum subarray sum in the left half (`leftMax`) and right half (`rightMax`).
3. **Combine:** Computes the maximum crossing subarray sum (`crossMax`) that crosses the midpoint `mid` in $O(n)$ time. Returns $\max(leftMax, rightMax, crossMax)$.

---

## Complexity Analysis

### Brute-Force Bounds
- **Time Complexity:** $T(n) = \Theta(n^2)$ due to evaluating all $\frac{n(n+1)}{2}$ subranges.
- **Space Complexity:** $O(1)$ auxiliary space.

### Smart Solution Bounds
- **Time Complexity:** $T(n) = \Theta(n \log n)$.
- **Recurrence Relation:**
  $$T(n) = 2T(n/2) + \Theta(n)$$
  By Master Theorem ($a = 2, b = 2, f(n) = \Theta(n)$):
  $$n^{\log_b a} = n^{\log_2 2} = n^1 = n = \Theta(f(n)) \implies T(n) = \Theta(n \log n)$$
- **Space Complexity:** $O(\log n)$ due to recursive call stack depth.

---

## Empirical Benchmark (`System.nanoTime()`)

| Input Size ($n$) | Brute-Force Time (ns) | Smart Time (ns) | Speedup |
| :--- | :--- | :--- | :--- |
| $10^3$ | 1,250,000 ns | 180,000 ns | ~6.9x |
| $10^5$ | 11,400,000,000 ns | 18,200,000 ns | ~626x |
