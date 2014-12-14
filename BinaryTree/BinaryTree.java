import java.util.*;

/**     
	This is a concrete class called BinaryTree that implements the Collection interface. The add() method inserts a new BinaryTree in Inorder and the Iterator iterates over the tree in Preorder. 
*/

public class BinaryTree implements Collection {

	public static void main ( String [] args ) {
		try {
			BinaryTree bt = new BinaryTree ();
			for ( int i = 0; i < args.length; i++ ) {
				bt.add ( args [ i ] );
			}
			for ( Object o : bt ) {
				System.out.println ( o.toString () );
			}
		}
		catch ( Exception e ) {
			System.out.println ( "BinaryTree is Empty" );
		}
	}

	/** Private instance data for BinaryTree class. */
	private Object rootData;
	private BinaryTree leftSubtree;
	private BinaryTree rightSubtree;
	
	/** BinaryTree constructor with no nodes. */
	public BinaryTree () {
		this.rootData = null;
	}

	/** BinaryTree constructor with only the root. */
	public BinaryTree ( Object root ) {
		this.rootData = root;
	}

	/** BinaryTree constructor with leftSubtree/rightSubtree. */
	public BinaryTree ( Object root, BinaryTree leftSubtree, BinaryTree rightSubtree ) {
		this.rootData = root;
		this.leftSubtree = leftSubtree;
		this.rightSubtree = rightSubtree;
	}

	/** Constructs a BinaryTree from given rootData, leftSubtree, and rightSubtree. */
	public static BinaryTree createFromData ( Object rootData, BinaryTree leftSubtree, BinaryTree rightSubtree ) {
		BinaryTree bt = new BinaryTree ( rootData );
		if ( bt == null ) {
			bt.add ( leftSubtree.rootData );
			bt.rightSubtree = rightSubtree;
		}
		else {
			bt.leftSubtree = leftSubtree;
			bt.rightSubtree = rightSubtree;
		}
		return bt;
	}

	/** Returns whether the BinaryTree has a left child. */
	public boolean hasLeft () {
		return this.leftSubtree != null;
	}

	/** Returns whether the BinaryTree has a right child. */
	public boolean hasRight () {
		return this.rightSubtree != null;
	}

	/** Inserts a new BinaryTree always to the left of root so it appears first in inorder traversal. */
	public boolean add ( Object o ) {
		BinaryTree bt = new BinaryTree ( o );
		if ( this.isEmpty () ) {
			this.rootData = bt.rootData;
			return true;
		}
		else {
			if ( ! ( this.hasLeft () ) ) {
				this.leftSubtree = bt ;
				return true;
			}
			else {
				this.leftSubtree.add ( bt.rootData );
			}
		}
		return false;
	}

   	/** Removes data from BinaryTree. */
    public void clear () {
    	this.rootData = null;
    }

	/** Returns whether the BinaryTree contains a specific object. */
	public boolean contains ( Object o ) {
		if ( this.rootData == null ) {
			return false;
		}
		else if ( o.equals ( this.rootData ) ) {
			return true;
		}
		return false;
	}

	/** Compares whether the BinaryTree is the same as another BinaryTree. */
	public boolean equals ( Object o ) {
		if ( !( o instanceof BinaryTree ) ) {
			return false;
		}
		BinaryTree newTree = ( BinaryTree ) o;
		if ( this.hasLeft () != newTree.hasLeft () || this.hasRight () != newTree.hasRight () ) {
			return false;
		}
		else if ( !( this.rootData.equals ( newTree.rootData ) ) ) {
			return false;
		}
		else if ( this.hasLeft () && !( this.leftSubtree.equals ( newTree.leftSubtree ) ) ) {
			return false;
		}
		else if ( this.hasRight() && !( this.rightSubtree.equals ( newTree.rightSubtree ) ) ) {
			return false;
		}
		return true;
	}

	/** Returns whether the BinaryTree is empty. */
	public boolean isEmpty () {
		return this.rootData == null;
	}

	/** Returns an iterator of the BinaryTree. */
	public Iterator iterator () {
		return new PreorderIterator ( this );
	}

	/** Method not implemented. */
	public boolean remove ( Object o ) {
		throw new UnsupportedOperationException(); 
	}

	/** Returns how many subtrees are in BinaryTree. */
	public int size () {
		int count = 1;
		if ( hasLeft () ) {
			count += leftSubtree.size ();
		}
		if ( hasRight () ) {
			count += rightSubtree.size ();
		}
		return count;
	}

	/** Method not implemented. */
	public Object [] toArray () { 
		throw new UnsupportedOperationException();
	}

	/** Method not implemented. */
	public Object [] toArray ( Object [] o ) {
		throw new UnsupportedOperationException();
	}

	/** Method not implemented. */
	public boolean retainAll ( Collection c ) {
		throw new UnsupportedOperationException();
	}

	/** Method not implemented. */
	public boolean removeAll ( Collection c ) {
		throw new UnsupportedOperationException();
	}

	/** Method not implemented. */
	public boolean addAll ( Collection c ) {
		throw new UnsupportedOperationException();
	}

	/** Method not implemented. */
	public boolean containsAll ( Collection c ) {
		throw new UnsupportedOperationException();
	}

	/** Iterator for BinaryTree in preorder. Uses a stack to keep track of rightSubtrees. */
	private class PreorderIterator implements Iterator {

		/** Private instance data for PreorderIterator. */
		private BinaryTree bt;
		private BinaryTree workingTree;
		private Stack <BinaryTree> s;

		/** Preorder iterator constructor. */
		public PreorderIterator ( BinaryTree bt ) {
			this.bt = bt;
			this.workingTree = null;
			this.s = new Stack <BinaryTree> ();
		}

		/** Returns the next object in the BinaryTree. */
		public Object next () {
			if ( !( this.hasNext() ) ) {
				throw new NoSuchElementException();
			}
			if ( this.workingTree == null ) {
				this.workingTree = this.bt;
			}
			else {
				if ( this.workingTree.hasLeft() ) {
					this.workingTree = this.workingTree.leftSubtree;
				}
				else if ( this.s.isEmpty() ) {
					this.workingTree = this.s.pop ();
				}
			}
			if ( this.workingTree.hasRight() ) {
				this.s.push ( this.workingTree.rightSubtree );
			}
			return this.workingTree.rootData;
		}

		/** Returns whether the BinaryTree has more children. */
		public boolean hasNext () {
			if ( this.workingTree == null ) {
				return this.bt != null;
			}
			if ( this.workingTree.hasLeft() | !( this.s.isEmpty() ) ) {
				return true;
			}
			return false;
		}

		/** Method not implemented. */
		public void remove () {
			throw new UnsupportedOperationException();
		}
	}
}