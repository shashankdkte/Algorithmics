import java.util.*
/**
 * Given are N ropes of different lengths, the task is to connect these ropes into one rope 
 * with minimum cost , such that the cost to connect two ropes is equal to sum of their lengths
 * Input 
 *    ropes = {4,3,2,6}
 * Output
 *     29
 * Steps
 *    connect 2 and 3 
 *    connect 5 and 4
 *    connect 6 and 9
 */
class ConnectingRopes{

  public static void main(String[] args)
  {
     int ropes[] = { 2, 3, 3, 4, 6 };
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    for (int i = 0; i < ropes.length; i++) {
      pq.add(ropes[i]);

    }
    int cost = 0;
    while (pq.size() > 1) {
      int firstMin = pq.remove();
      int secondMin = pq.remove();
      cost += firstMin + secondMin;
      pq.add(firstMin + secondMin);

    }
    System.out.println("Cost of connecting n ropes = " + cost);
  
  }
}