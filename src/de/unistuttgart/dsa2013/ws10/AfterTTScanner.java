package de.unistuttgart.dsa2013.ws10;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Implementierung des LineScanner Interfaces mit dem Hintergrund, dass Woerter
 * darauf geprueft werden, ob sie mit einem oder mehreren 't's Enden. Ggf. werden
 * sie gelistet.
 * 
 * @author Maximilian Visotschnig
 * @author Frank Merkle
 * @author Alessandro Tridico
 * @version 2013-07-04 MV 1.0
 * @history 2013-07-04 MV 1.0 Anfang
 * 
 */
public class AfterTTScanner implements LineScanner {

	//TODO
	private static final Pattern p = Pattern.compile("\\.*t+");

	
	/**
	 * Iterates over line and matches with the pattern, if the last letters are
	 * one or more 't's. If yes, the word will be added
	 * 
	 * 
	 * @param line String which should be checked
	 * @throws IllegalArgumentException
	 *             if line is null
	 */
	@Override
	public Iterable<String> retrieveStrings(String line) {
		if (line == null){
			throw new IllegalArgumentException("line is null");
		}
		
		
		//TODO
		List<String> result = new ArrayList<String>();
		
		Matcher m = p.matcher(line);
		while (m.find()) {
			result.add(m.group());
		}
		
		return result;
	}
}
