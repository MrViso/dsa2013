package de.unistuttgart.dsa2013.ws5;

/**
 * Verwaltet den Knoten eines binaeren Array-Listen-Baums
 * 
 * @author Maximilian Visotschnig
 * @author Frank Merkle
 * @author Alessandro Tridico
 * @version 2013-05-30 MV 1.0
 * @history 2013-05-30 MV 1.0 Erste Version
 * 
 * @param <T>
 *            Der Datentyp der in den Knoten gespeichert wird..
 */
public class ArrayTreeNode<T> implements GenericTreeNode<T> {
	private FixedSizeSerialBinTreeStorage<T> serialStorage;
	private int serialIndex;
	private T value;

	/**
	 * Wird benoetigt um Wurzelknoten zu erstellen
	 * 
	 * @param serialStorage
	 *            der Storage List Array auf den verwiesen werden muss
	 * @throws IllegalArgumentException
	 *             Falls der Storage List Array mit null uebergeben wird
	 */
	public ArrayTreeNode(FixedSizeSerialBinTreeStorage<T> serialStorage)
			throws IllegalArgumentException {
		if (serialStorage == null)
			throw new IllegalArgumentException(
					"serialStorage darf nicht 'null' sein.");
		this.serialStorage = serialStorage;
		this.serialIndex = 0;
	}

	/**
	 * Wird benoetigt um Kinderknoten zu erstellen
	 * 
	 * @param serialStorage
	 *            der Storage List Array auf den verwiesen werden muss
	 * @param serialIndex
	 *            der Index im Array
	 * @throws IllegalArgumentException
	 *             Falls der Storage List Array mit null uebergeben wird
	 */
	private ArrayTreeNode(FixedSizeSerialBinTreeStorage<T> serialStorage,
			int serialIndex) throws IllegalArgumentException {
		if (serialStorage == null)
			throw new IllegalArgumentException(
					"serialStorage darf nicht 'null sein.");
		this.serialStorage = serialStorage;
		this.serialIndex = serialIndex;
	}

	/**
	 * Elternknoten des Elements
	 * 
	 * @return Den Elternknoten des aktuellen Knotens
	 */
	public GenericTreeNode<T> getParent() {
		int z = this.serialIndex - 1;
		if (z <= 1) {
			return null;
		}
		z = z % 2;
		if (z == 0) {
			z = ((this.serialIndex - 1) / 2);
		} else if (z == 1) {
			z = (this.serialIndex / 2);
		}
		// Welche Funktion gibt es sonst um Elemente von serialStorage auszugeben?
		// LEider nur serialStorage.getElement(z) wahrgenommen.
		return serialStorage.getElement(z);
	}

	/**
	 * Gibt das "index" Kind des Knotens aus
	 * 
	 * @return Gibt den Knoten des Kindes mit der Nummer index aus
	 * @throws IndexOutOfBoundsException
	 *             Falls der Index hoeher liegt als die Anzahl der moeglichen
	 *             Kinderknoten
	 */
	public GenericTreeNode<T> getChildAt(int index)
			throws IndexOutOfBoundsException {
		if (index > getMaxChildCount())
			throw new IndexOutOfBoundsException(
					"Index ist ausserhalb der Reichweite der Kinderknoten");
		int z = 2 * serialIndex + index;

		// Welche Funktion gibt es sonst um Elemente von serialStorage auszugeben?
		// LEider nur serialStorage.getElement(z) wahrgenommen.
		return serialStorage.getElement(z);
	}

	/**
	 * Fuegt einen Knoten nach moeglichkeit hinzu.
	 * 
	 * 
	 * @throws {@link UnsupportedOperationException} Falls die maximale Anzahl
	 *         an Kindern ausgreizt ist
	 */
	public GenericTreeNode<T> addChild(T value)
			throws UnsupportedOperationException, IllegalArgumentException {
		if (value == null)
			throw new IllegalArgumentException("Value ist null");
		if (getMaxChildCount() > getChildCount()) {
			GenericTreeNode<T> element = new ArrayTreeNode<T>(serialStorage,
					serialIndex * 2 + (getChildCount() + 1));
			element.setValue(value);
			return element;
		} else {
			throw new UnsupportedOperationException(
					"Maximale Anzahl an Kinderknoten schon ausgereizt");
		}

	}

	/**
	 * Gibt zurueck ob ein Knoten 0, 1 oder 2 Kinder hat
	 */
	public int getChildCount() {
		if (serialStorage.getElement((serialIndex * 2 + 1)) == null) {
			return 0;
		}
		if (serialStorage.getElement((serialIndex * 2 + 2)) == null) {
			return 1;
		} else {
			return 2;
		}
	}

	/**
	 * Gibt die maximale Anzahl an Knoten zurueck.
	 * 
	 * @return 0 falls Kinder auf letzter zugesicherter Speicherebene waeren.
	 * @return 2 in allen anderen Faellen
	 * 
	 */
	public int getMaxChildCount() {
		if (getLevelIndex() == serialStorage.getLevelCount()) {
			return 0;
		} else {
			return 2;
		}
	}

	/**
	 * Gibt die Knotenid aus.
	 */
	public int getNodeId() {
		return serialIndex;
	}

	/**
	 * Gibt Wert des Knotens aus
	 */
	public T getValue() {
		return this.value;
	}

	/**
	 * Speichert Wert des Knotens
	 * 
	 */
	public void setValue(T value) throws IllegalArgumentException {
		if (value == null)
			throw new IllegalArgumentException("Value darf nciht null sein");
		this.value = value;
	}

	/**
	 * Leitet den Levelindex des aktuellen Knotens her.
	 * 
	 * @return Levelindex des Knotens
	 */
	private int getLevelIndex() {
		int z = 0;
		double i = this.serialIndex - 1;
		while (i > 1) {
			i = i / 2;
			z++;
		}

		return z;
	}

}
