package com.zgm.tdd.third._2_6;

import java.util.Map;

public class VariableSegment implements Segment {
	private String name;
	
	public VariableSegment(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		/*if (this == obj) {
			return true;
		}
		
		if (obj != null && obj instanceof Variable) {
			Variable variable = (Variable) obj;
			
			if (variable.name.equals(this.name)) {
				return true;
			} else {
				return false;
			}
		} 
		
		return false;*/
		
		if (obj == this) {
			return true;
		}
		
		if (!(obj instanceof VariableSegment)) {
			return false;
		}
		
		VariableSegment variable = (VariableSegment) obj;
		
		/*return (variable.name == null) ?
				(this.name == null) :
				(variable.name.equals(this.name));*/
		
		//如果vaiable.name this.name 通常是相同的引用的话，这种判断方法快些
		 return (variable.name == this.name) ||
				 (variable.name != null && variable.name.equals(this.name)); 		
			
	}
	
	@Override
	public int hashCode() {
		
		return super.hashCode();
	}

	@Override
	public void appendTo(StringBuilder result, Map<String, String> variables) {
		
	}

	@Override
	public String evaluate(Map<String, String> variables) {
		return variables.get(name);
	}

}
