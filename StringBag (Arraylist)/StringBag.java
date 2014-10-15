/** This is a concrete class called StringBag that uses ArrayList and implements the methods in the interface SimpleCollection. */

import java.util.ArrayList;

public class StringBag implements SimpleCollection {

	private ArrayList < String > stringArr;

    /** Stringbag constructor using array of strings as parameter. */
    private StringBag ( String [] s ) {
        this.stringArr = new ArrayList < String > ( s.length );
        for ( int i = 0; i < s.length; i++ ) {
        	this.stringArr.add ( s [ i ] ) ;
        }
    }

	/** Ensures that this collection contains the specified element (optional operation). */
    public boolean add ( Object o ) {
    	boolean changed = false;
    	if ( o instanceof String ) {
    		changed = this.stringArr.add ( ( String ) o );
    	}
    	return changed;
    }
    
    /** Removes all of the elements from this collection (optional operation). */
    public void clear() {
    	this.stringArr.clear ();
    }
    
    /** Returns true if this collection contains the specified element. */
    public boolean contains ( Object o ) {
        if ( o instanceof String ) {
    	   return this.stringArr.contains ( ( String ) o );
        }
        return false;
    }

    /** Returns true if this collection contains no elements. */
    public boolean isEmpty () {
    	return this.stringArr.isEmpty();
    }

    /** Removes a single instance of the specified element from this collection, if it is present. */
    public boolean remove ( Object o ) {
        if ( o instanceof String ) {
            return this.stringArr.remove ( ( String ) o );
        }
        return false;
    }
    
    /** Returns the number of elements in this collection. */
    public int size() {
       return this.stringArr.size();
    }
    
    /** Returns an array containing all of the elements in this collection. */
    public Object[] toArray() {
        return this.stringArr.toArray();
    }

    /** Returns a string representation of StringBag. */
    public String toString () {
    	String result = "";
    	for ( int i = 0; i < this.stringArr.size(); i++ ) {
    		result += "" + this.stringArr.get ( i );
    		if ( i < this.stringArr.size() - 1 ) {
                result += ", ";
            }
    	}
    	return "[" + result + "]";
    }
}
