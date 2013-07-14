package de.unistuttgart.dsa2013.bws2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Imports town data.
 */
public final class TownImporter {
	
	/**
	 * Hidden constructor.
	 */
	private TownImporter() {
	}
	
	/**
	 * The pattern used to recognize valid AGS values (amtliche Gemeindeschlüssel).
	 */
	private static final Pattern agsPattern = Pattern.compile("^\\d+$");
	
	/**
	 * The number format used to parse the file.
	 */
	private static final NumberFormat format = NumberFormat.getInstance(Locale.US);
	
	/**
	 * Imports all towns from a tab-separated file.
	 * The file is expected to contain a row with column titles. Columns ags, name, lat, lon and level are required.
	 * 
	 * @param filename The complete path to the file.
	 * @return An enumeration of all imported towns.
	 * @throws IOException if importing failed.
	 */
	public static Iterable<Town> importTowns(String filename) throws IOException {
		List<Town> result = new ArrayList<Town>();
		
		BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"));
		try {
			String line;
			Integer agsColumnIndex = null;
			Integer nameColumnIndex = null;
			Integer latColumnIndex = null;
			Integer lonColumnIndex = null;
			Integer levelColumnIndex = null;
			int minColumnCount = 0;
			boolean isFirstLine = true;
			
			while ((line = r.readLine()) != null) {
				String[] tokens = line.split("\t");
				if (isFirstLine) {
					isFirstLine = false;
					
					Map<String, Integer> columnIndices = new HashMap<String, Integer>();
					for (int i = 0; i < tokens.length; i++) {
						columnIndices.put(tokens[i], i);
					}
					
					agsColumnIndex = columnIndices.get("ags");
					nameColumnIndex = columnIndices.get("name");
					latColumnIndex = columnIndices.get("lat");
					lonColumnIndex = columnIndices.get("lon");
					levelColumnIndex = columnIndices.get("level");
					
					if ((agsColumnIndex == null) || (nameColumnIndex == null) || (latColumnIndex == null) || (lonColumnIndex == null) || (levelColumnIndex == null)) {
						throw new IOException("Invalid file format.");
					}
					minColumnCount = Math.max(Math.max(agsColumnIndex, nameColumnIndex), Math.max(latColumnIndex, Math.max(lonColumnIndex, levelColumnIndex))) + 1;
				} else {
					if ((tokens.length >= minColumnCount) && agsPattern.matcher(tokens[agsColumnIndex]).matches()) {
						try {
							int level = format.parse(tokens[levelColumnIndex]).intValue();
							if (level >= 6) {
								Town town = new Town(tokens[nameColumnIndex],
										format.parse(tokens[latColumnIndex]).doubleValue(),
										format.parse(tokens[lonColumnIndex]).doubleValue());
								result.add(town);
							}
						} catch (ParseException ex) {
						}
					}
				}
			}
			
			return result;
		} finally {
			r.close();
		}
	}
}
