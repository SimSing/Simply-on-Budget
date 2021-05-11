package controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import model.Income;
import model.Income.CategoryInc;

public class IncomeDetailsController extends CommonPropertiesController {

	@FXML
	private ComboBox<CategoryInc> categoryComboBox;

	@FXML
	private Button yesButton;

	@FXML
	private Button noButton;

	@FXML
	private TextField commentTextField;

	@FXML
	private AnchorPane negativeInputAnchorPane;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private AnchorPane incomeDetailsAnchorPane;

	@FXML
	private TextField amountTextField;

	@FXML
	private Button addButton;

	@FXML
	private Button saveButton;
	
    @FXML
    private Button exitButton;

	@FXML
	private Label negativeNumberLabel;

	@FXML
	private Label confirmationLabel;
	



	@FXML
	void onNoButtonPressed(ActionEvent event) {
		negativeInputAnchorPane.setVisible(false);
		incomeDetailsAnchorPane.setVisible(true);
	}

	@FXML
	void onYesButtonPressed(ActionEvent event) {

		addIncomeToDataBase();
		negativeInputAnchorPane.setVisible(false);
		incomeDetailsAnchorPane.setVisible(true);
	}

	@FXML
	void onAddButtonPressed(ActionEvent event) {

		if (amountTextField.getText().contains("-")) {
			incomeDetailsAnchorPane.setVisible(false);
			negativeInputAnchorPane.setVisible(true);

		} else {
			addIncomeToDataBase();

		}
	}
	
	   @FXML
	    void onExitButtonPressed(ActionEvent event) {
		   
		   exitButton.getScene().getWindow().hide();

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
	void onSaveButtonPressed(ActionEvent event) {
		
		Income income = selectedIncomeProperty.get();
		int index = incomeList.indexOf(income);
		
		income.setCategoryInc(categoryComboBox.getSelectionModel().getSelectedItem());
		income.setCommentInc(commentTextField.getText());
		income.setDateInc(LocalDate.now());
		double amountIncDouble = Double.parseDouble(amountTextField.getText());
		income.setAmountInc(amountIncDouble);
		
		incomeList.set(index, income);
		
		clearIncomeInForm();

	}

	@FXML
	void initialize() {
		assert incomeDetailsAnchorPane != null
				: "fx:id=\"incomeDetailsAnchorPane\" was not injected: check your FXML file 'IncomeDetails.fxml'.";
		assert addButton != null : "fx:id=\"addButton\" was not injected: check your FXML file 'IncomeDetails.fxml'.";
		assert saveButton != null : "fx:id=\"saveButton\" was not injected: check your FXML file 'IncomeDetails.fxml'.";
		assert negativeInputAnchorPane != null
				: "fx:id=\"negativeInputAnchorPane\" was not injected: check your FXML file 'IncomeDetails.fxml'.";
		assert yesButton != null : "fx:id=\"yesButton\" was not injected: check your FXML file 'IncomeDetails.fxml'.";
		assert noButton != null : "fx:id=\"noButton\" was not injected: check your FXML file 'IncomeDetails.fxml'.";
		assert categoryComboBox != null
				: "fx:id=\"categoryComboBox\" was not injected: check your FXML file 'IncomeDetails.fxml'.";
		assert amountTextField != null
				: "fx:id=\"amountTextField\" was not injected: check your FXML file 'IncomeDetails.fxml'.";
		assert commentTextField != null
				: "fx:id=\"commentTextField\" was not injected: check your FXML file 'IncomeDetails.fxml'.";

		
		addButton.disableProperty()
		.bind(commentTextField.textProperty().isEmpty().or(amountTextField.textProperty().isEmpty()));

		
		saveButton.setVisible(false);
		categoryComboBox.getItems().setAll(CategoryInc.values());

		negativeInputAnchorPane.setManaged(false);
		// addButton.disableProperty().bind(amountTextField.getText().isEmpty());
		
		selectedIncomeProperty.addListener(new ChangeListener<Income>() {

			@Override
			public void changed(ObservableValue<? extends Income> observable, Income oldValue,
					Income newValue) {

				if (newValue != null) {
					updateIncomeInForm(newValue);
				}else {
					clearIncomeInForm();
				}
				
			}
        	
		});
		
		
		
	}
	
	void addIncomeToDataBase() {
		CategoryInc categoryInc = categoryComboBox.getValue();
		String amountString = amountTextField.getText();
		double amount = Double.parseDouble(amountString);
		LocalDate date = LocalDate.now();
		String comment = commentTextField.getText();

		if (!categoryInc.toString().isEmpty() && !amountString.isEmpty()) {
			Income income = new Income(categoryInc, amount, date, comment);
			System.out.println("Income added");
			
			incomeList.add(income);

		}
	}
	
	private void clearIncomeInForm() {
		commentTextField.clear();
		categoryComboBox.getSelectionModel().clearSelection();
		amountTextField.clear();
	}
	
	private void updateIncomeInForm(Income income) {
		commentTextField.setText(income.getCommentInc());
		categoryComboBox.getSelectionModel().select(income.getCategoryInc());
		Double amountIncDouble = (income.getAmountInc());
		String amountIncString = amountIncDouble.toString();
		amountTextField.setText(amountIncString);
		
		saveButton.setVisible(true);
		addButton.setVisible(false);
	}
}
