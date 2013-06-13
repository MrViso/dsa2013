package de.unistuttgart.dsa2013.ws7.answers;

import java.util.Set;

import de.unistuttgart.dsa2013.ws7.*;
/**
 * Implementation des NodeExpanders
 * 
 * @author Maximilian Visotschnig
 * @author Frank Merkle
 * @author Alessandro Tridico
 * @version 2013-06-13 MV 1.0 
 * @history 2013-06-13 MV 1.0 Erste Version
 * 
 * @param <E> Node Value Type
 * 
 */
public class MyNodeExpander<E> implements NodeExpander<E> {

	/**
	 * Node Expander orientiert am Vorbild des Pseudocodes der unter 
	 * http://de.wikipedia.org/wiki/A*-Algorithmus#Funktionsweise
	 * zu finden ist.
	 * 
	 * Es wird erst geprueft ob alle Parameter ungleich null sind, daraufhin
	 * folgt eine for-Schleife, welche alle Kanten des eines Knotens durchgeht
	 * und die darauffolgenden Knoten auf deren Entfernung prueft ungd ggf.
	 * anpasst.
	 */
	public void expand(ImmutableGraphNode<E> u, NodeFunctions<E> nodeFunctions,
			OpenSet<E> open, Set<Integer> closed) throws IllegalArgumentException{
		
		if (u == null)
			throw new IllegalArgumentException("u mustn't be null");
		if (nodeFunctions == null)
			throw new IllegalArgumentException("nodeFunctions mustn't be null");
		if (open == null)
			throw new IllegalArgumentException("open mustn't be null");
		if (closed == null)
			throw new IllegalArgumentException("closed mustn't be null");

		for (ImmutableGraphEdge<E> edge : u.getOutboundEdges()) {
			//Falls Knoten schon geschlossen ist wird dieser uebersprungen
			if (closed.contains(edge.getTarget())) {
				continue;
			}
			
			//eventueller g Wert berechnen
			double tentative_g = nodeFunctions.getG(u) + edge.getWeight();

			//falls dieses eventuelle g groeßer ist un d der Knoten schon in der 
			//geoeffneten Liste eingetragen wurde, wird auch uebersprungen
			if (open.contains(edge.getTarget())
					&& tentative_g >= nodeFunctions.getG(edge.getTarget())) {
				continue;
			}

			//den Vorgaenger des Kindes festlegen, dabei wird der g
			//Wert automatisch besetzt
			nodeFunctions.setPredecessor(edge.getTarget(), u);
			
			//Den F Wert aktualisieren und in die open Liste aktualisieren
			double f = tentative_g + nodeFunctions.getH(edge.getTarget());
			nodeFunctions.setF(edge.getTarget(), f);
			
			if (open.contains(edge.getTarget())){
				open.updateNodeF(edge.getTarget());
			}
			else {
				open.enqueue(edge.getTarget());
			}

		}

	}
}
