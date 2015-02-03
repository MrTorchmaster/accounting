package org.entu.model;

import java.util.Date;

/**
 * Created by MSI-Pc on 03.02.2015.
 */
public interface Criteria {

    public enum Matcher {
        EQ, LESS, MORE, LESS_EQ, MORE_EQ, LIKE
    }

    Criteria id(Matcher matcher, Long id);

    <T> Criteria type(Matcher matcher, T type);

    Criteria label(Matcher matcher, String label);

    <T> Criteria value(Matcher matcher, T value);

    Criteria executor(Matcher matcher, User user);

    Criteria timestamp(Matcher matcher, Date timestamp);

    //TODO: add "or"

}
