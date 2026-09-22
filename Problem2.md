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