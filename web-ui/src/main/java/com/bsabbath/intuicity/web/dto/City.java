package com.bsabbath.intuicity.web.dto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import com.bsabbath.intuicity.model.helper.CityEnum;

@XmlAccessorType(XmlAccessType.FIELD)
public class City {
	
	private CityEnum code;
	
	@XmlElementWrapper(name="metrics")
	@XmlElement (name="metric")	
	private List<Metric> metrics;
	
	private float latitude;
	private float longitude;
	
	public City() {
		super();
	}

	public City(CityEnum code) {
		super();
		this.code = code;
	}

	public City(CityEnum code, float latitude, float longitude) {
		super();
		this.code = code;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public CityEnum getCode() {
		return code;
	}

	public void setCode(CityEnum code) {
		this.code = code;
	}
	
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

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("[");        
        sb.append("\"");
        sb.append(code);
        sb.append("\"");
        sb.append(",");
        sb.append("\"");
        sb.append(latitude);
        sb.append("\""); 
        sb.append(",");
        sb.append("\"");
        sb.append(longitude);
        sb.append("\"");      
        sb.append("]");
        
        return sb.toString();	
        
	}
	
}
