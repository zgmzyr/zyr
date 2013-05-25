package com.zgm.zen.command.example2;

public abstract class Command {

	protected RequirementGroup rg = new RequirementGroup();
	protected PageGroup pg = new PageGroup();
	protected CodeGroup cg = new CodeGroup();
	
	public abstract void execute();
}
