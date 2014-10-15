/** Class StringBag extends Arraylist and implements SimpleCollection. */

import java.util.ArrayList;
import java.util.Collection;

public class StringBag extends java.util.ArrayList implements SimpleCollection {

    private ArrayList < String > al;

    /** StringBag constructor with no elements. */
    private StringBag () {
        super ();
    }

    /** StringBag constructor using array of as parameter. */
    private StringBag ( String [] s ) {
        super ();
        for ( int i = 0; i < s.length; i++ ) {
            this.add ( s [ i ] );
        }
    }

    /** StringBag constructor with initial capacity. */
    private StringBag ( int initialCapacity ) {
        super ( initialCapacity );
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
    	System.out.println ( sb.toString () );
    	System.out.println ( sb.contains ( "dog" ) );
    	System.out.println ( sb.add ( "dog" ) );
    }
}