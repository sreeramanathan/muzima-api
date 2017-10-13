package com.muzima.api.dao;

import com.google.inject.ImplementedBy;
import com.muzima.api.dao.impl.MuzimaSettingDaoImpl;
import com.muzima.api.model.MuzimaSetting;
import org.apache.lucene.queryParser.ParseException;

import java.io.IOException;

@ImplementedBy(MuzimaSettingDaoImpl.class)
public interface MuzimaSettingDao extends OpenmrsDao<MuzimaSetting> {
    MuzimaSetting getSettingByProperty(String property) throws IOException, ParseException;
}
