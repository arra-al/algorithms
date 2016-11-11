package com.arra.algorithm.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bag<T> implements Iterable<T> {

	private Node<T> first; // beginning of bag
	private int n; // number of elements in bag

	public Bag() {
		first = null;
		n = 0;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return n;
	}

	public void add(T item) {
		Node<T> oldFirst = first;
		first = new Node<T>();
		first.item = item;
		first.next = oldFirst;
		n++;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new ListIterator<T>(first);
	}
}
