/*
 * Copyright (c) 2014. The Trustees of Indiana University.
 *
 * This version of the code is licensed under the MPL 2.0 Open Source license with additional
 * healthcare disclaimer. If the user is an entity intending to commercialize any application
 * that uses this code in a for-profit venture, please contact the copyright holder.
 */

package com.muzima.api.model;

import com.muzima.search.api.util.StringUtil;
import com.muzima.util.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Write brief description about the class here.
 */
public class Concept extends OpenmrsSearchable implements Comparable<Concept> {

    public static final String NUMERIC_TYPE = "Numeric";

    public static final String CODED_TYPE = "Coded";

    public static final String DATETIME_TYPE = "Datetime";

    public static final String DATE_TYPE = "Date";

    private String unit;

    private int id;

    private boolean precise;

    private ConceptType conceptType;

    private List<ConceptName> conceptNames;

    public String getUnit() {
        return unit;
    }

    public void setUnit(final String unit) {
        this.unit = unit;
    }

    public boolean isPrecise() {
        return precise;
    }

    public void setPrecise(final boolean precise) {
        this.precise = precise;
    }

    public ConceptType getConceptType() {
        return conceptType;
    }

    public void setConceptType(final ConceptType conceptType) {
        this.conceptType = conceptType;
    }

    public void addName(final ConceptName conceptName) {
        getConceptNames().add(conceptName);
    }

    public List<ConceptName> getConceptNames() {
        if (conceptNames == null) {
            conceptNames = new ArrayList<ConceptName>();
        }
        return conceptNames;
    }

    public void setConceptNames(final List<ConceptName> conceptNames) {
        this.conceptNames = conceptNames;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        String name = StringUtil.EMPTY;
        for (ConceptName conceptName : getConceptNames()) {
            name = conceptName.getName();
            if (conceptName.isPreferred()) {
                return name;
            }
        }
        return name;
    }

    public boolean isNumeric() {
        boolean numeric = false;
        if (getConceptType() != null) {
            numeric = StringUtil.equals(getConceptType().getName(), NUMERIC_TYPE);
        }
        return numeric;
    }

    public boolean isCoded() {
        boolean coded = false;
        if (getConceptType() != null) {
            coded = StringUtil.equals(getConceptType().getName(), CODED_TYPE);
        }
        return coded;
    }

    public boolean isDatetime() {
        boolean datetime = false;
        if (getConceptType() != null) {
            datetime = (StringUtil.equals(getConceptType().getName(), DATE_TYPE)
                    || StringUtil.equals(getConceptType().getName(), DATETIME_TYPE));
        }
        return datetime;
    }

    public String getSynonyms() {
        int size = this.getConceptNames().size();
        switch (size) {
            case 0:
            case 1:
                return "";
            case 2:
                return getFirstConceptName();
            default:
                return getFirstConceptName() + " (" + (size - 2) + " more.)";
        }
    }

    private String getFirstConceptName() {
        return this.getConceptNames().get(0).getName();
    }

    @Override
    public int compareTo(Concept otherConcept) {
        return this.getName().toLowerCase().compareTo(otherConcept.getName().toLowerCase());
    }

    public Boolean containsNameIgnoreLowerCase(String name) {
        name = name.trim();
        List<ConceptName> conceptNames = getConceptNames();
        int index = 0;
        ConceptName conceptName = conceptNames.get(index);
        boolean found = name.equalsIgnoreCase(conceptName.getName());
        while (!found & index < conceptNames.size()) {
            conceptName = conceptNames.get(index++);
            found = name.equalsIgnoreCase(conceptName.getName().trim());
        }
        return found;
    }

    public boolean isCreatedOnDevice() {
        return getUuid().startsWith(Constants.CONCEPT_CREATED_ON_PHONE);
    }
}
