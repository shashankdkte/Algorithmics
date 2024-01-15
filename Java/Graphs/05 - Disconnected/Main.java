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

  public static void bfsUtil(ArrayList<Edge>[] graph, int src, boolean[] visited) {
    Queue<Integer> q = new LinkedList<>();
    q.add(src);
    while (!q.isEmpty()) {
      int curr = q.remove();
      if (!visited[curr]) {
        System.out.print(curr + " ");
        visited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
          Edge e = graph[curr].get(i);
          if (!visited[e.dest]) {
            q.add(e.dest);
          }
        }
      }
    }

  }

  public static void bfs(ArrayList<Edge>[] graph, int src) {
    boolean[] visited = new boolean[graph.length];
    for (int i = 0; i < graph.length; i++) {
      if (!visited[i]) {
        bfsUtil(graph, 0, visited);
      }
    }

  }

  public static void dfs(ArrayList<Edge>[] graph) {
    boolean[] visited = new boolean[graph.length];
    for (int i = 0; i < graph.length; i++) {
      if (!visited[i]) {
        dfsUtil(graph, i, visited);
      }
    }
  }

  public static void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean[] visited) {
    System.out.print(curr + " ");
    visited[curr] = true;
    for (int i = 0; i < graph[curr].size(); i++) {
      Edge e = graph[curr].get(i);
      if (!visited[e.dest]) {
        dfsUtil(graph, e.dest, visited);
      }
    }
  }

  public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited) {
    if (src == dest) {
      return true;
    }

    visited[src] = true;
    for (int i = 0; i < graph[src].size(); i++) {
      Edge e = graph[src].get(i);
      if (!visited[e.dest] && hasPath(graph, e.dest, dest, visited)) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println("Hello world!");

    int V = 5;
    ArrayList<Edge> graph[] = new ArrayList[V]; // null ->empty arraylist
    createGraph(graph);
    // bfs(graph, 0);
    dfs(graph, 0, new boolean[V]);
    hasPath(graph, 0, 5, new boolean[V]);
    // Find neighbours
    /*
     * for (int i = 0; i < graph[2].size(); i++) {
     * Edge e = graph[2].get(i);
     * System.out.println(e.dest);
     */
  }
}
