package de.unistuttgart.dsaws2015.ex01.p1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SpeedList<T> implements ISpeedList<T>, ISpeedListIterable<T> {
	
	private class Node {

	}
	
	private class SpeedListIterator implements Iterator<T> {

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			return null;
		}

	}
	
	private class SpeedListSkippingIterator implements Iterator<T> {

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			return null;
		}

	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> skippingIterator(int n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void prepend(T item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T getElementAt(int pos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getNext8thElementOf(int pos) {
		// TODO Auto-generated method stub
		return null;
	}

}
