package de.telekom.sea.javaChallenge.part5;

public class Queue implements PersonenSchlange {

	private Person[] personArray = new Person[8];;
	private int index = 0;

	@Override
	public void add(Person person) {
		if (person != null) {
			while (personArray[index] != null) { // make checking whether Person by itself or person in an array is Null
				try {
					personArray[index] = (PersonImpl) person;
				} catch (RuntimeException e) {
					System.out.println("No free places in list");
				}
			}
			index += 1; 							// array with index has value Person

		} else {
			throw new RuntimeException("Participant you're trying to add has value Null");
		}
	}

	public Person head() {
		Person p = personArray[0];
		return p;
	}

	@Override
	public Person remove() { // remove the first person (person which is in position 0 in array)
		Person p = null;
		if (this.getSize() > 0) {
			p = personArray[0];
			for (int j = 0; j < this.getSize(); j++) {
				personArray[j] = personArray[j + 1];
				personArray[j + 1] = null;
			}
		}
		return p;
	}

	@Override
	public void reset() { // deletes all elements in array
		personArray = new PersonImpl[0];
		System.out.println("Array is empty");

	}

	@Override
	public boolean empty() {
		// check if the array is empty
		if (getSize() == 0) {
			return true;
		}
		return false;
	}

	@Override
	public int search(Person person) { // search an specific person in array
		if (person != null) {
			for (int i = 0; i < getSize(); i++) {
				if (personArray[i].equals(person)) {
					System.out.println("Index of found person is " + i);
					return i;
				}
			}
		} else {
			throw new RuntimeException();
		}
		return -1;
	}

	public Person get(int index) { // returns person in the array which index is written
		if (index < 0 && index < personArray.length) {
			return personArray[index];
		}
		return null; // returns Null in Person not found;
	}

	public int getSize() {
		int sum = 0;
		for (int i = 0; i < personArray.length; i++) {
			if (personArray[i] != null) {
				sum++; // variable sum ++ if the element in array is not Null;
			}
		}
		return sum;
	}

}
