package de.telekom.sea.javaChallenge.part5;

public interface PersonenSchlange {
	
	public void add(Person person);

	public Person head();

	public Person remove();

	public void reset();

	public boolean empty();

	public int search(Person person);
}
