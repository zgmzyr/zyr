/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._15_atomicVariablesAndNonblockingSynchronization._4_nonblockingAlgorithms._2_aNonblockingLinkedList;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: LinkedQueue.java $Date: Jun 17, 2013 3:40:00 PM -0400 2013
 * @since 1.0
 * 
 */
// @ThreadSafe
public class LinkedQueue<E> {
	private static class Node<E> {
		final E item;
		final AtomicReference<Node<E>> next;

		public Node(E item, Node<E> next) {
			this.item = item;
			this.next = new AtomicReference<Node<E>>(next);
		}
	}

	private final Node<E> dummy = new Node<E>(null, null);
	private final AtomicReference<Node<E>> head = new AtomicReference<Node<E>>(dummy);
	private final AtomicReference<Node<E>> tail = new AtomicReference<Node<E>>(dummy);

	public boolean put(E item) {
		Node<E> newNode = new Node<E>(item, null);
		while (true) {
			Node<E> curTail = tail.get();
			Node<E> tailNext = curTail.next.get();
			if (curTail == tail.get()) {
				if (tailNext != null) {
					// Queue in intermediate state, advance tail
					tail.compareAndSet(curTail, tailNext);
				} else {
					// In quiescent state, try inserting new node
					if (curTail.next.compareAndSet(null, newNode)) {
						// Insertion succeeded, try advancing tail
						tail.compareAndSet(curTail, newNode);
						return true;
					}
				}
			}
		}
	}
}
