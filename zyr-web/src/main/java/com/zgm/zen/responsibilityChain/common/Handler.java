package com.zgm.zen.responsibilityChain.common;

public abstract class Handler {

	private Handler nextHandler;
	
	//每个处理者都必须对请求做出处理
	public final Response handleMessage(Request request){
		Response response = null;
		
		if(this.getHandlerLevel().equals(request.getRequestlevel())){
			response = this.echo(request);
		}else{
			if(this.nextHandler != null){
				response = this.nextHandler.handleMessage(request);
			}else{
				//没有适当的处理者，业务自行处理
			}
		}
		
		return response;
	}
	
	//设置下一个处理是谁
	public void setNext(Handler nextHandler){
		this.nextHandler = nextHandler;
	}
	
	//每个处理者都有一个处理级别
	protected abstract Level getHandlerLevel();
	
	//每个处理者都 必须处理任务
	protected abstract Response echo(Request request);
}
