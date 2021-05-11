package controller;

import java.net.URL;
import java.time.Year;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import model.Inflation;

public class InflationTableController extends CommonPropertiesController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TableView<Inflation> inflationTableView;

	@FXML
	private TableColumn<Inflation, String> yearColumn;

	@FXML
	private TableColumn<Inflation, Number> inflationColumn;

	@FXML
	private TableColumn<Inflation, String> deleteColumn;

	@FXML
	void initialize() {
		assert inflationTableView != null
				: "fx:id=\"inflationTableView\" was not injected: check your FXML file 'InflationTable.fxml'.";
		assert yearColumn != null
				: "fx:id=\"yearColumn\" was not injected: check your FXML file 'InflationTable.fxml'.";
		assert inflationColumn != null
				: "fx:id=\"inflationColumn\" was not injected: check your FXML file 'InflationTable.fxml'.";
		assert deleteColumn != null
				: "fx:id=\"deleteColumn\" was not injected: check your FXML file 'InflationTable.fxml'.";

		List<Year> inflationYearsList = (inflationList.stream().map(f -> f.getInflationYear())
				.collect(Collectors.toList()));

		yearColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getInflationYear().toString()));
		inflationColumn.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getInflationFigure()));

		inflationTableView.setItems(inflationList);
		inflationTableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Inflation>() {

			@Override
			public void changed(ObservableValue<? extends Inflation> observable, Inflation oldValue,
					Inflation newValue) {
				// TODO Auto-generated method stub

			}
		});

		var deleteCallBack = new Callback<TableColumn<Inflation, String>, TableCell<Inflation, String>>() {
			@Override
			public TableCell<Inflation, String> call(TableColumn<Inflation, String> param) {
				TableCell<Inflation, String> cell = new TableCell<Inflation, String>() {

					Button deleteButton = new Button("Delete");

					public void updateItem(String item, boolean empty) {
						super.updateItem(item, empty);

						if (empty) {
							setGraphic(null);
							setText(null);

						} else {

							deleteButton.setOnAction(e -> {
								Inflation inflation = getTableView().getItems().get(getIndex());

								inflationList.remove(inflation);

							});
							setGraphic(deleteButton);
							setText(null);

						}
					}

				};
				return cell;
			}
		};

		deleteColumn.setCellFactory(deleteCallBack);
	}
}
