package com.zgm.zen.iterator.example;

import java.util.ArrayList;

public class Boss {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ArrayList<IProject> projectList = new ArrayList<IProject>();
		
		projectList.add(new Project("星球大战项目", 10, 10000));
		projectList.add(new Project("项目2", 120, 100030));
		projectList.add(new Project("项目3", 220, 200030));
		projectList.add(new Project("项目4", 20, 10030));
		projectList.add(new Project("项目5", 50, 100037));
		
		for(int i = 5; i < 50; i++){
			projectList.add(new Project("第" + i + "个项目", i + 5, i * 100000));
		}
		
		for(IProject project : projectList){
			System.out.println(project.getProjectInfo());
		}
	}

}
