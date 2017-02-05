package ku.util;

import java.util.Arrays;

/**
 * A main class to create objects and run the program.
 * @author Patinya Yongyai
 *
 */
public class Main {

	/**
	 * To create array iterator and show the result.
	 * @param args not used.
	 */
	public static void main(String[] args){
		String [] array = { "apple", "banana", null, "carrot" };
		ArrayIterator<String> iter = new ArrayIterator( array );
		System.out.println(iter.next( )); // returns "apple" User is not required to call hasNext.
		System.out.println(iter.hasNext( )); // true
		System.out.println(iter.hasNext( )); // true again
		System.out.println(iter.hasNext( )); // true again User can call hasNext many times
		System.out.println(iter.next( )); // returns "banana"
		System.out.println(iter.next( )); // returns "carrot" (skip over null element)
		System.out.println(iter.hasNext()); // false
		System.out.println(iter.next( )); // throws NoSuchElementException
	}
}
