import java.util.*;

public class HeapImplementation {
  static class Heap {
    ArrayList<Integer> arr = new ArrayList<Integer>();

    public void add(int data) {
      // Add at last index
      arr.add(data);

      // Get Child Index
      int child = arr.size() - 1;

      // Get Parent Index
      int parent = (child - 1) / 2;

      while (arr.get(child) < arr.get(parent)) {
        // Swap
        int temp = arr.get(child);
        arr.set(child, arr.get(parent));
        arr.set(parent, temp);

        child = parent;
        parent = (child - 1) / 2;
      }

    }

    public int peek() {
      return arr.get(0);
    }

    // O Logn
    private void heapify(int i) {
      // Find the minimum value between the parent and child
      int leftChild = 2 * i + 1;
      int rightChild = 2 * i + 2;
      int minIndex = i;

      if (leftChild < arr.size() && arr.get(leftChild) < arr.get(minIndex)) {
        minIndex = leftChild;
      }
      if (rightChild < arr.size() && arr.get(rightChild) < arr.get(minIndex)) {
        minIndex = rightChild;
      }

      if (minIndex != i) {
        // Swap
        int temp = arr.get(i);
        arr.set(i, arr.get(minIndex));
        arr.set(minIndex, temp);
        heapify(minIndex);
      }
    }

    public boolean isEmpty() {
      return arr.size() == 0;
    }

    public int remove() {
      int data = arr.get(0);

      // Step 1 : Swap first and Last Element
      int first = arr.get(0);
      arr.set(0, arr.get(arr.size() - 1));
      arr.set(arr.size() - 1, first);

      // Step 2 Delete Last Element
      arr.remove(arr.size() - 1);
      heapify(0);
      return data;

    }

  }

  public static void main(String[] args) {
    Heap heap = new Heap();
    heap.add(3);    
    heap.add(4);
    heap.add(1);
    heap.add(2);

    while(!heap.isEmpty())
      {
        System.out.println(heap.peek());
        heap.remove();
      }

  }
  
}