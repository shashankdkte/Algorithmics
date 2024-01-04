import java.util.*;

class IterateHashMap {
  public static void main(String[] args) {
    HashMap<String, Integer> hm = new HashMap<String, Integer>();
    hm.put("India", 100);
    hm.put("China", 150);
    hm.put("USA", 50);
    hm.put("Indonesia", 6);
    hm.put("Nepal", 5);

    // Iterate
    Set<String> keys = hm.keySet();
    System.out.println(keys);

    for (String k : keys) {
      System.out.println(k + " -> " + hm.get(k));
    }

  }
}