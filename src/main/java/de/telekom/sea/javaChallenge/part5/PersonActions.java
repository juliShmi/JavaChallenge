package de.telekom.sea.javaChallenge.part5;

public class PersonActions {

	private Person[] personArray = new Person[8];
	private int index = 0;

	public boolean add(Person person) {
		if (person != null) {
			while (personArray[index] != null) {
				try {
					index++;
				} catch (RuntimeException e) {
					System.out.println("No free places in list");
				}
			}
			personArray[index] = person;
			System.out.println("index = " + index);
			++index;
			return true;
		} else {
			throw new RuntimeException("Participant you're trying to add has value Null");
		}
	}

	public boolean remove(Person person) {
		boolean success = false;
		if (this.personArray.length > 0)
			for (int i = 0; i < this.personArray.length; i++) 
			{
				Person sPerson = (Person) this.personArray[i];
				if ((sPerson != null && personArray[i].equals(person))) {
					this.personArray[i] = null;
					for (int j = i; j < this.size(); j++) {
						this.personArray[j] = personArray[j + 1];
						personArray[j + 1] = null;
					}
					success = true;
					return success;
				}
			}
		return success;
	}

	private int size() {
		int sum = 0;
		for (int i = 0; i < personArray.length; i++) {
			if (personArray[i] != null) {
				sum++;
			}
		}
		return sum;
	}

}
