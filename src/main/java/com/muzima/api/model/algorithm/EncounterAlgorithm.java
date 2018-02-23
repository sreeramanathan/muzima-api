/*
 * Copyright (c) 2014. The Trustees of Indiana University.
 *
 * This version of the code is licensed under the MPL 2.0 Open Source license with additional
 * healthcare disclaimer. If the user is an entity intending to commercialize any application
 * that uses this code in a for-profit venture, please contact the copyright holder.
 */

package com.muzima.api.model.algorithm;

import com.jayway.jsonpath.JsonPath;
import com.muzima.api.model.Encounter;
import com.muzima.api.model.EncounterType;
import com.muzima.api.model.Location;
import com.muzima.api.model.Patient;
import com.muzima.api.model.Person;
import com.muzima.search.api.model.object.Searchable;
import com.muzima.util.JsonUtils;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;

import java.io.IOException;

/**
 * TODO: Write brief description about the class here.
 */
public class EncounterAlgorithm extends BaseOpenmrsAlgorithm {

    public static final String ENCOUNTER_SIMPLE_REPRESENTATION = "(uuid,uuid,id)";
    public static final String ENCOUNTER_STANDARD_REPRESENTATION =
            "(uuid,voided,encounterDatetime,id," +
                    "provider:" + PersonAlgorithm.PERSON_STANDARD_REPRESENTATION + "," +
                    "location:" + LocationAlgorithm.LOCATION_STANDARD_REPRESENTATION + "," +
                    "encounterType:" + EncounterTypeAlgorithm.ENCOUNTER_TYPE_STANDARD_REPRESENTATION + "," +
                    "patient:" + PatientAlgorithm.PATIENT_SIMPLE_REPRESENTATION +
                    ")";

    private PersonAlgorithm personAlgorithm;
    private PatientAlgorithm patientAlgorithm;
    private LocationAlgorithm locationAlgorithm;
    private EncounterTypeAlgorithm encounterTypeAlgorithm;

    public EncounterAlgorithm() {
        this.personAlgorithm = new PersonAlgorithm();
        this.patientAlgorithm = new PatientAlgorithm();
        this.locationAlgorithm = new LocationAlgorithm();
        this.encounterTypeAlgorithm = new EncounterTypeAlgorithm();
    }

    /**
     * Implementation of this method will define how the object will be serialized from the String representation.
     *
     * @param serialized the string representation
     * @return the concrete object
     */
    @Override
    public Searchable deserialize(final String serialized, final boolean isFullSerialization) throws IOException {
        Encounter encounter = new Encounter();
        String uuid = JsonUtils.readAsString(serialized, "$['uuid']");
        encounter.setUuid(uuid);
        encounter.setId(JsonUtils.readAsInteger(serialized, "$['id']"));
        if(isFullSerialization) {
            encounter.setVoided(JsonUtils.readAsBoolean(serialized, "$['voided']"));
            encounter.setEncounterDatetime(JsonUtils.readAsDateTime(serialized, "$['encounterDatetime']"));
            encounter.setFormDataUuid(JsonUtils.readAsString(serialized, "$['formDataUuid']"));
            Object patientObject = JsonUtils.readAsObject(serialized, "$['patient']");
            encounter.setPatient((Patient) patientAlgorithm.deserialize(String.valueOf(patientObject), isFullSerialization));
            Object providerObject = JsonUtils.readAsObject(serialized, "$['provider']");
            encounter.setProvider((Person) personAlgorithm.deserialize(String.valueOf(providerObject), isFullSerialization));
            Object locationObject = JsonUtils.readAsObject(serialized, "$['location']");
            encounter.setLocation((Location) locationAlgorithm.deserialize(String.valueOf(locationObject), isFullSerialization));
            Object encounterTypeObject = JsonUtils.readAsObject(serialized, "$['encounterType']");
            encounter.setEncounterType((EncounterType) encounterTypeAlgorithm.deserialize(String.valueOf(encounterTypeObject), isFullSerialization));
        }
        return encounter;
    }

    /**
     * Implementation of this method will define how the object will be de-serialized into the String representation.
     *
     * @param object the object
     * @return the string representation
     */
    @Override
    public String serialize(final Searchable object, final boolean isFullSerialization) throws IOException {
        Encounter encounter = (Encounter) object;
        JSONObject jsonObject = new JSONObject();
        JsonUtils.writeAsString(jsonObject, "uuid", encounter.getUuid());
        JsonUtils.writeAsInteger(jsonObject, "id", encounter.getId());
        if(isFullSerialization) {
            JsonUtils.writeAsString(jsonObject, "formDataUuid", encounter.getFormDataUuid());
            JsonUtils.writeAsBoolean(jsonObject, "voided", encounter.isVoided());
            JsonUtils.writeAsDateTime(jsonObject, "encounterDatetime", encounter.getEncounterDatetime());
            String patient = patientAlgorithm.serialize(encounter.getPatient(), isFullSerialization);
            jsonObject.put("patient", JsonPath.read(patient, "$"));
            String provider = personAlgorithm.serialize(encounter.getProvider(), isFullSerialization);
            jsonObject.put("provider", JsonPath.read(provider, "$"));
            String location = locationAlgorithm.serialize(encounter.getLocation(), isFullSerialization);
            jsonObject.put("location", JsonPath.read(location, "$"));
            String encounterType = encounterTypeAlgorithm.serialize(encounter.getEncounterType(), isFullSerialization);
            jsonObject.put("encounterType", JsonPath.read(encounterType, "$"));
        }
        return jsonObject.toJSONString();
    }
}
