package controller;

import java.net.URL;
import java.time.Year;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Inflation;


public class InflationController extends CommonPropertiesController {


	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private ComboBox<Year> yearComboBox;

	@FXML
	private TextField inflationTextField;
	
    @FXML
    private Button exitButton;

    @FXML
    private Button saveButton;

    @FXML
    private Button addButton;


	@FXML
	void onYearComboBoxPressed(ActionEvent event) {
		
		

	}
	
    @FXML
    void onAddButtonPressed(ActionEvent event) {
    	
    	Year inflationYear = yearComboBox.getSelectionModel().getSelectedItem();
    	String inflationFigureString = inflationTextField.getText();
    	double inflationFigure = Double.parseDouble(inflationFigureString);
    	
    	if(!inflationYear.toString().isEmpty() && !inflationFigureString.isEmpty()) {
    		Inflation inflation = new Inflation(inflationYear, inflationFigure);
    		inflationList.add(inflation);
    	}

    }

    @FXML
    void onExitButtonPressed(ActionEvent event) {
		Stage stage = (Stage) exitButton.getScene().getWindow();
		
		stage.hide();
    }

    @FXML
    void onSaveButtonPressed(ActionEvent event) {
    	
    	Inflation inflation = selectedInflationProperty.get();
    	int index = inflationList.indexOf(inflation);
    	
    	inflation.setInflationYear(yearComboBox.getSelectionModel().getSelectedItem());
    	double inflationFigureDouble = Double.parseDouble(inflationTextField.getText());
    	inflation.setInflationFigure(inflationFigureDouble);
    	
    	inflationList.set(index, inflation);
    	
    	clearInflationInForm();

    }

	@FXML
	void initialize() {
		assert yearComboBox != null : "fx:id=\"yearComboBox\" was not injected: check your FXML file 'Inflation.fxml'.";
		assert inflationTextField != null
				: "fx:id=\"inflationTextField\" was not injected: check your FXML file 'Inflation.fxml'.";
		
		saveButton.setVisible(false);

		List<Year> inflationYearsList = (inflationList.stream()
													  .map(f -> f.getInflationYear())
													  .sorted()
													  .collect(Collectors.toList()));
		
		yearComboBox.getItems().setAll(inflationYearsList);
		
		selectedInflationProperty.addListener(new ChangeListener<Inflation>() {

			@Override
			public void changed(ObservableValue<? extends Inflation> observable, Inflation oldValue,
					Inflation newValue) {
						if (newValue != null) {
					updateInflationInForm(newValue);
				} else {
					clearInflationInForm();
				}
				
			}
		});


}
	private void clearInflationInForm() {
		yearComboBox.getSelectionModel().clearSelection();
		inflationTextField.clear();
	}
	
private void updateInflationInForm(Inflation inflation) {
	yearComboBox.getEditor().setText(inflation.getInflationYear().toString());
	Double inflationFigureDouble = inflation.getInflationFigure();
	String inflationFigureString = inflationFigureDouble.toString();
	inflationTextField.setText(inflationFigureString);
	
	saveButton.setVisible(true);
	addButton.setVisible(false);
	
}

}