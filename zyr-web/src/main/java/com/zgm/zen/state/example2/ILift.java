package com.zgm.zen.state.example2;


public interface ILift {

	public final static int OPENING_STATE = 1; //
	public final static int CLOSING_STATE = 2; // 闭门状态
	public final static int RUNNING_STATE = 3; // 运行状态
	public final static int STOPING_STATE = 4; // 停止状态
	
	public void setState(int state);
	
	public void open();
	
	public void close();
	
	public void run();
	
	public void stop();
}
/*public interface ILift {

	
	public void open();
	
	public void close();
	
	public void run();
	
	public void stop();
}*/
