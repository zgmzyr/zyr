package com.zgm.zen.dip;

public class Sort{
	public static void main(String[] args){
		Sort s= new Sort();
		int a,b,c,d,e;
		int x[]=new int[5];
		for(a=1;a<6;a++){
			x[0]=a;
			for(b=1;b<6;b++){
				x[1]=b;
				for(c=1;c<6;c++){
					x[2]=c;
					for(d=1;d<6;d++){
						x[3]=d;
						for(e=1;e<6;e++){
							x[4]=e;
						if(s.sort(x) && x[3]!=4 && s.abc(x)){
							for(int i=0;i<x.length;i++)
							    System.out.print(x[i]);
							System.out.println();
						}
						}
					}
				}
			}
		}
	}
	public boolean sort(int x[]){
		for(int i=1;i<x.length-1;i++)
			for(int j=i+1;j<x.length;j++){
				if(x[i]==x[j])  
					return false;
			}
		return true;
	}
	public boolean abc(int a[]){
		for(int i=0;i<a.length-1;i++){
				if((a[i]==5&&a[i+1]==3)|| (a[i]==3&&a[i+1]==5))
					return false;
			}return true;
	}
}
