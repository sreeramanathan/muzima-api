/*
 * Copyright (c) 2014. The Trustees of Indiana University.
 *
 * This version of the code is licensed under the MPL 2.0 Open Source license with additional
 * healthcare disclaimer. If the user is an entity intending to commercialize any application
 * that uses this code in a for-profit venture, please contact the copyright holder.
 */

package com.muzima.api.service;

import com.google.inject.ImplementedBy;
import com.muzima.api.model.Encounter;
import com.muzima.api.model.EncounterType;
import com.muzima.api.model.Patient;
import com.muzima.api.service.impl.EncounterServiceImpl;
import org.apache.lucene.queryParser.ParseException;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * TODO: Write brief description about the class here.
 */
@ImplementedBy(EncounterServiceImpl.class)
public interface EncounterService extends MuzimaInterface {

    /**
     * Download encounter with matching uuid.
     *
     * @param uuid the uuid of the encounter.
     * @return the encounter with matching uuid.
     * @throws java.io.IOException when the search api unable to process the resource.
     * @should return downloaded encounter with matching uuid.
     * @should return null when no encounter match the uuid.
     */
    Encounter downloadEncounterByUuid(final String uuid) throws IOException;

    /**
     * Download list of encounters with matching patient name.
     *
     * @param name the partial name of the patient.
     * @return list of encounters with for patient with matching name.
     * @throws java.io.IOException when the search api unable to process the resource.
     * @should return encounters for patient with matching name.
     * @should return empty list when the name is empty.
     */
    List<Encounter> downloadEncountersByPatientName(final String name) throws IOException;

    /**
     * Download list of encounters with matching patient uuid.
     *
     * @param patientUuid the uuid of the patient.
     * @return list of encounters with matching name.
     * @throws java.io.IOException when the search api unable to process the resource.
     * @should return downloaded list of encounters with matching uuid.
     * @should return empty list when the uuid is empty.
     */
    List<Encounter> downloadEncountersByPatientUuid(final String patientUuid) throws IOException;

    List<Encounter> downloadEncountersByPatientUuidAndSyncDate(final String patientUuid, final Date syncDate) throws IOException;

    /**
     * Download list of encounters with matching patient.
     *
     * @param patient the patient who own the encounter.
     * @return list of encounters for the patient.
     * @throws java.io.IOException when the search api unable to process the resource.
     * @should return downloaded list of encounters with matching uuid.
     * @should return empty list when the uuid is empty.
     */
    List<Encounter> downloadEncountersByPatient(final Patient patient) throws IOException;

    List<Encounter> downloadEncountersByPatient(final Patient patient, final Date syncDate) throws IOException;

    List<Encounter> downloadEncountersByPatients(final List<Patient> patients) throws IOException;

    List<Encounter> downloadEncountersByPatientsAndSyncDate(final List<Patient> patients, final Date syncDate) throws IOException;

    List<Encounter> downloadEncountersByPatientUuids(final List<String> uuids) throws IOException;

    List<Encounter> downloadEncountersByPatientUuidsAndSyncDate(final List<String> patientUuids, final Date syncDate) throws IOException;

    /**
     * Get a single encounter from local data repository with matching uuid.
     *
     * @param uuid the uuid of the encounter.
     * @return the encounter with matching uuid.
     * @throws java.io.IOException when the search api unable to process the resource.
     * @should return encounter with matching uuid.
     * @should return null when no encounter match the uuid.
     */
    Encounter getEncounterByUuid(final String uuid) throws IOException;

    /**
     * Get list of encounters from local data repository with matching patient name.
     *
     * @param name the name of the patient.
     * @return list of encounters with matching name.
     * @throws java.io.IOException when the search api unable to process the resource.
     * @should return list of encounters with matching patient name.
     * @should return empty list when no encounter match the patient name.
     */
    List<Encounter> getEncountersByPatientName(final String name) throws IOException, ParseException;

    /**
     * Get list of encounters from local data repository with matching patient uuid.
     *
     * @param patientUuid the patient uuid.
     * @return list of encounters with matching uuid.
     * @throws java.io.IOException when the search api unable to process the resource.
     * @should return list of encounters with matching patient uuid.
     * @should return empty list when no encounter match the patient uuid.
     */
    List<Encounter> getEncountersByPatientUuid(final String patientUuid) throws IOException;

    /**
     * Get Encounter from local data repository with matching form data uuid.
     *
     * @param formDataUuid the form data uuid.
     * @return Encounter with matching form data uuid.
     * @throws java.io.IOException when the search api unable to process the resource.
     * @should return an encounter with matching form data uuid.
     * @should return null when no encounter matches the form data uuid.
     */
    Encounter getEncounterByFormDataUuid(final String formDataUuid) throws IOException;


