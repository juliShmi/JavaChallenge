package de.telekom.sea.javaChallenge.part3;

public class WhileSchleife {

	public static void makeWhile() {
//		for (int i = 0; i < 8; i++) {
//			System.out.println(i);
//		}
		int i = 0;
		while (i < 8) {
			System.out.println(i);
			i++;
		}

		i = 0;

		do {
			System.out.println(i);
			i++;
		} while (i < 8);
	}

}
