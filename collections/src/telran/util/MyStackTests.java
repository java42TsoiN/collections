package telran.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyStackTests {
	MyStack myStack;
	Stack<Integer> stack;
	Integer elements[]= {
			10,-10,20,40,40,-8,3
	};
	@BeforeEach
	void setUp() throws Exception {
		myStack = new MyStack();
		stack = new Stack<>();
		for(Integer num:elements) {
			myStack.push(num);
			stack.push(num);
		}
	}

	@Test
	void testPop() {
		for (int i = 0; i < elements.length; i++) {
			assertEquals(stack.pop(), myStack.pop());
		}
		boolean flExeption = false;
		try {
			myStack.pop();
		} catch (NoSuchElementException e) {
			flExeption = true;
		}
		assertTrue(flExeption);
	}

	@Test
	void testIsEmpty() {
		assertFalse(myStack.isEmpty());
		allPops();
		assertTrue(myStack.isEmpty());
	}

	private void allPops() {
		for (int i = 0; i < elements.length; i++) {
			assertEquals(stack.pop(), myStack.pop());
		}
		
	}

	@Test
	void testPush() {
		Integer num =1000;
		stack.push(num);
		myStack.push(num);
		allPops();
	}

	@Test
	void testMax() {
		assertEquals(Collections.max(stack), myStack.max());
		int nPops =3;
		pops(nPops);
		assertEquals(Collections.max(stack), myStack.max());
		nPops =2;
		pops(nPops);
		assertEquals(Collections.max(stack), myStack.max());
	}


	private void pops(int nPops) {
		for(int i =0;i<nPops;i++) {
			stack.pop();
			myStack.pop();
		}
	}

}
