package com.sist.exam08;

import java.util.List;

public class ProtocolHandler {
	private List<Filter> filters;

	public void setFilters(List<Filter> filters) {
		this.filters = filters;
	}
	
	public void execute() {
		for(Filter filter:filters) {
			filter.execute();
		}
	}
}
