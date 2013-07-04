package de.unistuttgart.dsa2013.ws10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LineScannerTest {
	
	public static void main(String[] args) {
		if (args.length <= 0) {
			System.out.println("No filename specified.");
		} else {
			LineScanner scanner = new WordScanner();
			
			try {
				BufferedReader r = new BufferedReader(new FileReader(new File(args[0])));
				try {
					int count = 0;
					for (String line = r.readLine(); line != null; line = r.readLine()) {
						for (String s : scanner.retrieveStrings(line)) {
							System.out.println(s);
							count++;
						}
					}
					System.out.printf("%d string(s) found.\n", count);
				} finally {
					r.close();
				}
			} catch (IOException e) {
				System.out.printf("Unable to read the file \"%s\".\n", args[0]);
			}
		}
	}
}
