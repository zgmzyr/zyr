package com.zgm.chainOfResponsibility.javaWebfilter;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements Filter {
	private List<Filter> filters = new ArrayList();
	int index = 0;
	
	
	public void doFilter(Request request, Response response, FilterChain chain) {
		
		if(index == filters.size()){
			return;
		}
		
		Filter f = filters.get(index);
		index++;
		f.doFilter(request, response, chain);
/*		for(Filter filter : filters){
			filter.doFilter(request, response, chain);
		}
*/		
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
