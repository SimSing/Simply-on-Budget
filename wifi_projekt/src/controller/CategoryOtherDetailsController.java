package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CategoryOtherDetailsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField categoryOtherTextField;

    @FXML
    private Button saveButton;

    @FXML
    private Button cancelButton;

    @FXML
    void onCancelButtonPressed(ActionEvent event) {
    	
  	  Stage stage = (Stage) cancelButton.getScene().getWindow();
  	
  	  stage.close();

    }

    @FXML
    void onSaveButtonPressed(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert categoryOtherTextField != null : "fx:id=\"categoryOtherTextField\" was not injected: check your FXML file 'CategoryOtherDetails.fxml'.";
        assert saveButton != null : "fx:id=\"saveButton\" was not injected: check your FXML file 'CategoryOtherDetails.fxml'.";
        assert cancelButton != null : "fx:id=\"cancelButton\" was not injected: check your FXML file 'CategoryOtherDetails.fxml'.";

    }
}