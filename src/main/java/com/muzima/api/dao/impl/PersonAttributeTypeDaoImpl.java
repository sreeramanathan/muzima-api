package com.muzima.api.dao.impl;

import com.muzima.api.dao.PersonAttributeTypeDao;
import com.muzima.api.model.PersonAttributeType;

public class PersonAttributeTypeDaoImpl extends OpenmrsDaoImpl<PersonAttributeType> implements PersonAttributeTypeDao {
    private static final String TAG = PersonAttributeTypeDaoImpl.class.getSimpleName();
            PersonAttributeTypeDaoImpl(){
        super(PersonAttributeType.class);
    }
}
