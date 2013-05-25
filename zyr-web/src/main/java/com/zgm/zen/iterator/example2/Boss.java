package com.zgm.zen.iterator.example2;

import java.util.ArrayList;

public class Boss {

	
	/*public static void main(String[] args) {
		
		ArrayList<IProuect> projectList = new ArrayList<IProuect>();
		
		projectList.add(new Project("星球大战项目", 10, 10000));
		projectList.add(new Project("项目2", 120, 100030));
		projectList.add(new Project("项目3", 220, 200030));
		projectList.add(new Project("项目4", 20, 10030));
		projectList.add(new Project("项目5", 50, 100037));
		
		for(int i = 5; i < 50; i++){
			projectList.add(new Project("第" + i + "个项目", i + 5, i * 100000));
		}
		
		for(IProuect project : projectList){
			System.out.println(project.getProjectInfo());
		}
	}*/
	
	public static void main(String[] args) {
		IProject project = new Project();
		
		project.add("星球大战项目", 10, 10000);
		project.add("项目2", 120, 100030);
		project.add("项目3", 220, 200030);
		project.add("项目4", 20, 10030);
		project.add("项目5", 50, 100037);
		
		for(int i = 5; i < 50; i++){
			project.add("第" + i + "个项目", i + 5, i * 100000);
		}
		
		IProjectIterator projectIterator = project.iterator();
		
		while(projectIterator.hasNext()){
			IProject p = (IProject) projectIterator.next();
			
			System.out.println(p.getProjectInfo());
		}
	}

}
