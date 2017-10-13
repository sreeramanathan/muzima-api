package com.muzima.api.model;

import com.muzima.search.api.util.StringUtil;

public class MuzimaSetting extends OpenmrsSearchable {
    private String name;
    private String description;
    private String property;
    private String valueString;
    private Boolean valueBoolean;
    private String settingDataType;
    private boolean retired;

    public String getProperty(){
        return property;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getSettingDataType() {
        return settingDataType;
    }

    public void setSettingDataType(String dataType) {
        this.settingDataType = dataType;
    }

    public Boolean getValueBoolean() {
        return valueBoolean;
    }

    public void setValueBoolean(Boolean valueBoolean) {
        this.valueBoolean = valueBoolean;
    }

    public String getValueString() {
        return valueString;
    }

    public void setValueString(String valueString) {
        this.valueString = valueString;
    }

    public Object getSettingValue() {
        if (StringUtil.equals("BOOLEAN",settingDataType)) {
            return valueBoolean;
        } else {
            return valueString;
        }
    }

    public void setRetired(boolean retired) {
        this.retired = retired;
    }

    public Boolean getRetired(){
        return retired;
    }
    @Override
    public String toString() {
        return "MuzimaSetting{" +
                ", uuid=" + getUuid() +
                ", name='" + getName() +
                ", property='" + getProperty() +
                ", description='" + getDescription() +
                ", value='" + getSettingValue() +
                ", settingDataType='" + getSettingDataType() +
                '}';
    }
}
