package de.telekom.sea.javaChallenge.part2;

public class DatenTypen {
	
	public static void printAll() {
		System.out.println("Type: byte; Size: 1 byte; Range: -128 ... 127; initial Value = 0");
		System.out.println("Type: boolean; Size: 1 byte; RANGE: true/false; initial Value = false");
		System.out.println("Type: short; Size: 2 byte; Range: -32 768 ... 32 767; initial Value = 0");
		System.out.println("Type: char; Size: 2 byte; Range: 0 ... 65 535; initial Value = \u0000"); //Symbol, Character in UniCode-Kodierung
		System.out.println("Type: int; Size: 4 byte; Range:(approximately) -2 Milliarden ... 2 Milliarden; initial Value = 0");
		System.out.println("Type: float; Size: 4 byte; RANGE: viel mehr als int; initial Value = 0.0f");
		System.out.println("Type: long; Size: 8 byte; Range:(approximately) -9223372036854775808L ... 9223372036854775807L; initial Value = 0L");
		System.out.println("Type: double; Size: 8 byte; RANGE: viel mehr als long; initial Value = 0.0d");
	}

}
