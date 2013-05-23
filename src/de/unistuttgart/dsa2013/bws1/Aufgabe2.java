package de.unistuttgart.dsa2013.bws1;

public class Aufgabe2 {

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
	
	public static void main(String[] args){
		Integer[] array = new Integer[5];
		array[0] = null;
		array[1] = null;
		array[2] = 1;
		array[3] = 2;
		array[4] = 3;
		defragmentArray(array);
		System.out.println(array[0]);
		System.out.println(array[1]);
		System.out.println(array[2]);
	}
}
