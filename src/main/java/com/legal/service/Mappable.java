package com.legal.service;

import java.util.List;

public interface Mappable<T extends Object> {

	public Object convertToModel(Object domainObject);

	public Object convertToDomain(Object modelObject);

	public List<? extends Object> convertToModelList(List<Object> domainlist);

	public List<? extends Object> convertToDomainList(List<Object> modelList);

}
