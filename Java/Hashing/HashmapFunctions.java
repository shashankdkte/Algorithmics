import java.util.HashMap;

class HashmapFunctions {
  public static void main(String[] args) {
    System.out.println("Hello world!");
    HashMap<String, Integer> hm = new HashMap<>();
    hm.put("India", 100);
    hm.put("China", 150);
    hm.put("USA", 50);

    System.out.println(hm);

    // Get
    int population = hm.get("India");
    System.out.println(population);

    System.out.println(hm.get("Indonesia"));

    // ContainsKey
    System.out.println(hm.containsKey("India"));
    System.out.println(hm.containsKey("Indonesia"));

    // Remove
    System.out.println(hm.remove("China"));
    System.out.println(hm);

    // Size
    System.out.println(hm.size());

    // Is Empty
    System.out.println(hm.isEmpty());
    hm.clear();
  }
}