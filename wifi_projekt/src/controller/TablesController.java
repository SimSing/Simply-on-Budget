package controller;

import java.awt.Desktop;
import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import model.FixedExpenditures;
import model.FluctExpenditures;
import model.FluctExpenditures.Category;
import model.Income;
import model.Income.CategoryInc;
import model.Inflation;

public class TablesController extends CommonPropertiesController {

	ArrayList<Double> inflationValuesPercent = new ArrayList<>();

	boolean inflationBool = false;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private CheckBox inflationCheckBox2;

	@FXML
	private CheckBox inflationCheckBox3;

	@FXML
	private TabPane tabPane;

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
	private TableColumn<FixedExpenditures, Number> amount2Column;

	@FXML
	private TableColumn<FixedExpenditures, String> date2Column;

	@FXML
	private TableColumn<FixedExpenditures, String> delete2Column;

	@FXML
	private TableColumn<FixedExpenditures, String> category2Column;
	@FXML
	private ComboBox<Month> monthComboBox2;

	@FXML
	private ComboBox<Integer> yearComboBox2;

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
	private ComboBox<Integer> yearComboBox3;

	@FXML
	private ComboBox<CategoryInc> categoryComboBox3;

	@FXML
	private CheckBox inflationCheckBox;

	@FXML
	void onInflationCheckBoxPressed(ActionEvent event) {
		
		
		
		inflationBool = !inflationBool;
		if (inflationList.size() > 0 && inflationBool == true) {
			modifyLists();
			inflationCheckBox.setSelected(true);
			inflationCheckBox2.setSelected(true);
			inflationCheckBox3.setSelected(true);
			if (tableView1.getItems().size()>0) {sumColumn1();}
			if (tableView2.getItems().size()>0) {sumColumn2();}
			if (tableView3.getItems().size()>0) {sumColumn3();}
		}
		if (inflationBool == false) {
			
			inflationCheckBox.setSelected(false);
			inflationCheckBox2.setSelected(false);
			inflationCheckBox3.setSelected(false);
			tableView1.setItems(filteredFluctExpendituresList);

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

			for (int i = 0; i <= yearComboBox1.getItems().size(); i++) {
				if (yearComboBox1.getSelectionModel().isSelected(i)) {
					filterYear(yearComboBox1.getItems().get(i));
				}
			}

			if (filteredFluctExpendituresList.size() > 0) {
				tableView1.refresh();
				sumColumn1();
			}
			

			tableView2.setItems(filteredFixedExpendituresList);

			for (int i = 0; i <= 11; i++) {
				if (monthComboBox2.getSelectionModel().isSelected(i)) {
					filterMonthFixedExp(Month.of(i + 1));
				}
			}
			for (int i = 0; i <= yearComboBox2.getItems().size(); i++) {
				if (yearComboBox2.getSelectionModel().isSelected(i)) {
					filterYearFixedExp(yearComboBox2.getItems().get(i));
				}
			}
			if (filteredFixedExpendituresList.size() > 0) {
				tableView2.refresh();
				sumColumn2();
			}
		}
		for (int i = 0; i <= 2; i++) {
			if (categoryComboBox3.getSelectionModel().isSelected(i)) {
				filterCategoriesInc(categoryComboBox3.getSelectionModel().getSelectedItem().toString());

			}
		}

		for (int i = 0; i <= 11; i++) {
			if (monthComboBox3.getSelectionModel().isSelected(i)) {
				filterMonthInc(Month.of(i + 1));
			}
		}
		for (int i = 0; i <= yearComboBox3.getItems().size() - 1; i++) {
			if (yearComboBox3.getSelectionModel().isSelected(i)) {
				filterYearInc(yearComboBox3.getSelectionModel().getSelectedItem());
			}
		}
		if (filteredIncomeList.size() > 0) {
			tableView3.refresh();
			sumColumn3();
		}
	}

