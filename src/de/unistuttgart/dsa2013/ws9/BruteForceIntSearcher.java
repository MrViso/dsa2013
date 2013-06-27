package de.unistuttgart.dsa2013.ws9;

/**
 * Implementierung des SequenceSearcher als Brute-Force-Suche,
 * wobei nur Zahlensequenzen geprueft werden.
 * 
 * @author Maximilian Visotschnig
 * @author Frank Merkle
 * @author Alessandro Tridico
 * @version 2013-06-27 MV 1.0
 * @history 2013-06-27 MV 1.0 Erste Version
 * 
 */
public class BruteForceIntSearcher implements SequenceSearcher<Integer> {

	/**
	 * find Methode 
	 * Sucht eine Sequenz von Zahlen mit Hilfe der
	 * Brute-Force-Suche nach dem Pattern
	 * 
	 * @param sequence
	 *            Zahlensequenz die geprueft werden muss
	 * @param pattern
	 *            Pattern mit Zahlen auf die geprueft werden soll
	 * 
	 */
	@Override
	public int find(Integer[] sequence, Integer[] pattern) {
		// Variablen initialisieren mit Sequenz und Pattern
		int n = sequence.length;
		int m = pattern.length;
		// Aeussere Schleife um die Sequenz durchzugehen
		for (int i = 0; i <= n - m; i++) {
			// Aeussere Schleife, welche den Pattern und die Sequenz durchgeht
			for (int j = 0; j < m; j++) {
				if (pattern[j] != sequence[i + j])
					break; // Verlasse Schleife bei Mismatch
				if (j >= m - 1) // Volles Pattern gefunden
					return i; // Gebe Anfangsposition zurück
			}
		}
		return -1; // Pattern nicht gefunden
	}

}
