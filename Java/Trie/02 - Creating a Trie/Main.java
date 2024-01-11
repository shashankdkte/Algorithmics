public class Main {
  static class Node {
    Node childern[] = new Node[26];
    boolean eow = false;

    Node(){
      for(int i=0;i<26;i++){
        childern[i] = null;
    }
  }

  public static Node root = new Node();
  public static void main(String[] args) {
   String words[] = {"the","a","there","answer","any","by","bye","their"};
  }
}
}