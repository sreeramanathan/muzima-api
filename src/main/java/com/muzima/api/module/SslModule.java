/*
 * Copyright (c) 2014. The Trustees of Indiana University.
 *
 * This version of the code is licensed under the MPL 2.0 Open Source license with additional
 * healthcare disclaimer. If the user is an entity intending to commercialize any application
 * that uses this code in a for-profit venture, please contact the copyright holder.
 */

package com.muzima.api.module;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

/**
 * TODO: Write brief description about the class here.
 */
public class SslModule extends AbstractModule {

    /**
     * Configures a {@link com.google.inject.Binder} via the exposed methods.
     */
    @Override
    protected void configure() {
        bind(String.class)
                .annotatedWith(Names.named("key.store.path"))
                .toInstance("/mnt/sdcard/keystore/keystore.pem");
        bind(String.class)
                .annotatedWith(Names.named("key.store.credential"))
                .toInstance("/mnt/sdcard/keystore/keystore.credential");
    }
}
