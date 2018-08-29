/**
 * Applies the linear scan strategy to counting the number of negative
 * values in an array.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2017-08-22
 */
public class CountNegatives {
   /**
    * Returns the number of negative values in the given array.
    * @param a is the return item.
    * @return give negative count.
    */
   public static int countNegatives(int[]a) {
      int negativeCount = 0;
      for (int b = 0; b < a.length; b++) {
         if (a[b] < 0) {
            negativeCount++;
         }      
      }
      return negativeCount;
   }
}
