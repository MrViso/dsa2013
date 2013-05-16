package de.unistuttgart.dsa2013.ws4;

import java.awt.Dimension;

/**
 * Implementation fuer optimale Ausgabe der Knoten.
 * 
 * @author Maximilian Visotschnig
 * @author Frank Merkle
 * @author Alessandro Tridico
 * @version 2013-05-15 MV 1.0 Erste Version
 * @version 2013-05-16 MV 1.1 Exceptions eingefuegt
 * @history 2013-05-16 MV 1.1 
 * 
 * @param <T>
 *            Der Datentyp der in den Knoten gespeichert wird.
 */
public class MyTreeInfoProvider<T> implements TreeInfoProvider<T> {

	/**
	 * Gibt den horizontalen Abstand zurueck.
	 * 
	 * @return Horizontalabstand
	 */
	@Override
	public int getHSpacing() {
		//TODO
		return 130;
	}

	/**
	 * Gibt den vertikalen Abstand zurueck.
	 * 
	 * @return Vertikalabstand
	 */
	@Override
	public int getVSpacing() {
		//TODO
		return 50;
	}
	
	public int rec_overwrite = 0;

	/**
	 * Berechnet den Abstand zwischen Knoten und Kindsknoten
	 * 
	 * @param sizeStorage
	 *            Berechnete Groessen die gespeichert werden.
	 * @param root
	 *            Wurzel des Baums
	 * @throws IllegalArgumentException
	 *             Falls eines der Argumente null ist
	 */
	@Override
	public void computeSizes(TreeSizeStorage<T> sizeStorage,
			GenericTreeNode<T> root) throws IllegalArgumentException {
		
		//Exception falls sizeStorage null ist
		if (sizeStorage == null)
			throw new IllegalArgumentException("sizeStorage ist null");
		
		//Exception falls die Wurzel null ist
		if (root == null)
			throw new IllegalArgumentException("Wurzel ist null");

		
		Dimension sizeNode = new Dimension();
		Dimension sizeTree = new Dimension();
		sizeNode.height = 20;
		sizeNode.width = 30;
		sizeTree.height = 20;
		sizeTree.width = -30;

		sizeStorage.setNodeSize(root, sizeNode);
		
		if(rec_overwrite == 0)
		{
			//Setze die Position der Wurzel
			sizeTree.width = 100;
			sizeStorage.setSubtreeSize(root, sizeTree);
		}
			
		//rec_overwrite auf 1 setzen, damit für die Kinder die Position nicht falsch gesetzt wird.
		rec_overwrite = 1;
		

		for (int i = 0; i < root.getChildCount(); i++){
			computeSizes(sizeStorage, root.getChildAt(i));
		
			//Falls es mehr als 0 Knoten gibt muss für die verästelung noch etwas getan werden..
			if(root.getChildAt(i).getChildCount() > 0)
			{
				int i2 = 0;
				while(i2 < root.getChildAt(i).getChildCount())
				{	
					//Neue Dimension für die Verästelungen tieferer Ebenen
					Dimension sizeTree_temp = new Dimension();
					sizeTree_temp.height = sizeTree.height;
					sizeTree_temp.width = -20;			
					
					//Die breite je mit der Kinderanzahl multiplizieren
					sizeTree_temp.width = sizeTree_temp.width * root.getChildAt(i).getChildCount();

					
					sizeStorage.setSubtreeSize(root.getChildAt(i).getChildAt(i2), sizeTree_temp);

					i2++;
				}		
			}
		}
	}

}
