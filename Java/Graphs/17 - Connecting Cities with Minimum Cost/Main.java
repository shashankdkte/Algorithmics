/**
 * Similar to Minimum Spanning Tree 
 */
import java.util.*;

class Main {
  static class Edge implements Comparable<Edge> {
    int destination;
    int cost;

    public Edge(int destination, int cost) {
      this.destination = destination;
      this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
      return this.cost - o.cost;
    }

  }

  public static int connectCities(int cities[][]) {
    PriorityQueue<Edge> pq = new PriorityQueue<>();
    boolean visited[] = new boolean[cities.length];

    pq.add(new Edge(0, 0));
    int finalCost = 0;

    while (!pq.isEmpty()) {
      Edge current = pq.remove();
      if (!visited[current.destination]) {
        visited[current.destination] = true;
        finalCost += current.cost;

        for (int i = 0; i < cities[current.destination].length; i++) {
          if (cities[current.destination][i] != 0 && !visited[i]) {
            pq.add(new Edge(i, cities[current.destination][i]));
          }
        }
      }
    }
    return finalCost;
  }

  public static void main(String[] args) {
    int cities[][] = { { 0, 1, 2, 3, 4 },
        { 1, 0, 5, 0, 7 },
        { 2, 5, 0, 6, 0 },
        { 3, 0, 6, 0, 0 },
        { 4, 7, 0, 0, 0 } };
    System.out.println(connectCities(cities));

  }
}