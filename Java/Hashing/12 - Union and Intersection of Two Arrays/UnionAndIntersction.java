/**
 * Input
 *  arr1 = {7,3,9}
 *  arr2 = {6,3,9,2,9,4}
 * Output
 *  Union: 6 {7,3,9,6,2,4}
 *  Intersection: 2 {3,9}
 */

 import java.util.*;

class UnionAndIntersection {

  public static void main(String[] args) {
    int arr1[] = { 7, 3, 9 };
    int arr2[] = { 6, 3, 9, 2, 9, 4 };
    HashSet<Integer> set = new HashSet<>();
    for (int i = 0; i < arr1.length; i++) {
      set.add(arr1[i]);
    }
    for (int i = 0; i < arr2.length; i++) {
      set.add(arr2[i]);
    }
    System.out.println("union " + set.size());

    // Intersection
    set.clear();
    for (int i = 0; i < arr1.length; i++) {
      set.add(arr1[i]);
    }
    int count = 0;
    for (int i = 0; i < arr2.length; i++) {
      if (set.contains(arr2[i])) {
        count++;
        set.remove(arr2[i]);
      }
    }
    System.out.println("Instersection " + count);

  }
}