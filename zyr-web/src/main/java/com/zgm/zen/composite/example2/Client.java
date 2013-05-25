package com.zgm.zen.composite.example2;

import java.util.ArrayList;

public class Client {

	public static void main(String[] args){
		
		Branch ceo  = compositeCorpTree();
		
		System.out.println(ceo.getInfo());
		
		System.out.println(getTreeInfo(ceo));
	}
	
	public static Branch compositeCorpTree(){
		
        Branch ceo = new Branch("zgm", "CEO", 1000000);
		
		IBranch developDep = new Branch("周浩", "开发部经理", 10000);
		IBranch saleopDep = new Branch("周亚明", "销售部经理", 10000);
		IBranch financeDep = new Branch("周文明", "财务部经理", 10000);
		
		IBranch firstDevGroup = new Branch("张三", "开发一组长", 6000);
		IBranch secondDevGroup = new Branch("李四", "开发二组长", 7000);
		
		ILeaf a = new Leaf("a", "开发人员", 2000);
		ILeaf b = new Leaf("b", "开发人员", 2000);
		ILeaf c = new Leaf("c", "开发人员", 2000);
		ILeaf d = new Leaf("d", "开发人员", 2000);
		ILeaf e = new Leaf("e", "开发人员", 2000);
		ILeaf f = new Leaf("f", "开发人员", 2000);
		ILeaf g = new Leaf("g", "开发人员", 2000);
		ILeaf h = new Leaf("h", "销售人员", 4000);
		ILeaf i = new Leaf("i", "销售人员", 4000);
		ILeaf j = new Leaf("j", "财务人员", 5000);
		ILeaf k = new Leaf("k", "CEO秘书", 8000);
		
		ILeaf zhengLaoLiu = new Leaf("郑老六", "研发部副总", 20000); 
		
		ceo.addSubordinate(developDep);
		ceo.addSubordinate(saleopDep);
		ceo.addSubordinate(financeDep);
		
		ceo.addSubordinate(k);
		
		developDep.addSubordinate(firstDevGroup);
		developDep.addSubordinate(secondDevGroup);
		
		developDep.addSubordinate(zhengLaoLiu);
		
		
		firstDevGroup.addSubordinate(a);
		firstDevGroup.addSubordinate(b);
		firstDevGroup.addSubordinate(c);
		
		secondDevGroup.addSubordinate(d);
		secondDevGroup.addSubordinate(f);
		secondDevGroup.addSubordinate(g);
		secondDevGroup.addSubordinate(e);
		
		saleopDep.addSubordinate(h);
		saleopDep.addSubordinate(i);
		
		financeDep.addSubordinate(j);
		
		return ceo;
	}
	
	public static String getTreeInfo(Branch root){
		ArrayList<ICorp> subordinateList = root.getSubordinate();
		String info = "";
		
		for(ICorp s : subordinateList){
			if(s instanceof ILeaf){
				info = info + s.getInfo() + "\n";
			}else{
				info = info + s.getInfo() + "\n" + getTreeInfo((Branch) s);
			}
		}
		
		return info;
	}
	
	/*public static void main(String[] args){
		
		IRoot ceo = new Root("zgm", "CEO", 1000000);
		
		IBranch developDep = new Branch("周浩", "开发部经理", 10000);
		IBranch saleopDep = new Branch("周亚明", "销售部经理", 10000);
		IBranch financeDep = new Branch("周文明", "财务部经理", 10000);
		
		IBranch firstDevGroup = new Branch("张三", "开发一组长", 6000);
		IBranch secondDevGroup = new Branch("李四", "开发二组长", 7000);
		
		ILeaf a = new Leaf("a", "开发人员", 2000);
		ILeaf b = new Leaf("b", "开发人员", 2000);
		ILeaf c = new Leaf("c", "开发人员", 2000);
		ILeaf d = new Leaf("d", "开发人员", 2000);
		ILeaf e = new Leaf("e", "开发人员", 2000);
		ILeaf f = new Leaf("f", "开发人员", 2000);
		ILeaf g = new Leaf("g", "开发人员", 2000);
		ILeaf h = new Leaf("h", "销售人员", 4000);
		ILeaf i = new Leaf("i", "销售人员", 4000);
		ILeaf j = new Leaf("j", "财务人员", 5000);
		ILeaf k = new Leaf("k", "CEO秘书", 8000);
		
		ILeaf zhengLaoLiu = new Leaf("郑老六", "研发部副总", 20000); 
		
		ceo.add(developDep);
		ceo.add(saleopDep);
		ceo.add(financeDep);
		
		ceo.add(k);
		
		developDep.add(firstDevGroup);
		developDep.add(secondDevGroup);
		
		developDep.add(zhengLaoLiu);
		
		
		firstDevGroup.add(a);
		firstDevGroup.add(b);
		firstDevGroup.add(c);
		
		secondDevGroup.add(d);
		secondDevGroup.add(f);
		secondDevGroup.add(g);
		secondDevGroup.add(e);
		
		saleopDep.add(h);
		saleopDep.add(i);
		
		financeDep.add(j);
		
		
		System.out.println(ceo.getInfo());
		
		getAllSubordinateInfo(ceo.getSubordinateInfo());
	}
	
	
	private static void getAllSubordinateInfo(ArrayList subordinateList){
		int length = subordinateList.size();
		
		for(int m = 0; m < length; m++){
			
			Object s = subordinateList.get(m);
			
			if(s instanceof Leaf){
				ILeaf employee = (ILeaf) s;
				System.out.println(((Leaf)s).getInfo());	
			}else{
				IBranch branch = (IBranch) s;
				System.out.println(branch.getInfo());
				
				getAllSubordinateInfo(branch.getSubordinateInfo());
			}
		}
	}*/
}
