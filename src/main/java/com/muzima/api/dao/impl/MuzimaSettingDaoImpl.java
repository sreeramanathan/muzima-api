package com.muzima.api.dao.impl;

import com.muzima.api.dao.MuzimaSettingDao;
import com.muzima.api.model.MuzimaSetting;
import com.muzima.search.api.util.CollectionUtil;
import com.muzima.search.api.util.StringUtil;
import org.apache.lucene.queryParser.ParseException;

import java.io.IOException;
import java.util.List;

public class MuzimaSettingDaoImpl extends OpenmrsDaoImpl<MuzimaSetting> implements MuzimaSettingDao {
    protected MuzimaSettingDaoImpl(){
        super(MuzimaSetting.class);
    }

    public MuzimaSetting getSettingByProperty(String property) throws IOException, ParseException {
        MuzimaSetting muzimaSetting = null;
        StringBuilder query = new StringBuilder();
        if (!StringUtil.isEmpty(property)) {
            query.append("property:").append(property);
        }
        List<MuzimaSetting> settings = service.getObjects(query.toString(), daoClass);
        if (!CollectionUtil.isEmpty(settings)) {
            if (settings.size() > 1) {
                throw new IOException("Unable to uniquely identify a setting using the property");
            }
            muzimaSetting = settings.get(0);
        }
        return muzimaSetting;
    }

}
