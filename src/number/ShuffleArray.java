package number;

import java.util.Random;

public class ShuffleArray
{ // CC150 18.2
  public static void shuffle(int[] cards)
  {
    int temp, index;
    for (int i = 0 ; i < cards.length ; i++) {
      index = (int) (Math.random() * (cards.length - i)) + i;
      temp = cards[i];
      cards[i] = cards[index];
      cards[index] = temp;
    }
  }
  
//Implementing Fisher¨CYates shuffle
 static void shuffleArray(int[] ar)
 {
   Random rnd = new Random();
   for (int i = ar.length - 1; i >= 0; i--)
   {
     int index = rnd.nextInt(i + 1);
     // Simple swap
     int a = ar[index];
     ar[index] = ar[i];
     ar[i] = a;
   }
 }

  // CC150 18.3
  public static int rand(int lower, int higher)
  {
    return lower + (int) (Math.random() * (higher - lower + 1));
  }

  public static int[] pickMRandomly(int[] original, int m)
  {
    int[] subset = new int[m];
    int[] array = original.clone();
    for (int j = 0 ; j < m ; j++) {
      int index = rand(j, array.length - 1);
      subset[j] = array[index];
      array[index] = array[j];
    }
    return subset;
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub

  }

}
