package org.entu.model;

import java.util.Date;

/**
 * Created by MSI-Pc on 03.02.2015.
 */
public interface User {

    Long id();

    String login();

    String name();

    Date created();
}
