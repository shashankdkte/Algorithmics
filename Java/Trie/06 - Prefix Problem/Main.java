/**
 * Find the shortest unique prefix for every word in a given list
 * Assume no word is prefix of another {"apple","app"}
 * Input:
 *    arr[] = {"zebra","dog","duck","dove"}
 * Output:
 *    ans = {"z","dog","du","dov"}
 */

 /**
  * Create a Trie
  */

  public class Main {

  static final int ALPHABET_SIZE = 26;

  static class Node {
    Node childern[] = new Node[ALPHABET_SIZE];
    boolean eow = false;
    int freq;

    public Node() {
      for (int i = 0; i < 26; i++) {
        childern[i] = null;
      }
      freq = 1;
    }
  }

  public static Node root = new Node();

  public static void insert(String word) {
    Node curr = root;
    for (int level = 0; level < word.length(); level++) {
      int index = word.charAt(level) - 'a';
      if (curr.childern[index] == null) {
        curr.childern[index] = new Node();
      } else {
        curr.childern[index].freq++;
      }
      curr = curr.childern[index];
    }
    curr.eow = true;
  }

  public static boolean search(String word) {
    Node curr = root;
    for (int level = 0; level < word.length(); level++) {
      int index = word.charAt(level) - 'a';
      if (curr.childern[index] == null) {
        return false;
      }
      curr = curr.childern[index];
    }
    return curr.eow == true;
  }

  public static boolean wordBreak(String key) {
    if (key.length() == 0) {
      return true;
    }
    for (int i = 1; i <= key.length(); i++) {
      if (search(key.substring(0, i)) && wordBreak(key.substring(i))) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    String arr[] = { "i", "like", "sam", "sung", "samsung", "mobile", "ice" };
    for (int i = 0; i < arr.length; i++) {
      insert(arr[i]);
    }
   
  }
}