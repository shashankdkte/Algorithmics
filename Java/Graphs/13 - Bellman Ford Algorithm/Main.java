/**
 * Dijkstra Algorithm cannot be used in case of negative weights
 * Shortest path from the sources to all vertices (negative egdes)
 * Cannot be used for Negative Weight Cycles
 */

 //O(VE)

 /**
  * Perform this operation V-1 times
  for all egdes(u,v)
  if dist[u] + wt(u,v) < dist[v]
  dist[v] = dist [u] + wt(u,v)

  Relaxation 
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
    graph[1].add(new Edge(1, 2, -4));

    // 2 vertex

    graph[2].add(new Edge(2, 3, 2));

    // 3 vertex
    graph[3].add(new Edge(3, 4, 4));

    // 4 vertex
    graph[4].add(new Edge(4, 1, -1));

  }

  public static void bellmanFord(ArrayList<Edge>[] graph, int src) {
    int dist[] = new int[graph.length];
    for (int i = 0; i < graph.length; i++) {
      if (i != src) {
        dist[i] = Integer.MAX_VALUE;
      }
    }

    int V = graph.length;

    // algo

    for (int i = 0; i < V - 1; i++) {
      // edges - O(E)
      for (int j = 0; j < graph.length; j++) {
        for (int k = 0; k < graph[j].size(); k++) {
          Edge e = graph[j].get(k);
          // u , v , wt

          int u = e.src;
          int v = e.dest;
          int wt = e.wt;

          // relaxation

          if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
            dist[v] = dist[u] + wt;
          }
        }
      }
    }

    for (int i = 0; i < dist.length; i++) {
      System.out.print(dist[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    System.out.println("Hello world!");

    int V = 5;
    ArrayList<Edge> graph[] = new ArrayList[V]; // null ->empty arraylist
    createGraph(graph);
    bellmanFord(graph, 0);

  }
}
