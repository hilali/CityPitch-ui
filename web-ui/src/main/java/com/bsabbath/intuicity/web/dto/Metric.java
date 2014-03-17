package com.bsabbath.intuicity.web.dto;

import com.bsabbath.intuicity.model.helper.MetricEnum;

public class Metric {
	
	private MetricEnum name;
	
	private MetricValue value;
	
	public Metric() {
		super();
	}	

	public Metric(MetricEnum name) {
		super();
		this.name = name;
	}

	public Metric(MetricEnum name, MetricValue value) {
		super();
		this.name = name;
		this.value = value;
	}

	public MetricEnum getName() {
		return name;
	}

	public void setName(MetricEnum name) {
		this.name = name;
	}		
	
	public MetricValue getValue() {
		return value;
	}

	public void setValue(MetricValue value) {
		this.value = value;
	}

	@Override
	public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("[");        
        sb.append("\"");
        sb.append(name);
        sb.append("\"");
        sb.append(",");
        sb.append("\"");
        sb.append(value);
        sb.append("\"");        
        sb.append("]");
        
        return sb.toString();	
        
	}
	
}
