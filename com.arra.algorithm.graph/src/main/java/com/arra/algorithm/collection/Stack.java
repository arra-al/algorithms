package com.arra.algorithm.collection;

import java.util.Iterator;

public class Stack<T> implements Iterable<T> {
	private Node<T> first; //top of stack (most recently added node)
	private int N = 0;//number of items

	public boolean isEmpty() {
		return first == null;//N == 0
	}
	
	public int size() {
		return N;
	}
	
	public void push(T item) {
		Node<T> oldFirst = first;
		first = new Node<T>();
		first.item = item;
		first.next = oldFirst;
		N++;
	}
	
	public T pop() {
		T item = first.item;
		first = first.next;
		N--;
		return item;
	}
	
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new ListIterator<T>(first);
	}
}
