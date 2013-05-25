package com.zgm.zen.composite.example3;

import java.util.ArrayList;


public class Client {

	public static void main(String[] args){
		
		Branch ceo  = compositeCorpTree();
		
		System.out.println(ceo.getInfo());
		
		System.out.println(getTreeInfo(ceo));
	}
	
	public static Branch compositeCorpTree(){
		
        Branch ceo = new Branch("zgm", "CEO", 1000000);
		
		Branch developDep = new Branch("周浩", "开发部经理", 10000);
		Branch saleopDep = new Branch("周亚明", "销售部经理", 10000);
		Branch financeDep = new Branch("周文明", "财务部经理", 10000);
		
		Branch firstDevGroup = new Branch("张三", "开发一组长", 6000);
		Branch secondDevGroup = new Branch("李四", "开发二组长", 7000);
		
		Leaf a = new Leaf("a", "开发人员", 2000);
		Leaf b = new Leaf("b", "开发人员", 2000);
		Leaf c = new Leaf("c", "开发人员", 2000);
		Leaf d = new Leaf("d", "开发人员", 2000);
		Leaf e = new Leaf("e", "开发人员", 2000);
		Leaf f = new Leaf("f", "开发人员", 2000);
		Leaf g = new Leaf("g", "开发人员", 2000);
		Leaf h = new Leaf("h", "销售人员", 4000);
		Leaf i = new Leaf("i", "销售人员", 4000);
		Leaf j = new Leaf("j", "财务人员", 5000);
		Leaf k = new Leaf("k", "CEO秘书", 8000);
		
		Leaf zhengLaoLiu = new Leaf("郑老六", "研发部副总", 20000); 
		
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
		ArrayList<Corp> subordinateList = root.getSubordinate();
		String info = "";
		
		for(Corp s : subordinateList){
			if(s instanceof Leaf){
				info = info + s.getInfo() + "\n";
			}else{
				info = info + s.getInfo() + "\n" + getTreeInfo((Branch) s);
			}
		}
		
		return info;
	}
	
	
}

/*public class Client {

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
	
	
}*/



