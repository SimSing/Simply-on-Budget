package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Profile;

public class CreateNewProfileController extends CommonPropertiesController {

	private String userName;
	private String password;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField userTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private Button createButton;

    @FXML
    private Button cancelButton;

    @FXML
    void onCancelButtonPressed(ActionEvent event) {
    	
    	loadScene("Login"); 
    						
    	
		Stage stage = (Stage) cancelButton.getScene().getWindow();
		
		stage.close();
		
    	
    }

    @FXML
    void onCreateButtonPressed(ActionEvent event) {
    	
		userName = userTextField.getText();
		password = passwordTextField.getText();
		
		if(!userName.isEmpty()&&(!password.isEmpty())) {
			Profile profile = new Profile(userName, password);
			System.out.println("Profile added");
			
			Stage stageLogin = (Stage) createButton.getScene().getWindow();  

			stageLogin.close();
			
			profileList.add(profile);
			System.out.println(profileList);
			loadScene("Login");
		}
    	
		else {}


    }

    @FXML
    void initialize() {
        assert userTextField != null : "fx:id=\"userTextField\" was not injected: check your FXML file 'CreateNewProfile.fxml'.";
        assert passwordTextField != null : "fx:id=\"passwordTextField\" was not injected: check your FXML file 'CreateNewProfile.fxml'.";
        assert createButton != null : "fx:id=\"createButton\" was not injected: check your FXML file 'CreateNewProfile.fxml'.";
        assert cancelButton != null : "fx:id=\"cancelButton\" was not injected: check your FXML file 'CreateNewProfile.fxml'.";
        
        createButton.disableProperty().bind(Bindings.createBooleanBinding(() -> userTextField.getText().isEmpty()||passwordTextField.getText().isEmpty(), userTextField.textProperty(), passwordTextField.textProperty()));
        
        }
    }

