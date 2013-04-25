/**
 * 
 */
package de.unistuttgart.dsa2013.ws1;

/**
 * Klasse von generischen Knoten Node<T>, welche aus jeweils einem generischen
 * Wert value, einem Zeiger auf den nachesten Knoten und einem Zeiger auf den
 * achtnaechsten Knoten bestehen.
 * 
 * @author Maximilian Visotschnig, Frank Merkle, Alessandro Tridico
 * @history 2013-04-24 MV 1.0 Klasse integrieren
 * @history 2013-04.25 MV 1.1 Konstruktor erstellen
 * @history 2013-04.25 MV 1.2 achtNext privat setzen und nur noch mit Getter und
 *          Setter aufrufbar machen
 * @version 2013-04-25 MV 1.2
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
		 * Pruefung und Setzung der achtnaechsten Stelle des Knotens.
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
	public Node<T> getAchtNext() {
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
