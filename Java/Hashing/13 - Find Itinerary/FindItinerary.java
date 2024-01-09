/**
 * Find Itinerary from Tickets
 * "Chennai" -> "Bengaluru"
 * "Mumbai" -> "Delhi"
 * "Goa" -> "Chennai"
 * "Delhi" ->"Goa"
 * 
 * "Mumbai" -> "Delhi" -> "Goa" -> "Chennai" -> "Bengaluru"
 * 
 * // Start : from 
 * 
 * <from,to> map
 * <to, from> Rev Map
 */

// Time complexity O(n)
import java.util.*;

class Main {

  public static void main(String[] args) {
    HashMap<String, String> tickets = new HashMap<String, String>();
    tickets.put("Chennai", "Bengaluru");
    tickets.put("Mumbai", "Delhi");
    tickets.put("Goa", "Chennai");
    tickets.put("Delhi", "Goa");

    String startingPoint = getStartingPoint(tickets);
    System.out.print(startingPoint);
    for (String key : tickets.keySet()) {
      System.out.print(" -> " + tickets.get(startingPoint));
      startingPoint = tickets.get(startingPoint);

    }
  }

  public static String getStartingPoint(HashMap<String, String> tickets) {

    // Generate ReverseMap for ticket i.e key -> value and value -> key
    HashMap<String, String> reverseMap = new HashMap<>();
    for (String key : tickets.keySet()) {
      reverseMap.put(tickets.get(key), key);
    }
    // The Starting point will not be part of reverse Map
    for (String key : tickets.keySet()) {
      if (!reverseMap.containsKey(key)) {
        return key;
      }

    }
    return null;
  }
}