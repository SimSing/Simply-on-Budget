package controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import javax.security.auth.callback.ConfirmationCallback;

import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Profile;

public class CreateNewProfileController extends CommonPropertiesController {

	private String userName;
	private String password;
	private String confirmPassword;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField userTextField;
	
	@FXML
	private PasswordField confirmPasswordField;
	
	@FXML
	private PasswordField passwordPasswordField;

	@FXML
	private Button createButton;

	@FXML
	private Button cancelButton;

	@FXML
	void onCancelButtonPressed(ActionEvent event) {

		loadScene("Login");

		Stage stage = (Stage) cancelButton.getScene().getWindow();

		stage.hide();

	}

	@FXML
	void onCreateButtonPressed(ActionEvent event) {

		userName = userTextField.getText();
		password = passwordPasswordField.getText();
		confirmPassword = confirmPasswordField.getText();
		List<String> userList = profileList.stream().map(f -> f.getAccountName()).collect(Collectors.toList());

		if (!userName.isEmpty() && (!password.isEmpty() && (!confirmPassword.isEmpty()))) {
			for (int i = 0; i <= userList.size() - 1; i++) {

				if (userList.get(i).equals(userName)) {
					
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Error");
					alert.setContentText("User already exists, pls enter another name!");
					alert.initOwner(createButton.getScene().getWindow());
					alert.showAndWait();
					
				}else if(!password.equals(confirmPassword)) {
					
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Error");
					alert.setContentText("Passwords are not matching! Please re-enter passwords.");
					alert.initOwner(createButton.getScene().getWindow());
					alert.showAndWait();
				}
				
				else {

					Profile profile = new Profile(userName, password);
					System.out.println("Profile added");

					Stage stageLogin = (Stage) createButton.getScene().getWindow();

					stageLogin.hide();

					profileList.add(profile);
					System.out.println(profileList);
				}
			}

		}

	}

	@FXML
	void initialize() {
		assert userTextField != null
				: "fx:id=\"userTextField\" was not injected: check your FXML file 'CreateNewProfile.fxml'.";
		assert passwordPasswordField != null
				: "fx:id=\"passwordTextField\" was not injected: check your FXML file 'CreateNewProfile.fxml'.";
		assert createButton != null
				: "fx:id=\"createButton\" was not injected: check your FXML file 'CreateNewProfile.fxml'.";
		assert cancelButton != null
				: "fx:id=\"cancelButton\" was not injected: check your FXML file 'CreateNewProfile.fxml'.";

		createButton.disableProperty()
				.bind(Bindings.createBooleanBinding(
						() -> userTextField.getText().isEmpty() || passwordPasswordField.getText().isEmpty() || confirmPasswordField.getText().isEmpty(),
						userTextField.textProperty(), passwordPasswordField.textProperty(), confirmPasswordField.textProperty()));

	}
}
