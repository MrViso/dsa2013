package de.unistuttgart.dsa2013.ws5;

public class ArrayTreeNode<T> implements GenericTreeNode<T> {
	private FixedSizeSerialBinTreeStorage<T> serialStorage;
	private int serialIndex;
	
	public ArrayTreeNode(FixedSizeSerialBinTreeStorage<T> serialStorage) throws IllegalArgumentException {
		if (serialStorage == null)
			throw new IllegalArgumentException("serialStorage darf nicht 'null' sein.");
		this.serialStorage = serialStorage;
		this.serialIndex = 0;
	}
	
	private ArrayTreeNode(FixedSizeSerialBinTreeStorage<T> serialStorage, int serialIndex) {
		// TODO
		this.serialStorage = serialStorage;
	}
	
	@Override
	public GenericTreeNode<T> getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GenericTreeNode<T> getChildAt(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GenericTreeNode<T> addChild(T value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getChildCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxChildCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNodeId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T getValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setValue(T value) {
		// TODO Auto-generated method stub
		
	}
	
	private int getLevelIndex(){
		//TODO ??
		return this.serialIndex;
	}
	

}
