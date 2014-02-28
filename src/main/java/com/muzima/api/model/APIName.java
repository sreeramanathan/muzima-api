package com.muzima.api.model;

public enum APIName {
    DOWNLOAD_OBSERVATIONS, DOWNLOAD_FORMS,
    DOWNLOAD_COHORTS, DOWNLOAD_COHORTS_DATA, DOWNLOAD_ENCOUNTERS;

    public static APIName getAPIName(String apiName) {
        for (APIName name : values()) {
            if (apiName.equals(name.toString())) {
                return name;
            }
        }
        return null;
    }
}