package controller;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import model.FluctExpenditures;
import model.FluctExpenditures.Category;
import model.Profile;

public class MainTableController extends CommonPropertiesController {
	
	String style_inner = "-fx-border-color: black;"
            + "-fx-border-width: 1;"
            + "-fx-border-style: dotted;";
	
	@FXML
	private ImageView billImageView;
	
    @FXML
    private HBox hBoxImageView;
	
	@FXML
	private TextField billPathTextField;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button saveButton;

	@FXML
	private TextField commentTextField;

	@FXML
	private Button editIncome;

	@FXML
	private Button editFixedExpenditures;

	@FXML
	private ComboBox<Category> categoryComboBox;

	@FXML
	private TextField priceTextField;

	@FXML
	private DatePicker datePicker;

	@FXML
	private Button billPathButton;

	@FXML
	private Button addButton;

	@FXML
	private Button exitButton;

	@FXML
	private Button inflationButton;

	@FXML
	private Button chartsButton;

	@FXML
	private Button tablesButton;

	@FXML
	private Button clearButton;
	
    @FXML
    void onBillImageViewPressed(MouseEvent event) {
    	try  
    	{  
    	File file = new File(billPathTextField.getText());
    	
    	if(!Desktop.isDesktopSupported())
    	{  
    	System.out.println("not supported");  
    	return;  
    	}  
    	Desktop desktop = Desktop.getDesktop();  
    	if(file.exists())         
    	desktop.open(file);             
    	}  
    	catch(Exception e)  
    	{  
    	e.printStackTrace();  
    	} 
    }

	@FXML
	void onAddButtonPressed(ActionEvent event) {

		Category category = categoryComboBox.getSelectionModel().getSelectedItem();
		String priceString = priceTextField.getText();
		double price = Double.parseDouble(priceString);
		LocalDate date = datePicker.getValue();
		String comment = commentTextField.getText();
		String path = billPathTextField.getText();
		Profile profile = profileList.get(loginId - 1);

		System.out.println(category.toString() + " " + priceString + " " + date + " " + comment);
		if (!category.toString().isEmpty() && !priceString.isEmpty() && date != null && !comment.isEmpty()) {
			FluctExpenditures fluctExpenditures = new FluctExpenditures(category, price, date, comment, path, profile);
			System.out.println("Object added");

			fluctExpendituresList.add(fluctExpenditures);
			// reInitialiseLists();

//			Node node = 
//			node.getScene().getWindow().setOnHiding((event2) -> System.out.println("Window close"));
		} // updateAllLists();
	}

	@FXML
	void onClearButtonPressed(ActionEvent event) {

		clearFluctExpendituresInForm();
		addButton.setVisible(true);
		saveButton.setVisible(false);

	}

	@FXML
	void onCategoryComboBoxPressed(ActionEvent event) {

	}

	@FXML
	void onSaveButtonPressed(ActionEvent event) {

		FluctExpenditures fluctExpenditures = selectedFluctExpendituresProperty.get();
		int index = fluctExpendituresList.indexOf(fluctExpenditures);

		fluctExpenditures.setCategory(categoryComboBox.getSelectionModel().getSelectedItem());
		fluctExpenditures.setComment(commentTextField.getText());
		fluctExpenditures.setDate(LocalDate.parse(datePicker.getEditor().getText(), dateFormatter));
		fluctExpenditures.setPath(billPathTextField.getText());
		double priceDouble = Double.parseDouble(priceTextField.getText());
		fluctExpenditures.setPrice(priceDouble);

		fluctExpendituresList.set(index, fluctExpenditures);

		clearFluctExpendituresInForm();
		addButton.setVisible(true);
		saveButton.setVisible(false);
	}

	@FXML
	void onChartsButtonPressed(ActionEvent event) {

		loadScene("Charts");

	}

	@FXML
	void onDatePickerPressed(ActionEvent event) {

	}

	@FXML
	void onEditBillButtonPressed(ActionEvent event) {

		loadScene("Bill");

	}

	@FXML
	void onEditFixedExpendituresButtonPressed(ActionEvent event) {

		loadScene("ExpenditureDetails");

	}

	@FXML
	void onEditIncomeButtonPressed(ActionEvent event) {

		loadScene("IncomeDetails");

	}

