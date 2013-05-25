package com.zgm.zen.command.example2;

public class AddRequirementCommand extends Command {

	@Override
	public void execute() {

		super.rg.find();
		super.rg.add();
		
		super.pg.add();
		super.cg.add();
		
		super.rg.plan();
	}

}
