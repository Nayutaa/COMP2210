import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Provides an implementation of the Set interface.
 * A doubly-linked list is used as the underlying data structure.
 * Although not required by the interface, this linked list is
 * maintained in ascending natural order. In those methods that
 * take a LinkedSet as a parameter, this order is used to increase
 * efficiency.
 * @author Boyang Yu
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2018-10-04
 * @param <T> is valble.
 *
 */
public class LinkedSet<T extends Comparable<? super T>> implements Set<T> {

    //////////////////////////////////////////////////////////
    // Do not change the following three fields in any way. //
    //////////////////////////////////////////////////////////

    /** References to the first and last node of the list. */
   Node front;
   Node rear;

    /** The number of nodes in the list. */
   int size;

    /////////////////////////////////////////////////////////
    // Do not change the following constructor in any way. //
    /////////////////////////////////////////////////////////

    /**
     * Instantiates an empty LinkedSet.
     */
   public LinkedSet() {
      front = null;
      rear = null;
      size = 0;
   }


    //////////////////////////////////////////////////
    // Public interface and class-specific methods. //
    //////////////////////////////////////////////////

    ///////////////////////////////////////
    // DO NOT CHANGE THE TOSTRING METHOD //
    ///////////////////////////////////////
    /**
     * Return a string representation of this LinkedSet.
     *
     * @return a string representation of this LinkedSet
     */
   @Override
   public String toString() {
      if (isEmpty()) {
         return "[]";
      }
      StringBuilder result = new StringBuilder();
      result.append("[");
      for (T element : this) {
         result.append(element + ", ");
      }
      result.delete(result.length() - 2, result.length());
      result.append("]");
      return result.toString();
   }


    ///////////////////////////////////
    // DO NOT CHANGE THE SIZE METHOD //
    ///////////////////////////////////
    /**
     * Returns the current size of this collection.
     *
     * @return  the number of elements in this collection.
     */
   public int size() {
      return size;
   }

    //////////////////////////////////////
    // DO NOT CHANGE THE ISEMPTY METHOD //
    //////////////////////////////////////
    /**
     * Tests to see if this collection is empty.
     *
     * @return  true if this collection contains no elements, false otherwise.
     */
   public boolean isEmpty() {
      return (size == 0);
   }


    /**
     * Ensures the collection contains the specified element. Neither duplicate
     * nor null values are allowed. This method ensures that the elements in the
     * linked list are maintained in ascending natural order.
     *
     * @param  element  The element whose presence is to be ensured.
     * @return true if collection is changed, false otherwise.
     */
   public boolean add(T element) {
      if (element == null) {
         return false;
      }
      else {
         Node current = new Node(element);
         if (this.size() == 0) {
            front = current;
            rear = current;
            size++;
            return true;
         }
         else {
            Node pointer = front;
            for (int i = 0; i < size; i++) {
               if (current.element.compareTo(pointer.element) == 0) {
                  return false;
               }
               else if (current.element.compareTo(pointer.element) < 0) {
                  current.prev = pointer.prev;
                  current.next = pointer;
                  if (pointer != front) {
                     pointer.prev.next = current;
                  }
                  pointer.prev = current;
                  if (current.prev == null) {
                     front = current;
                  }
                  size++;
                  return true;
               }
               if (size - i > 1) {
                  pointer = pointer.next;
               }
            }
            pointer.next = current;
            current.prev = pointer;
            rear = current;
            size++;
            return true;
         }
      }
   }
    
    /**
     * Ensures the collection does not contain the specified element.
     * If the specified element is present, this method removes it
     * from the collection. This method, consistent with add, ensures
     * that the elements in the linked lists are maintained in ascending
     * natural order.
     *
     * @param   element  The element to be removed.
     * @return  true if collection is changed, false otherwise.
     */
   public boolean remove(T element) {
      if (element == null) {
         return false; 
      }
      else {
         Node pointer = front;
         for (int i = 0; i < this.size(); i++) {
            if (pointer.element.compareTo(element) == 0) {
               if (pointer == front && pointer != rear) {
                  pointer.next.prev = null;
                  front = pointer.next;
                  size--;
                  return true;
               }
               else if (pointer != front && pointer == rear) {
                  pointer.prev.next = null;
                  rear = pointer.prev;
                  size--;
                  return true;
               }
               else if (pointer != front) {
                  pointer.prev.next = pointer.next;
                  pointer.next.prev = pointer.prev;
                  size--;
                  return true;
               }
               else {
                  front = null;
                  rear = null;
                  size--;
                  return true;
               }
            }
            if (size - i > 1) {
               pointer = pointer.next;
            }
         }
         return false;
      }
   }
    /**
     * Searches for specified element in this collection.
     *
     * @param   element  The element whose presence in this collection is to
     * @return  true if this collection contains the specified element
     */
     
