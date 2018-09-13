import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
//import java.util.List;
import java.util.NoSuchElementException;

/**
 * Defines a library of selection methods on Collections.
 *
 * @author  Boyang Yu (you@auburn.edu)
 * @author  Dean Hendrix (dh@auburn.edu)
 * @version 09/12/2018
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
    * Returns the minimum value in the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty, this method throws a
    * NoSuchElementException. This method will not change coll in any way.
    *
    * @param coll    the Collection from which the minimum is selected
    * @param comp    the Comparator that defines the total order on T
    * @param <T> is the arrey list.
    * @return        the minimum value in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T min(Collection<T> coll, Comparator<T> comp) {
      if (coll == null || comp == null) {
         throw new IllegalArgumentException();
      }
      if (coll.isEmpty()) {
         throw new NoSuchElementException();
      }
      else {
         Iterator<T> iter = coll.iterator();
         T min = iter.next();
         T ii = min;
         while (iter.hasNext()) {
            ii = iter.next();
            if (comp.compare(ii, min) < 0) {
               min = ii;
            }
         }
         return min;
      }
   }


   /**
    * Selects the maximum value in the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty, this method throws a
    * NoSuchElementException. This method will not change coll in any way.
    *
    * @param coll    the Collection from which the maximum is selected
    * @param comp    the Comparator that defines the total order on T
    * @param <T> is the array list
    * @return        the maximum value in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T max(Collection<T> coll, Comparator<T> comp) {
      if (coll == null || comp == null) {
         throw new IllegalArgumentException();
      }
      if (coll.size() == 0) {
         throw new NoSuchElementException();
      }
      else {
         Iterator<T> iter = coll.iterator();
         T max = iter.next();
         T ii = max;
         while (iter.hasNext()) {
            ii = iter.next();
            if (comp.compare(ii, max) > 0) {
               max = ii;
            }
         }
         return max;
      }
   }


   /**
    * Selects the kth minimum value from the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty or if there is no kth minimum
    * value, this method throws a NoSuchElementException. This method will not
    * change coll in any way.
    *
    * @param coll    the Collection from which the kth minimum is selected
    * @param k       the k-selection value
    * @param <T> is the array list
    * @param comp    the Comparator that defines the total order on T
    * @return        the kth minimum value in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T kmin(Collection<T> coll, int k, Comparator<T> comp) {
      if (coll == null || comp == null) {
         throw new IllegalArgumentException();
      }
      if (coll.size() == 0 || k < 1 || k > coll.size()) {
         throw new NoSuchElementException();
      }
      else {
         ArrayList<T> list = new ArrayList<T>(coll);
         java.util.Collections.sort(list, comp);
         if (k == 1) {
            return list.get(0);
         } 
         T countt = list.get(0);
         T kmin = null;
         int cou = 1;
         for (int i = 1; i < list.size(); i++) {
            if (!list.get(i).equals(countt)) {
               cou++;
               if (k == cou) {
                  kmin = list.get(i);
               }     
            }
            countt = list.get(i);
         }            
         if (k > cou) {
            throw new NoSuchElementException();
         }
         return kmin;
      }
   }


   /**
    * Selects the kth maximum value from the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty or if there is no kth maximum
    * value, this method throws a NoSuchElementException. This method will not
    * change coll in any way.
    *
    * @param coll    the Collection from which the kth maximum is selected
    * @param k       the k-selection value
    * @param <T> is the array list
    * @param comp    the Comparator that defines the total order on T
    * @return        the kth maximum value in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T kmax(Collection<T> coll, int k, Comparator<T> comp) {
      if (coll == null || comp == null) {
         throw new IllegalArgumentException();
      }
      if (coll.size() == 0 || k < 1 || k > coll.size()) {
         throw new NoSuchElementException();
      }
      else {
         ArrayList<T> list = new ArrayList<T>(coll);
         java.util.Collections.sort(list, comp);
         if (k == 1) {
            return list.get(list.size() - 1);
         }
         int count = 1;
         T countt = list.get(list.size() - 1);
         T kmax = null;
         for (int i = list.size() - 2; i >= 0; i--) {
            if (!list.get(i).equals(countt)) {
               count++;
               if (k == count) {
                  kmax = list.get(i);
               }
            }
            countt = list.get(i);
         }
         if (k > count) {
            throw new NoSuchElementException();
         }
         return kmax;
      }
   }


   /**
    * Returns a new Collection containing all the values in the Collection coll
    * that are greater than or equal to low and less than or equal to high, as
    * defined by the Comparator comp. The returned collection must contain only
    * these values and no others. The values low and high themselves do not have
    * to be in coll. Any duplicate values that are in coll must also be in the
    * returned Collection. If no values in coll fall into the specified range or
    * if coll is empty, this method throws a NoSuchElementException. If either
    * coll or comp is null, this method throws an IllegalArgumentException. This
    * method will not change coll in any way.
    *
    * @param coll    the Collection from which the range values are selected
    * @param low     the lower bound of the range
    * @param high    the upper bound of the range
    * @param <T>     is the array list
    * @param comp    the Comparator that defines the total order on T
    * @return        a Collection of values between low and high
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> Collection<T> range(Collection<T> coll, T low, T high,
                                         Comparator<T> comp) {
      if (coll == null || comp == null) {
         throw new IllegalArgumentException();
      }
      if (coll.isEmpty()) {
         throw new NoSuchElementException();
      }
      else {
         ArrayList<T> range = new ArrayList<T>();
         Iterator<T> iter = coll.iterator();
         while (iter.hasNext()) {
            T i = iter.next();
            if (comp.compare(i, low) >= 0 
               && comp.compare(i, high) <= 0) {
               range.add(i);
            }
         }
         if (range.size() == 0) {
            throw new NoSuchElementException();
         }
         return range;
      }
   }


   /**
    * Returns the smallest value in the Collection coll that is greater than
    * or equal to key, as defined by the Comparator comp. The value of key
    * does not have to be in coll. If coll or comp is null, this method throws
    * an IllegalArgumentException. If coll is empty or if there is no
    * qualifying value, this method throws a NoSuchElementException. This
    * method will not change coll in any way.
    *
    * @param coll    the Collection from which the ceiling value is selected
    * @param key     the reference value
    * @param <T>     is the array list
    * @param comp    the Comparator that defines the total order on T
    * @return        the ceiling value of key in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T ceiling(Collection<T> coll, T key, Comparator<T> comp) {
      if (coll == null || comp == null) {
         throw new IllegalArgumentException();
      }
      if (coll.size() == 0) {
         throw new NoSuchElementException();
      }
      else {
         Iterator<T> iter = coll.iterator();
         ArrayList<T> list = new ArrayList<T>();
         Iterator<T> ite;
         while (iter.hasNext()) {
            T countt = iter.next();
            if (comp.compare(countt, key) >= 0) {
               list.add(countt);
            }
         }
         ite = list.iterator();
         T i = ite.next();
         while (ite.hasNext()) {
            T ii = ite.next();
            if (comp.compare(ii, i) < 0) {
               i = ii;
            }
         }
         if (comp.compare(i, key) < 0) {
            throw new NoSuchElementException();
         }
         return i;
      }
   }


   /**
    * Returns the largest value in the Collection coll that is less than
    * or equal to key, as defined by the Comparator comp. The value of key
    * does not have to be in coll. If coll or comp is null, this method throws
    * an IllegalArgumentException. If coll is empty or if there is no
    * qualifying value, this method throws a NoSuchElementException. This
    * method will not change coll in any way.
    *
    * @param coll    the Collection from which the floor value is selected
    * @param key     the reference value
    * @param <T>     is the array list
    * @param comp    the Comparator that defines the total order on T
    * @return        the floor value of key in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T floor(Collection<T> coll, T key, Comparator<T> comp) {
      if (coll == null || comp == null) {
         throw new IllegalArgumentException();
      }
      if (coll.size() == 0) {
         throw new NoSuchElementException();
      }
      else {
         Iterator<T> iter = coll.iterator();
         ArrayList<T> list = new ArrayList<T>();
         Iterator<T> ite;
         while (iter.hasNext()) {
            T countt = iter.next();
            if (comp.compare(countt, key) <= 0) {
               list.add(countt);
            }
         }
         ite = list.iterator();
         T ii = ite.next();
         while (ite.hasNext()) {
            T i = ite.next();
            if (comp.compare(i, ii) > 0) {
               ii = i;
            }
         }
         if (comp.compare(ii, key) > 0) {
            throw new NoSuchElementException();
         }
         return ii;
      }
   }

}
