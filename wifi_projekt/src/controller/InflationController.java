package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class InflationController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<?> yearComboBox;

    @FXML
    private TextField inflationTextField;

    @FXML
    void onYearComboBoxPressed(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert yearComboBox != null : "fx:id=\"yearComboBox\" was not injected: check your FXML file 'Inflation.fxml'.";
        assert inflationTextField != null : "fx:id=\"inflationTextField\" was not injected: check your FXML file 'Inflation.fxml'.";

    }
}
