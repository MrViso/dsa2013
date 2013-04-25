/**
 * 
 */
package de.unistuttgart.dsa2013.ws1;

/**
 * @author Maximilian Visotschnig,
 * 
 */
public class Node<T> {
	public T value;
	public Node<T> next = null;
	private Node<T> achtNext = null;

	/**
	 * Konstruktor für Knoten der Klasse Node<T>, welcher ein vorgegebenes value
	 * und zu einem vorgegeben naechsten Knoten verlinkt. Es wird automatisch
	 * geprueft ob ein Zeiger zum achtnaechsten Knoten festgelegt werden kann.
	 * 
	 * @param value
	 *            der generische Wert der dem Knoten zugeteilt wird
	 * @param nextNode
	 *            der Zeiger zum Knoten auf den der neuerzeugte Knoten zeigen
	 *            soll
	 * 
	 */
	public Node(T value, Node<T> nextNode) {
		this.value = value;
		this.next = nextNode;

		/*
		 * Pruefung und setzung der achtnaechsten Stelle des Knotens.
		 */
		setAchtnext(nextNode);

	}

	/**
	 * Setter für achtNext, da diese Variable privat gesetzt wurde um falsche
	 * Zugriffe zu vermeiden.
	 * 
	 * @return den Zeiger achtNext zur achtnaechsten Stelle, wenn verfuegbar,
	 *         sonst null
	 */
	public Node<T> getAchtnext() {
		return achtNext;
	}

	/**
	 * Getter für achtNext um sicherzustellen, dass der Zeiger nur auf die
	 * achtnaechste Stelle zeigt und keine anderen Werte eingelesen werden
	 * koennen.
	 * 
	 * @param nextNode
	 *            der Zeiger des aktuellen Knotens zu seinem naechsten. Ueber
	 *            diesen werden alle darauffolgenden geprueft um den
	 *            achtnaechsten zu finden und ggf. zu setzen
	 */
	public void setAchtnext(Node<T> nextNode) {
		if (nextNode == null)
			this.achtNext = null;
		else {
			Node<T> zeiger = nextNode;
			int i = 1;
			while ((i < 9 && zeiger.next != null) | (i == 8 && zeiger != null)) {
				if (i == 8 && zeiger != null) {
					this.achtNext = zeiger;
				}

				i++;
				zeiger = zeiger.next;
			}
		}
	}

}
