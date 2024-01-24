/**
 *  There are n cities connected by some number of flights . You are given an array of flights where
 * flights[i] = [from,to,price] indicates that there is a flight
 * You are also given three integers src,dest and K return the cheapest from source to destination with at most k stops
 * If there is no such route return -1
 * Input
 * flights = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0 
 * destintion = 2
 * k = 1
 * Output
 * ans 200
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

  public static void createGraph(int flights[][], ArrayList<Edge>[] graph) {
    for (int i = 0; i < graph.length; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < graph.length; i++) {
      int source = flights[i][0];
      int destination = flights[i][1];
      int weight = flights[i][2];
      Edge e1 = new Edge(source, destination, weight);
      graph[source].add(e1);
    }

  }

  static class Info {

    int v;
    int cost;
    int stops;

    public Info(int v, int c, int s) {
      this.v = v;
      this.cost = c;
      this.stops = s;
    }
  }

  public static int cheapestFlight(int n, int flights[][], int source, int destination, int k) {
    ArrayList<Edge>[] graph = new ArrayList[n];
    createGraph(flights, graph);
    int dist[] = new int[n];
    for (int i = 0; i < n; i++) {
      if (i != source) {
        dist[i] = Integer.MAX_VALUE;
      }
    }

    Queue<Info> q = new LinkedList<>();
    q.add(new Info(source, 0, 0));
    while (!q.isEmpty()) {
      Info curr = q.remove();
      if (curr.stops > k) {
        break;
      }

      for (int i = 0; i < graph[curr.v].size(); i++)

      {
        Edge e = graph[curr.v].get(i);
        int u = e.src;
        int v = e.dest;
        int wt = e.wt;
        // curr.cost + wt < dist[v]
        if ( curr.cost + wt < dist[v] && curr.stops <= k) {
          dist[v] = dist[u] + wt;
          q.add(new Info(v, dist[v], curr.stops + 1));
        }
      }
    }

    if (dist[destination] == Integer.MAX_VALUE)

    {
      return -1;
    } else {
      return dist[destination];
    }
  }

  public static void main(String[] args) {
    int n = 4;
    int flights[][] = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } };
    System.out.println(cheapestFlight(n, flights, 0, 3, 1));
  }
}
