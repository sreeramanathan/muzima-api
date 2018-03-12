package com.muzima.api.service;

import com.google.inject.ImplementedBy;
import com.muzima.api.model.MuzimaSetting;
import com.muzima.api.service.impl.MuzimaSettingServiceImpl;
import com.muzima.util.Constants;
import org.apache.lucene.queryParser.ParseException;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@ImplementedBy(MuzimaSettingServiceImpl.class)
public interface MuzimaSettingService extends MuzimaInterface {
    List<MuzimaSetting> downloadAllSettings(final Date syncDate)  throws IOException;
    MuzimaSetting downloadSettingByUuid(final String uuid)  throws IOException;
    MuzimaSetting downloadSettingByProperty(final String property)  throws IOException;
    void saveSetting(MuzimaSetting setting) throws IOException;
    void updateSetting(MuzimaSetting setting) throws IOException;
    Integer countAllSettings() throws IOException;
    MuzimaSetting getSettingByUuid(final String uuid) throws IOException;
    MuzimaSetting getSettingByProperty(final String property) throws IOException,ParseException;
    List<String> getMandatorySettingsProperties();
    Boolean isAllMandatorySettingsDownloaded() throws IOException,ParseException;
    List<String> getNonDownloadedMandatorySettingsProperties() throws IOException, ParseException;
}
