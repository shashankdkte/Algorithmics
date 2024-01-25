/**
 * Count ways to reach nth stair. The person can climb either
 * 1 stair or 2 stairs at a time
 * 
 * ways(n) = ways(n-1) + ways(n - 2)
 */
//O(2^n)

 import java.util.*;

class Main {

  public static int countWays(int n) {
    if (n == 0) {
      return 1;
    }
    if (n < 0) {
      return 0;
    }
    return countWays(n - 1) + countWays(n - 2);
  }

  public static void main(String[] args) {
    System.out.println("Hello world!");
    int n = 5;
    int result = countWays(n);
    System.out.println(result);
  }

}