	@FXML
	void onBillPathButton(ActionEvent event) {

		FileChooser fileChooser = new FileChooser();
		File file = fileChooser.showOpenDialog(billImageView.getScene().getWindow());

		String path = file.getAbsolutePath();
		billPathTextField.setText(path);

		updateImageView(path);

	}

	private void updateImageView(String path) {

		try {
			billImageView.setImage(new Image(Files.newInputStream(Path.of(path))));
		} catch (IOException e) {

			billImageView.setImage(null);
			System.err.println("Image at: " + path + " could not be opened");
		}

	}

	@FXML
	void onInflationButtonPressed(ActionEvent event) {

		loadScene("Inflation");

	}

	@FXML
	void onTablesButtonPressed(ActionEvent event) {

		loadScene("Tables");

	}

	@FXML
	void initialize() {
		assert commentTextField != null
				: "fx:id=\"commentTextField\" was not injected: check your FXML file 'MainTable.fxml'.";
		assert editIncome != null : "fx:id=\"editIncome\" was not injected: check your FXML file 'MainTable.fxml'.";
		assert editFixedExpenditures != null
				: "fx:id=\"editFixedExpenditures\" was not injected: check your FXML file 'MainTable.fxml'.";
		assert categoryComboBox != null
				: "fx:id=\"categoryComboBox\" was not injected: check your FXML file 'MainTable.fxml'.";
		assert priceTextField != null
				: "fx:id=\"priceTextField\" was not injected: check your FXML file 'MainTable.fxml'.";
		assert datePicker != null : "fx:id=\"datePicker\" was not injected: check your FXML file 'MainTable.fxml'.";
		assert billPathButton != null
				: "fx:id=\"billPathButton\" was not injected: check your FXML file 'MainTable.fxml'.";
		assert addButton != null : "fx:id=\"addButton\" was not injected: check your FXML file 'MainTable.fxml'.";
		assert exitButton != null : "fx:id=\"exitButton\" was not injected: check your FXML file 'MainTable.fxml'.";
		assert inflationButton != null
				: "fx:id=\"inflationButton\" was not injected: check your FXML file 'MainTable.fxml'.";
		assert chartsButton != null : "fx:id=\"chartsButton\" was not injected: check your FXML file 'MainTable.fxml'.";
		assert tablesButton != null : "fx:id=\"tablesButton\" was not injected: check your FXML file 'MainTable.fxml'.";
		assert billPathTextField != null
				: "fx:id=\"billPathTextField\" was not injected: check your FXML file 'MainTable.fxml'.";
		assert billImageView != null
				: "fx:id=\"billImageView\" was not injected: check your FXML file 'MainTable.fxml'.";
		assert saveButton != null : "fx:id=\"saveButton\" was not injected: check your FXML file 'MainTable.fxml'.";
		assert clearButton != null : "fx:id=\"clearButton\" was not injected: check your FXML file 'MainTable.fxml'.";

		hBoxImageView.setStyle(style_inner);
		saveButton.setVisible(false);

		categoryComboBox.getItems().setAll(Category.values());
		categoryComboBox.getItems().remove(Category.ALL);

		selectedFluctExpendituresProperty.addListener(new ChangeListener<FluctExpenditures>() {

			@Override
			public void changed(ObservableValue<? extends FluctExpenditures> observable, FluctExpenditures oldValue,
					FluctExpenditures newValue) {

				if (newValue != null) {
					updateFluctExpendituresInForm(newValue);
				} else {
					clearFluctExpendituresInForm();
				}

			}

		});

	}

	private void clearFluctExpendituresInForm() {
		commentTextField.clear();
		priceTextField.clear();
		datePicker.getEditor().clear();
		categoryComboBox.getSelectionModel().clearSelection();
		billPathTextField.clear();
		billImageView.setImage(null);
	}

	private void updateFluctExpendituresInForm(FluctExpenditures fluctExpenditures) {

		commentTextField.setText(fluctExpenditures.getComment());
		datePicker.getEditor().setText(fluctExpenditures.getDate().format(dateFormatter));
		categoryComboBox.getSelectionModel().select(fluctExpenditures.getCategory());
		billPathTextField.setText(fluctExpenditures.getPath());
		Double priceDouble = (fluctExpenditures.getPrice());
		String priceString = priceDouble.toString();
		priceTextField.setText(priceString);

		updateImageView(fluctExpenditures.getPath());

		saveButton.setVisible(true);
		addButton.setVisible(false);
	}
}
