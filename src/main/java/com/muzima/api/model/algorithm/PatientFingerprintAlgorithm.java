package com.muzima.api.model.algorithm;

import com.muzima.api.model.PatientFingerprint;
import com.muzima.search.api.model.object.Searchable;
import com.muzima.util.JsonUtils;
import net.minidev.json.JSONObject;

import java.io.IOException;

public class PatientFingerprintAlgorithm extends BaseOpenmrsAlgorithm {
    @Override
    public Searchable deserialize(String serialized) throws IOException {

        PatientFingerprint patientFingerprint = new PatientFingerprint();
        patientFingerprint.setPatientId(JsonUtils.readAsString(serialized,"$['patientId']"));
        patientFingerprint.setFingerprint(JsonUtils.readAsString(serialized,"$['fingerprint']"));

        return patientFingerprint;

    }

    @Override
    public String serialize(Searchable searchable) throws IOException {

        PatientFingerprint patientFingerprint =  (PatientFingerprint) searchable;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("patientId", patientFingerprint.getPatientId());
        jsonObject.put("fingerprint", patientFingerprint.getFingerprint());

        return jsonObject.toJSONString();

    }
}
