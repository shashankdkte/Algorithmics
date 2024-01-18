/**
 * dist[v] = dist[u] + wht(u,v) 
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

  static class Pair implements Comparable<Pair> {
    int n;
    int path;

    public Pair(int n, int path) {
      this.n = n;
      this.path = path;
    }

    @Override
    public int compareTo(Pair o) {

      return this.path - o.path;
    }
  }

  public static void createGraph(ArrayList<Edge>[] graph) {
    for (int i = 0; i < graph.length; i++) {
      graph[i] = new ArrayList<>();
    }

    // 0 vertex
    graph[0].add(new Edge(0, 1, 2));
    graph[0].add(new Edge(0, 2, 4));

    // 1 vertex
    graph[1].add(new Edge(1, 3, 7));
    graph[1].add(new Edge(1, 2, 1));

    // 2 vertex

    graph[2].add(new Edge(2, 4, 3));

    // 3 vertex
    graph[3].add(new Edge(3, 5, 1));

    // 4 vertex
    graph[4].add(new Edge(4, 3, 2));
    graph[4].add(new Edge(4, 5, 5));

  }

  public static void dijkstra(ArrayList<Edge>[] graph, int source) {
    int dist[] = new int[graph.length];
    for (int i = 0; i < graph.length; i++) {
      if (i != source) {
        dist[i] = Integer.MAX_VALUE;

      }
    }
    boolean[] visited = new boolean[graph.length];
    PriorityQueue<Pair> pq = new PriorityQueue<>();
    pq.add(new Pair(source, 0));

    while (!pq.isEmpty()) {
      Pair curr = pq.remove();
      if (!visited[curr.n]) {
        visited[curr.n] = true;
        for (int i = 0; i < graph[curr.n].size(); i++) {
          Edge e = graph[curr.n].get(i);
          int u = e.src;
          int v = e.dest;
          int wt = e.wt;
          if (dist[u] + wt < dist[v]) {
            dist[v] = dist[u] + wt;
            pq.add(new Pair(v, dist[v]));
          }
        }
      }
    }
    for (int i = 0; i < dist.length; i++) {
      System.out.println(dist[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    System.out.println("Hello world!");

    int V = 6;
    ArrayList<Edge> graph[] = new ArrayList[V]; // null ->empty arraylist
    createGraph(graph);
    int source = 0;
    int destination = 1;
    dijkstra(graph, source);

  }
}
