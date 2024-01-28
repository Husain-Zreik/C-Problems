// LinkedNumberSequence.java

import static java.lang.System.in;

/****************************************************************

LinkedNumberSequence represents a sequence of real numbers.
Such a sequence is defined by the interface NumberSequence.
The class uses linked nodes to store the numbers in the sequence.

Author
Fadil Galjic

****************************************************************/

public class LinkedNumberSequence //implements NumberSequence
{
	private class Node
	{
		public double number;
		public Node next;

		public Node (double number)
		{
			this.number = number;
			next = null;
		}
	}

	// the first node in the node-sequence
    private Node first;

    // create the sequence
    public LinkedNumberSequence (double[] numbers)
    {
		if (numbers.length < 2)
		    throw new IllegalArgumentException("not a sequence");

        first = new Node(numbers[0]);
        Node n = first;
		for (int i = 1; i < numbers.length; i++)
		{
			n.next = new Node(numbers[i]);
			n = n.next;
		}
	}

    // toString returns the character string representing this
    // sequence
	public String toString ()
	{
		String s = "";
		Node n = first;
		while (n.next != null)
		{
		    s = s + n.number + ", ";
		    n = n.next;
		}
		s = s + n.number;

		return s;
	}

    public int length () {
		Node n = first;
		int length = 0;

		while (n != null) {
			length++;
			n=n.next;
		}

		return length;
	}

	public double upperBound () {
		Node n = first;
		double Maxval = first.number;

		while (n != null) {
			if (n.number > Maxval) {
				Maxval = n.number;
			}
			n = n.next;
		}
		
		return Maxval;
	}

	public double lowerBound () {
		Node n = first;
		double Minval = first.number;

		while (n != null) {
			if (n.number < Minval) {
				Minval = n.number;
			}
			n = n.next;
		}
		return Minval;
	}

	 // numberAt returns the number at the specified position
    // in this sequence.
    // The method throws IndexOutOfBoundsException if the
    // position is wrong.
    public double numberAt (int position)
        throws IndexOutOfBoundsException {
			Node n = first;

			if(this.length() <= position) {
				throw new IndexOutOfBoundsException("Position not available :(");
			}
			
			for (int i = 0; i < position; i++) {
				n = n.next;
			}
			return n.number;
		}


	// positionOf returns the position of the first occurance of
    // the specified number in this sequence.
    // If the number is not present in the sequence, -1 is returned.
     public int positionOf (double number){
		Node n = first;
		int pos = 0;
		while (n != null) {
			if (n.number == number) {
				return pos;
				
			}
			n = n.next;
			pos++;

				
	    }
		return -1;
	}


	 // isIncreasing returns true if this sequence is increasing,
    // else false is returned.
    public boolean isIncreasing () {
		Node n = first;
		boolean increasing = true;
		while (n.next != null) {
			if (n.number >= n.next.number) {
				increasing = false;
				break;
			}
			n = n.next;
		}
		return increasing;
	}


	 // isDecreasing returns true if this sequence is decreasing,
    // else false is returned.
    public boolean isDecreasing () {
		Node n = first;
		boolean decreasing = true;
		while (n.next != null) {
			if (n.number <= n.next.number) {
				decreasing = false;
				break;
			}
			n = n.next;
		}
		return decreasing;
	}


	// contains returns true if this sequence contains the
    // specified number, else false is returned.
    public boolean contains (double number) {
		
		return positionOf(number) >= 0;
		
		
		
		
		
		
		
		
		// Node n = first;
		// int pos = 0;
		// boolean good = true;
		
		
		
		
		
		// while (!(n.number == number)) {
		// 	n = n.next;
		// 	pos++;

		// 	if (pos == this.length()){
		// 	good = false;
		// 	break;
		//     }					
	    // }
		// return good;
	}


	// add adds the specified number to the end of this sequence.
    public void add (double number) {
		Node node = new Node(number);
		if (first == null) {
			first = node;
		}
		else {
			Node n = first;
			while (n.next != null) {
			n = n.next;
			}
			n.next = node;
	    }
	}


	 // insert inserts the given number at the specified position
    // in this sequence.
    // The method throws IndexOutOfBoundsException if the
    // position is wrong.
    public void insert (int position, double number)
        throws IndexOutOfBoundsException {

			if (position > this.length()){
				throw new IndexOutOfBoundsException("Position not available :(");
			}
			Node node = new Node(number);

			if (position == 0) {
				node.next = first;
				first = node;
			}
			else {	
			Node n = first;
			for (int i = 0; i < position - 1; i++) {
					n = n.next;
				}
			node.next = n.next;
			n.next = node;
			}
					
				
		    

	}

	 // removeAt removes the number at the specified position
    // in this sequence.
    // The method throws IndexOutOfBoundsException if the
    // position is wrong.
    // The method throws IllegalStateException if there are
    // just two numbers in the sequence.
    public void removeAt (int position)
        throws IndexOutOfBoundsException, IllegalStateException {

			if (position > this.length()){
				throw new IndexOutOfBoundsException("Position not available :(");
			}
			
			if (this.length() < 3) {
				throw new IllegalStateException("List has too few elements :(");
			}
			Node n = first;
			if (position == 0) {
				first = n.next;
			}
			else {

			for (int i = 0; i < position - 1; i++) {
					n = n.next;
				}
			n.next = n.next.next;
			}
			
		}


	 // asArray returns an array containing all of the numbers in
    // this sequence, in the same order as in the sequence.
    public double[] asArray () {
		double[] arr = new double[this.length()];
		Node n = first;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = n.number;
			n = n.next;
		}

		return arr;



	}




}