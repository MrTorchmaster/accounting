package org.entu.model;

import java.util.Date;

/**
 * Created by MSI-Pc on 03.02.2015.
 */
public interface Operation<T extends Type, Z, V extends Value<Z>> {

    Long id();

    T type();

    String label();

    // Maybe too much
    V value();

    User executor();

    Date timestamp();


}
