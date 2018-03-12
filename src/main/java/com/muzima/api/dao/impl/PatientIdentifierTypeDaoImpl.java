package com.muzima.api.dao.impl;

import com.muzima.api.dao.PatientIdentifierTypeDao;
import com.muzima.api.model.PatientIdentifierType;

public class PatientIdentifierTypeDaoImpl extends OpenmrsDaoImpl<PatientIdentifierType> implements PatientIdentifierTypeDao {
    private static final String TAG = PatientIdentifierTypeDaoImpl.class.getSimpleName();
    protected PatientIdentifierTypeDaoImpl(){
        super(PatientIdentifierType.class);
    }
}
