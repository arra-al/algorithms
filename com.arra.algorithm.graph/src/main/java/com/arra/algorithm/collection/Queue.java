package com.arra.algorithm.collection;

import java.util.Iterator;

public class Queue<T> implements Iterable<T> {

	private Node<T> first; //link to least recently added node
	private Node<T> last; //link to most recently added node;
	private int N; //number of items on the queue
	
	public boolean isEmpty() {
		return first == null; // N == 0
	}
	
	public int size() {
		return N;
	}
	
	public void enqueue(T item) {
		// add new item to the end of the list
		Node<T> oldLast = last;
		last = new Node<T>();
		last.item = item;
		last.next = null;
		if(isEmpty()) {
			first = last;
		} else {
			oldLast.next = last;
		}
		N++;
	}
	
	public T dequeue() {
		//remove item from beginning of the list
		T item = first.item;
		first = first.next;
		if(isEmpty()) last = null;
		N--;
		return item;
	}
	
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new ListIterator<T>(first);
	}

}
