package com.muzima.api.dao;

import com.google.inject.ImplementedBy;
import com.muzima.api.dao.impl.PatientIdentifierTypeDaoImpl;
import com.muzima.api.model.PatientIdentifierType;

@ImplementedBy(PatientIdentifierTypeDaoImpl.class)
public interface PatientIdentifierTypeDao extends OpenmrsDao<PatientIdentifierType>{
}
