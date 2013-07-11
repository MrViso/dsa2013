package de.unistuttgart.dsa2013.ws10;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Implementierung des LineScanner Interfaces mit dem Hintergrund, dass Woerter
 * darauf geprueft werden ob sie mit einem Grossbuchstaben starten- Solche Worte
 * werden gelistet.
 * 
 * @author Maximilian Visotschnig
 * @author Frank Merkle
 * @author Alessandro Tridico
 * @version 2013-07-04 MV 1.0
 * @history 2013-07-04 MV 1.0 Anfang
 * 
 */
public class CapitalWordScanner implements LineScanner {

	private static final Pattern p = Pattern.compile("\\p{Upper}.*");

	/**
	 * Iterates over line and matches with the pattern, if the first letter is
	 * capital size. If yes, the word will be added
	 * 
	 * 
	 * @param line String which should be checked
	 * @throws IllegalArgumentException
	 *             if line is null
	 */
	@Override
	public Iterable<String> retrieveStrings(String line) {
		if (line == null) {
			throw new IllegalArgumentException("line is null");
		}

		List<String> result = new ArrayList<String>();

		Matcher m = p.matcher(line);
		while (m.find()) {
			result.add(m.group());
		}

		return result;
	}
}
