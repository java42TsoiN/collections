package telran.util;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 * all specified bellow methods should be written with complexity O[1]
 *
 */
public class MyStack {
	static int MAX_LENGTH = 100;
	private Integer stack[] = new Integer[MAX_LENGTH];
	private int top = -1;
	private Integer maxElements[] = new Integer[MAX_LENGTH];
	private int max_index = 0;

	// TODO fields
	/**
	 * removes the last element and returns it if the stack is empty an exception
	 * "NoSuchElementException" should be thrown
	 * 
	 * @return
	 */
	Integer pop() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		int res = stack[top--];
		if (res == maxElements[max_index - 1]) {
			max_index--;
		}
		return res;
	}

	/**
	 * 
	 * @return true if stack is empty
	 */
	boolean isEmpty() {
		return top == -1;
	}

	/**
	 * adds the given element at the end of the stack
	 * 
	 * @param element
	 */
	void push(Integer element) {
		stack[++top] = element;
		if (max_index == 0 || element >= maxElements[max_index - 1]) {
			maxElements[max_index++] = element;
		}
	}

	/**
	 * 
	 * @return maximal element existing in the stack
	 */
	Integer max() {
		if (max_index == 0) {
			throw new NoSuchElementException();
		}
		return maxElements[max_index - 1];
	}
}
