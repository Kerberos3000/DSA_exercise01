package de.unistuttgart.dsaws2015.ex01.p1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Test;

//import de.unistuttgart.dsaws2015.ex01.p1.SpeedList.SpeedListIterator;

public class SpeedListTest {
	
//TODO: Implement a more elegant SpeedListTest class
	//not important and only nice to have
	
	
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
		assertEquals("book",list.getElementAt(7));
		//assertEquals("hello",list.getElementAt(size)); // should through out of bounds exception
		assertEquals("hello",list.getElementAt(size-1));//TODO: discuss with team about the index
		assertEquals("hello",list.getElementAt(17));
		assertEquals("hi",list.getElementAt(16)); //check if optimized getElementAt is working as expected
		assertEquals("bike",list.getElementAt(0));
		assertEquals("ball",list.getElementAt(1));


			
		assertEquals("hugo",list.getNext8thElementOf(0));
		assertEquals("foo",list.getNext8thElementOf(1));
		assertEquals("hi",list.getNext8thElementOf(8)); 
//		assertEquals("hi",list.getNext8thElementOf(18)); //should be an exception
		assertEquals("hello",list.getNext8thElementOf(9)); //should be hello
//		assertEquals("hello",list.getNext8thElementOf(11)); //should be an exception
		assertEquals("hello",list.getNext8thElementOf(size-9));

		
		//TestProb1b:
		System.out.println("Start Test 1b\n");
		// iterator is tested in print function
		
		//test Skipping Iterator:
		
		testSkippingIterator(list,2);
		testSkippingIterator(list,4);
		testSkippingIterator(list,11);
		testSkippingIterator(list,500);
		testSkippingIterator(list,1);
//		testSkippingIterator(list,0); // should be an exception


		assertTrue(true);
	}
	
	public void testSkippingIterator (SpeedList<String> list, int testwidth) {
		// test Skipping Iterator
		Iterator<String> testSkippingIter = list.skippingIterator(testwidth);
		
		//testSkippingIter.remove(); //should throw an exception

		System.out.println("Skipping Test with stepwidth: " + testwidth );
		int counter = 1; //0 = head	
		while (testSkippingIter.hasNext())
		{
			System.out.println(counter + ": " + (String)testSkippingIter.next()); 
			counter++;
		}		
	}

}
