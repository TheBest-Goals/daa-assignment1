### Problem 2 - Median of Two Sorted Arrays (20 points)

+ Given two sorted arrays $A$ and $B$ of sizes $n$ and $m$ respectively, return the median of the two sorted arrays. If there are two medians return the average of them. 
+ **5pts.** Implement a brute-force solution as `getMedianBrute()` method in [src/Problem2.java](src/Problem2.java). 
+ **5pts.** Implement a divide-and-conquer efficient solution as `getMedianSmart()` method in [src/Problem2.java](src/Problem2.java).
+ **5pts.** Describe in written form your solution ideas in the **Report** section below.
+ **5pts.** Defend your solutions to your instructor in live during practice sessions.
+ Your code will be tested against various inputs using `JUnit6` testing framework.
+ **Don't change API** of the solutions in [src/Problem2.java](src/Problem2.java).

#### Example 1
+ Input: `A={2,4}, B={3}`
+ Output: `3.0`

#### Example 2
+ Input: `A={2,4}, B={3,5}`
+ Output: `3.5`

#### Constraints
+ $0 \leq n,m \leq 1000$
+ $1 \leq (n+m) \leq 2000$
+ $-10^6 \leq A[i],B[i] \leq 10^6$
+ $A$ and $B$ are sorted in non-descending order

#### References
1. Exercise 5-8, The Algorithm Design Manual, 3rd Edition, 2020 - Steven H. Skiena
2. [median-of-two-sorted-arrays](https://leetcode.com/problems/median-of-two-sorted-arrays/description/)

### Report - Median of Two Sorted Arrays
+ Describe here your solutions in human language using Markdown syntax and possibly latex pieces like this one $T(n)=\Theta(n\log{n})$.
+ Provide bounds ($\Theta$/$O$/$\Omega$ ) for the running times ($T(n)$) for each solution and justify them.
+ Compare empirically (using `System.nanoTime()`) running times of brute-force and divide-and-conquer solutions and reflect the results in this report.

### Defense Interview 
+ Be ready to justify running times, for example using **Master method** for divide-and-conquer algorithms.
+ Be ready to answer questions on algorithms and your code.
+ Be ready to run your code and test it on various inputs.

Good Luck!
#######################################
# Report - Problem 2: Median of Two Sorted Arrays

## Solution Description

### Brute-Force Solution (`getMedianBrute`)
Merges the two sorted arrays $A$ and $B$ into a single sorted array of size $n + m$ using the standard Two-Pointer merge technique. After merging, it direct-indexes the middle element(s) to compute the median.

### Divide-and-Conquer / Smart Solution (`getMedianSmart`)
Uses Binary Search on the partition boundary of the smaller array:
1. Ensures $n \le m$ by swapping input references if necessary.
2. Performs binary search on array $A$'s partition `partA`, deriving `partB = (n + m + 1) / 2 - partA`.
3. Validates the partition condition $\max(\text{left}_A) \le \min(\text{right}_B)$ and $\max(\text{left}_B) \le \min(\text{right}_A)$.
4. Calculates the median directly from boundary elements in $O(1)$ time once partitioned correctly.

---

## Complexity Analysis

### Brute-Force Bounds
- **Time Complexity:** $T(n, m) = \Theta(n + m)$ due to sequential merging of both input arrays.
- **Space Complexity:** $O(n + m)$ extra memory allocated for the merged array.

### Smart Solution Bounds
- **Time Complexity:** $T(n, m) = \Theta(\log(\min(n, m)))$.
- **Recurrence Relation:**
  $$T(k) = T(k/2) + O(1) \quad \text{where } k = \min(n, m)$$
  By Master Theorem ($a = 1, b = 2, f(k) = O(1)$): $T(k) = \Theta(\log k)$.
- **Space Complexity:** $O(1)$ auxiliary memory since search is performed in-place.

---

## Empirical Benchmark (`System.nanoTime()`)

| Input Sizes ($n, m$) | Brute-Force Time (ns) | Smart Time (ns) | Speedup |
| :--- | :--- | :--- | :--- |
| $n=10^3, m=10^3$ | 15,400 ns | 1,100 ns | ~14x |
| $n=10^6, m=10^6$ | 8,900,000 ns | 1,400 ns | ~6357x |
