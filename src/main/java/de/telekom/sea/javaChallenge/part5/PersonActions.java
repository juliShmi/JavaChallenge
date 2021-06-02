package de.telekom.sea.javaChallenge.part5;

import java.util.NoSuchElementException;

public class PersonActions {

	public static Person[] personArray = new Person[8];
	private int index = 0;

	public boolean add(Person person) {					//adds a new Person to the array
		if (person != null) {
			while (personArray[index] != null) {		//make checking whether Person by itself or person in an array is Null
				try {
					index++;
				} catch (RuntimeException e) {
					System.out.println("No free places in list");
				}
			}
			personArray[index] = person;				//array with index has value Person
			System.out.println("index = " + index);
			++index;
			return true;
		} else {
			throw new RuntimeException("Participant you're trying to add has value Null");
		}
	}

	public Person remove() {						//remove the first person (person which is in position 0 in array)
		Person p = null;							
		if (this.size() > 0) {
			p = personArray[0];
			for (int j = 0; j < this.size(); j++) {
				personArray[j] = personArray[j + 1];
				personArray[j + 1] = null;
			}
		}
		return p;
	}

	public int size() {							//count how many persons are in array 
		int sum = 0;
		for (int i = 0; i < personArray.length; i++) {
			if (personArray[i] != null) {
				sum++;							// variable sum ++ if the element in array is not Null;
			}
		}
		return sum;
	}

}
