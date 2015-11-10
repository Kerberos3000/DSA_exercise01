package de.unistuttgart.dsaws2015.ex01.p1;

import static org.junit.Assert.*;

import org.junit.Test;

public class SpeedListTest {
	
	@Test
	public void test() {
		
		SpeedList<String> list = new SpeedList<String>();

		// initialize list
		list.prepend("hello");
		list.prepend("hi");
		list.prepend("hallo");
		list.prepend("bonjour");
		list.prepend("hey");
		list.prepend("salue");
		list.prepend("hola");
		list.prepend("house");
		list.prepend("foo");
		list.prepend("hugo");
		list.prepend("book");
		list.prepend("car");
		list.prepend("fish");
		list.prepend("dog");
		list.prepend("cat");
		list.prepend("university");
		list.prepend("ball");
		list.prepend("bike");
		
		
		
		// print list:
		list.printList();
		
		//assertEquals("hallo",list.getElementAt(1000)); //throws exception
		int size = list.size();
		assertEquals("car",list.getElementAt(7));
		assertEquals("hello",list.getElementAt(size));//TODO: discuss with team about the index
		assertEquals("hello",list.getElementAt(18));
		assertEquals("hello",list.getElementAt(17)); //check if optimized getElementAt is working as expected
		assertEquals("bike",list.getElementAt(1));

			
		assertEquals("hi",list.getNext8thElementOf(9)); //should be hi
		//assertEquals("hi",list.getNext8thElementOf(19)); //should be an exception
		assertEquals("hello",list.getNext8thElementOf(10)); //should be hello
		//assertEquals("hello",list.getNext8thElementOf(11)); //should be an exception



		assertTrue(true);
	}

}
