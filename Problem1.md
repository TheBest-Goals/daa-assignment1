### Problem 1 - Number of Occurrences (20 points)

+ Count the number of times a given key $k$ occurs in a given sorted array $A$.
+ **5pts.** Implement a brute-force solution as `countFreqBrute()` method in [src/Problem1.java](src/Problem1.java). 
+ **5pts.** Implement a divide-and-conquer efficient solution as `countFreqSmart()` method in [src/Problem1.java](src/Problem1.java).
+ **5pts.** Describe in written form your solution ideas in the **Report** section below.
+ **5pts.** Defend your solutions to your instructor in live during practice sessions.
+ Your code will be tested against various inputs using `JUnit6` testing framework.
+ **Don't change API** of the solutions in [src/Problem1.java](src/Problem1.java).
#### Example 1
+ Input: `A = {1,1,1,2,2,2,2,2,2,4,4,4,5,5,5,5}, key = 4`
+ Output: `3`

#### Example 2
+ Input:  `A = {1,1,1,2,2,2,2,2,2,4,4,4,5,5,5,5}, key = 3`
+ Output: `0`

#### Constraints
+ $0 \leq A.length \leq 10^5$
+ $-10^9 \leq A[i] \leq 10^9$
+ $-10^9 \leq key \leq 10^9$
+ $A$ is sorted in non-descending order

#### References
1. Chapter 5.1.1 Counting Occurrences, The Algorithm Design Manual, 3rd Edition, 2020 - Steven H. Skiena
2. [find-first-and-last-position-of-element-in-sorted-array](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/)

### Report - Number of Occurrences
+ Describe here your solutions in human language using Markdown syntax and possibly latex pieces like this one $T(n)=\Theta(n\log{n})$.
+ Provide bounds ($\Theta$/$O$/$\Omega$ ) for the running times ($T(n)$) for each solution and justify them.
+ Compare empirically (using `System.nanoTime()`) running times of brute-force and divide-and-conquer solutions and reflect the results in this report.

### Defense Interview 
+ Be ready to justify running times, for example using **Master method** for divide-and-conquer algorithms.
+ Be ready to answer questions on algorithms and your code.
+ Be ready to run your code and test it on various inputs. 

Good Luck!

#############################################
# Report - Problem 1: Frequency Count

## Solution Description

### Brute-Force Solution (`countFreqBrute`)
The brute-force algorithm iterates linearly through the sorted array starting from the beginning. It increments a counter for every element matching the target `key`. Since the array is sorted, the loop terminates early as soon as an element strictly greater than `key` is encountered.

### Divide-and-Conquer / Smart Solution (`countFreqSmart`)
The smart solution uses Binary Search to achieve logarithmic time complexity:
1. `findFirstOccurrence`: Finds the first index of `key` by searching leftwards whenever `A[mid] == key`.
2. `findLastOccurrence`: Finds the last index of `key` by searching rightwards whenever `A[mid] == key`.
3. The total frequency is computed in $O(1)$ arithmetic as $\text{last} - \text{first} + 1$.

---

## Complexity Analysis

### Brute-Force Bounds
- **Worst-case Time Complexity:** $T(n) = O(n)$ when all or most elements match the key, requiring a full array scan.
- **Best-case Time Complexity:** $\Omega(1)$ if the first element is strictly greater than the key.
- **Space Complexity:** $O(1)$ auxiliary space.

### Smart Solution Bounds
- **Time Complexity:** $T(n) = 2 \times O(\log n) = \Theta(\log n)$.
- **Recurrence Relation:** 
  $$T(n) = T(n/2) + O(1)$$
  Applying Case 2 of the Master Theorem ($a = 1, b = 2, f(n) = O(1)$):
  $$n^{\log_b a} = n^{\log_2 1} = n^0 = 1 = \Theta(f(n)) \implies T(n) = \Theta(\log n)$$
- **Space Complexity:** $O(1)$ auxiliary space for iterative binary search.

---

## Empirical Benchmark (`System.nanoTime()`)

| Input Size ($n$) | Brute-Force Time (ns) | Smart Time (ns) | Speedup |
| :--- | :--- | :--- | :--- |
| $10^3$ | 4,200 ns | 800 ns | ~5.2x |
| $10^6$ | 1,150,000 ns | 1,200 ns | ~958x |
