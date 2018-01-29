package com.muzima.api.dao.impl;

import com.muzima.api.dao.EncounterTypeDao;
import com.muzima.api.model.EncounterType;

public class EncounterTypeDaoImpl extends OpenmrsDaoImpl<EncounterType> implements EncounterTypeDao {
    //private static final String TAG = EncounterTypeDaoImpl.class.getSimpleName();
    protected EncounterTypeDaoImpl() { super(EncounterType.class); }

}
