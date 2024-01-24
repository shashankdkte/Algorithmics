/**
 * Sort Edges
 * Take minimum cost edge which dont form cycle
 * Union if not parA == parB
 *  Then Union(a,b)
 *  O(V+ELogE)
 */

 import java.util.*;

class Main {
  static class Edge implements Comparable<Edge> {
    int source;
    int destination;
    int weight;

    public Edge(int source, int destination, int weight) {
      this.source = source;
      this.destination = destination;
      this.weight = weight;
    }

    @Override // Add this annotation
    public int compareTo(Edge o) {
      return this.weight - o.weight;
    }
  }

  static void createGraph(ArrayList<Edge> edges) {
    edges.add(new Edge(0, 1, 10));
    edges.add(new Edge(0, 2, 15));
    edges.add(new Edge(0, 3, 30));
    edges.add(new Edge(1, 3, 40));
    edges.add(new Edge(2, 3, 50));

  }

  static int n = 4;
  static int par[] = new int[n];
  static int rank[] = new int[n];

  public static void init() {
    for (int i = 0; i < n; i++) {
      par[i] = i;
    }
  }

  public static int find(int x) {
    if (x == par[x]) {
      return x;
    }
    return par[x] = find(par[x]);
  }

  public static void union(int a, int b) {
    int parA = find(a);
    int parB = find(b);

    if (rank[parA] == rank[parB]) {
      par[parB] = parA;
      rank[parA]++;
    } else if (rank[parA] < rank[parB]) {
      par[parA] = parB;
    } else {
      par[parB] = parA;
    }
  }

  public static void kruskalMST(ArrayList<Edge> edges, int V) {
    init();
    Collections.sort(edges);
    int mstCost = 0;
    int count = 0;
    for (int i = 0; count < V - 1; i++) {
      Edge e = edges.get(i);

      int parA = find(e.source);
      int parB = find(e.destination);
      if (parA != parB) {
        union(e.source, e.destination);
        mstCost += e.weight;
        count++;

      }
    }
    System.out.println(mstCost);
  }

  public static void main(String[] args) {
    int V = 4;
    ArrayList<Edge> edges = new ArrayList<>();
    createGraph(edges);
    kruskalMST(edges, V);
  }
}