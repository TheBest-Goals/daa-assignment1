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