    Integer countEncountersByPatientUuid(final String patientUuid) throws IOException;

    /**
     * Get list of encounters from local data repository with matching patient.
     *
     * @param patient the patient who own the encounters.
     * @return list of encounters for the patient.
     * @throws java.io.IOException when the search api unable to process the resource.
     * @should return list of encounters with matching patient.
     * @should return empty list when no encounter match the patient.
     */
    List<Encounter> getEncountersByPatient(final Patient patient) throws IOException;

    /**
     * Get all encounters stored in the local data repository.
     *
     * @return all encounters stored in the local data repository.
     * @throws java.io.IOException when the search api unable to process the resource.
     * @should return all encounters stored in the local data repository.
     */
    List<Encounter> getAllEncounters() throws IOException;

    /**
     * Count all encounters stored in the local data repository.
     *
     * @return number of encounters stored in the local data repository.
     * @throws java.io.IOException when the search api unable to process the resource.
     * @should return number of encounters stored in the local data repository.
     */
    Integer countAllEncounters() throws IOException;

    /**
     * Save a encounter into local data repository.
     *
     * @param encounter the encounter to be saved.
     * @throws java.io.IOException when the search api unable to process the resource.
     * @should save encounter into local data repository.
     */
    void saveEncounter(final Encounter encounter) throws IOException;

    /**
     * Save list of encounters into local data repository.
     *
     * @param encounters the encounters to be saved.
     * @throws java.io.IOException when the search api unable to process the resource.
     * @should save list of encounters into local data repository.
     */
    void saveEncounters(final List<Encounter> encounters) throws IOException;

    /**
     * Update a encounter in the local data repository.
     *
     * @param encounter the encounter to be updated.
     * @throws java.io.IOException when the search api unable to process the resource.
     * @should update encounter in local data repository.
     */
    void updateEncounter(final Encounter encounter) throws IOException;

    /**
     * Update list of encounters in the local data repository.
     *
     * @param encounters the encounters to be updated.
     * @throws java.io.IOException when the search api unable to process the resource.
     * @should update list of encounters in local data repository.
     */
    void updateEncounters(final List<Encounter> encounters) throws IOException;

    /**
     * Delete a encounter from the local data repository.
     *
     * @param encounter the encounter to be deleted.
     * @throws java.io.IOException when the search api unable to process the resource.
     * @should delete encounter from local data repository.
     */
    void deleteEncounter(final Encounter encounter) throws IOException;
    /**
     * Delete list of encounters from the local data repository.
     *
     * @param encounters the encounters to be deleted.
     * @throws java.io.IOException when the search api unable to process the resource.
     * @should delete list of encounters from local data repository.
     */
    void deleteEncounters(final List<Encounter> encounters) throws IOException;

    /**
     * Delete all encounters from the local data repository.
     *
     * @throws java.io.IOException when the search api unable to process the resource.
     * @should delete all the encounters from local data repository.
     */
    void deleteAll() throws IOException;

    /**
     * Get all encounter types from the local data repository.
     *
     * @throws java.io.IOException when the search api unable to process the resource.
     * @should get all the encounter Types from local data repository.
     */
    List<EncounterType> getAllEncounterTypes() throws IOException;

    /**
     * Get list of encounters from the local data repository.
     *
     * @param name the encounter type name.
     * @param patientUuid
     * @throws java.io.IOException when the search api unable to process the resource.
     * @should get list of encounters from local data repository.
     */
    List<Encounter> getEncountersByEncounterTypeNameAndPatientUuid(final String name,final String patientUuid) throws IOException;

    /**
     * Get list of encounters from the local data repository.
     *
     * @param encounterTypeUuid the encounter type name.
     * @param patientUuid
     * @throws java.io.IOException when the search api unable to process the resource.
     * @should get list of encounters from local data repository.
     */
    List<Encounter> getEncountersByEncounterTypeUuidAndPatientUuid(final String encounterTypeUuid,final String patientUuid) throws IOException;

    /**
     * Get list of encounters from the local data repository.
     *
     * @param encounterTypeId the encounter type name.
     * @param patientUuid
     * @throws java.io.IOException when the search api unable to process the resource.
     * @should get list of encounters from local data repository.
     */
    List<Encounter> getEncountersByEncounterTypeIdAndPatientUuid(final int encounterTypeId,final String patientUuid) throws IOException;
}
