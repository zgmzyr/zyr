package com.zgm.zen.lod;

import java.util.ArrayList;
import java.util.List;

public class Client {

	public static void main(String[] args){
		List<Girl> listGirls = new ArrayList<Girl>();
		
		for(int i = 0; i < 20; i++){
			Girl girl = new Girl();
			listGirls.add(girl);
		}
		
		GroupLeader groupLeader = new GroupLeader(listGirls);
		
		Teacher teacher = new Teacher();
		
		teacher.commond(groupLeader);
	}
}
