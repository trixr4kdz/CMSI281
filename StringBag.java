/** Class StringBag extends Arraylist and implements SimpleCollection. */

import java.util.ArrayList;

public class StringBag extends java.util.ArrayList implements SimpleCollection {

    /** StringBag constructor without parameters. */
    private StringBag () {
        super ();
    }

	/** StringBag constructor using array of objects as parameter. */
	private StringBag ( String [] s ) {
        super ();
    }

	/** Ensures that this collection contains the specified element (optional operation). */
    public boolean add ( Object o ) {
        if ( o instanceof String ) {
    	   return this.add ( ( String ) o );
        }
        return false;
    }
    
    /** Removes all of the elements from this collection (optional operation). */
    public void clear () {
    	this.clear ();
    }
    
    /** Returns true if this collection contains the specified element. */
    public boolean contains ( Object o ) {
    	return this.contains ( ( String ) o );
    }

    /** Returns true if this collection contains no elements. */
   	public boolean isEmpty () {
    	return this.isEmpty();
    }

    /** Removes a single instance of the specified element from this collection, if it is present. */
    public boolean remove ( Object o ) {
        return this.remove ( ( String ) o );
    }
    
    /** Returns the number of elements in this collection. */
    public int size() {
       return this.size();
    }
    
    /** Returns an array containing all of the elements in this collection. */
    public Object[] toArray() {
        return this.toArray();
    }

    /** Returns a string representation of StringBag. */
  	public String toString () {
    	String result = "";
    	for ( int i = 0; i < this.size (); i++ ) {
    		result += "" + this.get ( i );
    		if ( i < this.size() - 1 ) {
                result += ", ";
            }
    	}
    	return "[" + result + "]";
    }

    public static void main ( String [] args ) {
    	StringBag sb = new StringBag ( args );
    	//sb.clear();
    	//System.out.println ( sb.toString () );
    	System.out.println ( sb.isEmpty () );
    	System.out.println ( sb.add ( "dog" ) );
    }
}