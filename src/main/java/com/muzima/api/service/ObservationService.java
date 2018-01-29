/*
 * Copyright (c) 2014. The Trustees of Indiana University.
 *
 * This version of the code is licensed under the MPL 2.0 Open Source license with additional
 * healthcare disclaimer. If the user is an entity intending to commercialize any application
 * that uses this code in a for-profit venture, please contact the copyright holder.
 */

package com.muzima.api.service;

import com.google.inject.ImplementedBy;
import com.muzima.api.model.Concept;
import com.muzima.api.model.Observation;
import com.muzima.api.model.Patient;
import com.muzima.api.service.impl.ObservationServiceImpl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Service handling all operation to the @Observation actor/model
 */
@ImplementedBy(ObservationServiceImpl.class)
public interface ObservationService extends MuzimaInterface {

    /**
     * Download all observations for patient with the concept as the question.
     *
     * @param patient the patient.
     * @param concept the concept.
     * @return list of all observation matching the patient and concept.
     * @throws IOException when search api unable to process the resource.
     * @should download all observation with matching patient and concept.
     */
    List<Observation> downloadObservationsByPatientAndConcept(final Patient patient,
                                                              final Concept concept) throws IOException;

    List<Observation> downloadObservations(Patient patient, Concept concept, Date syncDate) throws IOException;

    List<Observation> downloadObservationsByPatientAndConcept(final String patientUuid,
                                                              final String conceptUuid) throws IOException;

    List<Observation> downloadObservations(String patientUuid, String conceptUuid, Date syncDate) throws IOException;

    List<Observation> downloadObservationsByPatientsAndConcepts(final List<Patient> patients,
                                                                final List<Concept> concepts) throws IOException;

    List<Observation> downloadObsByObjects(List<Patient> patients, List<Concept> concepts,
                                           Date syncDate) throws IOException;

    List<Observation> downloadObservationsByPatientUuidsAndConceptUuids(final List<String> patientUuids,
                                                                        final List<String> conceptUuids) throws IOException;

    List<Observation> downloadObservations(List<String> patientUuids, List<String> conceptUuids,
                                           Date syncDate) throws IOException;

    void deleteObservationsByFormData(String formDataUuid) throws IOException;

    /**
     * Save the observation into the local lucene repository.
     *
     * @param observation the observation to be saved.
     * @throws IOException when search api unable to process the resource.
     * @should save observation to local data repository
     */
    void saveObservation(final Observation observation) throws IOException;

    /**
     * Save the observations into the local lucene repository.
     *
     * @param observations the observations to be saved.
     * @throws IOException when search api unable to process the resource.
     * @should save observations to local data repository
     */
    void saveObservations(final List<Observation> observations) throws IOException;

    /**
     * Update the observation into the local lucene repository.
     *
     * @param observation the observation to be updated.
     * @throws IOException when search api unable to process the resource.
     * @should replace existing observation in the local data repository.
     */
    void updateObservation(final Observation observation) throws IOException;

    /**
     * Update the observations into the local lucene repository.
     *
     * @param observations the observations to be updated.
     * @throws IOException when search api unable to process the resource.
     * @should replace existing observations in the local data repository.
     */
    void updateObservations(final List<Observation> observations) throws IOException;

    /**
     * Get a single observation record from the repository using the uuid of the observation.
     *
     * @param uuid the observation uuid.
     * @return the observation with matching uuid or null when no observation match the uuid.
     * @throws IOException when search api unable to process the resource.
     * @should return observation with matching uuid.
     * @should return null when no observation match the uuid.
     */
    Observation getObservationByUuid(final String uuid) throws IOException;

    /**
     * Get all observations for the particular patient.
     *
     * @param patientUuid the uuid of the patient.
     * @return list of all observations for the patient or empty list when no observation found for the patient.
     * @throws IOException when search api unable to process the resource.
     * @should return list of all observations for the patient.
     * @should return empty list when no observation found for the patient.
     */
    List<Observation> getObservationsByPatient(final String patientUuid) throws IOException;

    List<Observation> getObservationsByPatient(final String patientUuid,final Integer page, final Integer pageSize) throws IOException;

    List<Observation> getObservationsByPatient(final Patient patient) throws IOException;

    /**
     * Get all observations for the particular patient.
     *
     * @param patientUuid the uuid of the patient.
     * @param conceptUuid the uuid of the concept.
     * @return list of all observations for the patient or empty list when no observation found for the patient.
     * @throws IOException when search api unable to process the resource.
     * @should return list of all observations for the patient.
     * @should return empty list when no observation found for the patient.
     */
    List<Observation> getObservationsByPatientAndConcept(final String patientUuid,
                                                         final String conceptUuid) throws IOException;

    List<Observation> getObservationsByPatientAndConcept(final String patientUuid,
                                                         final int conceptId) throws IOException;

    List<Observation> getObservationsByPatientAndConcept(final Patient patient,
                                                         final Concept concept) throws IOException;

    List<Observation> getObservationsByEncounter(final String encounterUuid) throws IOException;

    List<Observation> getObservationsByEncounter(final int encounterId) throws IOException;

    List<Observation> getObservationsByEncounterType(final int encounterTypeId,final String patientUuid) throws IOException;
    /**
     * @param concept
     * @return List of Observations for the given Concept
     * @throws IOException
     */
    List<Observation> getObservations(Concept concept) throws IOException;

    /**
     * Search for all observations for the particular patient with matching search term.
     *
     * @param patientUuid the patient.
     * @param term        the search term.
     * @return list of all observations with matching search term on the searchable fields or empty list.
     * @throws IOException when search api unable to process the resource.
     * @should return list of all observations with matching search term on the searchable fields.
     * @should return empty list when no observation match the search term.
     */
    List<Observation> searchObservations(final String patientUuid,
                                         final String term) throws IOException;

    List<Observation> searchObservations(final Patient patient,
                                         final String term) throws IOException;
    int countObservationsByPatient(final String patientUuid) throws IOException;

    /**
     * Delete a single observation from the local repository.
     *
     * @param observation the observation.
     * @throws IOException when search api unable to process the resource.
     * @should delete the observation from the local repository.
     */
    void deleteObservation(final Observation observation) throws IOException;

    /**
     * Delete observations from the local repository.
     *
     * @param observations the observations.
     * @throws IOException when search api unable to process the resource.
     * @should delete observations from the local repository.
     */
    void deleteObservations(final List<Observation> observations) throws IOException;

    /**
     * Delete all observations from the local repository.
     *
     * @throws IOException when search api unable to process the resource.
     * @should delete all observations from the local repository.
     */
    void deleteAll() throws IOException;

}
