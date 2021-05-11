package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
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
    private PasswordField passwordField;

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
		boolean loginSuccessful = false;

		Alert alert = new Alert(AlertType.INFORMATION);
		
		// für "alwaysOnTop"-Eigenschaft (in meiner loadScene-Methode im CommonPropertiesController)
		alert.initOwner(loginButton.getScene().getWindow()); 
		
		alert.setTitle("Error");
		alert.setContentText("Unknown Username or password.");

		for (int i = 0; i < profileList.size(); i++) {
			Profile profile = profileList.get(i);
			if (profile.getAccountName().equals(userTextField.getText())
					&& (profile.getPassword().equals(passwordField.getText()))) {
				loginSuccessful = true;
				loadScene("MainTable");
				Stage stageLogin = (Stage) loginButton.getScene().getWindow();

				stageLogin.hide();

			}

			}System.out.println(loginSuccessful);
			if (loginSuccessful == false) {
				alert.showAndWait();
				System.out.println("test");

		}

	}

	@FXML
	void onNewProfileLabelHovered(MouseEvent event) {
		newProfileLabel.setCursor(Cursor.HAND);

	}

	@FXML
	void onNewProfileLabelPressed(MouseEvent event) {

		Stage stageLogin = (Stage) newProfileLabel.getScene().getWindow();

		stageLogin.hide();

		loadScene("CreateNewProfile");

	}

	@FXML
	void initialize() {
		assert loginAnchorPane != null
				: "fx:id=\"loginAnchorPane\" was not injected: check your FXML file 'Login.fxml'.";
		assert userTextField != null : "fx:id=\"userTextField\" was not injected: check your FXML file 'Login.fxml'.";
		assert passwordField != null
				: "fx:id=\"passwordTextField\" was not injected: check your FXML file 'Login.fxml'.";
		assert loginButton != null : "fx:id=\"loginButton\" was not injected: check your FXML file 'Login.fxml'.";
		assert newProfileLabel != null
				: "fx:id=\"newProfileLabel\" was not injected: check your FXML file 'Login.fxml'.";
		assert exitButton != null : "fx:id=\"exitButton\" was not injected: check your FXML file 'Login.fxml'.";

		loginButton.disableProperty()
				.bind(Bindings.createBooleanBinding(
						() -> userTextField.getText().isEmpty() || passwordField.getText().isEmpty(),
						userTextField.textProperty(), passwordField.textProperty()));

	}
}
