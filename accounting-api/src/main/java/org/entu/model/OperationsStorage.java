package org.entu.model;

import java.util.Collection;

/**
 * Created by MSI-Pc on 03.02.2015.
 */
public interface OperationsStorage {

    Collection<Operation> get(Criteria criteria);

    void add(Operation operation);

    void addAll(Collection<Operation> operations);

    void remove(Operation operation);

    void removeAll(Collection<Operation> operations);
}
