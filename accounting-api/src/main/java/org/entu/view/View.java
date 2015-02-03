package org.entu.view;

import org.entu.controller.Listener;
import org.entu.model.Operation;

import java.util.Collection;

/**
 * Created by MSI-Pc on 03.02.2015.
 */
public interface View {

    void show(Collection<Operation> operations);

    void registerListener(Listener listener);

}
