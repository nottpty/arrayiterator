package ku.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Many collections and data structures provide an Iterator so we can iterate
 * over all the elements in the collection without knowing the structure of the
 * collection
 * 
 * Arrays don't have an Iterator, but it would be really useful to have one.
 * 
 * For convenience, we will design the Arrayiterator so it will skip null
 * elements in the array.
 * 
 * @author Patinya Yongyai
 *
 * @param <T>
 *            means the type of thing in the ArrayIterator. At run-time it will
 *            be replaced by the name of an actual class (like Student if we ask
 *            for ArrayIterator<Student>).
 */
public class ArrayIterator<T> implements Iterator<T> {
	/** attribute for the array we want to iterate over */
	private T[] array;
	/** Current index of array. */
	private int index;
	private int tempIndex;

	/**
	 * Initialize a new array iterator with the array to process.
	 * 
	 * @param array
	 *            is the array to iterate over
	 */
	public ArrayIterator(T[] array) {
		this.array = array;
		this.index = -1;
		this.tempIndex = -1;
	}

	/**
	 * Check the next element of array is non-null element or null element from
	 * array.
	 * 
	 * @return true if next() can return another non-null array element, false
	 *         if no more elements.
	 */
	@Override
	public boolean hasNext() {
		for (int i = index + 1; i < array.length; i++) {
			if (lastIndex())
				return false;
			if (this.array[i] != null)
				return true;
		}
		return false;
	}

	/**
	 * Return the next non-null element from array, if any.
	 * 
	 * @return the next non-null element in the array.
	 * @throws NoSuchElementException
	 *             if there are no more elements to return.
	 */
	@Override
	public T next() {
		if (hasNext()) {
			while (array[index + 1] == null)
				++index;
			tempIndex = index + 1;
			return array[++index];
		}
		throw new NoSuchElementException();
	}

	/**
	 * Remove most recent element returned by next() from the array by setting
	 * it to null. This method may only be called once after a call to next().
	 * If this method is called without calling next(). or called more than once
	 * after calling next(), it throws IllegalStateException.
	 */
	public void remove() {
		if (tempIndex == -1 || array[tempIndex] == null)
			throw new IllegalStateException();
		this.array[tempIndex] = null;
	}

	/**
	 * Check current index of array is the last index or not.
	 * 
	 * @return true if current is the last index, return false if current isn't
	 *         the last index.
	 */
	private boolean lastIndex() {
		return index == this.array.length - 1;
	}

}
