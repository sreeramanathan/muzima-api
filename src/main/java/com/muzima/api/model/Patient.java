/*
 * Copyright (c) 2014. The Trustees of Indiana University.
 *
 * This version of the code is licensed under the MPL 2.0 Open Source license with additional
 * healthcare disclaimer. If the user is an entity intending to commercialize any application
 * that uses this code in a for-profit venture, please contact the copyright holder.
 */

package com.muzima.api.model;

import com.muzima.search.api.util.StringUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Patient extends Person implements Comparable<Patient> {

    private String id;
    private List<PatientIdentifier> identifiers;
    private List<PersonAttribute> attributes;
    private String fingerprint;

    public void addIdentifier(final PatientIdentifier identifier) {
        getIdentifiers().add(identifier);
    }

    public void addattribute(final PersonAttribute attribute) {
        getAtributes().add(attribute);
    }

    public List<PersonAttribute> getAtributes() {
        if (attributes == null) {
            attributes = new ArrayList<PersonAttribute>();
        }
        return attributes;
    }

    public void setAttributes(final List<PersonAttribute> attributes) {
        this.attributes = attributes;
    }

    public List<PatientIdentifier> getIdentifiers() {
        if (identifiers == null) {
            identifiers = new ArrayList<PatientIdentifier>();
        }
        return identifiers;
    }

    public void setIdentifiers(final List<PatientIdentifier> identifiers) {
        this.identifiers = identifiers;
    }

    /**
     * Get the patient identifier
     *
     * @return the patient identifier
     */
    public String getIdentifier() {
        String identifier = StringUtil.EMPTY;
        for (PatientIdentifier patientIdentifier : getIdentifiers()) {
            identifier = patientIdentifier.getIdentifier();
            if (patientIdentifier.isPreferred()) {
                return identifier;
            }
        }
        return identifier;
    }

    /**
     * Gets the PatientIdentifier with the given identifier type name.
     *
     * @param identifierTypeName the name of the identifier type
     * @return the PatientIdentifier with the given identifier type name
     */
    public PatientIdentifier getIdentifier(String identifierTypeName) {
        for (PatientIdentifier identifier : getIdentifiers()) {
            if (identifier.getIdentifierType().getName().equals(identifierTypeName)) {
                return identifier;
            }
        }
        return null;
    }

    /**
     * Removes the PatientIdentifier with the given identifier type name.
     *
     * @param identifierTypeName the name of the identifier type
     */
    public void removeIdentifier(String identifierTypeName) {
        Iterator<PatientIdentifier> iterator = getIdentifiers().iterator();
        while (iterator.hasNext()) {
            PatientIdentifier next = iterator.next();
            if (identifierTypeName.equals(next.getIdentifierType().getName())) {
                iterator.remove();
            }
        }
    }

    public String getSummary() {
        StringBuilder sb = new StringBuilder();
        sb.append("f".equalsIgnoreCase(getGender()) ? "♀" : "♂")
                .append(" ")
                .append(getAbbreviatedName())
                .append(", ")
                .append(getIdentifier());
        return sb.toString();
    }

    private String getAbbreviatedName() {
        String middleNameAbbr = "";
        if (!StringUtil.isEmpty(getMiddleName())) {
            middleNameAbbr = " " + getMiddleName().substring(0, 1);
        }
        return getFamilyName() + ", " + getGivenName().substring(0, 1) + middleNameAbbr;
    }

    @Override
    public int compareTo(Patient patient) {
        if (this.getDisplayName() != null && patient.getDisplayName() != null) {
            return this.getDisplayName().toLowerCase().compareTo(patient.getDisplayName().toLowerCase());
        }
        return 0;
    }

    /**
     * Get the patient attribute
     *
     * @return the patient attribute
     */
    public String getAttribute() {
        String attribute = StringUtil.EMPTY;
        for (PersonAttribute personAttribute : getAtributes()) {
            attribute = personAttribute.getAttribute();
        }
        return attribute;
    }

    /**
     * Gets the PersonAttribute with the given attribute type name.
     *
     * @param attributeName the name of the identifier type
     * @return the PersonAttribute with the given identifier type name
     */
    public PersonAttribute getAttribute(String attributeName) {
        for (PersonAttribute attribute : getAtributes()) {
            if (attribute.getAttributeType().getName().equals(attributeName)) {
                return attribute;
            }
        }
        return null;
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
