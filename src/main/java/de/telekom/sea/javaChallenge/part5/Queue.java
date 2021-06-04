package de.telekom.sea.javaChallenge.part5;

public class Queue implements PersonenSchlange {

	private PersonActions personArray;
													//all methods description is in PersonAction class
	public Queue() {
		this.personArray = new PersonActions();
	}

	@Override
	public void add(Person person) {
		if (person != null) {					//adds new person in array (if person is != Null
			personArray.add((PersonImpl) person);
		} else {
			throw new RuntimeException();
		}

	}

	@Override
	public Person head() {					//returns the first element in array (head of queue)
		PersonImpl p = (PersonImpl) getPerson(0);
		if (p != null) {
			return p;
		}
		return null;
	}

	@Override
	public Person remove() {				//removes the first person in array (see PersonAction class for details)
		PersonImpl p = personArray.remove();
		return p;
	}

	@Override
	public void reset() {					//deletes all elements in array
		personArray.clear();

	}

	@Override
	public boolean empty() {				//check if array is empty
		boolean result = personArray.Isempty();
		return result;
	}

	@Override
	public int search(Person person) {
		int index = personArray.search((PersonImpl) person);
		return index;
	}

	@Override
	public int getSize() {
		int count = personArray.size();
		return count;
	}

	public Person getPerson(int index) {
		PersonImpl p = personArray.get(index);
		return p;

	}

}
