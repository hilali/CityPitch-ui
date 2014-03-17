package com.bsabbath.intuicity.web.dto;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.bsabbath.intuicity.model.ErrorMessage;

public class Metrics {
	

    public void addMetric(Metric pMetric)
    {
    	getMetrics().add(pMetric);
    }

    public List<Metric> getMetrics() {
    	
    	if (null == this.metrics)
    	{
    		setMetrics(new ArrayList<Metric>());
    	}
    	
        return metrics;
    }

    public void setMetrics(List<Metric> metrics) {
        this.metrics = metrics;
    }

	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public boolean hasErrors()
	{
		return (null != getErrorMessage());
	}
    
    private List<Metric> metrics;
	
	private ErrorMessage errorMessage ;

	@Override
	public String toString() {        
        return StringUtils.join(metrics, ",");	        
	}
}
