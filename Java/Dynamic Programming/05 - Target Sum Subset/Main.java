/**
 *  dp(i,j) i -> items , j subset sum
 */

 // O(n  * sum)
 import java.util.*;

class Main {

  public static boolean targetSumSubset(int arr[], int sum) {
    int n = arr.length;
    boolean dp[][] = new boolean[n + 1][sum + 1];
    // i -> items, j-> target sum
    for (int i = 0; i < n + 1; i++) {
      dp[i][0] = true;
    }

    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < sum + 1; j++) {
        int v = arr[i - 1];
        if (v <= j && dp[i - 1][j - v] == true) {
          dp[i][j] = true;
        } else if (dp[i - 1][j] == true) {
          dp[i][j] = true;
        }
      }
    }
    return dp[n][sum];
  }

  public static void main(String[] args) {
    System.out.println("Hello world!");
    int arr[] = { 4, 2, 7, 1, 3 };
    int target = 10;
    System.out.println(targetSumSubset(arr, target));
  }

}