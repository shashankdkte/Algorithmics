import java.util.*;

class TreeMapFunc {
  public static void main(String[] args) {
    /*
     * Array of Double Linked List
     */
    TreeMap<String, Integer> lmap = new TreeMap<>();
    lmap.put("India", 100);
    lmap.put("China", 150);
    lmap.put("USA", 50);

    System.out.println(lmap);

    HashMap<String, Integer> hmap = new HashMap<>();
    hmap.put("India", 100);
    hmap.put("China", 150);
    hmap.put("USA", 50);

    System.out.println(hmap);

  }
}