package com.arra.algorithm.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

class ListIterator<T> implements Iterator<T> {

	private Node<T> current;

	public ListIterator(Node<T> first) {
		current = first;
	}

	@Override
	public boolean hasNext() {
		return current != null;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

	@Override
	public T next() {
		if (!hasNext())
			throw new NoSuchElementException();
		T item = current.item;
		current = current.next;
		return item;
	}

}
