package com.zgm.zen.state.example2;

public class Lift implements ILift {

	private int state;
	
	@Override
	public void setState(int state){
		this.state = state;
	}
	
	@Override
	public void close() {
		switch(this.state){
		case OPENING_STATE:
			this.closeWithoutLogic();
			this.setState(CLOSING_STATE);
			break;
		case CLOSING_STATE:
			//不做任何事
			break;
		case RUNNING_STATE:
			//不做任何事
			break;
		case STOPING_STATE:
			//不做任何事
			break;
		}
		
	}

	@Override
	public void open() {
		switch(this.state){
		case OPENING_STATE:
			//不做任何事
			break;
		case CLOSING_STATE:
			this.openWithoutLogic();
			this.setState(OPENING_STATE);
			break;
		case RUNNING_STATE:
			//不做任何事
			break;
		case STOPING_STATE:
			this.openWithoutLogic();
			this.setState(OPENING_STATE);
			break;
		}
	}

	@Override
	public void run() {
		switch(this.state){
		case OPENING_STATE:
			//不做任何事
			break;
		case CLOSING_STATE:
			this.runWithoutLogic();
			this.setState(RUNNING_STATE);
			break;
		case RUNNING_STATE:
			//不做任何事
			break;
		case STOPING_STATE:
			this.runWithoutLogic();
			this.setState(RUNNING_STATE);
			break;
		}
	}

	@Override
	public void stop() {

		switch(this.state){
		case OPENING_STATE:
			//不做任何事
			break;
		case CLOSING_STATE:
			this.stopWithoutLogic();
			this.setState(STOPING_STATE);
			break;
		case RUNNING_STATE:
			this.stopWithoutLogic();
			this.setState(STOPING_STATE);
		case STOPING_STATE:
			//不做任何事
			break;
		}
	}
	
	private void closeWithoutLogic(){
		System.out.println("电梯门关闭。。。");
	}
	
	private void openWithoutLogic(){
		System.out.println("电梯门开启。。。");
	}
	
	private void runWithoutLogic(){
		System.out.println("电梯运行。。。");
	}
	
	private void stopWithoutLogic(){
		System.out.println("电梯停止。。。");
	}
	

}
