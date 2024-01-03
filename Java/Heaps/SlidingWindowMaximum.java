public class SlidingWindowMaximum {
  static class Pair implements Comparable<Pair> {
    int value;
    int index;

    public Pair(int value, int index) {
      this.value = value;
      this.index = index;
    }

    @Override
    public int compareTo(Pair p) {
      return p.value - this.value;
    }
  }
   public static void main(String[] args) {

    int array[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
    int k = 3;
    int result[] = new int[array.length - k + 1];
    PriorityQueue<SlidingWindowMaximum.Pair> pq = new PriorityQueue<SlidingWindowMaximum.Pair>();

    for (int i = 0; i < k; i++) {
      pq.add(new SlidingWindowMaximum.Pair(array[i], i));
    }

    result[0] = pq.peek().value;

    for (int i = k; i < array.length; i++) {
      while (pq.size() > 0 && pq.peek().index <= (i - k)) {
        pq.remove();
      }

      pq.add(new SlidingWindowMaximum.Pair(array[i], i));
      result[i - k + 1] = pq.peek().value;
    }

    // print result
    for (int i = 0; i < result.length; i++) {
      System.out.println(result[i]);
    }
  }
  
}

