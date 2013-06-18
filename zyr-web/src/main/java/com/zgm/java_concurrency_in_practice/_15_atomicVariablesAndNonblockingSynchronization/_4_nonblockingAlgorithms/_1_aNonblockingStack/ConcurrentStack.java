/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._15_atomicVariablesAndNonblockingSynchronization._4_nonblockingAlgorithms._1_aNonblockingStack;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: ConcurrentStack.java $Date: Jun 17, 2013 3:08:56 PM -0400 2013
 * @since 1.0
 * 
 */
// @ThreadSafe
public class ConcurrentStack<E> {
	AtomicReference<Node<E>> top = new AtomicReference<Node<E>>();

	public void push(E item) {
		Node<E> newHead = new Node<E>(item);
		Node<E> oldHead;
		do {
			oldHead = top.get();
			newHead.next = oldHead;
		} while (!top.compareAndSet(oldHead, newHead));
	}

	public E pop() {
		Node<E> oldHead;
		Node<E> newHead;
		do {
			oldHead = top.get();
			if (oldHead == null) {
				return null;
			}
			
			newHead = oldHead.next;
		} while (!top.compareAndSet(oldHead, newHead));
		
		return oldHead.item;
	}

	private static class Node<E> {
		public final E item;
		public Node<E> next;

		public Node(E item) {
			this.item = item;
		}
	}
}
