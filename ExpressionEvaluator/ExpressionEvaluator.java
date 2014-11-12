import java.util.*;

public class ExpressionEvaluator {
	
	public static void main ( String [] args ) throws Exception {
		CustomizedStack cs = new CustomizedStack ();
		for ( int i = 0; i < args.length; i++ ) {
			cs.push ( ( args [ i ] ) );
			if ( args [ i ].matches ( "[ + -- x / % ]") ) {
				String operator = cs.pop ();
				operate ( cs, operator );
			}
			System.out.println ( cs.toString() );
		} 
		System.out.println ( cs.top.item );
	}
	
	public static void operate ( CustomizedStack cs, String operation ) {
		int second = Integer.parseInt ( cs.pop() );
		int first = Integer.parseInt ( cs.pop() );
		StringBuilder result = new StringBuilder ();

		if ( operation.equals ( "+" ) ) {
			result.append ( first + second );
		}
		else if ( operation.equals ( "-" ) ) {
			result.append ( first - second );
		}
		else if ( operation.equals ( "x" ) ) {
			result.append ( first * second );
		}
		else if ( operation.equals ( "/" ) ) {
			result.append ( first / second );
		}
		else if ( operation.equals ( "%" ) ) {
			result.append ( first % second );
		}
		cs.push ( result.toString() );
	}

	public static class CustomizedStack {

		private Node top;

		private class Node {
			public String item;
			public Node next;

			public Node ( String item, Node next ) {
				this.item = item;
				this.next = next;
			}
		}

		/** Empty CustomizedStack constructor. */
		public CustomizedStack () {
			this.top = null;
		}

		/** Removes and returns the top string of the stack. */
		public String pop () {
			String str = this.top.item;
			this.top = this.top.next;
			return str;
		} 

		/** Inserts a string to the top of the stack. */
		public void push ( String s ) {
			this.top = new Node ( s, this.top );
		}

		/** Returns a string representation of the stack. */
		public String toString () {
			String result = "";
			for ( Node node = this.top; node != null; node = node.next ) {
				result += ( node.next == null ) ? ( "|" + "\u005F" + node.item + "\u005F" + "|" + "\n") : ("| " + node.item + " |" + "\n");
			}
			return result;
		}
	}
}