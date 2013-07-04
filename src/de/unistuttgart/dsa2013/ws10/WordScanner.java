package de.unistuttgart.dsa2013.ws10;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordScanner implements LineScanner {
	
	private static final Pattern p = Pattern.compile("\\w+");
	
	@Override
	public Iterable<String> retrieveStrings(String line) {
		List<String> result = new ArrayList<String>();
		
		Matcher m = p.matcher(line);
		while (m.find()) {
			result.add(m.group());
		}
		
		return result;
	}
}
