package com.zgm.chainOfResponsibility.filter;

import java.util.List;

public class MsbProcessor {
	private List<Filter> filters;
	public String doFilter(String msg){
		for(Filter filter : filters){
			msg = filter.doFilter(msg);
		}
		
		return msg;
	}
	
	public List<Filter> getFilters() {
		return filters;
	}
	public void setFilters(List<Filter> filters) {
		this.filters = filters;
	}
	
}
