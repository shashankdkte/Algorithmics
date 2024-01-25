import java.util.*;

class Main {

public static int countWays(int n)
  {
    int dp[] = new int[n+1];
    dp[0] = 1;
    for(int i=1;i<=n;i++)
      {
        if(i==1)
        {
          dp[i] = dp[i-1];
      
        }
        else
        {
          dp[i] = dp[i-1] + dp[i-2];
        }
      }
    return dp[n];
  }

  public static void main(String[] args) {
    System.out.println("Hello world!");
    int n = 5;
    int result = countWays(n);
    System.out.println(result);
  }

}