## Dynamic Programming

Optimal Problem  
Some choice is given (multiple branches in recursion tree )


Dynamic Programming is a technique in computer programming that helps to efficiently solve a class of problems that have overlapping subproblems and optimal structure property

#### Ways of DP
Memoization (Top Down)
  subproblem is stored

Tabulation (Bottom Up) (Efficient)
  Iteration 

  Initialization
  Meaning
  Filling 

```java

  dp[n+1]
  for(int  i = 2 ; i<=n;i++)
  {
    dp[i] = dp[i-1] + dp[i-2];
  }

  ans = dp[n];
```

#### 7 Important questions
Fibonacci
0-1 Knapsack
Unbounded Knapsack
Longest Common Subsequence
Kadane Algorithm
Catalan Number
DP on Grid 2D Arrays

![img info](./images/06_Dynamic.png)