package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class IncomeDetailsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button onSaveButtonPressed;

    @FXML
    private Button onExitButtonPressed;

    @FXML
    void initialize() {
        assert onSaveButtonPressed != null : "fx:id=\"onSaveButtonPressed\" was not injected: check your FXML file 'IncomeDetails.fxml'.";
        assert onExitButtonPressed != null : "fx:id=\"onExitButtonPressed\" was not injected: check your FXML file 'IncomeDetails.fxml'.";

    }
}
