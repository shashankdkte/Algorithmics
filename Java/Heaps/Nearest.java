import java.util.*;

public class Nearest {
  static class Point implements Comparable<Point> {
    int x;
    int y;
    int distSq;
    int index;

    public Point(int x, int y, int distSq, int index) {
      this.x = x;
      this.y = y;
      this.distSq = distSq;
      this.index = index;
    }

    @Override
    public int compareTo(Point p2) {
      return this.distSq - p2.distSq;
    }

  }

    public static void main(String[] args) {
      
    int pts[][] = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
    int k = 2;

    PriorityQueue<Nearest.Point> pq = new PriorityQueue<Nearest.Point>();
    for (int i = 0; i < pts.length; i++) {
      int distSq = pts[i][0] * pts[i][0] + pts[i][1] * pts[i][1];
      pq.add(new Nearest.Point(pts[i][0], pts[i][1], distSq, i));
    }
    for (int i = 0; i < k; i++) {
      System.out.println("C" + pq.remove().index);
    }
    }
}