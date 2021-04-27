package controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.FixedExpenditures;
import model.FluctExpenditures;
import javafx.scene.control.Label;

public class ExpenditureDetailsController extends CommonPropertiesController {
	


	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private AnchorPane negativeInputAnchorPane;

	@FXML
	private AnchorPane expenditureDetailsAnchorPane;

	@FXML
	private TextField categoryTextField;

	@FXML
	private TextField amountTextField;

	@FXML
	private Button addButton;

	@FXML
	private Button exitButton;

	@FXML
	private Button yesButton;

	@FXML
	private Button noButton;

	@FXML
	Label negativeNumberLabel;

	@FXML
	Label confirmationLabel;

	void addFixedExpenditureToDataBase() {
		String categoryFixedExp = categoryTextField.getText();
		String amountString = amountTextField.getText();
		double amount = Double.parseDouble(amountString);
		LocalDate date = LocalDate.now();

		if (!categoryFixedExp.isEmpty() && !amountString.isEmpty()) {
			FixedExpenditures fixedExpenditure = new FixedExpenditures(categoryFixedExp, amount, date);
			System.out.println("Fixed Expenditure added");
			fixedExpendituresList.add(fixedExpenditure);
		}
	}

	@FXML
	void limitInputinTextfield(KeyEvent event) {

		if (amountTextField.getText().length() >= 8) {
			String s = amountTextField.getText().substring(0, 7);
			amountTextField.setText(s);
		}

		amountTextField.setTextFormatter(new TextFormatter<>(c -> {
			if (c.isContentChange()) {
				if (c.getControlNewText().length() == 0) {
					return c;
				}
				try {
					Integer.parseInt(c.getControlNewText());
					return c;
				} catch (NumberFormatException e) {
				}
				return null;

			}
			return c;
		}));

	}

	@FXML
	void onAddButtonPressed(ActionEvent event) {
		if (amountTextField.getText().contains("-")) {
			expenditureDetailsAnchorPane.setVisible(false);
			negativeInputAnchorPane.setVisible(true);
		}else {
			addFixedExpenditureToDataBase();
		}
	}

	@FXML
	void onExitButtonPressed(ActionEvent event) {

		Stage stage = (Stage) exitButton.getScene().getWindow();

		stage.close();

	}

	@FXML
	void onNoButtonPressed(ActionEvent event) {
		negativeInputAnchorPane.setVisible(false);
		expenditureDetailsAnchorPane.setVisible(true);

	}

	@FXML
	void onYesButtonPressed(ActionEvent event) {

	}

	@FXML
	void initialize() {
		assert expenditureDetailsAnchorPane != null
				: "fx:id=\"expenditureDetailsAnchorPane\" was not injected: check your FXML file 'ExpenditureDetails.fxml'.";
		assert categoryTextField != null
				: "fx:id=\"categoryTextField\" was not injected: check your FXML file 'ExpenditureDetails.fxml'.";
		assert amountTextField != null
				: "fx:id=\"amountTextField\" was not injected: check your FXML file 'ExpenditureDetails.fxml'.";
		assert addButton != null
				: "fx:id=\"addButton\" was not injected: check your FXML file 'ExpenditureDetails.fxml'.";
		assert exitButton != null
				: "fx:id=\"exitButton\" was not injected: check your FXML file 'ExpenditureDetails.fxml'.";

		addButton.disableProperty()
				.bind(categoryTextField.textProperty().isEmpty().or(amountTextField.textProperty().isEmpty()));

	}
}