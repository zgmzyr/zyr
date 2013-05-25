/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._4_composingObjects._4_addingFunctionalityToExistingThreadSafeClasses._2_Composition;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: ImprovedList.java $Date: May 14, 2013 3:49:22 PM -0400 2013
 * @since 1.0
 * 
 */
//@ThreadSafe
public class ImprovedList<T> implements List<T> {
	
	//TODO 只能是私有级别
    private final List<T> list;

    public ImprovedList(List<T> list) { this.list = list; }

    public synchronized boolean putIfAbsent(T x) {
        boolean contains = list.contains(x);
        if (contains)
            list.add(x);
        return !contains;
    }
    
    public synchronized void clear() { 
    	list.clear(); 
    }
    
    // ... similarly delegate other List methods

    //TOTO 其它方法都应该是synchronized
    @Override
	public int size() {
		//TODO
		return 0;
	}

	@Override
	public boolean isEmpty() {
		//TODO
		return false;
	}

	@Override
	public boolean contains(Object o) {
		//TODO
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		//TODO
		return null;
	}

	@Override
	public Object[] toArray() {
		//TODO
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		//TODO
		return null;
	}

	@Override
	public boolean add(T e) {
		//TODO
		return false;
	}

	@Override
	public boolean remove(Object o) {
		//TODO
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		//TODO
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		//TODO
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		//TODO
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		//TODO
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		//TODO
		return false;
	}

	@Override
	public T get(int index) {
		//TODO
		return null;
	}

	@Override
	public T set(int index, T element) {
		//TODO
		return null;
	}

	@Override
	public void add(int index, T element) {
		//TODO
		
	}

	@Override
	public T remove(int index) {
		//TODO
		return null;
	}

	@Override
	public int indexOf(Object o) {
		//TODO
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		//TODO
		return 0;
	}

	@Override
	public ListIterator<T> listIterator() {
		//TODO
		return null;
	}

	@Override
	public ListIterator<T> listIterator(int index) {
		//TODO
		return null;
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		//TODO
		return null;
	}
}


