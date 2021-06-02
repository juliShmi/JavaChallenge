package de.telekom.sea.javaChallenge.part5;

import java.io.IOException;
import java.util.NoSuchElementException;

public class Queue implements PersonenSchlange {

	private PersonActions pa = new PersonActions();
	private java.util.Scanner scanner = new java.util.Scanner(System.in);
	private String result;

	@Override
	public void add(Person person) {
		if (person != null) {
			pa.add(person);
			System.out.println(person.getVorname() + " " + person.getNachname());
		} else {
			throw new ArrayIndexOutOfBoundsException();

		}

	}

	@Override
	public Person head() {
		if (PersonActions.personArray[0] != null) {
			System.out.println("Person head is: " + PersonActions.personArray[0].getVorname() + " "
					+ PersonActions.personArray[0].getNachname());
			return PersonActions.personArray[0];
		} else {
			throw new RuntimeException("Participant you're trying to see has value Null");
		}
	}

	@Override
	public Person remove() {
		if (getSize() != 0) {
			Person p = pa.remove();
			return p;
		}
		throw new NoSuchElementException();
	}

	@Override
	public void reset() {									//deletes all elements in array
		for (int i = 0; i < getSize(); i++) {
			PersonActions.personArray[i] = null;
		}
		System.out.println("Reset all successfully");

	}

	@Override
	public boolean empty() { 								//check if the array is empty
		int j = 0;
		for (int i = 0; i < getSize(); i++) {
			if (PersonActions.personArray[i] != null) {
				j++;
			}
			if (j == 0) {
				System.out.println("Array is empty");
				return true;
			}
		}
		return false;
	}

	@Override
	public int search(Person person) {										//search an specific person  in array
		if (person != null) {
			for (int i = 0; i < getSize(); i++) {
				if (PersonActions.personArray[i].equals(person)) {			//if the specific person is in array (equals with element in array) -> return person
					System.out.println("Index of found person is " + i);
					return i;
				}
			}
		} else {
			System.out.println("Person not found");
		}
		return -1;
	}

	public Person get(int index) {											//returns person in the array which index is written
		if (index < 0 && index < PersonActions.personArray.length) {
			return PersonActions.personArray[index];
		}
		return null;														//returns Null in Person not found;										
	}

	public int getSize() {
		return pa.size();
	}

}
