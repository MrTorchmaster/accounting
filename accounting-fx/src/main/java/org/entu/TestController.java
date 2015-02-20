package org.entu;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;

/**
 * Created by Hell on 20.02.2015.
 */
public class TestController {

    @FXML
    private javafx.scene.control.ListView<String> testList;

    public void fill() {
        testList.getItems().addAll(FXCollections.observableArrayList("Single", "Double", "Suite", "Family App"));
    }
}
