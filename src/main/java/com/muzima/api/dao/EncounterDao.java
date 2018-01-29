/*
 * Copyright (c) 2014. The Trustees of Indiana University.
 *
 * This version of the code is licensed under the MPL 2.0 Open Source license with additional
 * healthcare disclaimer. If the user is an entity intending to commercialize any application
 * that uses this code in a for-profit venture, please contact the copyright holder.
 */

package com.muzima.api.dao;

import com.google.inject.ImplementedBy;
import com.muzima.api.dao.impl.EncounterDaoImpl;
import com.muzima.api.model.Encounter;

import java.io.IOException;
import java.util.List;

/**
 * TODO: Write brief description about the class here.
 */
@ImplementedBy(EncounterDaoImpl.class)
public interface EncounterDao extends OpenmrsDao<Encounter> {

    /**
     * Get list of encounters for particular patient.
     *
     * @param patientUuid the patient uuid.
     * @return list of encounters for the patient.
     * @throws java.io.IOException when the search api unable to process the resource.
     */
    List<Encounter> getEncountersByPatientUuid(final String patientUuid) throws IOException;


    /**
     * Get Encounter from local data repository with matching form data uuid.
     *
     * @param formDataUuid the form data uuid.
     * @return Encounter with matching form data uuid.
     * @throws java.io.IOException when the search api unable to process the resource.
     */
    List<Encounter> getEncountersByFormDataUuid(final String formDataUuid) throws IOException;

    /**
     * Count list of encounters for particular patient.
     *
     * @param patientUuid the patient uuid.
     * @return number of encounters for the patient.
     * @throws java.io.IOException when the search api unable to process the resource.
     */
    int countEncountersByPatientUuid(final String patientUuid) throws IOException;

    /**
     * Get list of encounters for particular patient given encounter type name.
     *
     * @param patientUuid the patient uuid.
     * @param name encounter type names.
     * @return list of encounters for the patient.
     * @throws java.io.IOException when the search api unable to process the resource.
     */
    List<Encounter> getAllEncounterByEncounterTypeNameAndPatientUUid(final String name,final String patientUuid) throws IOException;

    /**
     * Get list of encounters for particular patient given encounter type Uuid.
     *
     * @param patientUuid the patient uuid.
     * @param encounterTypeUuid encounter type Uuid.
     * @return list of encounters for the patient.
     * @throws java.io.IOException when the search api unable to process the resource.
     */
    List<Encounter> getAllEncounterByEncounterTypeUuidAndPatientUUid(final String encounterTypeUuid,final String patientUuid) throws IOException;


    /**
     * Get list of encounters for particular patient given encounter type Id.
     *
     * @param patientUuid the patient uuid.
     * @param encounterTypeId encounter type Id.
     * @return list of encounters for the patient.
     * @throws java.io.IOException when the search api unable to process the resource.
     */
    List<Encounter> getAllEncounterByEncounterTypeIdAndPatientUUid(final int encounterTypeId,final String patientUuid) throws IOException;


}
