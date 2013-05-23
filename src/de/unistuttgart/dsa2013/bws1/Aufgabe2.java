package de.unistuttgart.dsa2013.bws1;

/**
 * Aufgabe 2 ermoeglicht es mit einer MEthode ein Array zu defragmentieren.
 * 
 * @author Maximilian Visotschnig
 * @author Frank Merkle
 * @author Alessandro Tridico
 * @version 2013-05-23 MV 1.1
 * @history 2013-05-23 MV 1.0 Implementierung von defrafmentArray
 * @history 2013-05-23 MV 1.1 Implementierung von compareEven
 * 
 */
public class Aufgabe2 {
	/**
	 * Diese Methode prüft alle Elemente ob sie null sind und schiebt sie nach
	 * hinten. Da die Methode immer nur so lange schiebt bis das naechstbeste
	 * Element null ist, koennen weitere Traversierungen vermieden werden. Dies
	 * wird erreicht indem das Array von hinten aus geprueft wird, weshalb der
	 * Anteil an Nullelementen direkt am Ende immer aufgebaut wird und man sich
	 * sicher sein kann, dass das naechste null Element am Endblock des Arrays
	 * liegt.
	 * 
	 * @param array
	 *            das zu defragmentierende Array
	 */
	private static <T> void defragmentArray(T[] array) {

		for (int i = array.length - 1; i >= 0; i--) {
			if (array[i] == null) {
				boolean push = true;
				if (i < array.length - 1) {
					if (array[i + 1] == null) {
						push = false;
					}
				}

				int j = i;
				while (push) {
					if (array[j + 1] != null) {
						array[j] = array[j + 1];
						array[j + 1] = null;
					} else {
						push = false;
					}
					j++;
					if (j + 1 == array.length) {
						push = false;
					}
				}

			}
		}
	}

	/**
	 * 
	 * Prueft alle geraden Indize zweier Arrays darauf, ob sie die selben Werte
	 * besitzen
	 * 
	 * @param array1
	 *            1. Vergleichsarray
	 * @param array2
	 *            2. Vergleichsarray
	 * @return ob die Arrays gleiche Laenge haben und alle geraden Indize
	 *         gleiche Werte besitzen
	 */
	public static <T> boolean compareEven(T[] array1, T[] array2) {
		if (array1.length != array2.length)
			return false;

		for (int i = 0; i < array1.length; i += 2) {
			if (array1[i] != array2[i])
				return false;
		}

		return true;
	}

	/**
	 * Testmethode
	 * 
	 * @param args
	 * 
	 */
	public static void main(String[] args) {
		// Array zum defragmentieren aufstellen
		Integer[] array = new Integer[5];
		array[0] = null;
		array[1] = null;
		array[2] = 1;
		array[3] = 2;
		array[4] = 3;

		// Defragmentieren
		defragmentArray(array);

		// Ausgabe des ersten defgramentierten Arrays
		System.out.println(array[0]);
		System.out.println(array[1]);
		System.out.println(array[2]);
		System.out.println(array[3]);
		System.out.println(array[4]);

		// Testarrays
		Integer[] array1 = new Integer[5];
		Integer[] array2 = new Integer[5];
		array2[0] = 1;
		array2[1] = null;
		array2[2] = 3;
		array2[3] = 50;
		array2[4] = null;
		Integer[] array3 = new Integer[6];

		// Test von compareEven
		System.out.println("Vergleich Array mit Array 1: "
				+ compareEven(array, array1));
		System.out.println("Vergleich Array mit Array 2: "
				+ compareEven(array, array2));
		System.out.println("Vergleich Array mit Array 3: "
				+ compareEven(array, array3));
	}
}
