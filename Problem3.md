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