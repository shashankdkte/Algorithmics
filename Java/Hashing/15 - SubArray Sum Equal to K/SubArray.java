/**
 * Input:
 *  arr = {1,2,3}
 *  k = 3
 * Output:
 *    2
 * sum(0,j) - sum(0,i-1) = sum(i,j)
 */
import java.util.*;

class Main {

  public static void main(String[] args) {
    int arr[] = { 10, 2, -2, -20, 10 };
    int k = -10;

    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    int sum = 0;
    int ans = 0;
    for (int j = 0; j < arr.length; j++) {
      sum += arr[j];
      if (map.containsKey(sum - k)) {
        ans += map.get(sum - k);
      }
      map.put(sum, map.getOrDefault(sum, 0) + 1);

    }

    System.out.println(ans);
  }
}