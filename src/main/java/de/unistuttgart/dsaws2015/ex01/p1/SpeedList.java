package de.unistuttgart.dsaws2015.ex01.p1;

//import java.util.Iterator;

//public class SpeedList<T> implements ISpeedList<T>, ISpeedListIterable<T> {
public class SpeedList<T> implements ISpeedList<T> {


	private class Node {


		//attributes
		private T obj;
		private Node next;
		private Node next8th;
		

		// default constructor
		public Node()
		{
			this.obj = null;
			this.next = null;
			this.next8th = null;
		}

		// parameter constructor
		public Node(T o){
			this.obj = o;
			this.next = null;
			this.next8th = null;
		}
		
		/**
		 * @return the obj
		 */
		public T getObj() {
			return obj;
		}

		/**
		 * @param obj the obj to set
		 */
		public void setObj(T obj) {
			this.obj = obj;
		}

		/**
		 * @return the next
		 */
		public Node getNext() {
			return next;
		}

		/**
		 * @param next the next to set
		 */
		public void setNext(Node next) {
			this.next = next;
		}
		
		/**
		 * @return the next8th
		 */
		public Node getNext8th() {
			return next8th;
		}

		/**
		 * @param next8th the next8th to set
		 */
		public void setNext8th(Node next8th) {
			this.next8th = next8th;
		}

	}

	private Node head;
	
	// default constructor
	public SpeedList() {
		head = new Node();
	}


	@Override
	public int size() {
		int counter = 0; // remark: the head will not be considered as part of the list
		//TODO: discuss this with team.
		Node l = this.head;
		while(l.getNext()!=null)
		{
			l = l.getNext(); //iterate through list
			counter++;
		}
		return counter;
		}

	@Override
	public void prepend(T item) {
		// insert new node after head
		Node n = new Node(item);
		n.setNext(this.head.getNext()); 
		this.head.setNext(n);
		
		//check if list is larger then 8 elements
		if (this.size() > 8)
		{
			for(int i=0; i<8; i++) // only 7 because next already points to position 2
			{
				n = n.getNext();
			}

			// set next8th pointer of new first element to element on position 8
			// no out of bound exception needed because of prior if condition
			this.head.getNext().setNext8th(n);
		}
		
	}

	@Override
	public T getElementAt(int pos) {
		Node l = this.head;
		for(int i=0; i<pos; i++)
		{
			if (l.getNext() == null)
			{
				throw new IndexOutOfBoundsException("position pos is out of bounds");
			}
			l = l.getNext();
		}
		
		return l.getObj();
	}

	@Override
	public T getNext8thElementOf(int pos) {
		//first, find element at position: pos
		Node l = this.head;
		for(int i=0; i<pos; i++)
		{
			if (l.getNext() == null) {
				throw new IndexOutOfBoundsException("position pos is out of bounds");
			}
			l = l.getNext();
		}
		
		if (l.next8th != null) {
			return l.getNext8th().getObj();
		}
		
		else{
			throw new IndexOutOfBoundsException("position pos+8 is out of bounds");
		}
		
	}

	// not required
	/**
	 * This functions prints the whole content of the list on the console
	 * This is useful for debugging purpose during implementation.
	 */
	public void printList(){
		Node l = this.head;
		int counter = 0; //0 = head
		while(l.getNext()!=null)
		{
			System.out.println(counter + ": " + (String) l.getObj());	
			l = l.getNext();
			counter++;
		}
		// print last element
		System.out.println(counter + ": " + (String) l.getObj());	
		
	}
	

}
