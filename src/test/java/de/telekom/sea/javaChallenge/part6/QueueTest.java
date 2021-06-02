package de.telekom.sea.javaChallenge.part6;

import de.telekom.sea.javaChallenge.part5.Person;
import de.telekom.sea.javaChallenge.part5.PersonImpl;
import de.telekom.sea.javaChallenge.part5.Queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterEach;

public class QueueTest {

	private Queue queue;;

	@BeforeEach
	void setup() {
		queue = new Queue();
	}

	@Test
	void testAddNineth() {
		PersonImpl p1 = new PersonImpl("Tony", "Stark");
		PersonImpl p2 = new PersonImpl("Peter", "Parker");
		PersonImpl p3 = new PersonImpl("Thor", "Odynsson");
		PersonImpl p4 = new PersonImpl("Natasha", "Romanoff");
		PersonImpl p5 = new PersonImpl("Steven", "Rogers");
		PersonImpl p6 = new PersonImpl("Clint", "Barton");
		PersonImpl p7 = new PersonImpl("Bruce", "Banner");
		PersonImpl p8 = new PersonImpl("Scott", "Lang");

		PersonImpl p9 = new PersonImpl("Loki", "Odynsson");
		queue.add(p1);
		queue.add(p2);
		queue.add(p3);
		queue.add(p4);
		queue.add(p5);
		queue.add(p6);
		queue.add(p7);
		queue.add(p8);
		assertThrows(IndexOutOfBoundsException.class, () -> {
			queue.add(p9);
		});

	}

	@Test
	void testAddNull() {
		PersonImpl p1 = new PersonImpl("Tony", "Stark");
		PersonImpl p2 = new PersonImpl("Peter", "Parker");
		PersonImpl p3 = new PersonImpl("Thor", "Odynsson");
		PersonImpl p4 = new PersonImpl("Natasha", "Romanoff");
		PersonImpl p5 = new PersonImpl("Steven", "Rogers");
		PersonImpl p6 = new PersonImpl("Clint", "Barton");
		PersonImpl p7 = new PersonImpl("Bruce", "Banner");
		PersonImpl personNull = null;
		queue.add(p1);
		queue.add(p2);
		queue.add(p3);
		queue.add(p4);
		queue.add(p5);
		queue.add(p6);
		queue.add(p7);
		assertThrows(RuntimeException.class, () -> {
			queue.add(personNull);
		});

	}

	@Test
	void testHead() {
		PersonImpl p1 = new PersonImpl("Tony", "Stark");
		PersonImpl p2 = new PersonImpl("Peter", "Parker");
		queue.add(p1);
		queue.add(p2);
		assertSame(p1, queue.head());
	}

	@Test
	void testHeadNull() {
		assertSame(null,  queue.head());
	}

	@Test
	void testSearch() {
		PersonImpl p1 = new PersonImpl("Tony", "Stark");
		PersonImpl p2 = new PersonImpl("Peter", "Parker");
		PersonImpl p3 = new PersonImpl("Thor", "Odynsson");
		PersonImpl p4 = new PersonImpl("Natasha", "Romanoff");
		queue.add(p1);
		queue.add(p3);
		queue.add(p2);
		assertEquals(1, queue.search(p3));
		assertNotEquals(2, queue.search(p1));
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
		PersonImpl p1 = new PersonImpl("Tony", "Stark");
		queue.add(p1);
		assertSame(p1, queue.remove());

	}

	@Test
	void isEmpty() {
		assertTrue(queue.empty());
	}

	@Test
	void testIsEmptyAfterReset() {
		PersonImpl p1 = new PersonImpl("Tony", "Stark");
		queue.add(p1);
		queue.reset();
		assertTrue(queue.empty());
	}

	@Test
	void testReset() {
		queue.reset();
		assertEquals(0, queue.getSize());
	}

	@AfterEach
	void teardown() {
		queue.reset();
	}

}
