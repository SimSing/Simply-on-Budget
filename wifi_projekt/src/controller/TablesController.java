package controller;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import model.FixedExpenditures;
import model.FluctExpenditures;
import model.FluctExpenditures.Category;
import model.Income;
import model.Income.CategoryInc;

public class TablesController extends CommonPropertiesController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Label sumFluctExpendituresLabel;

	@FXML
	private Label sumFixedExpendituresLabel;

	@FXML
	private Label sumIncomeLabel;

	@FXML
	private TableView<FluctExpenditures> tableView1;

	@FXML
	private Tab categoriesTab;

	@FXML
	private TableColumn<FluctExpenditures, String> category1Column;

	@FXML
	private TableColumn<FluctExpenditures, Number> price1Column;

	@FXML
	private TableColumn<FluctExpenditures, String> date1Column;

	@FXML
	private TableColumn<FluctExpenditures, String> comment1Column;

	@FXML
	private TableColumn<FluctExpenditures, String> delete1Column;

	@FXML
	private ComboBox<Month> monthComboBox1;

	@FXML
	private ComboBox<Integer> yearComboBox1;

	@FXML
	private ComboBox<Category> categoryComboBox1;

	@FXML
	private TableView<FixedExpenditures> tableView2;

	@FXML
	private Tab expendituresTab;

	@FXML
	private TableColumn<FixedExpenditures, String> category2Column;

	@FXML
	private TableColumn<FixedExpenditures, Number> amount2Column;

	@FXML
	private TableColumn<FixedExpenditures, String> date2Column;

	@FXML
	private TableColumn<FixedExpenditures, String> delete2Column;

	@FXML
	private ComboBox<Month> monthComboBox2;

	@FXML
	private ComboBox<Year> yearComboBox2;

	@FXML
	private ComboBox<Category> categoryComboBox2;

	@FXML
	private TableView<Income> tableView3;

	@FXML
	private Tab incomeTab;

	@FXML
	private TableColumn<Income, String> category3Column;

	@FXML
	private TableColumn<Income, Number> amount3Column;

	@FXML
	private TableColumn<Income, String> date3Column;

	@FXML
	private TableColumn<Income, String> comment3Column;

	@FXML
	private TableColumn<Income, String> delete3Column;

	@FXML
	private ComboBox<Month> monthComboBox3;

	@FXML
	private ComboBox<LocalDate> yearComboBox3;

	@FXML
	private ComboBox<CategoryInc> categoryComboBox3;

	@FXML
	void onCategoryComboBox1Pressed(ActionEvent event) {
		tableView1.setItems(fluctExpendituresList);

		for (int i = 0; i <= 7; i++) {
			if (categoryComboBox1.getSelectionModel().isSelected(i)) {
				filterCategories(categoryComboBox1.getSelectionModel().getSelectedItem().toString());

			}
		}
		for (int i = 0; i <= 11; i++) {
			if (monthComboBox1.getSelectionModel().isSelected(i)) {
				filterMonth(Month.of(i + 1));
			}
		}

		sumColumn1();

	}

	@FXML
	void onMonthComboBox1Pressed(ActionEvent event) {
		tableView1.setItems(fluctExpendituresList);

		for (int i = 0; i <= 7; i++) {
			if (categoryComboBox1.getSelectionModel().isSelected(i)) {
				filterCategories(categoryComboBox1.getSelectionModel().getSelectedItem().toString());

			}
		}

		for (int i = 0; i <= 11; i++) {
			if (monthComboBox1.getSelectionModel().isSelected(i)) {
				filterMonth(Month.of(i + 1));
			}
		}
		sumColumn1();

	}

	@FXML
	void onYearComboBox1Pressesd(ActionEvent event) {
		sumColumn1();
	}
	


	@FXML
	void onMonthComboBox2Pressed(ActionEvent event) {

		tableView3.setItems(incomeList);

		for (int i = 0; i <= 2; i++) {
			if (categoryComboBox3.getSelectionModel().isSelected(0)) {
				filterCategoriesInc(categoryComboBox3.getSelectionModel().getSelectedItem().toString());
			}

		}
		for (int i = 0; i <= 11; i++) {
			if (monthComboBox1.getSelectionModel().isSelected(i)) {
				filterMonth(Month.of(i + 1));
			}
		}
		sumColumn2();
	}



	
	@FXML
	void onCategoryComboBox3Pressed(ActionEvent event) {
		tableView3.setItems(incomeList);

		for (int i = 0; i <= 2; i++) {
			if (categoryComboBox3.getSelectionModel().isSelected(0)) {
				filterCategoriesInc(categoryComboBox3.getSelectionModel().getSelectedItem().toString());
			}

		}
		for (int i = 0; i <= 11; i++) {
			if (monthComboBox1.getSelectionModel().isSelected(i)) {
				filterMonth(Month.of(i + 1));
			}
		}
		sumColumn3();

	}

	@FXML
	void onCategoriesTabChanged(ActionEvent event) {
		if(categoriesTab.isSelected()) {
			sumColumn1();
		}
	}
	
	void onfixedExpendituresTabChanged(ActionEvent event) {
		if(expendituresTab.isSelected()) {
			sumColumn2();
		}
	}

	
	void onIncomeTabChanged(ActionEvent event) {
		if(incomeTab.isSelected()) {
			sumColumn3();
		}
	}


	@FXML
	void initialize() {
		assert categoriesTab != null : "fx:id=\"categoriesTab\" was not injected: check your FXML file 'Tables.fxml'.";
		assert tableView1 != null : "fx:id=\"tableView1\" was not injected: check your FXML file 'Tables.fxml'.";
		assert category1Column != null
				: "fx:id=\"category1Column\" was not injected: check your FXML file 'Tables.fxml'.";
		assert price1Column != null : "fx:id=\"price1Column\" was not injected: check your FXML file 'Tables.fxml'.";
		assert date1Column != null : "fx:id=\"date1Column\" was not injected: check your FXML file 'Tables.fxml'.";
		assert comment1Column != null
				: "fx:id=\"comment1Column\" was not injected: check your FXML file 'Tables.fxml'.";
		assert delete1Column != null : "fx:id=\"delete1Column\" was not injected: check your FXML file 'Tables.fxml'.";
		assert monthComboBox1 != null
				: "fx:id=\"monthComboBox1\" was not injected: check your FXML file 'Tables.fxml'.";
		assert yearComboBox1 != null : "fx:id=\"yearComboBox1\" was not injected: check your FXML file 'Tables.fxml'.";
		assert categoryComboBox1 != null
				: "fx:id=\"categoryComboBox1\" was not injected: check your FXML file 'Tables.fxml'.";
		assert expendituresTab != null
				: "fx:id=\"expendituresTab\" was not injected: check your FXML file 'Tables.fxml'.";
		assert tableView2 != null : "fx:id=\"tableView2\" was not injected: check your FXML file 'Tables.fxml'.";
		assert category2Column != null
				: "fx:id=\"category2Column\" was not injected: check your FXML file 'Tables.fxml'.";
		assert amount2Column != null : "fx:id=\"amount2Column\" was not injected: check your FXML file 'Tables.fxml'.";
		assert date2Column != null : "fx:id=\"date2Column\" was not injected: check your FXML file 'Tables.fxml'.";
		assert delete2Column != null : "fx:id=\"delete2Column\" was not injected: check your FXML file 'Tables.fxml'.";
		assert monthComboBox2 != null
				: "fx:id=\"monthComboBox2\" was not injected: check your FXML file 'Tables.fxml'.";
		assert yearComboBox2 != null : "fx:id=\"yearComboBox2\" was not injected: check your FXML file 'Tables.fxml'.";
		assert categoryComboBox2 != null
				: "fx:id=\"categoryComboBox2\" was not injected: check your FXML file 'Tables.fxml'.";
		assert incomeTab != null : "fx:id=\"incomeTab\" was not injected: check your FXML file 'Tables.fxml'.";
		assert tableView3 != null : "fx:id=\"tableView3\" was not injected: check your FXML file 'Tables.fxml'.";
		assert category3Column != null
				: "fx:id=\"category3Column\" was not injected: check your FXML file 'Tables.fxml'.";
		assert amount3Column != null : "fx:id=\"amount3Column\" was not injected: check your FXML file 'Tables.fxml'.";
		assert date3Column != null : "fx:id=\"date3Column\" was not injected: check your FXML file 'Tables.fxml'.";
		assert comment3Column != null
				: "fx:id=\"comment3Column\" was not injected: check your FXML file 'Tables.fxml'.";
		assert delete3Column != null : "fx:id=\"delete3Column\" was not injected: check your FXML file 'Tables.fxml'.";
		assert monthComboBox3 != null
				: "fx:id=\"monthComboBox3\" was not injected: check your FXML file 'Tables.fxml'.";
		assert yearComboBox3 != null : "fx:id=\"yearComboBox3\" was not injected: check your FXML file 'Tables.fxml'.";
		assert categoryComboBox3 != null
				: "fx:id=\"categoryComboBox3\" was not injected: check your FXML file 'Tables.fxml'.";
		assert sumIncomeLabel != null
				: "fx:id=\"sumIncomeLabel\" was not injected: check your FXML file 'Tables.fxml'.";
		assert sumFixedExpendituresLabel != null
				: "fx:id=\"sumFixedExpendituresLabel\" was not injected: check your FXML file 'Tables.fxml'.";
		assert sumFluctExpendituresLabel != null
				: "fx:id=\"sumFluctExpendituresLabel\" was not injected: check your FXML file 'Tables.fxml'.";
		
		
		
		
		
		List<Integer> fluctExpendituresYearsList = (fluctExpendituresList.stream().map(f -> f.getDate().getYear())
				.distinct().collect(Collectors.toList()));

		// fill Category-comboBoxes
		categoryComboBox1.getItems().setAll(Category.values());
		categoryComboBox3.getItems().setAll(CategoryInc.values());

		// fill month-comboBoxes
		monthComboBox1.getItems().setAll(Month.values());
		monthComboBox2.getItems().setAll(Month.values());
		monthComboBox3.getItems().setAll(Month.values());


		// fill year-comboBoxes
		yearComboBox1.getItems().setAll(fluctExpendituresYearsList);

		// set default tableView-items
		tableView1.setItems(fluctExpendituresList);
		tableView2.setItems(fixedExpendituresList);
		tableView3.setItems(incomeList);

		// Columns for FluctExpenditures

		category1Column.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCategory().toString()));
		price1Column.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getPrice()));
		date1Column
				.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDate().format(dateFormatter)));
		comment1Column.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getComment()));

		tableView1.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<FluctExpenditures>() {

			@Override
			public void changed(ObservableValue<? extends FluctExpenditures> observable, FluctExpenditures oldValue,
					FluctExpenditures newValue) {

				System.out.println("Table Selection Changed called: " + newValue);
				selectedFluctExpendituresProperty.set(newValue);
				sumColumn1();
			}

		});

		// Columns for FixedExpenditures

		tableView2.setItems(fixedExpendituresList);

		category2Column.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCategory()));
		amount2Column.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getAmount()));
		date2Column
				.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDate().format(dateFormatter)));

		tableView2.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<FixedExpenditures>() {

			@Override
			public void changed(ObservableValue<? extends FixedExpenditures> observable, FixedExpenditures oldValue,
					FixedExpenditures newValue) {

				System.out.println("Table Selection Changed called: " + newValue);
				selectedFixedExpendituresProperty.set(newValue);
				sumColumn2();
			}

		});

		// columns for Income

		tableView3.setItems(incomeList);

		category3Column
				.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCategoryInc().toString()));
		amount3Column.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getAmountInc()));
		date3Column.setCellValueFactory(
				data -> new SimpleStringProperty(data.getValue().getDateInc().format(dateFormatter)));
		comment3Column.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCommentInc()));

		tableView3.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Income>() {

			@Override
			public void changed(ObservableValue<? extends Income> observable, Income oldValue, Income newValue) {

				System.out.println("Table Selection Changed called: " + newValue);
				selectedIncomeProperty.set(newValue);
				sumColumn3();
			}
		});

		// delete-button for FluctExpenditures

		var deleteCallBack = new Callback<TableColumn<FluctExpenditures, String>, TableCell<FluctExpenditures, String>>() {
			@Override
			public TableCell<FluctExpenditures, String> call(TableColumn<FluctExpenditures, String> param) {
				TableCell<FluctExpenditures, String> cell = new TableCell<FluctExpenditures, String>() {

					Button deleteButton = new Button("Delete");

					public void updateItem(String item, boolean empty) {
						super.updateItem(item, empty);

						if (empty) {
							setGraphic(null);
							setText(null);

						} else {

							deleteButton.setOnAction(e -> {
								FluctExpenditures fluctExpenditures = getTableView().getItems().get(getIndex());

								fluctExpendituresList.remove(fluctExpenditures);
								sumColumn1();
							});
							setGraphic(deleteButton);
							setText(null);

						}
					}

				};
				return cell;
			}
		};

		// delete-button for FixedExpenditures

		var deleteFixedExpenditureCallBack = new Callback<TableColumn<FixedExpenditures, String>, TableCell<FixedExpenditures, String>>() {
			@Override
			public TableCell<FixedExpenditures, String> call(TableColumn<FixedExpenditures, String> param) {
				TableCell<FixedExpenditures, String> cell = new TableCell<FixedExpenditures, String>() {

					Button deleteButton = new Button("Delete");

					public void updateItem(String item, boolean empty) {
						super.updateItem(item, empty);

						if (empty) {
							setGraphic(null);
							setText(null);

						} else {

							deleteButton.setOnAction(e -> {
								FixedExpenditures fixedExpenditures = getTableView().getItems().get(getIndex());

								fixedExpendituresList.remove(fixedExpenditures);
								sumColumn2();
							});
							setGraphic(deleteButton);
							setText(null);

						}
					}

				};
				return cell;
			}
		};

		// delete-Button for Income

		var deleteIncCallBack = new Callback<TableColumn<Income, String>, TableCell<Income, String>>() {
			@Override
			public TableCell<Income, String> call(TableColumn<Income, String> param) {
				TableCell<Income, String> cell = new TableCell<Income, String>() {

					Button deleteButton = new Button("Delete");

					public void updateItem(String item, boolean empty) {
						super.updateItem(item, empty);

						if (empty) {
							setGraphic(null);
							setText(null);

						} else {

							deleteButton.setOnAction(e -> {
								Income income = getTableView().getItems().get(getIndex());

								incomeList.remove(income);
								sumColumn3();
							});
							setGraphic(deleteButton);
							setText(null);

						}
					}

				};
				return cell;
			}
		};

		// delete-buttons

		delete1Column.setCellFactory(deleteCallBack);
		delete2Column.setCellFactory(deleteFixedExpenditureCallBack);
		delete3Column.setCellFactory(deleteIncCallBack);

		/*
		 * filter-methods (Category)
		 */
		
		//initally summing up the values price/amount columns of the respective tables
		sumColumn1();
		sumColumn2();
		sumColumn3();
	}

	private void filterCategories(String categories) {
		FilteredList<FluctExpenditures> items = new FilteredList<>(tableView1.getItems());
		Predicate<FluctExpenditures> itemsCategories = i -> i.getCategory().toString() == categories;
		items.setPredicate(itemsCategories);
		tableView1.setItems(items);

	}

	private void filterCategoriesInc(String categoriesInc) {
		FilteredList<Income> items = new FilteredList<>(tableView3.getItems());
		Predicate<Income> itemsCategoriesInc = i -> i.getCategoryInc().toString() == categoriesInc;
		items.setPredicate(itemsCategoriesInc);
		tableView3.setItems(items);

	}

	/*
	 * filter - methods (months)
	 */
	private void filterMonth(Month month) {
		FilteredList<FluctExpenditures> itemsFluctExp = new FilteredList<>(tableView1.getItems());
		Predicate<FluctExpenditures> itemsMonth = i -> i.getDate().getMonth() == month;
		itemsFluctExp.setPredicate(itemsMonth);
		tableView1.setItems(itemsFluctExp);

	}

	private void sumColumn1() {
		Double sum = tableView1.getItems().stream().mapToDouble(i -> i.getPrice()).sum();
		sumFluctExpendituresLabel.setText(sum.toString());
	}

	private void sumColumn2() {
		Double sum = tableView2.getItems().stream().mapToDouble(i -> i.getAmount()).sum();
		sumFixedExpendituresLabel.setText(sum.toString());
	}
	
	private void sumColumn3() {
		Double sum = tableView3.getItems().stream().mapToDouble(i -> i.getAmountInc()).sum();
		sumIncomeLabel.setText(sum.toString());
	}
}