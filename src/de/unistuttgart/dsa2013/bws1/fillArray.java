package de.unistuttgart.dsa2013.bws1;

private static void fillArray (Integer[][] array, int value){
	if (array == null) {
		throw new IllegalArgumentException("array must not be null.");
	}
	
	int column = 0;
	int line = 0;
	int value = 0;
	
	system.out.println("Welchen Wert einfügen?");
	value = system.in.line;							//muss man nicht-int eingaben abfangen oder geht des automatisch?
	
	system.out.println("In welche Zeile einfügen?");
	line = system.in.line;							
	if (line > array.length) {
		throw new IllegalArgumentException("array has only " + array.length + " lines");
	}
	
	system.out.println("In welche Spalte einfügen?");
	column = system.in.line;
	if (column > array[line].length) {
		throw new IllegalArgumentException("array has only " + array[line].length + " columns!");
	}
	
	array[line][column] = value;
}
}

private static void fillArrayInc ( Integer [][] array ){
	
	for (i=0, i < array.length, i++) {
		for (j=0, j < array[i].length, j++) {
			array[i][j] = i + j;
		}
	}
}