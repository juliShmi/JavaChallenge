package de.telekom.sea.javaChallenge.part5;

public class PersonImpl implements Person {

	private String vorname;
	private String nachname;

	public PersonImpl(String vorname, String nachname) {
		this.vorname = vorname;
		this.nachname = nachname;
	}

	public void setVorname(String vorname) {
		if (vorname != "") {
			this.vorname = vorname;
		}

	}

	public void setNachname(String nachname) {
		if (nachname != "") {
			this.nachname = nachname;
		}
	}

	@Override
	public String getVorname() {
		return this.vorname;
	}

	@Override
	public String getNachname() {
		return this.nachname;
	}

}
