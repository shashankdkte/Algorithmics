/**
 * For every node we have 3 conditions
 * visited[neighbour] == true and !parent  cycle = true
 * visited[neighbour] == true and parent   
 * visited[neighbour] != true   
 * 
 */ 

 import java.util.*;

class Main {

  static class Edge {
    int src;
    int dest;
    int wt;

    public Edge(int s, int d, int w) {
      this.src = s;
      this.dest = d;
      this.wt = w;
    }
  }

  public static void createGraph(ArrayList<Edge>[] graph) {
    for (int i = 0; i < graph.length; i++) {
      graph[i] = new ArrayList<>();
    }

    // 0 vertex
    graph[0].add(new Edge(0, 1, 5));

    // 1 vertex
    graph[1].add(new Edge(1, 0, 5));
    graph[1].add(new Edge(1, 2, 1));
    graph[1].add(new Edge(1, 3, 3));

    // 2 vertex
    graph[2].add(new Edge(2, 1, 1));
    graph[2].add(new Edge(2, 3, 1));
    graph[2].add(new Edge(2, 4, 4));

    // 3 vertex
    graph[3].add(new Edge(3, 1, 3));
    graph[3].add(new Edge(3, 2, 1));

    // 4 vertex
    graph[4].add(new Edge(4, 2, 2));

  }

  public static void createGraphHasCycle(ArrayList<Edge>[] graph) {
    for (int i = 0; i < graph.length; i++) {
      graph[i] = new ArrayList<>();
    }

    // 0 vertex
    graph[0].add(new Edge(0, 1, 1));
    graph[0].add(new Edge(0, 2, 1));
    graph[0].add(new Edge(0, 3, 1));

    // 1 vertex
    graph[1].add(new Edge(1, 0, 1));
    graph[1].add(new Edge(1, 2, 1));

    // 2 vertex
    graph[2].add(new Edge(2, 0, 1));
    graph[2].add(new Edge(2, 1, 1));

    // 3 vertex
    graph[3].add(new Edge(3, 0, 1));
    graph[3].add(new Edge(3, 4, 1));

    // 4 vertex
    graph[4].add(new Edge(4, 3, 1));

  }

  public static boolean detectCycle(ArrayList<Edge>[] graph) {
    boolean[] visited = new boolean[graph.length];
    for (int i = 0; i < graph.length; i++) {
      if (!visited[i]) {
        if (detectCycleUtil(graph, visited, i, -1)) {
          return true;
        }
      }

    }
    return false;
  }

  public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean[] visited, int current, int parent) {

    visited[current] = true;
    for (int i = 0; i < graph[current].size(); i++) {
      Edge e = graph[current].get(i);
      // Case 3
      if (!visited[e.dest]) {
        if (detectCycleUtil(graph, visited, e.dest, current)) {
          return true;
        }
      }

      // Case 1
      else if (visited[e.dest] && e.dest != parent) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println("Hello world!");

    int V = 5;
    ArrayList<Edge> graph[] = new ArrayList[V]; // null ->empty arraylist
    createGraphHasCycle(graph);
    System.out.println(detectCycle(graph));

  }
}
