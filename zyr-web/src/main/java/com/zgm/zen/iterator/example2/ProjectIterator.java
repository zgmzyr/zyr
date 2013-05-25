package com.zgm.zen.iterator.example2;

import java.util.ArrayList;

import com.zgm.zen.iterator.example2.IProject;

public class ProjectIterator implements IProjectIterator {

	private ArrayList<IProject> projectList = new ArrayList<IProject>();
	private int currentItem = 0;
	
	public ProjectIterator(ArrayList<IProject> projectList){
		this.projectList = projectList;
	}
	
	@Override
	public boolean hasNext() {
		boolean b = true;
		if(this.currentItem  >= projectList.size() || this.projectList.get(this.currentItem) == null){
			b = false;
		}
		return b;
	}

	@Override
	public Object next() {
		return this.projectList.get(this.currentItem++);
	}

	@Override
	public void remove() {

		
	}

}
