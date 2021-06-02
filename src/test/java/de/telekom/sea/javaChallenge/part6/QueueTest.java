package de.telekom.sea.javaChallenge.part6;

import de.telekom.sea.javaChallenge.part5.Person;
import de.telekom.sea.javaChallenge.part5.PersonImpl;
import de.telekom.sea.javaChallenge.part5.Queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterEach;

public class QueueTest {

	private Queue queue;
	Person p1;
	Person p2;
	Person p3;
	Person p4;
	Person p5;
	Person p6;
	Person p7;
	Person p8;
	Person p9;

	@BeforeEach
	void setup() {
		p1 = new PersonImpl("Tony", "Stark");
		p2 = new PersonImpl("Peter", "Parker");
		p3 = new PersonImpl("Thor", "Odynsson");
		p4 = new PersonImpl("Natasha", "Romanoff");
		p5 = new PersonImpl("Steven", "Rogers");
		p6 = new PersonImpl("Clint", "Barton");
		p7 = new PersonImpl("Bruce", "Banner");
		p8 = new PersonImpl("Scott", "Lang");

		p9 = new PersonImpl("Loki", "Odynsson");

		queue = new Queue();
	}

	@Test
	void testAddNinth() {
		queue.add(p1);
		queue.add(p2);
		queue.add(p3);
		queue.add(p4);
		queue.add(p5);
		queue.add(p6);
		queue.add(p7);
		queue.add(p8);
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {queue.add(p9);}); //unfortunately I can't understand why this test is failed

	}

	@Test
	void testHead() {
		queue.add(p1);
		queue.add(p2);
		queue.add(p3);
		assertSame(p1, queue.head());
		assertNotSame(p3, queue.head());

		queue.reset();
		assertThrows(RuntimeException.class, () -> {
			queue.head();
		});
	}

	@Test
	void testSearch() {
		queue.add(p1);
		queue.add(p3);
		queue.add(p2);
		assertSame(1, queue.search(p3));
		assertNotSame(1, queue.search(p1));
		assertThrows(NullPointerException.class, () -> {
			queue.search(p4);
		});

	}

	@Test
	void testRemoveIfEmpty() {
		assertThrows(NoSuchElementException.class, () -> {
			queue.remove(); // Exception if the array is empty
		});
	}

	@Test
	void testRemove() {
		queue.add(p1);
		queue.add(p2);
		assertSame(p1,queue.remove());

	}
	
	@Test
	void isEmpty() {
		assertTrue(queue.empty());
		queue.add(p1);
		assertFalse(queue.empty());
	}
	
	@Test
	void testReset() {
		queue.reset();
		assertEquals(0, queue.getSize());
	}

	@AfterEach
	void teardown() {
		p1 = null;
		p2 = null;
		p3 = null;
		p4 = null;
		p5 = null;
		p6 = null;
		p7 = null;
		p8 = null;
		p9 = null;
		queue.reset();
	}

}
