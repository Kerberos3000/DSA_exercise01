package de.unistuttgart.dsaws2015.ex01.p1;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class SpeedList<T> implements ISpeedList<T>, ISpeedListIterable<T> {


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
	private int size;
	
	// default constructor
	public SpeedList() {
		head = new Node();
		size = 0; // 0 elements in list
	}


	@Override
	public int size() {
		// remark: the head will not be considered as part of the list


		//TODO: discuss this with team.
		//QUOTE Mark: yeah i think you are right. The head can be null,
		//therefore the list can be empty (0 elements) even if the head is
		//initialized.
		
		//TODO: I dont know how the size thing is done at list... but maybe we
		// should consider saving the size as private variable and then we 
		// just raise or lower the size if a elemt gets added or deleted. 
		// the size() method would then be as simple as : "return size;"
		
		// Remark Daniel: very good point.
		// I implemented it accordingly. 
		// Delete all the comments if so ok.

		//TODO: This could be optimized using the next8th element.
		return this.size;
	}

	@Override
	public void prepend(T item) {
		// insert new node after head
		Node n = new Node(item);
		n.setNext(this.head.getNext()); 
		this.head.setNext(n); // head points now to new element
		this.size++;
		
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
		
		//TODO: this has to be expanded as well
		//I think the whole point of the next8th list is to 
		//speed up the traversing.... Okay i already did it, please
		// check if it makes sense. The TestCases still work.
		//
		//Daniel: Very good point!
		//FIXME: head does not have a next8th pointer.
		//This means your loop is never iterated.
		//Solution a) we add a next8th pointer to the head, too. Not that trivial
		//Solution b) we optimize from the first element. (and not from head)

		Node l = this.head;
		int i = 0;

		if (pos >= 1 && l.getNext() != null){
			l = l.getNext();
			i++;
		}
		else{
			// list is empty or requested position is <1
			throw new IndexOutOfBoundsException("position pos is out of bounds or your list is empty");
		}
	
		//check if fast iterating possible
		while(l.getNext8th() != null && (i+8)<pos) 
		{
			l = l.getNext8th();
			i += 8;
		}
		
		for(int j=i; j<pos; j++)
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
		int i = 0;

		// preparation for fast iterating (head does not have a next8th pointer)
		if (pos >= 1 && l.getNext() != null){
			l = l.getNext();
			i++;
		}
		else{
			// list is empty or requested position is <1
			throw new IndexOutOfBoundsException("position pos is out of bounds or your list is empty");
		}

		//Remark Daniel: Same here: this loop will be never iteraed (head.getnext8th always null
		while(l.getNext8th() != null && (i+8)<pos) 
		{
			l = l.getNext8th();
			i += 8;
		}
		
		for(int j=i; j<pos; j++)
		{
			if (l.getNext() == null) {
				throw new IndexOutOfBoundsException("position pos is out of bounds");
			}
			l = l.getNext();
		}
	
		//l is now the element at position pos
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
		// use print function to validate new iterator:
		
		SpeedListIterator iter = new SpeedListIterator();
		int counter = 1; //0 = head	
		while (iter.hasNext())
		{
			System.out.println(counter + ": " + (String)iter.next()); 
			counter++;
		}
}

	private class SpeedListIterator implements Iterator<T> {

		private Node node = null;

		//constructor for iterator
		public SpeedListIterator()
		{
			node = head.getNext();
		}

		@Override
		public boolean hasNext() {
			return node != null; //remark: node always points to next (not current) element
		}

		@Override
		public T next() {

			if (!this.hasNext()) {
				throw new NoSuchElementException();
			}
			
			T object = node.getObj();
			node = node.getNext();
			
			return object;
		}

		@Override
		/**
		 * This method is not supported
		 * 
		 * @throws UnsupportedOperationException
		 */
		public void remove() {
			throw new UnsupportedOperationException("The method SpeedListIterator.remove() is not supported");
		}
		
	}
	
	private class SpeedListSkippingIterator implements Iterator<T> {

		private Node node;
		private int stepWidth;
		
		// constructor for iterator
		SpeedListSkippingIterator(int n){
			if (n<1){
				throw new IllegalArgumentException("stepwidth n is less than 1");
			}
			
			node = head.getNext();
			stepWidth = n;
		}
		
		@Override
		public boolean hasNext() {
			return node != null; 
		}

		@Override
		public T next() {

			if (!this.hasNext()) {
				throw new NoSuchElementException();
			}
			T object = node.getObj();
		
			for(int i=0; i<this.stepWidth; i++)
			{
				node = node.getNext();
				if (node == null)
				{
					break;
				}
				//TODO: improvement possibility: if stepwidth > 8, use next8th attribute
			}
			
			return object;
		}

		@Override
		/**
		 * This method is not supported
		 * 
		 * @throws UnsupportedOperationException
		 */
		public void remove() {
			throw new UnsupportedOperationException("The method SpeedListSkippingIterator.remove() is not supported");
			
		}
		
	}
	
	@Override
	public Iterator<T> iterator() {
		return new SpeedListIterator();
	}

	@Override
	public Iterator<T> skippingIterator(int n) {
		return new SpeedListSkippingIterator(n);
	}
	

}