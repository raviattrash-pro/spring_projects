package com.social_media.app_project.filter;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@SuppressWarnings("removal")
@RestController
public class FilterController {
	
	@GetMapping("filters")
	public  SomeBean filtering() {
		return new SomeBean("val1","val2","val3");
	}
	
	@GetMapping("filter-list")
	public  List<SomeBean> filterlist() {
		return Arrays.asList(new SomeBean("val1","val2","val3"),new SomeBean("val1","val2","val3"));
	}
	
	/*@GetMapping("filters-specific")
	public  MappingJacksonValue filteringspecific() {
		MappingJacksonValue mappingjacksonval = new MappingJacksonValue(SomeBean);
		SomeBean somebean = new SomeBean("val1","val2","val3");
		FilterProvider filter = new SimpleFilterProvider().addFilter("Some Bean filter", filter);
		mappingjacksonval.setFilters(filter);
		SimpleBeanPropertyFilter filters  = SimpleBeanPropertyFilter.filterOutAllExcept("filed1","fileld2") 
		return mappingjacksonval;
	}*/
	
}
