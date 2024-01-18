/**
 * Directed graph
 */

 /**
  * dfs(graph,source,destination,path)
  {
    if(source == destination)
    {
      print(path);

    }
    else

    for(i:neighbour)
    {
      dfs(neighbour, destination,path + curr  )
    }
  }
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
    graph[0].add(new Edge(0, 3, 1));

    // 1 vertex

    // 2 vertex

    graph[2].add(new Edge(2, 3, 1));

    // 3 vertex
    graph[3].add(new Edge(3, 1, 1));

    // 4 vertex
    graph[4].add(new Edge(4, 0, 1));
    graph[4].add(new Edge(4, 1, 1));

    // 5 vertex
    graph[5].add(new Edge(5, 0, 1));
    graph[5].add(new Edge(5, 2, 1));

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

  public static void printAllPath(ArrayList<Edge>[] graph, int source, int destination, String path) {
    if (source == destination) {
      System.out.println(path + destination);
      return;
    }
    for (int i = 0; i < graph[source].size(); i++) {
      Edge e = graph[source].get(i);
      printAllPath(graph, e.dest, destination, path + source);
    }
  }

  public static void main(String[] args) {
    System.out.println("Hello world!");

    int V = 6;
    ArrayList<Edge> graph[] = new ArrayList[V]; // null ->empty arraylist
    createGraph(graph);
    int source = 5;
    int destination = 1;
    printAllPath(graph, source, destination, "");

  }
}
