import java.util.*;

class Main {
  public static void main(String[] args) {
    static class HashMap<K, V> {
      private class Node {
        K key;
        V value;
        Node next;

        Node(K key, V value) {
          this.key = key;
          this.value = value;
        }
      }

      private int n; // n -> Number of Nodes
      private int N;
      private LinkedList<Node> buckets[]; // N buckets.length

      @SupressWarning("unchecked")
      public HashMap() {
        this.N = 4;
        this.buckets = new LinkedList[4];
        // Intializing Linked list at each bucket
        for (int i = 0; i < 4; i++) {
          this.buckets[i] = new LinkedList<>();
        }
      } 
       /

      private int hashFuction(K key) {
        return Math.abs(key.hashCode()) % N;
      }

      private int searchInLinkedList(K key, int bi) {
        LinkedList<Node> li = this.buckets[bi];
        int di = 0;
        for (int i = 0; i < li.size(); i++) {
          Node node = li.get(i);
          if (node.key == key) {
            return di;

          }
          di++;
        }
        return -1;
      }

    }
  }
}