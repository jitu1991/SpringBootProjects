package com.udemy.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	/*@GetMapping("/filtering")
	public TestBean retrieveBean() {
		return new TestBean("value1", "value2", "value3");
	}*/
	
	@GetMapping("filtering")
	public MappingJacksonValue retrieveBean() {
		TestBean bean = new TestBean("value1", "value2", "value3");
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("TestBeanFilter", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(bean);
		mapping.setFilters(filters);
		return mapping;
	}
	
	@GetMapping("/filtering-list")
	public MappingJacksonValue retrieveListOfBeans() {
		List<TestBean> list = Arrays.asList(new TestBean("value1", "value2", "value3"), new TestBean("value11", "value22", "value33"));
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("TestBeanFilter", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(list);
		mapping.setFilters(filters);

		return mapping;
	}
}
