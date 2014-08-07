/*
 * Copyright (c) 2014. The Trustees of Indiana University.
 *
 * This version of the code is licensed under the MPL 2.0 Open Source license with additional
 * healthcare disclaimer. If the user is an entity intending to commercialize any application
 * that uses this code in a for-profit venture, please contact the copyright holder.
 */

package com.muzima.api.dao;

import com.google.inject.ImplementedBy;
import com.muzima.api.dao.impl.ConceptDaoImpl;
import com.muzima.api.model.Concept;

/**
 * TODO: Write brief description about the class here.
 */
@ImplementedBy(ConceptDaoImpl.class)
public interface ConceptDao extends OpenmrsDao<Concept> {
}
