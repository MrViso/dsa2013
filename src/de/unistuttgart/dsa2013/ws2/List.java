// Kopfkommentar nicht vergessen - siehe Styleguide
package de.unistuttgart.dsa2013.ws2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class List<T extends Comparable<? super T>> implements Iterable<T> {
	
	private class ListIterator implements Iterator<T> {
		
		public ListIterator(Node<T> first) {
			if (first == null) {
				throw new IllegalArgumentException("first must not be null.");
			}
			
			next = first;
		}
		
		private Node<T> next;
		
		@Override
		public boolean hasNext() {
			return next != null;
		}

		@Override
		public T next() {
			if (next != null) {
				T result = next.getValue();
				next = next.getNext();
				return result;
			} else {
				throw new NoSuchElementException();
			}
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	
	private class Node<T> {
		
		private T value;
		
		private Node<T> next, prev;

		public T getValue() {
			return value;
		}

		public void setValue(T value) {
			this.value = value;
		}

		public Node<T> getNext() {
			return next;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}

		public Node<T> getPrev() {
			return prev;
		}

		public void setPrev(Node<T> prev) {
			this.prev = prev;
		}
	}
	
	private Node<T> first, last;
	
	private int count;
	
	public int getCount() {
		return count;
	}
	
	public void add(T value) {
		if (value == null) {
			throw new IllegalArgumentException("value must not be null.");
		}
		
		Node<T> newItem = new Node<T>();
		newItem.setValue(value);
		
		if (first == null) {
			first = newItem;
			last = newItem;
		} else {
			last.next = newItem;
			newItem.setPrev(last);
			last = newItem;
		}
		count++;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public Iterator<T> iterator() {
		return new ListIterator(first);
	}
	
	public void sort(boolean shakerSort) {
		if (!isEmpty()) {
			boolean hasChanged;
			do {
				hasChanged = false;
				
				for (Node<T> current = first; current.getNext() != null; current = current.getNext()) {
					if (current.getValue().compareTo(current.getNext().getValue()) > 0) {
						hasChanged = true;
						
						T buf = current.getValue();
						current.setValue(current.getNext().getValue());
						current.getNext().setValue(buf);
					}
				}
			} while (hasChanged);
		}
	}
}
