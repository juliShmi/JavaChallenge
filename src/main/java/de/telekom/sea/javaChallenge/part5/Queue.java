package de.telekom.sea.javaChallenge.part5;

public class Queue implements PersonenSchlange {

	private PersonActions personArray;

	public Queue() {
		this.personArray = new PersonActions();
	}

	@Override
	public void add(Person person) {
		if (person != null) {
			personArray.add((PersonImpl) person);
		} else {
			throw new RuntimeException();
		}

	}

	@Override
	public Person head() {
		PersonImpl p = (PersonImpl) getPerson(0);
		if (p != null) {
			return p;
		}
		return null;
	}

	@Override
	public Person remove() {
		PersonImpl p = personArray.remove();
		return p;
	}

	@Override
	public void reset() {
		personArray.clear();

	}

	@Override
	public boolean empty() {
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
