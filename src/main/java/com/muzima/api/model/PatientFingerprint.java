package com.muzima.api.model;

import com.muzima.search.api.model.object.Searchable;

public class PatientFingerprint implements Searchable {

    private String id;
    private String patientId;
    private String fingerprint;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getFingerprint() {
        return fingerprint;
    }

    public void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
