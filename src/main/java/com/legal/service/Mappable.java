package com.legal.service;

import java.util.List;

public interface Mappable<E, T> {

	public Object convertToModel(Object domainObject);

	public Object convertToDomain(Object modelObject);

	public List<Object> convertToModelList(List<E> domainlist);

	public List<Object> convertToDomainList(List<T> modelList);

}
