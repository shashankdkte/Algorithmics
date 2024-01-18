/**
 *   Directed Acyclic graph is a directed graph with no cycles
 *  Topological sorting is used only for DAGs 
 *  It is linear order of vertices such that every directed edge u-> v,
 *  the vertex u comes before v in the order 
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

    // 1 vertex

    // 2 vertex

    graph[2].add(new Edge(2, 3, 1));

    // 3 vertex
    graph[3].add(new Edge(3, 1, 1));

    // 4 vertex
    graph[4].add(new Edge(4, 0, 1));
    graph[4].add(new Edge(4, 1, 1));

    // 5 vertex
    graph[4].add(new Edge(5, 0, 1));
    graph[4].add(new Edge(5, 2, 1));

  }

  public static void topSort(ArrayList<Edge>[] graph) {
    boolean[] visited = new boolean[graph.length];
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < graph.length; i++) {
      if (!visited[i]) {
        topSortUtil(graph, i, visited, stack);
      }
    }
    while (!stack.isEmpty()) {
      System.out.println(stack.pop() + " ");
    }
  }

  public static void topSortUtil(ArrayList<Edge>[] graph, int curr, boolean[] visited, Stack<Integer> stack) {
    visited[curr] = true;
    for (int i = 0; i < graph[curr].size(); i++) {
      Edge e = graph[curr].get(i);
      if (!visited[e.dest]) {
        topSortUtil(graph, e.dest, visited, stack);
      }
    }
    stack.push(curr);
  }

  public static void main(String[] args) {
    System.out.println("Hello world!");

    int V = 6;
    ArrayList<Edge> graph[] = new ArrayList[V]; // null ->empty arraylist
    createGraph(graph);
    topSort(graph);

  }
}
