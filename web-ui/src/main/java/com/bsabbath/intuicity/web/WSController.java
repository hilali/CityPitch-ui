package com.bsabbath.intuicity.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bsabbath.intuicity.model.helper.CityEnum;
import com.bsabbath.intuicity.model.helper.MetricEnum;
import com.bsabbath.intuicity.web.dto.Cities;
import com.bsabbath.intuicity.web.dto.City;
import com.bsabbath.intuicity.web.dto.Metric;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "ctl")
public class WSController {


	private static final Logger LOGGER = LoggerFactory.getLogger(WSController.class);
	
	@RequestMapping(value ="/home/map", method = RequestMethod.GET)
	public String getViewSummaryReportPage(Model model) 
	{
		
		
		return "map/all";
	}	
//
//
//	@RequestMapping(value = "/v1/metrics/{city}", method = RequestMethod.POST)
//	@ResponseBody
//	public Metrics getMetrics(@PathVariable String city,@RequestBody LifeQualityCriterias criterias)	
//	{
//		LOGGER.info("Metrics Asked for city ["+city+"]");
//		
//		LOGGER.info("NB LifeQualityCriterias  ["+((null != criterias) ? criterias.getCriterias().size():0)+"]");
//
//		Metrics metrics = null;
//		
//		try {
//			
//			metrics = new Metrics();
//			
//		}catch(NullPointerException e){ 
//			metrics = new Metrics();
//			metrics.setErrorMessage(new ErrorMessage("ERROR_CODE_BAD_ARGUMENTS", e.getMessage()));
//
//			LOGGER.error(metrics.getErrorMessage().toString());
//		}
//		catch (Exception e){
//			metrics = new Metrics();
//			metrics.setErrorMessage(new ErrorMessage("ERROR_CODE_UNDEFINED", e.getMessage()));
//			LOGGER.error(metrics.getErrorMessage().toString());
//		}
//		
//		return metrics;
//	}
//	
//	@RequestMapping(value = {"/v1/cities"}, method = RequestMethod.GET)
//	@ResponseBody
//	public Cities getCities()	
//	{
//		LOGGER.info("Cities Asked for All Country");
//
//		Cities cities = null;
//		City city = null;
//		
//		try {
//			
//			cities = getMockCities();
//			
//		}catch(NullPointerException e){ 
//			cities = new Cities();
//			cities.setErrorMessage(new ErrorMessage("ERROR_CODE_BAD_ARGUMENTS", e.getMessage()));
//
//			LOGGER.error(cities.getErrorMessage().toString());
//		}
//		catch (Exception e){
//			cities = new Cities();
//			cities.setErrorMessage(new ErrorMessage("ERROR_CODE_UNDEFINED", e.getMessage()));
//			LOGGER.error(cities.getErrorMessage().toString());
//		}
//		
//		return cities;
//	}
//	
//	@RequestMapping(value = {"/v1/cities/{province}"}, method = RequestMethod.GET)
//	@ResponseBody
//	public Cities getCities(@PathVariable String province)	
//	{
//		LOGGER.info("Cities Asked for Province ["+province+"]");
//
//		Cities cities = null;
//		
//		try {
//			
//			cities = getMockCities().getCities(ProvinceEnum.valueOf(province));
//			
//		}catch(NullPointerException e){ 
//			cities = new Cities();
//			cities.setErrorMessage(new ErrorMessage("ERROR_CODE_BAD_ARGUMENTS", e.getMessage()));
//
//			LOGGER.error(cities.getErrorMessage().toString());
//		}
//		catch (Exception e){
//			cities = new Cities();
//			cities.setErrorMessage(new ErrorMessage("ERROR_CODE_UNDEFINED", e.getMessage()));
//			LOGGER.error(cities.getErrorMessage().toString());
//		}
//		
//		return cities;
//	}
//	
	private Cities getMockCities()
	{		
		Cities cities = new Cities();
		City city = null;
		Metric metric = null;
		
		city = new City(CityEnum.MONTREAL,45.5f,-73.6f);
		metric = new Metric(MetricEnum.EDUCATION);
		city.addMetric(metric);
		metric = new Metric(MetricEnum.HEALTH);
		city.addMetric(metric);
		metric = new Metric(MetricEnum.SAFETY);
		city.addMetric(metric);
		cities.addCity(city);
		
		city = new City(CityEnum.QUEBEC,46.833f,-71.250f);
		metric = new Metric(MetricEnum.HEALTH);
		city.addMetric(metric);
		metric = new Metric(MetricEnum.SAFETY);
		city.addMetric(metric);
		cities.addCity(city);
		
		city = new City(CityEnum.TORONTO,43.70f,-79.417f);
		metric = new Metric(MetricEnum.EDUCATION);
		city.addMetric(metric);
		metric = new Metric(MetricEnum.HEALTH);
		city.addMetric(metric);
		metric = new Metric(MetricEnum.SAFETY);
		city.addMetric(metric);
		cities.addCity(city);
		
		city = new City(CityEnum.CALGARY,51.083f,-114.083f);
		metric = new Metric(MetricEnum.EDUCATION);
		city.addMetric(metric);
		cities.addCity(city);
		
		city = new City(CityEnum.VANCOUVER,49.217f,-123.10f);
		cities.addCity(city);
		
		return cities;		
	}
}
