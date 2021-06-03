package de.telekom.sea.javaChallenge.part5;

import java.util.NoSuchElementException;

public class PersonActions {

	private Person[] myPersons = new PersonImpl[8];
	private int index = 0;

	public boolean add(PersonImpl p) {
		if (p != null) {
			while (myPersons[index] != null) {
				try {
					index++;
				} catch (RuntimeException e) {
					System.out.println("No free places in list");
				}
			}
			myPersons[index] = p;
			System.out.println("Person " + p.getVorname() + " " +p.getNachname() + " added to the list");

			++index;
			return true;
		} else {
			throw new RuntimeException("Participant you're trying to add has value Null");
		}
	}

	public int size() {
		int sum = 0;
		for (int i = 0; i < myPersons.length; i++) {
			if (myPersons[i] != null) {
				sum++;
			}
		}
		return sum;
	}

	public PersonImpl get(int i) {
		if (i < myPersons.length) {
			return (PersonImpl) myPersons[i];
		} else {
			throw new RuntimeException(
					"Your index is out of bound. Max index is " + myPersons.length + ". Participant doesn't exist");
		}

	}

	public void clear() {
		for (int i = 0; i < myPersons.length; i++) {
			myPersons[i] = null;
		}

	}

	public int search(PersonImpl person) { // search an specific person in array
		PersonImpl p = null;
		int foundIndex = -1;
		for (int i = 0; i < this.size(); i++) {
			p = (PersonImpl) myPersons[i];
			if (p.getVorname().startsWith(person.getVorname()) && p.getNachname().startsWith(person.getNachname())) {
				System.out.println("Index of found person is " + i);
				foundIndex = i;
			}
		}System.out.println("Index not found: "+ foundIndex);
		return foundIndex;
	}

	public boolean Isempty() {		// check if the array is empty
												
		if (size() == 0) {
			return true;
		}
		return false;
	}

	public PersonImpl remove() { // remove the first person (person which is in position 0 in array)
		PersonImpl p = null;
		if (this.size() > 0) {
			p = (PersonImpl) myPersons[0];
			for (int j = 0; j < this.size(); j++) {
				myPersons[j] = myPersons[j + 1];
				myPersons[j + 1] = null;
			}
		}if (this.size() == 0) {
			throw new NoSuchElementException();
		}
		return p;
	}
}
