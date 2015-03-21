package array;

public class RemoteSequence
{/*
  * Given the English alphabet, 'a' through 'z' (lowercase), and an imaginary
  * onscreen keyboard with the letters laid out in 6 rows and 5 columns:
  * a b c d e
  * f g h i j
  * k l m n o
  * p q r s t
  * u v w x y
  * z
  * Using a remote control - (up - 'u', down 'd', left 'l', right 'r' and enter
  * '!'), write a function that given a word will produce the sequence of key
  * presses required to type out the word on the onscreen keyboard. The function
  * should return the sequence string.
  */

  public static void main(String[] args)
  {

    System.out.println(generateRemoteSequence("zebra"));

  }

  static String generateRemoteSequence(String word)
  {

    word = word.toLowerCase();

    StringBuffer sequence = new StringBuffer();

    int current_x = 0, current_y = 0;

    for (Character c : word.toCharArray()) {

      int location = c - 'a';

      int x = location % 5;
      int y = location / 5;

      char horizontal = current_x < x
                                     ? 'r'
                                     : 'l';
      char vertical = current_y < y
                                   ? 'd'
                                   : 'u';

      for (int i = 0 ; i < Math.abs(current_x - x) ; i++) {
        sequence.append(horizontal);
      }

      for (int i = 0 ; i < Math.abs(current_y - y) ; i++) {
        sequence.append(vertical);
      }

      sequence.append('!');

      current_x = x;
      current_y = y;

    }

    return sequence.toString();

  }

}
