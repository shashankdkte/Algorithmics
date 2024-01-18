/**
 * A DAG has at least one vertex with in-degree 0 and one vertex with out-degree 0
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

  public static void calcIndeg(ArrayList<Edge>[] graph, int[] indeg) {
    for (int i = 0; i < graph.length; i++) {
      int v = i;
      for (int j = 0; j < graph[v].size(); j++) {
        Edge e = graph[v].get(j);
        indeg[e.dest]++;
      }
    }
  }

  public static void topSort(ArrayList<Edge>[] graph) {
    int deg[] = new int[graph.length];
    calcIndeg(graph, deg);
    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < deg.length; i++) {
      // Add all the vertices with indegree 0 to the queue
      if (deg[i] == 0) {
        q.add(i);
      }
    }

    while (!q.isEmpty()) {
      int curr = q.remove();
      System.out.print(curr + " ");

      for (int i = 0; i < graph[curr].size(); i++) {
        Edge e = graph[curr].get(i);
        deg[e.dest]--;
        if (deg[e.dest] == 0) {
          q.add(e.dest);
        }
      }
    }
    System.out.println();
  }

  public static void main(String[] args) {
    System.out.println("Hello world!");

    int V = 6;
    ArrayList<Edge> graph[] = new ArrayList[V]; // null ->empty arraylist
    createGraph(graph);
    topSort(graph);

  }
}
