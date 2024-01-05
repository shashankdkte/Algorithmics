/**
 * Given two strings s and t return true 
 * if t is an anagram of s and false otherwise
 * An anagram is a word or phrase formed by rearranging the letters
 * of different word or phrase
 * typically using all the original letters exactly once
 * Input:
 *    s = "race"
 *    t = "care"
 * Output
 *    True
 * 
 * Input:
 *    s="heart"
 *    t="earth"
 * Output 
 *    True
 * 
 * Input:
 *    s="tulip"
 *    t="lipid"
 * Output:
 *      False
 */


 /**O(n)
  * HashMap<Character,Integer> hm = new HashMap<>()
  * for i=0 to s.length
  *     if(hm.containsKey(s.charAt(i)))
  *         hm.put(s.charAt(i), hm.get(s.charAt(i)) + 1)
  *      else
  *         hm.put(s.charAt(i), 1)
  *
  * for i=0 to t.length
  *     if(hm.get(t.charAt(i)))
  *         hm.put(t.charAt(i), t.get(s.charAt(i)) - 1)
  *          if(hm.get(t.charAt(i)) == 0)
  *             hm.remove(t.charAt(i))
  *      else
  *         return false
  * if hm.isEmpty()
  *     return true
  *
  */


  import java.util.*;

class ValidAnagram {

  public static boolean isAnagram(String a, String b) {
    if(a.length() != b.length())
    {
      return false;
    }
    HashMap<Character, Integer> map = new HashMap<>();
    
    for (int i = 0; i < a.length(); i++) {
      char ch = a.charAt(i);
      if (map.containsKey(ch)) {
        map.put(ch, map.get(ch) + 1);
      } else {
        map.put(ch, 1);
      }
    }

    for (int i = 0; i < b.length(); i++) {
      char ch = b.charAt(i);
      if (map.get(ch) != (null)) {
        if (map.get(ch) == 1) {
          map.remove(ch);
        } else {
          map.put(ch, map.get(ch) - 1);
        }
      } else {
        return false;
      }
    }

    return map.isEmpty();
  }

  public static void main(String[] args) {
    String s = "race";
    String t = "care";
    System.out.println(isAnagram(s, t));
  }
}