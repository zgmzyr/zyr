package com.zgm.chainOfResponsibility.filter;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements Filter {
	private List<Filter> filters = new ArrayList();
	
	
	
	public String doFilter(String msg){
		for(Filter filter : filters){
			msg = filter.doFilter(msg);
		}
		
		return msg;
	}
	
	public FilterChain addFilter(Filter filter){
		filters.add(filter);
		
		return this;
	}
	
	public List<Filter> getFilters() {
		return filters;
	}
	public void setFilters(List<Filter> filters) {
		this.filters = filters;
	}
}
