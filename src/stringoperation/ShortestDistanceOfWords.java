package stringoperation;

public class ShortestDistanceOfWords
{
  // CC150 18.5
  public static int shortest(String[] words, String word1, String word2)
  {
    int min = Integer.MAX_VALUE;
    int lastPosWord1 = -1;
    int lastPosWord2 = -1;
    for (int i = 0 ; i < words.length ; i++) {
      String currentWord = words[i];
      if (currentWord.equals(word1)) {
        lastPosWord1 = i;
        // Comment following 3 lines if word order matters
        int distance = lastPosWord1 - lastPosWord2;
        if (lastPosWord2 >= 0 && min > distance) {
          min = distance;
        }
      }
      else if (currentWord.equals(word2)) {
        lastPosWord2 = i;
        int distance = lastPosWord2 - lastPosWord1;
        if (lastPosWord1 >= 0 && min > distance) {
          min = distance;
        }
      }
    }
    return min;
  }

  public static String wordAtLocation(String[] words, int loc)
  {
    if (loc < 0 || loc >= words.length) {
      return null;
    }
    return words[loc];
  }

  // Method to confirm other result
  public static boolean searchConfirm(String[] words, String word1,
      String word2, int distance)
  {
    boolean found_at_distance = false;
    for (int i = 0 ; i < words.length ; i++) {
      if (words[i].equals(word1)) {
        for (int j = 1 ; j < distance ; j++) {
          String loc2a = wordAtLocation(words, i - j);
          String loc2b = wordAtLocation(words, i + j);
          if (word2.equals(loc2a) || word2.equals(loc2b)) {
            return false;
          }
        }

        String loc2a = wordAtLocation(words, i - distance);
        String loc2b = wordAtLocation(words, i + distance);
        if (word2.equals(loc2a) || word2.equals(loc2b)) {
          found_at_distance = true;
        }
      }
    }
    return found_at_distance;
  }

  public static String getLongTextBlob()
  {
    String book = "As they rounded a bend in the path that ran beside the river, Lara recognized the silhouette of a fig tree atop a nearby hill. The weather was hot and the days were long. The fig tree was in full leaf, but not yet bearing fruit. "
        + "Soon Lara spotted other landmarks—an outcropping of limestone beside the path that had a silhouette like a man’s face, a marshy spot beside the river where the waterfowl were easily startled, a tall tree that looked like a man with his arms upraised. They were drawing near to the place where there was an island in the river. The island was a good spot to make camp. They would sleep on the island tonight."
        + "Lara had been back and forth along the river path many times in her short life. Her people had not created the path—it had always been there, like the river—but their deerskin-shod feet and the wooden wheels of their handcarts kept the path well worn. Lara’s people were salt traders, and their livelihood took them on a continual journey. ";
    String book_mod = book.replace('.', ' ').replace(',', ' ')
        .replace('-', ' ');
    return book_mod;
  }

  public static String[] getLongTextBlobAsStringList()
  {
    return getLongTextBlob().split(" ");
  }

  public static void main(String[] args)
  {
    String[] wordlist = getLongTextBlobAsStringList();

    String[][] pairs = { { "Lara", "the" }, { "river", "life" },
        { "path", "their" }, { "life", "a" } };
    for (String[] pair : pairs) {
      String word1 = pair[0];
      String word2 = pair[1];
      int distance = shortest(wordlist, word1, word2);
      boolean confirm = searchConfirm(wordlist, word1, word2, distance);
      System.out.println("Distance between <" + word1 + "> and <" + word2
          + ">: " + distance + " (" + confirm + ")");
    }
  }
}
