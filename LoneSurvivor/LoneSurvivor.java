public class LoneSurvivor {

	public static void main ( String [] args ) {
      	long n = Long.parseLong ( args [ 0 ] );
		long k = Long.parseLong ( args [ 1 ] );
      	if ( args.length < 2 | n < 0 | k < 1 | k > n ) {
			throw new IllegalArgumentException ();
		}
      	CircularList cl = new CircularList ();
      	for ( long i = 0; i < n; i++ ){
        	cl.insert ( i );
      	}
      	cl.kill ( k );
      	System.out.println ( cl.head.num );
    }

  	private static class CircularList {

  		private class Node {
	    	public long num;
	    	public Node next;

	  		public Node ( long num, Node next ) {
	      		this.num = num;
	      		this.next = next;
	    	}
		}

    	private Node head;
    	private long size;

  		public CircularList () {
      		this.head = null;
      	}

      	public void insert ( long num ) {
       		Node newNode = new Node ( num, null );
       		if ( this.head == null ) {
          		this.head = newNode;
          		newNode.next = newNode;
        	}
        	else {
          		Node cursor = this.head;
          		for ( Node n = cursor; cursor.next != this.head; ) {
        			cursor = cursor.next;
        		}
          		cursor.next = newNode;
        	}
        	newNode.next = this.head;
        	this.size++;
      	}

      	public void remove ( Node node ) {
        	Node cursor = this.head;
        	Node prev = this.head;
        	long num = node.num;
        	for ( Node n = cursor; cursor.num != num; cursor = cursor.next ) {
        		prev = cursor;
        	}
        	prev.next = cursor.next;
        	this.size--;
      	}

    	public void kill ( long k ) {
      		Node cursor = this.head;
      		while ( this.size > 1 ) {
	      		for ( long i = 0; i < k; i++ ) {
	      			cursor = cursor.next;
	      		}
	      		this.head = cursor.next;
	      		remove ( cursor );
	      		cursor = this.head;
	      	}
    	}
    }
}