   public boolean contains(T element) {
      if (element == null) {
         return false;
      }
      Node pointer = front;
      for (int i = 0; i < size; i++) {
         if (pointer.element.compareTo(element) == 0) {
            return true;
         }
         if (size - i > 1) {
            pointer = pointer.next;
         }
      }
      return false;
   }


    /**
     * Tests for equality between this set and the parameter set.
     * Returns true if this set contains exactly the same elements
     * as the parameter set, regardless of order.
     * @param s is the set.
     * @return  true if this set contains exactly the same elements as
     *               the parameter set, false otherwise
     */
   public boolean equals(Set<T> s) {
      if (s.size() != this.size()) {
         return false;
      }
      Node pointer = front;
      for (int i = 0; i < size; i++) {
         if (!s.contains(pointer.element)) {
            return false;
         }
         pointer = pointer.next;
      }
      return true;
   }


    /**
     * Tests for equality between this set and the parameter set.
     * Returns true if this set contains exactly the same elements
     * as the parameter set, regardless of order.
     * 
     * @return  true if this set contains exactly the same elements as
     *               the parameter set, false otherwise
     * 
     */
   public boolean equals(LinkedSet<T> s) {
      if (s.size() != this.size()) {
         return false;
      }
      Node pointer = front;
      Node pointer2 = s.front;
      for (int i = 0; i < size; i++) {
         if (pointer.element.compareTo(pointer2.element) != 0) {
            return false;
         }
         pointer = pointer.next;
         pointer2 = pointer2.next;
      }
      return true;
   }


    /**
     * Returns a set that is the union of this set and the parameter set.
     * @param s is the set.
     * @return  a set that contains all the elements of
     * 
     */
   public Set<T> union(Set<T> s) {
      if (s == null) {
         throw new IllegalArgumentException();
      }
      Set<T> combo = new LinkedSet<>();
      Node pointer = front;
      Iterator<T> iterate = s.iterator(); 
   
      for (int i = 0; i < size; i++) {
         combo.add(pointer.element);
         pointer = pointer.next;
      }
   
      for (int i = 0; i < s.size(); i++) {
         combo.add(iterate.next());
      }
      return combo;
   }


    /**
     * Returns a set that is the union of this set and the parameter set.
     * @param s is the set.
     * @return  a set that contains all
     */
   public Set<T> union(LinkedSet<T> s) {
      if (s == null) {
         throw new NullPointerException();
      }
      LinkedSet<T> set = new LinkedSet<T>();
      Node n = front;
      while (n != null) {
         set.add(n.element);
         n = n.next;
      }
      Iterator<T> i = s.iterator();
   
      while (i.hasNext()) {
         set.add(i.next());
      }
      return set;
   }


    /**
     * Returns a set that is the intersection of this set and the parameter set.
     * @param s is the set.
     * @return  a set that contains elements that are
     */
   public Set<T> intersection(Set<T> s) {
      LinkedSet<T> i = new LinkedSet<T>();
      
      Iterator<T> scan = s.iterator();
      
      while (scan.hasNext()) {
         T o = scan.next();
         if (contains(o)) {
            i.add(o);
         }
      }
      
      return i;
   }

    /**
     * Returns a set that is the intersection of this set and
     * the parameter set.
     * @param s is the set.
     * @return  a set that contains elements that are in both
     *            this set and the parameter set

     */
   public Set<T> intersection(LinkedSet<T> s) {
      LinkedSet<T> i = new LinkedSet<T>();
      
      Iterator<T> scan = s.iterator();
      
      while (scan.hasNext()) {
         T o = scan.next();
         if (contains(o)) {
            i.add(o);
         }
      }
      return i;
   }


    /**
     * Returns a set that is the complement 
     * of this set and the parameter set.
     * @param s is the set.
     * @return  a set that contains elements
     */
   public Set<T> complement(Set<T> s) {
      if (s == null) {
         throw new NullPointerException();
      }
      LinkedSet<T> c = new LinkedSet<T>();
      Node n = front;
      while (n != null) {   
         if (!s.contains((T)n.element)) {
            c.add((T)n.element);
         }
         n = n.next;
      }
      return c;
   }


    /**
     * Returns a set that is the complement of this set and
     * the parameter set.
     * @param s is the set.
     * @return  a set that contains elements that are in this
     *            set but not the parameter set
     */
   public Set<T> complement(LinkedSet<T> s) {
      if (s == null) {
         throw new NullPointerException();
      }
      LinkedSet<T> c = new LinkedSet<T>();
      Node n = front;
      while (n != null) {   
         if (!s.contains((T)n.element)) {
            c.add((T)n.element);
         }
         n = n.next;
      }
      return c;
   }


