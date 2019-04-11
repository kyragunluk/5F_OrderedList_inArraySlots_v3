/**
  OrderedList_inArraySlots, holding Integers

  A list with the invariant the elements are in order by
  increasing value, implemented using a
  ArrayList<Integer>
 */

public class OrderedList_inArraySlots
    implements OrderedList {

    private java.util.ArrayList<Integer> list_iAS;


    /**
      @return the index of the first occurrence of
              \findMe in this list, or -1 if
              \findMe is absent from this list.
     */
    public int indexOf( Integer findMe) {
        //return indexOfWhileStyle(findMe,0,list_iAS.size()-1);
        return indexOfRecursive(findMe,0,list_iAS.size()-1);
    }
    public int indexOfWhileStyle( Integer findMe, int lowLimit, int highLimit) {
        while (lowLimit <= highLimit){
            int indexToCheck = (lowLimit+highLimit)/2;
            Integer intInIndex = list_iAS.get(indexToCheck);
            if (intInIndex == findMe){
                return indexToCheck;
            }
            else if (intInIndex > findMe){
                highLimit = indexToCheck - 1;
            }
            else{ lowLimit = indexToCheck+1;}
        }
        return -1;
    }
    public int indexOfRecursive( Integer findMe, int lowLimit, int highLimit) {
        if (lowLimit > highLimit) {return -1;}
        int indexToCheck = (lowLimit+highLimit)/2;
        Integer intInIndex = list_iAS.get(indexToCheck);
        if (intInIndex == findMe){
            return indexToCheck;
        }
        else if (intInIndex > findMe){
            return indexOfRecursive(findMe, lowLimit, indexToCheck - 1);
        }
        else{
            return indexOfRecursive(findMe, indexToCheck+1, highLimit);
          }

    }


    // ------ code from previous assignments below here ----

    public OrderedList_inArraySlots() {
        list_iAS = new java.util.ArrayList<Integer>();
    }

    /**
      @return the number of elements in this list
     */
    public int size(){
        return list_iAS.size();
    }

    /**
      @return a string representation of this Orderedlist_iAS
     */
    public String toString() {
        return list_iAS.toString();
    }


    /**
      Put @value where it belongs in the list.
      @pre: the list is in increasing order
     */
     public boolean add( Integer value) {
         int dest = 0;
         for( ; dest < list_iAS.size() && list_iAS.get( dest) < value
              ; dest++) ;
         // System.out.println( "OL adding " + value
         //                   + " at index " + dest);
         list_iAS.add( dest, value);
         return true;
     }


     /**
      @return element @index from this list
      precondition: @index is within the bounds of the array.
          (Having warned the user about this precondition,
           you should NOT complicate your code to check
           whether the condition was violated.)
     */
    public Integer get( int index ) {
        return list_iAS.get( index);
    }


    /**
      Remove the element at position @index in this list.

      Shift any subsequent elements to the left (that is,
      decrease the index associated with each).

      @return the value that was removed from the list
     */
    public Integer remove( int index) {
        return list_iAS.remove( index);
    }
}
