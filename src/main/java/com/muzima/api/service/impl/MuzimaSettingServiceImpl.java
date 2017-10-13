package com.muzima.api.service.impl;

import com.google.inject.Inject;
import com.muzima.api.dao.MuzimaSettingDao;
import com.muzima.api.model.MuzimaSetting;
import com.muzima.api.service.MuzimaSettingService;
import com.muzima.search.api.util.CollectionUtil;
import com.muzima.util.Constants;
import com.muzima.util.DateUtils;
import org.apache.lucene.queryParser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MuzimaSettingServiceImpl implements MuzimaSettingService {
    @Inject
    MuzimaSettingDao dao;

    @Override
    public List<MuzimaSetting> downloadAllSettings( final Date syncDate) throws IOException{
        Map<String, String> parameter = new HashMap<String, String>();
        if (syncDate != null) {
            parameter.put("syncDate", DateUtils.getUtcTimeInIso8601(syncDate));
        }
        return dao.download(parameter, Constants.UUID_MUZIMA_SETTING_RESOURCE);

    }

    @Override
    public MuzimaSetting downloadSettingByUuid(final String uuid) throws IOException{
        MuzimaSetting setting = null;
        Map<String, String> parameter = new HashMap<String, String>() {{
            put("uuid", uuid);
        }};
        List<MuzimaSetting> settings = dao.download(parameter, Constants.UUID_MUZIMA_SETTING_RESOURCE);
        if (!CollectionUtil.isEmpty(settings)) {
            if (settings.size() > 1) {
                throw new IOException("Unable to uniquely identify a setting record.");
            }
            setting = settings.get(0);
        }
        return setting;
    }

    @Override
    public MuzimaSetting downloadSettingByProperty(final String property) throws IOException{
        MuzimaSetting setting = null;
        Map<String, String> parameter = new HashMap<String, String>() {{
            put("q", property);
        }};
        List<MuzimaSetting> settings = dao.download(parameter, Constants.SEARCH_MUZIMA_SETTING_RESOURCE);

        if (!CollectionUtil.isEmpty(settings)) {
            if (settings.size() > 1) {
                throw new IOException("Unable to uniquely identify a setting record.");
            }
            setting = settings.get(0);
        }
        return setting;
    }

    @Override
    public void saveSetting(final MuzimaSetting muzimaSetting) throws IOException{
        dao.save(muzimaSetting, Constants.UUID_MUZIMA_SETTING_RESOURCE);
    }

    @Override
    public void updateSetting(final MuzimaSetting muzimaSetting) throws IOException{
        dao.update(muzimaSetting, Constants.UUID_MUZIMA_SETTING_RESOURCE);
    }

    @Override
    public Integer countAllSettings() throws IOException{
        return dao.countAll();
    }

    @Override
    public MuzimaSetting getSettingByUuid(final String uuid) throws IOException{
        return dao.getByUuid(uuid);
    }

    @Override
    public MuzimaSetting getSettingByProperty(final String property)throws IOException, ParseException {
        return dao.getSettingByProperty(property);
    }

    @Override
    public List<String> getMandatorySettingsProperties(){
        List<String> properties = new ArrayList<String>();
        properties.add(Constants.ServerSettings.PATIENT_IDENTIFIER_AUTOGENERATTION_SETTING);
        return properties;
    }

    @Override
    public Boolean isAllMandatorySettingsDownloaded() throws IOException,ParseException{
        List<String> properties = getMandatorySettingsProperties();
        for (String property:properties){
            if(getSettingByProperty(property) == null){
                return false;
            }
        }
        return true;
    }

    @Override
    public List<String> getNonDownloadedMandatorySettingsProperties() throws IOException, ParseException {
        List<String> properties = new ArrayList<String>();
        for (String property:getMandatorySettingsProperties()){
            if(getSettingByProperty(property) == null){
                properties.add(property);
            }
        }
        return properties;
    }

}
