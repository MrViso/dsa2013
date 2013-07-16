package de.unistuttgart.dsa2013.bws2.answers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import de.unistuttgart.dsa2013.bws2.QuadNodeA;
import de.unistuttgart.dsa2013.bws2.QuadNodeB;
import de.unistuttgart.dsa2013.bws2.QuadTreeDisplay;
import de.unistuttgart.dsa2013.bws2.Town;
import de.unistuttgart.dsa2013.bws2.TownImporter;

/**
 * Klasse welche einen Quadtree aufbauen soll.
 * 
 * @author Maximilian Visotschnig
 * @author Frank Merkle
 * @author Alessandro Tridico
 * @version 2013-07-17 MV 1.1
 * @history 2013-07-17 MV 1.1 Implementierung QuadNodeB und restliche Methoden
 * @history 2013-07-14 MV 1.0 Implementierung QuadNodeA
 * 
 */
public class Quad implements QuadNodeB, QuadNodeA {

	// Variablen aus UML Diagramm
	private double x;
	private double y;
	private double width;
	private double height;
	private int maxTownCount;
	private Quad[] children = null;
	private List<Town> towns = new ArrayList<Town>();

	/**
	 * Konstruktor der Quad Klasse
	 * 
	 * 
	 * @param x
	 *            Ursprungskoordinate des Quadranten
	 * @param y
	 *            Ursprungskoordinate des Quadranten
	 * @param width
	 *            Breite des Quadranten
	 * @param height
	 *            Hoehe des Quadranten
	 * @param maxTownCount
	 *            Maximale Anzahl an Staedten im Quadranten
	 */
	public Quad(double x, double y, double width, double height,
			int maxTownCount) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.maxTownCount = maxTownCount;
	}

	/**
	 * Gibt die X Koordinate des Quadranten zurueck
	 * 
	 * @return X Koordinate
	 */
	@Override
	public double getX() {
		return this.x;
	}

	/**
	 * Gibt die Y Koordinate des Quadranten zurueck
	 * 
	 * @return Y Koordinate
	 */
	@Override
	public double getY() {
		// TODO Auto-generated method stub
		return this.y;
	}

	/**
	 * Gibt die Breite des Quadranten zurueck
	 * 
	 * @return Breite
	 */
	@Override
	public double getWidth() {
		// TODO Auto-generated method stub
		return this.width;
	}

	/**
	 * Gibt die Hoehe des Quadranten zurueck
	 * 
	 * @return Hoehe
	 */
	@Override
	public double getHeight() {
		// TODO Auto-generated method stub
		return this.height;
	}

	/**
	 * Prueft ob eine Koordinate im Bereich des Quadranten liegt
	 * 
	 * 
	 * @param x
	 *            X Koordinate der Stadt
	 * @param y
	 *            Y Koordinate der Stadt
	 * 
	 */
	@Override
	public boolean contains(double x, double y) {
		if (x >= this.x && y >= this.y && x <= (this.x + this.width)
				&& y <= (this.y + this.height)) {
			return true;
		}
		return false;
	}

	/**
	 * Fuegt eine Stadt hinzu, wobei auf die maximale Anzahl an Staedten
	 * geprueft wird und ob Kinderquadranten bestehen
	 * 
	 * 
	 * @param town
	 *            Hinzuzufuegtende Stadt
	 */
	@Override
	public void add(Town town) {
		// TODO Auto-generated method stub
		if (!hasChildren()) {
			towns.add(town);
			if (countTowns() > maxTownCount)
				partition();
		} else {
			for (Quad child : getChildren()) {
				if (child.contains(town.getLongitude(), town.getLatitude())) {
					child.add(town);
					break;
				}
			}
		}

	}

	/**
	 * Ein Iterator um uebert die Stadte des Quadrantens zu iterieren
	 * 
	 * @return den Iterator zu den Staedten
	 * 
	 */
	@Override
	public Iterable<Town> getTowns() {
		// TODO Auto-generated method stub
		return this.towns;
	}

	/**
	 * Ein Iterator der ueber die Kinderquadranten iterieren soll
	 * 
	 * @return Den Kinderiterator
	 */
	@Override
	public Iterable<QuadNodeB> getChildren() {
		Iterable<QuadNodeB> liste = Arrays.asList(this.children);
		return liste;
	}

	/**
	 * Gibt zurueck ob Kinder im Quadranten vorhanden sind
	 * 
	 * 
	 * @return Wahrheitswert ob Kinder vorhanden sind
	 */
	@Override
	public boolean hasChildren() {
		if (getChildren() != null)
			return true;
		else
			return false;
	}

	/**
	 * Zaehlt die Anzahl an Staedten eines Quadranten
	 * 
	 * @return Anzahl der Staedte
	 */
	public int countTowns() {
		int count = 0;
		for (Town town : getTowns()) {
			count++;
		}
		return count;
	}

	/**
	 * Spaltet einen Quadranten zu vier Kinderquadranten und siedelt die Staedte
	 * um. Es wird rekursiv die Partitions Methode weiter aufgerufen um die
	 * Kinder ebenfalls zu pruefen
	 * 
	 */
	private void partition() {
		if (countTowns() > maxTownCount) {

			// Quadranten erstellen
			children[0] = new Quad(getX(), getY(), getWidth() / 2,
					getHeight() / 2, maxTownCount);
			children[1] = new Quad(getX() + getWidth() / 2, getY(),
					getWidth() / 2, getHeight() / 2, maxTownCount);
			children[2] = new Quad(getX(), getY() + getHeight() / 2,
					getWidth() / 2, getHeight() / 2, maxTownCount);
			children[3] = new Quad(getX() + getWidth() / 2, getY()
					+ getHeight() / 2, getWidth() / 2, getHeight() / 2,
					maxTownCount);

			// Staedte umsiedeln
			for (Town town : getTowns()) {
				if (children[0].contains(town.getLongitude(),
						town.getLatitude()))
					children[0].add(town);
				else if (children[1].contains(town.getLongitude(),
						town.getLatitude()))
					children[1].add(town);
				else if (children[2].contains(town.getLongitude(),
						town.getLatitude()))
					children[2].add(town);
				else if (children[3].contains(town.getLongitude(),
						town.getLatitude()))
					children[3].add(town);

			}

			// Partition rekursiv aufrufen
			children[0].partition();
			children[1].partition();
			children[2].partition();
			children[3].partition();

			// Staedteliste des urspruenglichen Quadrantens loeschen
			towns = null;
		}
	}

	/**
	 * Testprogramm aus Aufgabe c)
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Quad deutschland = new Quad(4, 46, 13, 10, 10);
		for (Town town : TownImporter.importTowns("DE.tab")) {
			deutschland.add(town);
		}
		QuadTreeDisplay.displayQuadTree(deutschland);

	}

}
