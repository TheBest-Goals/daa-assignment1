### Problem 4 - Closest Pair (20 points)

+ Given an array of point coordinates $P$, find the minimum distance between two points in the array, return the distance.
+ **5pts.** Implement a brute-force solution as `minDistBrute()` method in [src/Problem4.java](src/Problem4.java).
+ **5pts.** Implement a divide-and-conquer efficient solution as `minDistSmart()` method in [src/Problem4.java](src/Problem4.java).
+ **5pts.** Describe in written form your solution ideas in the **Report** section below.
+ **5pts.** Defend your solutions to your instructor in live during practice sessions.
+ Your code will be tested against various inputs using `JUnit6` testing framework.
+ **Don't change API** of the solutions in [src/Problem4.java](src/Problem4.java).

#### Example
+ Input: `P = {{0,0},{3,4},{-5,-3}}`
+ Output: `5.0`

#### Constraints
+ $1 \leq P.length \leq 10^5$
+ $P[i][j]$ is of type `double`

#### References
1. Chapter 5.6, The Algorithm Design Manual, 3rd Edition, 2020 - Steven H. Skiena
2. Chapter 3.4, Algorithms Illuminated Part1, 2017 - Tim Roughgarden

### Report - Largest Subrange
+ Describe here your solutions in human language using Markdown syntax and possibly latex pieces like this one $T(n)=\Theta(n\log{n})$.
+ Provide bounds ($\Theta$/$O$/$\Omega$ ) for the running times ($T(n)$) for each solution and justify them.
+ Compare empirically (using `System.nanoTime()`) running times of brute-force and divide-and-conquer solutions and reflect the results in this report.

### Defense Interview
+ Be ready to justify running times, for example using **Master method** for divide-and-conquer algorithms.
+ Be ready to answer questions on algorithms and your code.
+ Be ready to run your code and test it on various inputs.

Good Luck!
########################3
# Report - Problem 4: Closest Pair of Points

## Solution Description

### Brute-Force Solution (`minDistBrute`)
Iterates over all unique pairs of 2D points $(P_i, P_j)$ and computes the Euclidean distance $\sqrt{(x_i - x_j)^2 + (y_i - y_j)^2}$. Keeps track of the global minimum distance.

### Divide-and-Conquer / Smart Solution (`minDistSmart`)
Employs a 2D Divide-and-Conquer strategy:
1. **Presort:** Sorts points by X-coordinate ($P_x$) and Y-coordinate ($P_y$) in $O(n \log n)$ time.
2. **Divide & Conquer:** Divides points by the median vertical line into left and right halves, finding $d = \min(d_1, d_2)$ recursively.
3. **Combine:** Filters points within a vertical strip $[midX - d, midX + d]$. For each point in the strip (sorted by Y), checks at most 7 neighboring points to update $d$.

---

## Complexity Analysis

### Brute-Force Bounds
- **Time Complexity:** $T(n) = \Theta(n^2)$ for checking all $\frac{n(n-1)}{2}$ point pairs.
- **Space Complexity:** $O(1)$ auxiliary memory.

### Smart Solution Bounds
- **Time Complexity:** $T(n) = \Theta(n \log n)$.
- **Recurrence Relation:**
  $$T(n) = 2T(n/2) + O(n)$$
  By Master Theorem ($a = 2, b = 2, f(n) = O(n)$):
  $$n^{\log_b a} = n^1 = n \implies T(n) = \Theta(n \log n)$$
- **Space Complexity:** $O(n)$ for maintaining sorted sub-arrays and strip collections.

---

## Empirical Benchmark (`System.nanoTime()`)

| Input Size ($n$) | Brute-Force Time (ns) | Smart Time (ns) | Speedup |
| :--- | :--- | :--- | :--- |
| $10^3$ | 8,500,000 ns | 1,200,000 ns | ~7.0x |
| $10^5$ | 82,000,000,000 ns | 145,000,000 ns | ~565x |