	@FXML
	void onCategoryComboBox1Pressed(ActionEvent event) {
		tableView1.setItems(filteredFluctExpendituresList);

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

		for (int i = 0; i <= yearComboBox1.getItems().size(); i++) {
			if (yearComboBox1.getSelectionModel().isSelected(i)) {
				filterYear(yearComboBox1.getItems().get(i));
			}
		}

		if (filteredFluctExpendituresList.size() > 0) {
			sumColumn1();
		}

	}

	@FXML
	void onMonthComboBox2Pressed(ActionEvent event) {

		tableView2.setItems(filteredFixedExpendituresList);

		for (int i = 0; i <= 11; i++) {
			if (monthComboBox2.getSelectionModel().isSelected(i)) {
				filterMonthFixedExp(Month.of(i + 1));
			}
		}
		for (int i = 0; i <= yearComboBox2.getItems().size(); i++) {
			if (yearComboBox2.getSelectionModel().isSelected(i)) {
				filterYearFixedExp(yearComboBox2.getItems().get(i));
			}
		}
		if (filteredFixedExpendituresList.size() > 0) {
			sumColumn2();
		}

	}

	@FXML
	void onCategoryComboBox3Pressed(ActionEvent event) {
		tableView3.setItems(filteredIncomeList);

		for (int i = 0; i <= 2; i++) {
			if (categoryComboBox3.getSelectionModel().isSelected(i)) {
				filterCategoriesInc(categoryComboBox3.getSelectionModel().getSelectedItem().toString());

			}
		}

		for (int i = 0; i <= 11; i++) {
			if (monthComboBox3.getSelectionModel().isSelected(i)) {
				filterMonthInc(Month.of(i + 1));
			}
		}
		for (int i = 0; i <= yearComboBox3.getItems().size() - 1; i++) {
			if (yearComboBox3.getSelectionModel().isSelected(i)) {
				filterYearInc(yearComboBox3.getSelectionModel().getSelectedItem());
			}
		}
		if (filteredIncomeList.size() > 0) {
			sumColumn3();
		}

	}

	@FXML
	void onCategoriesTabChanged(ActionEvent event) {
		if (categoriesTab.isSelected()) {
			sumColumn1();
		}
	}

	void onfixedExpendituresTabChanged(ActionEvent event) {
		if (expendituresTab.isSelected()) {
			sumColumn2();
		}
	}

