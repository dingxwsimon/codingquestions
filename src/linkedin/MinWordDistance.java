package linkedin;

public class MinWordDistance
{
  
  /* This class will be given a list of words (such as might be tokenized
   * from a paragraph of text), and will provide a method that takes two
   * words and returns the shortest distance (in words) between those two
   * words in the provided text. 
   * Example:
   *   WordDistanceFinder finder = new WordDistanceFinder(Arrays.asList("the", "quick", "brown", "fox", "quick"));
   *   assert(finder.distance("fox","the") == 3);
   *   assert(finder.distance("quick", "fox") == 1);
   */
  
  static int Distance(String[] words, String word1, String word2)
  {
      int min = words.length;
      int last1 = -1;
      int last2 = -1;

      for (int i = 0; i < words.length; i++)
      {
          if (words[i] == word1) last1 = i;
          if (words[i] == word2) last2 = i;

          if ((words[i] == word1 || words[i] == word2) 
              && (last1 != -1 && last2 != -1))
          {
              int newDist = Math.abs(last1 - last2);
              min = Math.min(newDist, min);
          }
      }
      return min;
  }
}
