/**
 * Given an integer array of size n, 
 * Find all elements that appear more than n/3 times
 * Input:
 *    nums[] = {1,3,2,5,1,3,1,5,1}
 * Output
 *      1
 * Input
 *    nums[] = {1,2}
 *  Output 
 *    1,2
 */

 /**
  * O(n)
  * for i=0 to arr.length
  *     num = arr[i]
  *     if map.containsKey(num)
  *         map.put(num,map.get(num)+1)
  *     else
  *         map.put(num,1)
  * for int k: map.keySet()
  *     if map.get(k) > nums.length / 3
  *         print(k)
  */

  
import java.util.*;

class MajoirityElement {
  public static void main(String[] args) {
    int arr[] = { 1, 3, 2, 5, 1, 3, 1, 5, 1 };
    HashMap<Integer, Integer> hm = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      if (hm.containsKey(arr[i])) {
        hm.put(arr[i], hm.get(arr[i]) + 1);
      } else {
        hm.put(arr[i], 1);
      }
    }

    Set<Integer> keySet = hm.keySet();
    for (Integer key : keySet) {
      if (hm.get(key) > arr.length / 3) {
        System.out.println(key);
      }
    }

  }
}