	void onIncomeTabChanged(ActionEvent event) {
		if (incomeTab.isSelected()) {
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

		List<Integer> fluctExpendituresYearsList = (filteredFluctExpendituresList.stream()
				.map(f -> f.getDate().getYear()).sorted().distinct().collect(Collectors.toList()));

		List<Integer> fixedExpendituresYearsList = (filteredFixedExpendituresList.stream()
				.map(f -> f.getDateFixedExpenditures().getYear()).sorted().distinct().collect(Collectors.toList()));

		List<Integer> incomeYearsList = (filteredIncomeList.stream().map(f -> f.getDateInc().getYear()).sorted()
				.distinct().collect(Collectors.toList()));

		// fill Category-comboBoxes
		categoryComboBox1.getItems().setAll(Category.values());
		categoryComboBox1.getItems().remove(Category.ALL);
		categoryComboBox3.getItems().setAll(CategoryInc.values());

		// fill month-comboBoxes
		monthComboBox1.getItems().setAll(Month.values());
		monthComboBox2.getItems().setAll(Month.values());
		monthComboBox3.getItems().setAll(Month.values());

		// fill year-comboBoxes
		yearComboBox1.getItems().setAll(fluctExpendituresYearsList);
		yearComboBox2.getItems().setAll(fixedExpendituresYearsList);
		yearComboBox3.getItems().setAll(incomeYearsList);

		// set default tableView-items
		tableView1.setItems(filteredFluctExpendituresList);
		tableView2.setItems(filteredFixedExpendituresList);
		tableView3.setItems(filteredIncomeList);

		// Columns for FluctExpenditures

		category1Column.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCategory().toString()));
		price1Column.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getPrice()));
		price1Column.setCellFactory(tc -> new TableCell<FluctExpenditures, Number>() {
			@Override
			public void updateItem(Number value, boolean empty) {

				super.updateItem(value, empty);
				if (empty) {
					setText(null);
				} else {
					setText(String.format("%.2f", value.doubleValue()).toString());
				}
			}
		});
		date1Column
				.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDate().format(dateFormatter)));
		comment1Column.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getComment()));

		tableView1.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<FluctExpenditures>() {

			@Override
			public void changed(ObservableValue<? extends FluctExpenditures> observable, FluctExpenditures oldValue,
					FluctExpenditures newValue) {

				System.out.println("Table Selection Changed called: " + newValue);
				selectedFluctExpendituresProperty.set(newValue);
				if (filteredFluctExpendituresList.size() > 0) {
					sumColumn1();
				}
			}

		});

		// Columns for FixedExpenditures

		category2Column.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCategory()));
		amount2Column.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getAmount()));
		amount2Column.setCellFactory(tc -> new TableCell<FixedExpenditures, Number>() {
			@Override
			public void updateItem(Number value, boolean empty) {

				super.updateItem(value, empty);
				if (empty) {
					setText(null);
				} else {
					setText(String.format("%.2f", value.doubleValue()).toString());
				}
			}
		});
		date2Column.setCellValueFactory(
				data -> new SimpleStringProperty(data.getValue().getDateFixedExpenditures().format(dateFormatter)));

		tableView2.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<FixedExpenditures>() {

			@Override
			public void changed(ObservableValue<? extends FixedExpenditures> observable, FixedExpenditures oldValue,
					FixedExpenditures newValue) {

				System.out.println("Table Selection Changed called: " + newValue);
				selectedFixedExpendituresProperty.set(newValue);
				if (filteredFixedExpendituresList.size() > 0) {
					sumColumn2();
				}
			}

		});

		// columns for Income

		category3Column
				.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCategoryInc().toString()));
		amount3Column.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getAmountInc()));
		amount3Column.setCellFactory(tc -> new TableCell<Income, Number>() {
			@Override
			public void updateItem(Number value, boolean empty) {

				super.updateItem(value, empty);
				if (empty) {
					setText(null);
				} else {
					setText(String.format("%.2f", value.doubleValue()).toString());
				}
			}
		});
		date3Column.setCellValueFactory(
				data -> new SimpleStringProperty(data.getValue().getDateInc().format(dateFormatter)));
		comment3Column.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCommentInc()));
		tableView3.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Income>() {

			@Override
			public void changed(ObservableValue<? extends Income> observable, Income oldValue, Income newValue) {

				System.out.println("Table Selection Changed called: " + newValue);
				selectedIncomeProperty.set(newValue);

				if (filteredIncomeList.size() > 0) {
					sumColumn3();
				}
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
								Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
								alert.initOwner(categoryComboBox1.getScene().getWindow());
								alert.setTitle("Delete-Confirmation");
								alert.setContentText("Permanently delete Entry?");
//								ButtonType buttonOk = ButtonType.OK;
//								ButtonType buttonCancel = ButtonType.CANCEL;
								Optional<ButtonType> result = alert.showAndWait();
								if (result.get() == ButtonType.OK) {
									FluctExpenditures fluctExpenditures = getTableView().getItems().get(getIndex());

									fluctExpendituresList.remove(fluctExpenditures);
									sumColumn1();
								}
								if (result.get() == ButtonType.CANCEL) {
									alert.close();
								}
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
								Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
								alert.initOwner(categoryComboBox1.getScene().getWindow());
								alert.setTitle("Delete-Confirmation");
								alert.setContentText("Permanently delete Entry?");
//								ButtonType buttonOk = ButtonType.OK;
//								ButtonType buttonCancel = ButtonType.CANCEL;
								Optional<ButtonType> result = alert.showAndWait();
								if (result.get() == ButtonType.OK) {
									FixedExpenditures fixedExpenditures = getTableView().getItems().get(getIndex());

									fixedExpendituresList.remove(fixedExpenditures);
									sumColumn2();
								}
								if (result.get() == ButtonType.CANCEL) {
									alert.close();
								}
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
								Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
								alert.initOwner(categoryComboBox1.getScene().getWindow());
								alert.setTitle("Delete-Confirmation");
								alert.setContentText("Permanently delete Entry?");
								ButtonType buttonOk = ButtonType.OK;
								ButtonType buttonCancel = ButtonType.CANCEL;
								Optional<ButtonType> result = alert.showAndWait();
								if (result.get() == ButtonType.OK) {
									Income income = getTableView().getItems().get(getIndex());

									incomeList.remove(income);
									sumColumn3();
								}
								if (result.get() == ButtonType.CANCEL) {
									alert.close();
								}
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

		// initally summing up the values price/amount columns of the respective tables
		if (filteredFluctExpendituresList.size() > 0) {
			sumColumn1();
		}
		if (filteredFixedExpendituresList.size() > 0) {
			sumColumn2();
		}
		if (filteredIncomeList.size() > 0) {
			sumColumn3();
		}
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

	private void filterMonthFixedExp(Month month) {
		FilteredList<FixedExpenditures> itemsFixedExp = new FilteredList<>(tableView2.getItems());
		Predicate<FixedExpenditures> itemsMonth = i -> i.getDateFixedExpenditures().getMonth() == month;
		itemsFixedExp.setPredicate(itemsMonth);
		tableView2.setItems(itemsFixedExp);

	}

	private void filterMonthInc(Month month) {
		FilteredList<Income> itemsInc = new FilteredList<>(tableView3.getItems());
		Predicate<Income> itemsMonth = i -> i.getDateInc().getMonth() == month;
		itemsInc.setPredicate(itemsMonth);
		tableView3.setItems(itemsInc);

	}

	private void filterYear(int year) {

		FilteredList<FluctExpenditures> itemsFluctExp = new FilteredList<>(tableView1.getItems());
		Predicate<FluctExpenditures> itemsYear = i -> i.getDate().getYear() == year;
		itemsFluctExp.setPredicate(itemsYear);
		tableView1.setItems(itemsFluctExp);
	}

	private void filterYearFixedExp(int year) {

		FilteredList<FixedExpenditures> itemsFixedExp = new FilteredList<>(tableView2.getItems());
		Predicate<FixedExpenditures> itemsYear = i -> i.getDateFixedExpenditures().getYear() == year;
		itemsFixedExp.setPredicate(itemsYear);
		tableView2.setItems(itemsFixedExp);
	}

	private void filterYearInc(int year) {

		FilteredList<Income> itemsInc = new FilteredList<>(tableView3.getItems());
		Predicate<Income> itemsYear = i -> i.getDateInc().getYear() == year;
		itemsInc.setPredicate(itemsYear);
		tableView3.setItems(itemsInc);
	}

	private void sumColumn1() {
		Double sum = 0d;
		sum = tableView1.getItems().stream().mapToDouble(i -> i.getPrice()).sum();
		sumFluctExpendituresLabel.setText("Sum: " + String.format("%.2f", sum.doubleValue()).toString());
	}

	private void sumColumn2() {
		Double sum = 0d;
		sum = tableView2.getItems().stream().mapToDouble(i -> i.getAmount()).sum();
		sumFixedExpendituresLabel.setText("Sum: " + String.format("%.2f", sum.doubleValue()).toString());
	}

	private void sumColumn3() {
		Double sum = 0d;
		sum = tableView3.getItems().stream().mapToDouble(i -> i.getAmountInc()).sum();
		sumIncomeLabel.setText(String.format("Sum: " + "%.2f", sum.doubleValue()).toString());
	}

	private void modifyLists() {
		adjustForInflation();

		int i = 0;

		List<FluctExpenditures> inflationAdjustedFluctExp = filteredFluctExpendituresList.stream()
				.map(f -> new FluctExpenditures(f)).collect(Collectors.toList());
		for (i = inflationList.size() - 1; i >= 0; i--) {
			int tempint = i;
			inflationAdjustedFluctExp.stream()
					.filter(y -> y.getDate().getYear() == LocalDate.now().minusYears(tempint + 1).getYear())
					.forEach(f -> f.setPrice(f.getPrice() * inflationValuesPercent.get(tempint)));

		}
		ObservableList<FluctExpenditures> tempFluctList = FXCollections.observableArrayList(inflationAdjustedFluctExp);

		tableView1.setItems(tempFluctList);
		tableView1.refresh();

		List<FixedExpenditures> inflationAdjustedFixedExp = filteredFixedExpendituresList.stream()
				.map(f -> new FixedExpenditures(f)).collect(Collectors.toList());
		for (i = inflationList.size() - 1; i >= 0; i--) {
			int tempint = i;
			inflationAdjustedFixedExp.stream().filter(
					y -> y.getDateFixedExpenditures().getYear() == LocalDate.now().minusYears(tempint + 1).getYear())
					.forEach(f -> f.setAmount(f.getAmount() * inflationValuesPercent.get(tempint)));

		}
		ObservableList<FixedExpenditures> tempFixedList = FXCollections.observableArrayList(inflationAdjustedFixedExp);

		tableView2.setItems(tempFixedList);
		tableView2.refresh();

		List<Income> inflationAdjustedInc = filteredIncomeList.stream().map(f -> new Income(f))
				.collect(Collectors.toList());
		for (i = inflationList.size() - 1; i >= 0; i--) {
			int tempint = i;
			inflationAdjustedInc.stream()
					.filter(y -> y.getDateInc().getYear() == LocalDate.now().minusYears(tempint + 1).getYear())
					.forEach(f -> f.setAmountInc(f.getAmountInc() * inflationValuesPercent.get(tempint)));

		}
		ObservableList<Income> tempIncList = FXCollections.observableArrayList(inflationAdjustedInc);

		tableView3.setItems(tempIncList);
		tableView3.refresh();
	}

	private void adjustForInflation() {

		if (inflationValuesPercent.size() > 0) {
			inflationValuesPercent.clear();
		}

		// create List with only the inflation-values
		ArrayList<Double> inflationValuesRaw = new ArrayList<>(
				inflationList.stream().sorted(Comparator.comparing(Inflation::getInflationYear))
						.map(f -> f.getInflationFigure()).collect(Collectors.toList()));

		/*
		 * transform values to percent and also account for the time-dependency of
		 * inflation: prices at the start of a year shouldn't be adjusted equally as
		 * prices at the end of a year, as annual inflation depicts changes in prices
		 * only at the very end of the year. therefore uniform distribution of
		 * expenditures will be assumed and prices will be adjusted by
		 * ((inflation+(inflation/12))/2.
		 */

		for (int i = 0; i <= inflationValuesRaw.size() - 1; i++) {
			inflationValuesPercent.add(i,
					1 + (((inflationValuesRaw.get(i)) / 100) + ((inflationValuesRaw.get(i)) / 1200)) / 2);
		}

		// adjust values to base-year (inflation for prices in 2018 would be (inf2018 *
		// inf2019 * inf2020)

		int n = inflationValuesPercent.size();
		double prev = inflationValuesPercent.get(0);
		for (int i = 1; i <= n - 1; i++) {
			double curr = inflationValuesPercent.get(i);
			inflationValuesPercent.set(i, prev * curr);
			prev = curr * prev;

		}

	}

}
