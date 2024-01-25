import java.util.*;
// O(n)
class Main {

  public static int countWays(int n, int ways[]) {
    if (n == 0) {
      return 1;
    }
    if (n < 0) {
      return 0;
    }

    if (ways[n] != -1) {
      return ways[n];
    }
    ways[n] = countWays(n - 1, ways) + countWays(n - 2, ways);
    return ways[n];
  }

  public static void main(String[] args) {
    System.out.println("Hello world!");
    int n = 5;
    int ways[] = new int[n + 1];
    Arrays.fill(ways, -1);
    int result = countWays(n, ways);
    System.out.println(result);
  }

}