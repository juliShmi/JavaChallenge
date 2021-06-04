package de.telekom.sea.javaChallenge.part5;

import java.util.NoSuchElementException;

public class PersonActions {

	private Person[] myPersons = new PersonImpl[8];
	private int index = 0;

	public boolean add(PersonImpl p) {			//add person to array if person is not Null
		if (p != null) {
			while (myPersons[index] != null) {
				try {
					index++;						
				} catch (RuntimeException e) {		//if index is bigger than array length
					System.out.println("No free places in list");
				}
			}
			myPersons[index] = p;
			System.out.println("Person " + p.getVorname() + " " +p.getNachname() + " added to the list");

			++index;
			return true;
		} else {
			throw new RuntimeException("Participant you're trying to add has value Null");	//if person has value Null
		}
	}

	public int size() {				//returns count of persons in array (not Null)
		int sum = 0;
		for (int i = 0; i < myPersons.length; i++) {
			if (myPersons[i] != null) {
				sum++;
			}
		}
		return sum;
	}

	public PersonImpl get(int i) {			//implemented method which returns person in array by input index
		if (i < myPersons.length) {
			return (PersonImpl) myPersons[i];
		} else {
			throw new RuntimeException(
					"Your index is out of bound. Max index is " + myPersons.length + ". Participant doesn't exist");
		}

	}

	public void clear() {						//clear the array (all elements are Null)
		for (int i = 0; i < myPersons.length; i++) {
			myPersons[i] = null;
		}

	}

	public int search(PersonImpl person) { // search an specific person in array and returns the index of Person in array
		PersonImpl p = null;
		int foundIndex = -1;
		for (int i = 0; i < this.size(); i++) {
			p = (PersonImpl) myPersons[i];
			if (p.getVorname().startsWith(person.getVorname()) && p.getNachname().startsWith(person.getNachname())) {
				System.out.println("Index of found person is " + i);
				foundIndex = i;
			}
		}System.out.println("Index not found: "+ foundIndex);
		return foundIndex;						//if person is not found returns -1
	}

	public boolean Isempty() {		// check if the array is empty (if the size == 0)
												
		if (size() == 0) {			//return true if array is empty
			return true;
		}
		return false;
	}

	public PersonImpl remove() { // remove the first person (person which is in position 0 in array) -> FIFO
		PersonImpl p = null;
		if (this.size() > 0) {
			p = (PersonImpl) myPersons[0];
			for (int j = 0; j < this.size(); j++) {
				myPersons[j] = myPersons[j + 1];		//after deleting person[0] has the value of person[1] -> all persons move one position back
				myPersons[j + 1] = null;				
			}
		}if (this.size() == 0) {						//if no elements in array ->throw exception
			throw new NoSuchElementException();
		}
		return p;
	}
}
