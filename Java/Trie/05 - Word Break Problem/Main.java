/**
 * Given an input string and dictionary of words ,find  out
 * if input string can be broken into space seperated sequence of dictionary words.
 * Input:
 *      words[] = {"i","like","sam","samsung","mobile","ice"};
 *      key = "ilikesamsung"
 * Output:
 *    True
 */


 /**
  * Create a Trie from words
  * Check if i exist in words
  * Call recursive search on remaining 
  */
//O(L)
  public class Main {

  static final int ALPHABET_SIZE = 26;

  static class Node {
    Node childern[] = new Node[ALPHABET_SIZE];
    boolean eow = false;

    Node() {
      for (int i = 0; i < 26; i++) {
        childern[i] = null;
      }
    }
  }

  public static Node root = new Node();

  public static void insert(String word) {
    Node curr = root;
    for (int level = 0; level < word.length(); level++) {
      int index = word.charAt(level) - 'a';
      if (curr.childern[index] == null) {
        curr.childern[index] = new Node();
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
    String key = "ilikesamsung";
    System.out.println(wordBreak(key));
  }
}