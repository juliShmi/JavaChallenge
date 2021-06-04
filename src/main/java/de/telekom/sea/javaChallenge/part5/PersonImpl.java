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
		if (this.vorname != null) {
			return this.vorname;
		}
		throw new NullPointerException();
	}

	public String getNachname() {
		if (this.nachname != null) {
			return this.nachname;
		}
		throw new NullPointerException();
	}

	public void setVorname(String vorname) {
		if (vorname != "") {
			this.vorname = vorname;
		}
	}

	// set surname
	public void setNachname(String nachname) {
		if (nachname != "") {
			this.nachname = nachname;
		}

	}
}
