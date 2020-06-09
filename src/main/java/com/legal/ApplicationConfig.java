package com.legal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.modelmapper.AbstractConverter;
import org.modelmapper.AbstractProvider;

import org.modelmapper.ModelMapper;
import org.modelmapper.Provider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		stringToLocalDateConverter(modelMapper);
		localDateToStringConverter(modelMapper);
		return modelMapper;
	}
	public static void stringToLocalDateConverter(ModelMapper modelMapper)
	{
		Provider<LocalDate> localDateProvider = new AbstractProvider<LocalDate>() {
	        @Override
	        public LocalDate get() {
	            return LocalDate.now();
	        }
	    };

	    AbstractConverter<String, LocalDate> toStringDate = new AbstractConverter<String, LocalDate>() {
	        @Override
	        protected LocalDate convert(String source) {
	            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	            LocalDate localDate = source==null?LocalDate.now(): LocalDate.parse(source, format);
	            return localDate;
	        }
	    };


	    modelMapper.createTypeMap(String.class, LocalDate.class);
	    modelMapper.addConverter(toStringDate);
	    modelMapper.getTypeMap(String.class, LocalDate.class).setProvider(localDateProvider);
	}
	public static void localDateToStringConverter(ModelMapper modelMapper)
	{
		Provider<String> localDateProvider = new AbstractProvider<String>() {
	        @Override
	        public String get() {
	        	DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	            return format.format(LocalDate.now());
	        }
	    };

	    AbstractConverter<LocalDate, String> toStringDate = new AbstractConverter<LocalDate,String>() {
	        @Override
	        protected String convert(LocalDate source) {
	            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	            String localDate = source==null?"": source.format(format);
	            return localDate;
	        }
	    };


	    modelMapper.createTypeMap(LocalDate.class,String.class);
	    modelMapper.addConverter(toStringDate);
	    modelMapper.getTypeMap(LocalDate.class,String.class).setProvider(localDateProvider);
	}
}
