/**
 * Input
 *  val[] = {15,14,10,45,30}
 *  wt[] = {2,5,1,3,4}
 *  W(total allowed weight) = 7
 * Output 
 * ans = maxProfit
 */

 /**
  * knapsack(val[],wt[],W,i   )

  if(w==0 || i == 0)
  {
    return 0
  }
  * if(wt<=W)
    {
      include W - wt, i+1
      exclude W , i+1
  
    }
    else
    {
      exclude W, i+1 
    }

  */

  // O(2^n)
  import java.util.*;

class Main {
  public static int knapsack(int val[], int wt[], int W, int n) {
    if (W == 0 || n == 0) {
      return 0;
    }
    if (wt[n - 1] <= W) {
      // include
      int ans1 = val[n - 1] + knapsack(val, wt, W - wt[n - 1], n - 1);
      // exclude
      int ans2 = knapsack(val, wt, W, n - 1);
      return Math.max(ans1, ans2);
    } else {
      return knapsack(val, wt, W, n - 1);
    }
  }

  public static void main(String[] args) {
    System.out.println("Hello world!");
    int val[] = { 15, 14, 10, 45, 30 };
    int wt[] = { 2, 5, 1, 3, 4 };
    int W = 7;
    System.out.println(knapsack(val, wt, W, val.length));
    ;
  }

}