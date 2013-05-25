package com.zgm.zen.composite.example2;

import java.util.ArrayList;

public interface IBranch extends ICorp {

	/*public String getInfo();
	
	public void add(IBranch branch);
	
	public void add(ILeaf leaf);
	
	public ArrayList getSubordinateInfo();*/
	
	public void addSubordinate(ICorp corp);
	
	public ArrayList<ICorp> getSubordinate();
	
	public void delSubordinate(ICorp corp);
	
	
}
