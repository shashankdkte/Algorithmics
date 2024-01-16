/**
 * Why Directed DFS approach Fails
 * Neighbour visited but not parent  return true // although should return false
 */

 /**
  * Stack boolean  
  */
  
  /**
   * isCycle(curr)
   * {
   *  vis[curr] = true
   * stack[curr] = true
   * for(all neighbours)
   * {
   *  if(stack[neigh] == true)
   * {  
   *  return true
   * }
   * if(!vis[neigh])
   * {
   * isCycle(neigh)
   * }
   * }
   * stack[curr] = false
   * }
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

  public static void createGraphCycle(ArrayList<Edge>[] graph) {
    for (int i = 0; i < graph.length; i++) {
      graph[i] = new ArrayList<>();
    }

    // 0 vertex
    graph[0].add(new Edge(0, 2, 1));

    // 1 vertex
    graph[1].add(new Edge(1, 0, 1));

    // 2 vertex
    graph[2].add(new Edge(2, 3, 1));

    // 3 vertex
    graph[3].add(new Edge(3, 0, 1));

  }

  public static boolean isCycle(ArrayList<Edge>[] graph) {
    boolean[] visited = new boolean[graph.length];
    boolean[] stack = new boolean[graph.length];
    for (int i = 0; i < graph.length; i++) {
      if (!visited[i]) {
        if (isCycleUtil(graph, i, visited, stack)) {
          return true;
        }
      }
    }
    return false;
  }

  public static boolean isCycleUtil(ArrayList<Edge>[] graph, int curr, boolean[] visited, boolean[] stack) {

    visited[curr] = true;
    stack[curr] = true;

    for (int i = 0; i < graph[curr].size(); i++) {
      Edge e = graph[curr].get(i);
      if (!visited[e.dest]) {
        if (isCycleUtil(graph, e.dest, visited, stack)) {
          return true;
        }
      } else if (stack[e.dest]) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println("Hello world!");

    int V = 5;
    ArrayList<Edge> graph[] = new ArrayList[V]; // null ->empty arraylist
    createGraphCycle(graph);
    System.out.println(isCycle(graph));

  }
}
