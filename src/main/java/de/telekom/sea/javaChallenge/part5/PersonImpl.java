package de.telekom.sea.javaChallenge.part5;

public class PersonImpl implements Person {

	private String vorname;
	private String nachname;

	public PersonImpl(String vorname, String nachname) {
		this.vorname = vorname;
		this.nachname = nachname;
	}

	public PersonImpl() {
	}

	public String getVorname() {
		return this.vorname;
	}

	public String getNachname() {
		return this.nachname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	// set surname
	public void setNachname(String nachname) {
		this.nachname = nachname;

	}
}
