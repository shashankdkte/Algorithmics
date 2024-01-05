import java.util.*;

class TreeSetFunc {

  public static void main(String[] args) {
    HashSet<String> cities = new HashSet<>();
    cities.add("Delhi");
    cities.add("Mumbai");
    cities.add("Kolkata");
    cities.add("Chennai");

    System.out.println(cities);
    LinkedHashSet<String> lcities = new LinkedHashSet<>();
    lcities.add("Delhi");
    lcities.add("Mumbai");
    lcities.add("Kolkata");
    lcities.add("Chennai");

    System.out.println(lcities);

    TreeSet<String> tcities = new TreeSet<>();
    tcities.add("Delhi");
    tcities.add("Mumbai");
    tcities.add("Kolkata");
    tcities.add("Chennai");

    System.out.println(tcities);
  }
}