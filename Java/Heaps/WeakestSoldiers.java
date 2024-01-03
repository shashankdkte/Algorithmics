import java.util.*
/**
 * We are given m X n matrix of 1's soldier and 0's civilians .The soldiers are positioned in front of the civilians.
 * That is all the 1's will appear to left of all the 0's in each row
 *  
 * A row is i is weaker than row j if one of the following is true
 * The number of soldier in row i is less than the number of soldiers in row j
 * Both rows have the same number of soldiers and i< j
 * Find the weakest rows
 * Input 
 *    army[][] = {
        { 1, 0, 0, 0 },
        { 1, 1, 1, 1 },
        { 1, 0, 0, 0 },
        { 1, 0, 0, 0 }
        k=2
    Output
      R0
      R2

 */
public class WeakestSoldier {
  static class Row implements Comparable<Row> {
    int soldiers;
    int index;

    public Row(int soldiers, int index) {
      this.soldiers = soldiers;
      this.index = index;
    }

    @Override
    public int compareTo(Row o){
      if(this.soldiers == o.soldiers)
      {
        return this.index - o.index;
      }
      else{
        return this.soldiers - o.soldiers;
      }
    }
  }

  public static void main(String[] args)
  {
     int army[][] = {
        { 1, 0, 0, 0 },
        { 1, 1, 1, 1 },
        { 1, 0, 0, 0 },
        { 1, 0, 0, 0 }
    };
    int k = 2;
    PriorityQueue<WeakestSoldier.Row> pq = new PriorityQueue<WeakestSoldier.Row>();
    for (int i = 0; i < army.length; i++) {
      int count = 0;
      for (int j = 0; j < army[i].length; j++) {
        if (army[i][j] == 1) {
          count++;
        }
      }
      pq.add(new WeakestSoldier.Row(count, i));
    }

    for (int i = 0; i < k; i++) {
      System.out.println("R" + pq.remove().index);
    }
  }
  }
