package com.bsabbath.intuicity.web.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.lang.StringUtils;

import com.bsabbath.intuicity.model.ErrorMessage;
import com.bsabbath.intuicity.model.helper.ProvinceEnum;

public class Cities {

    public void addCity(City pCity)
    {
    	getCities().add(pCity);
    }

    public void addAll(Collection<City> pCities)
    {
    	getCities().addAll(pCities);
    }

    public List<City> getCities() {
    	
    	if (null == this.cities)
    	{
    		setCities(new ArrayList<City>());
    	}
    	
        return cities;
    }
    
    public Cities getCities(ProvinceEnum province) {
    	
    	Cities citiesForProvince = new Cities() ;
    	
    	if (null != this.cities)    		    		
    	{
    		citiesForProvince.addAll(CollectionUtils.select(getCities(), new ProvincePredicate(province)));;
    	}
    	
        return citiesForProvince;
    }    

    public void setCities(List<City> cities) {
        this.cities = cities;
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
    
	@XmlElementWrapper(name="cities")
	@XmlElement (name="city")
    private List<City> cities;
	
	@XmlElement (name="error")
	private ErrorMessage errorMessage ;

	@Override
	public String toString() {
        return StringUtils.join(cities, ",");	        
	}
	
	public static class ProvincePredicate implements Predicate
	{
		private ProvinceEnum province;
		
		public ProvincePredicate(ProvinceEnum province)
		{
			this.province = province;
		}

		public boolean evaluate(Object objToEvaluate) 
		{
			boolean evaluationResult = false;
			
			if (objToEvaluate instanceof City)
			{
				City city = (City) objToEvaluate;
				
				if (null != province)
				{
					String provinceCode = province.getCode();
					
					evaluationResult = provinceCode.equals(city.getCode().getProvince());
				}
				
			}
			
			return evaluationResult;
		}
		
	}
}
