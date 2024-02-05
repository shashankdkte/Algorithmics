import java.util.*;

class Main {
  public static int rodCutting(int price[], int length[], int totalRod) {
    int n = price.length;
    int dp[][] = new int[n + 1][totalRod + 1];
    for (int i = 0; i < n + 1; i++) {
      dp[i][0] = 0;

    }

    for (int j = 0; j < totalRod + 1; j++) {
      dp[0][j] = 0;
    }

    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < totalRod + 1; j++) {
        if (length[i - 1] <= j) {
          dp[i][j] = Math.max(price[i - 1] + dp[i - 1][j - length[i - 1]], dp[i - 1][j]);
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }
    generateTable(dp);
    return dp[n][totalRod];
  }

  public static void generateTable(int dp[][]) {
    int n = dp.length;
    int m = dp[0].length;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        System.out.print(dp[i][j] + "\t");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    System.out.println("Hello world!");
    int price[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
    int length[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
    int totalRod = 8;
    System.out.println(rodCutting(price, length, totalRod));
  }

}