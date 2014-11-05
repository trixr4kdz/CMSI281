/** This is a class called WordSort that arranges a .txt file alphabetically and sends it to standard output. Only letters are recognized and any other character is ignored or used as a delimiter. Words that repeat are counted.
*/

import java.io.*;
import java.util.*;

public class WordSort {

	private static ArrayList < String > strArr;
	
	public static void main ( String [] args ) throws IOException {
		BufferedReader stdIn = new BufferedReader ( new InputStreamReader ( System.in ) );
		String s = stdIn.readLine();
		strArr = new ArrayList < String > ();

		if ( args.length == 1 && args [ 0 ].equals ( "-sensitive" ) ) {
			while ( s != null ) {
				processSensitive ( s );
				s = stdIn.readLine();
			}
			print();
		}

		else {
			while ( s != null ) {
				process ( s );
				s = stdIn.readLine();
			}
			print();
		}
	}

	/** Separates a String object into words. */
	public static void processSensitive ( String s ) {
		String allChar = s.replaceAll ( "[^a-z A-Z]" , " " );
		String [] words = allChar.split ( " " );
		for ( int i = 0; i < words.length; i++ ) {
			if ( !words [ i ].equals("") ) {
				strArr.add ( words [ i ] );
			}
		}
	}

	/** Separates a String object into all uppercase words. */
	public static void process ( String s ) {
		processSensitive ( s.toUpperCase() );
	}

	/** Prints out the words in alphabetical order using the Collections.sort() method */
	public static void print () {
		int frequency = 1;
		Collections.sort ( strArr );
		for ( int i = 1; i < strArr.size(); i++ ) {
			if ( strArr.get ( i ).equals ( strArr.get ( i - 1 ) ) ) {
				frequency++;
			}
			else {
				System.out.println (  "(" + frequency + ")" + " " +  strArr.get ( i - 1 ) );
				frequency = 1;
			}
		}
	}
}