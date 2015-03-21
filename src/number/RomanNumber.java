package number;

import java.util.HashMap;

public class RomanNumber
{

  // int to roman
  public String intToRoman(int num)
  {
    // Start typing your Java solution below
    // DO NOT write main() function
    if (num == 0) return "";
    HashMap<Integer, String> map = new HashMap<Integer, String>();
    setup(map);
    int[] dig = new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4,
        1 };
    String result = "";
    for (int i = 0 ; i < dig.length ; i++) {
      int pivot = dig[i];
      while (num - pivot >= 0) {
        result += map.get(pivot);
        num -= pivot;
      }
    }
    return result;
  }

  public void setup(HashMap<Integer, String> map)
  {
    map.put(1, "I");
    map.put(4, "IV");
    map.put(5, "V");
    map.put(9, "IX");
    map.put(10, "X");
    map.put(40, "XL");
    map.put(50, "L");
    map.put(90, "XC");
    map.put(100, "C");
    map.put(400, "CD");
    map.put(500, "D");
    map.put(900, "CM");
    map.put(1000, "M");
  }

  // roman to int
  private HashMap<Character, Integer> map;

  public int romanToInt(String s)
  {
    // Start typing your Java solution below
    // DO NOT write main() function
    map = new HashMap<Character, Integer>();
    map.put('I', 1);
    map.put('V', 5);
    map.put('X', 10);
    map.put('L', 50);
    map.put('C', 100);
    map.put('D', 500);
    map.put('M', 1000);
    int result = 0;
    for (int i = 0 ; i < s.length() ; i++) {
      result += sign(s, i) * map.get(s.charAt(i));
    }
    return result;
  }

  public int sign(String s, int i)
  {
    if (i == s.length() - 1) return 1;
    if (map.get(s.charAt(i + 1)) > map.get(s.charAt(i))) return -1;
    return 1;
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub

  }

}