    /**
     * Returns an iterator over the elements in this LinkedSet.
     * Elements are returned in ascending natural order.
     *
     * @return  an iterator over the elements in this LinkedSet
     */
   public Iterator<T> iterator() {
      Iterator<T> fwd = 
         new Iterator<T>() {
            private Node n = front;
            
            @Override
            public boolean hasNext() {
               return (n != null);
            }
            
            @Override
            public T next() {
               T loc = n.element;
               n = n.next;
               return loc;
            }
            
            @Override
            public void remove() {
               throw new UnsupportedOperationException();
            }
         };
      return fwd;
   }


    /**
     * Returns an iterator over the elements in this LinkedSet.
     * Elements are returned in descending natural order.
     *
     * @return  an iterator over the elements in this LinkedSet
     */
   public Iterator<T> descendingIterator() {
      Iterator<T> bkwd =
         new Iterator<T>() {
            private Node n = rear;
            
            @Override
            public boolean hasNext() {
               return (n != null);
            }
            
            @Override
            public T next() {
               T loc = n.element;
               n = n.prev;               
               return loc;
            }
            
            @Override
            public void remove() {
            
               throw new UnsupportedOperationException();
               
            }
         };
      return bkwd;
   }


    /**
     * Returns an iterator over the members of the power set
     * of this LinkedSet. No specific order can be assumed.
     *
     * @return  an iterator over members of the power set
     */
   public Iterator<Set<T>> powerSetIterator() {
      
      return new PowerIterator(front, size);
   }



    //////////////////////////////
    // Private utility methods. //
    //////////////////////////////

    // Feel free to add as many private methods as you need.
    
   private Node locate(T element) {
      Node n = front;
      while (n != null) {
         if (n.element.equals(element)) {
            return n;
         }
         n = n.next;
      }
      return null;
   }
   
   private int length(Node n) {
      Node p = n;
      int len = 0; 
      while (p != null) {
         len++;
         p = p.next;
      }
      return len; 
   }

    ////////////////////
    // Nested classes //
    ////////////////////
    /**
     *@param Iterator the inithl iterator.
     *
     *
     */
   class LinkedSetItr implements Iterator<T> {
      private Node current = front;
      
      public boolean hasNext() {
         return current != null;
      }
      
      public T next() {
         if (!hasNext()) {
            throw new NoSuchElementException();
         }
         
         T result = current.element;
         current = current.next;
         return result;
         
      }
      
      public void remove() {
         throw new UnsupportedOperationException();
      } 
   }
   /**
    *@param Iterator.
    */
    
   class LinkedDesItr implements Iterator<T> {
      private Node last = rear;
      
      public boolean hasNext() {
         return last != null;
      }
      
      public T next() {
         if (!hasNext()) {
            throw new NoSuchElementException();
         }
         
         T result = last.element;
         last = last.prev;
         return result;  
      }
      
      public void remove() {
         throw new UnsupportedOperationException();
      }
   }
   /**
    *@param Iterator.
    */
    
   private class PowerIterator implements Iterator<Set<T>> {
      Node n;
      int c;
      int current;
      int bit = 0;
   
      public PowerIterator(Node frontt, int sizee) {
         n = frontt;
         c = sizee;
         current = 0;
         bit = 0;
      
      }
   
      public boolean hasNext() {
         return (current < (int)Math.pow(2, c));
      
      }
   
      public Set<T> next() {
         Set<T> s = new LinkedSet<T>();
         int m = 1;
         for (int k1 = 0; k1 < c; k1++) {
            if ((bit & m) != 0) {
               s.add(n.element);
               n = n.next;
            }
            else {
               n = n.next;
            }
         }
         
         current++;
         bit = 0;
         n = front;
         return s;
      }
   
      public void remove() {
         throw new UnsupportedOperationException();
      }
   
   }

    //////////////////////////////////////////////
    // DO NOT CHANGE THE NODE CLASS IN ANY WAY. //
    //////////////////////////////////////////////

    /**
     * Defines a node class for a doubly-linked list.
     */
   class Node {
        /** the value stored in this node. */
      T element;
        /** a reference to the node after this node. */
      Node next;
        /** a reference to the node before this node. */
      Node prev;

        /**
         * Instantiate an empty node.
         */
      public Node() {
         element = null;
         next = null;
         prev = null;
      }

        /**
         * Instantiate a node that containts element
         * and with no node before or after it.
         */
      public Node(T e) {
         element = e;
         next = null;
         prev = null;
      }
   }

}
