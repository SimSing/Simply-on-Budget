package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Profile;

public class LoginController extends CommonPropertiesController {


	
	@FXML
	private AnchorPane loginAnchorPane;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField userTextField;

	@FXML
	private TextField passwordTextField;

	@FXML
	private Button loginButton;

	@FXML
	private Label newProfileLabel;

	@FXML
	private Button exitButton;

	@FXML
	void onExitButtonPressed(ActionEvent event) {
		Platform.exit();

	}

	@FXML
	void onLoginButtonPressed(ActionEvent event) {
		System.out.println(profileList.size());
		
		//hat nicht funktioniert wegen i==profileList.size(); bei i<profileList.size() funktionierts perfekt -> dass der java index eben mit 0 beginnt und nicht mit 1 is einfach unsympathisch ;)
		for(int i=0; i<profileList.size(); i++)
		{
			Profile profile = profileList.get(i);
			if (profile.getAccountName()==userTextField.getText() &&
				(profile.getPassword() == passwordTextField.getText()));
			{	
								
		Stage stageLogin = (Stage) loginButton.getScene().getWindow();

		stageLogin.close();
		loadScene("MainTable");
		
			}}

	}
    @FXML
    void onNewProfileLabelHovered(MouseEvent event) {
    	newProfileLabel.setCursor(Cursor.HAND);

    }
	@FXML
	void onNewProfileLabelPressed(MouseEvent event) {



		loadScene("CreateNewProfile");

	}

	@FXML
	void initialize() {
		assert loginAnchorPane != null
				: "fx:id=\"loginAnchorPane\" was not injected: check your FXML file 'Login.fxml'.";
		assert userTextField != null : "fx:id=\"userTextField\" was not injected: check your FXML file 'Login.fxml'.";
		assert passwordTextField != null
				: "fx:id=\"passwordTextField\" was not injected: check your FXML file 'Login.fxml'.";
		assert loginButton != null : "fx:id=\"loginButton\" was not injected: check your FXML file 'Login.fxml'.";
		assert newProfileLabel != null
				: "fx:id=\"newProfileLabel\" was not injected: check your FXML file 'Login.fxml'.";
		assert exitButton != null : "fx:id=\"exitButton\" was not injected: check your FXML file 'Login.fxml'.";

		loginButton.disableProperty()
				.bind(Bindings.createBooleanBinding(
						() -> userTextField.getText().isEmpty() || passwordTextField.getText().isEmpty(),
						userTextField.textProperty(), passwordTextField.textProperty()));
		
		

	}
}
