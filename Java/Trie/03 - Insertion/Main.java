/**
 * Time complexity is O(L)
 * L - > Largest word length
 */

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

  public static void main(String[] args) {
    String words[] = { "the", "a", "there", "answer", "any", "by", "bye", "their" };
    for (int i = 0; i < words.length; i++) {
      insert(words[i]);
    }
  }
}