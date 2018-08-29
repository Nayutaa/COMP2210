//import java.util.Arrays;

/**
* Defines a library of selection methods
* on arrays of ints.
*
* @author   Boyang Yu (bzy0015@auburn.edu)
* @author   Dean Hendrix (dh@auburn.edu)
* @version  08/24/2018
*
*/
public final class Selector {

   /**
    * Can't instantiate this class.
    *
    * D O   N O T   C H A N G E   T H I S   C O N S T R U C T O R
    *
    */
   private Selector() { }


   /**
    * Selects the minimum value from the array a. This method
    * throws IllegalArgumentException if a is null or has zero
    * length. The array a is not changed by this method.
    * @param a is the array.
    * @return the min
    */
   public static int min(int[] a) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      else {
         int min = a[0];
         for (int i = 1; i < a.length; i++) {
            if (min > a[i]) {
               min = a[i];
            }
         }
         return min;
      }
   }


   /**
    * Selects the maximum value from the array a. This method
    * throws IllegalArgumentException if a is null or has zero
    * length. The array a is not changed by this method.
    * @param a is the array
    * @return the max
    */
   public static int max(int[] a) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      else {
         int max = a[0];
         for (int i = 1; i < a.length; i++) {
            if (max < a[i]) {
               max = a[i];
            }
         }
         return max;
      }
   }


   /**
    * Selects the kth minimum value from the array a. This method
    * throws IllegalArgumentException if a is null, has zero length,
    * or if there is no kth minimum value. Note that there is no kth
    * minimum value if k < 1, k > a.length, or if k is larger than
    * the number of distinct values in the array. The array a is not
    * changed by this method.
    * @param a the array
    * @param k the k value
    * @return the kmin
    */
   public static int kmin(int[] a, int k) {
      return -99;
   }


   /**
    * Selects the kth maximum value from the array a. This method
    * throws IllegalArgumentException if a is null, has zero length,
    * or if there is no kth maximum value. Note that there is no kth
    * maximum value if k < 1, k > a.length, or if k is larger than
    * the number of distinct values in the array. The array a is not
    * changed by this method.
    * @param a is the array
    * @param k is the k value
    * @return the k th max
    */
   public static int kmax(int[] a, int k) {
      return -99;
   }


   /**
    * Returns an array containing all the values in a in the
    * range [low..high]; that is, all the values that are greater
    * than or equal to low and less than or equal to high,
    * including duplicate values. The length of the returned array
    * is the same as the number of values in the range [low..high].
    * If there are no qualifying values, this method returns a
    * zero-length array. Note that low and high do not have
    * to be actual values in a. This method throws an
    * IllegalArgumentException if a is null or has zero length.
    * The array a is not changed by this method.
    * @param a is the array
    * @param low is the low
    * @param high is the high
    * @return the range
    */
   public static int[] range(int[] a, int low, int high) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      else {
         int count = 0;
         for (int i:a) {
            if (i >= low && i <= high) {
               count++;
            }
         }
         int[] b = new int[count];
         int id = 0;
         for (int i:a) {
            if (i >= low && i <= high) {
               b[id] = i;
               id++;
            }
         }
         return b;
      }
   }


   /**
    * Returns the smallest value in a that is greater than or equal to
    * the given key. This method throws an IllegalArgumentException if
    * a is null or has zero length, or if there is no qualifying
    * value. Note that key does not have to be an actual value in a.
    * The array a is not changed by this method.
    * @param a the array
    * @param key the key
    * @return the ceiling
    */
   public static int ceiling(int[] a, int key) {
      if (a == null || a.length == 0 || key > max(a)) {
         throw new IllegalArgumentException();
      }
      else {
         int[] b = new int[a.length];
         int count = 0;
         int countt = 0;
         for (int i:a) {
            b[count] = key - i;
            count++;
         }
         for (int i:b) {
            if (i <= 0) {
               countt++;
            }
         }
         int[] c = new int[countt];
         int id = 0;
         for (int i:b) {
            if (i <= 0) {
               c[id] = i;
               id++;
            }
         }
         int max = c[0];
         for (int i:c) {
            if (i > max) {
               max = i;
            }
         }
         return key - max;
      }
   }


   /**
    * Returns the largest value in a that is less than or equal to
    * the given key. This method throws an IllegalArgumentException if
    * a is null or has zero length, or if there is no qualifying
    * value. Note that key does not have to be an actual value in a.
    * The array a is not changed by this method.
    * @param a is the array
    * @param key is the key
    * @return the floor
    */
   public static int floor(int[] a, int key) {
      if (a == null || a.length == 0 || key < min(a)) {
         throw new IllegalArgumentException();
      }
      else {
         int[] b = new int[a.length];
         int count = 0;
         int countt = 0;
         for (int i:a) {
            b[count] = key - i;
            count++;
         }
         for (int i:b) {
            if (i >= 0) {
               countt++;
            }
         }
         int[] c = new int[countt];
         int id = 0;
         for (int i:b) {
            if (i >= 0) {
               c[id] = i;
               id++;
            }
         }
         int min = c[0];
         for (int i:c) {
            if (i < min) {
               min = i;
            }
         }
         return key - min;
      }
   }

}
