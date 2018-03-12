package com.muzima.api.dao;

import com.google.inject.ImplementedBy;
import com.muzima.api.dao.impl.PersonAttributeTypeDaoImpl;
import com.muzima.api.model.PersonAttributeType;

@ImplementedBy(PersonAttributeTypeDaoImpl.class)
public interface PersonAttributeTypeDao extends OpenmrsDao<PersonAttributeType>{
}
