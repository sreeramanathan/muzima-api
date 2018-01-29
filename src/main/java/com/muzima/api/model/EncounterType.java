/*
 * Copyright (c) 2014. The Trustees of Indiana University.
 *
 * This version of the code is licensed under the MPL 2.0 Open Source license with additional
 * healthcare disclaimer. If the user is an entity intending to commercialize any application
 * that uses this code in a for-profit venture, please contact the copyright holder.
 */

package com.muzima.api.model;

/**
 * TODO: Write brief description about the class here.
 */
public class EncounterType extends OpenmrsSearchable  {

    private String name;

    private int id;

    /**
     * Get the name of the encounter type.
     *
     * @return the name.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the encounter type.
     *
     * @param name the name.
     */
    public void setName(final String name) {
        this.name = name;
    }

    public int getId(){ return id; }

    public void setId(int id) { this.id = id; }


}
