package controller;

import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import model.FixedExpenditures;
import model.FluctExpenditures;
import model.FluctExpenditures.Category;
import model.Income;

public class SettingsController extends CommonPropertiesController {

	@FXML
	private Button exitButton;

	@FXML
	private Button clearButton;

	@FXML
	private ComboBox<Month> monthFromComboBox;

	@FXML
	private ComboBox<Integer> yearFromComboBox;

	@FXML
	private ComboBox<Month> monthToComboBox;

	@FXML
	private ComboBox<Integer> yearToComboBox;

	@FXML
	private LineChart<String, Double> lineChart;

	@FXML
	private CategoryAxis xAxis;

	@FXML
	private NumberAxis yAxis;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private CheckBox dailyNecessitiesCheckBox;

	@FXML
	private CheckBox alcoholTobaccoCheckBox;

	@FXML
	private CheckBox workEducationCheckBox;

	@FXML
	private CheckBox otherCheckBox;

	@FXML
	private CheckBox trafficCarCheckBox;

	@FXML
	private CheckBox restaurantHotelsCheckBox;

	@FXML
	private CheckBox clothesShoesCheckBox;

	@FXML
	private CheckBox leasureSportCultureCheckBox;

	@FXML
	private CheckBox incomeCheckBox;

	@FXML
	private CheckBox fixedExpenditureCheckBox;

	@FXML
	private CheckBox fluctExpendituresCheckBox;

	@FXML
	private CheckBox totalExpendituresCheckBox;

	@FXML
	private CheckBox absoluteCheckBox;

	@FXML
	private CheckBox relativeCheckBox;

	@FXML
	private CheckBox monthCheckBox;

	@FXML
	private CheckBox yearCheckBox;

	@FXML
	private CheckBox fiveYearsCheckBox;

	@FXML
	private BarChart<String, Double> barChart;

	@FXML
	private CheckBox dailyNecessities2CheckBox;

	@FXML
	private CheckBox alcoholTobacco2CheckBox;

	@FXML
	private CheckBox workEducation2ChekBox;

	@FXML
	private CheckBox other2CheckBox;

	@FXML
	private CheckBox trafficCar2CheckBox;

	@FXML
	private CheckBox restaurantHotels2CheckBox;

	@FXML
	private CheckBox clothesShoes2CheckBox;

	@FXML
	private CheckBox leasureSportCulture2CheckBox;

	@FXML
	private PieChart pieChart;

	@FXML
	private ComboBox<Month> month3ComboBox;

	@FXML
	private ComboBox<Integer> year3ComboBox;

	@FXML
	private ComboBox<Category> showComboBox;

	@FXML
	private ComboBox<String> inComboBox;

	@FXML
	void onAbsoluteCheckBoxPressed(ActionEvent event) {

		absoluteCheckBox.setSelected(true);
		relativeCheckBox.setSelected(false);

	}

	@FXML
	void onRelativeCheckBoxPressed(ActionEvent event) {

		relativeCheckBox.setSelected(true);
		absoluteCheckBox.setSelected(false);

	}

	@FXML
	void onMonthCheckBoxPressed(ActionEvent event) {

		// monthCheckBox.setSelected(true);
		yearCheckBox.setSelected(false);
		fiveYearsCheckBox.setSelected(false);

		lineChartTimeSelectionChanged();
	}

	@FXML
	void onYearCheckBoxPressed(ActionEvent event) {

		// yearCheckBox.setSelected(true);
		monthCheckBox.setSelected(false);
		fiveYearsCheckBox.setSelected(false);

		lineChartTimeSelectionChanged();
	}

	@FXML
	void onFiveYearsCheckBoxPressed(ActionEvent event) {

		// fiveYearsCheckBox.setSelected(true);
		yearCheckBox.setSelected(false);
		monthCheckBox.setSelected(false);

		lineChartTimeSelectionChanged();
	}

	@FXML
	void onMonthFromComboBox(ActionEvent event) {

		barChartComboBoxesPressed();

	}

	@FXML
	void onMonthToComboBox(ActionEvent event) {

		barChartComboBoxesPressed();
	}

	@FXML
	void onYearFromComboBox(ActionEvent event) {

		barChartComboBoxesPressed();
	}

	@FXML
	void onYearToComboBox(ActionEvent event) {

		barChartComboBoxesPressed();
	}

	@FXML
	void onDailyNecessitiesCheckBoxPressed(ActionEvent event) {
		DN = !DN;

		createLineChart("DAILY_NECESSITIES", DN, LcSeries1);

	}

	@FXML
	void onDailyNecessities2CheckBoxPressed(ActionEvent event) {

		DN2 = !DN2;
		createBarChart("DAILY_NECESSITIES", DN2, BcSet, BcSet2);

	}

	@FXML
	void onAlcoholTobaccoCheckBoxPressed(ActionEvent event) {

		AT = !AT;

		createLineChart("ALCOHOL_TOBACCO", AT, LcSeries2);
	}

	@FXML
	void onAlcoholTobacco2CheckBoxPressed(ActionEvent event) {

		AT2 = !AT2;

		createBarChart("ALCOHOL_TOBACCO", AT2, BcSet, BcSet2);

	}

	@FXML
	void onWorkEducationCheckBoxPressed(ActionEvent event) {

		WE = !WE;
		createLineChart("WORK_EDUCATION", WE, LcSeries3);
	}

	@FXML
	void onWorkEducation2ChekBoxPressed(ActionEvent event) {

		WE2 = !WE2;

		createBarChart("WORK_EDUCATION", WE2, BcSet, BcSet2);

	}

	@FXML
	void onTrafficCarCheckBoxPressed(ActionEvent event) {

		TC = !TC;

		createLineChart("TRAFFIC_CAR", TC, LcSeries4);

	}

	@FXML
	void onTrafficCar2CheckBoxPressed(ActionEvent event) {
		TC2 = !TC2;

		createBarChart("TRAFFIC_CAR", TC2, BcSet, BcSet2);

	}

	@FXML
	void onRestaurantHotelsCheckBoxPressed(ActionEvent event) {

		RH = !RH;

		createLineChart("RESTAURANT_HOTELS", RH, LcSeries5);

	}

	@FXML
	void onRestaurantHotels2CheckBoxPressed(ActionEvent event) {

		RH2 = !RH2;

		createBarChart("RESTAURANT_HOTELS", RH2, BcSet, BcSet2);

	}

	@FXML
	void onClothesShoesCheckBoxPressed(ActionEvent event) {

		CS = !CS;

		createLineChart("CLOTHES_SHOES", CS, LcSeries6);
	}

	@FXML
	void onClothesShoes2CheckBoxPressed(ActionEvent event) {

		CS2 = !CS2;

		createBarChart("CLOTHES_SHOES", CS2, BcSet, BcSet2);

	}

	@FXML
	void onLeasureSportCultureCheckBoxPressed(ActionEvent event) {

		LSC = !LSC;

		createLineChart("LEASURE_SPORT_CULTURE", LSC, LcSeries7);
	}

	@FXML
	void onLeasureSportCultureCheckBox2Pressed(ActionEvent event) {

		LSC2 = !LSC2;

		createBarChart("LEASURE_SPORT_CULTURE", LSC2, BcSet, BcSet2);

	}

	@FXML
	void onOtherCheckBoxPressed(ActionEvent event) {

		O = !O;

		createLineChart("OTHER", O, LcSeries8);

	}

	@FXML
	void onOther2CheckBoxPressed(ActionEvent event) {

		O2 = !O2;

		createBarChart("OTHER", O2, BcSet, BcSet2);

	}

	@FXML
	void onExitButtonPressed(ActionEvent event) {

		exitButton.getScene().getWindow().hide();

	}

	@FXML
	void onFixedExpendituresCheckBoxPressed(ActionEvent event) {
		FE = !FE;
		createLineChartAllFixed(FE, LcSeries10);
	}

	@FXML
	void onFixedExpenditures2CheckBoxPressed(ActionEvent event) {
		FE2 = !FE2;

		createBarChartAllFixed(FE2, BcSet);

	}

	@FXML
	void onFluctExpendituresCheckBoxPressed(ActionEvent event) {
		FlE = !FlE;
		createLineChartAllFluct(FlE, LcSeries9);
	}

	@FXML
	void onFluctExpenditures2CheckBoxPressed(ActionEvent event) {
		FlE2 = !FlE2;

		createBarChartAllFluct(FlE2, BcSet, BcSet2);

	}

	@FXML
	void onIncomeCheckBoxPressed(ActionEvent event) {
		Inc = !Inc;
		createLineChartAllInc(Inc, LcSeries11);
	}

	@FXML
	void onIncome2CheckBoxPressed(ActionEvent event) {

		Inc2 = !Inc2;

		createBarChartAllInc(Inc2, BcSet);

	}

	@FXML
	void onTotalExpendituresCheckBoxPressed(ActionEvent event) {

	}

	@FXML
	void onTotalExpenditures2CheckBoxPressed(ActionEvent event) {

		TE2 = !TE2;

		createBarChartTotalExp(TE2, BcSet, BcSet2);

	}

	@FXML
	void onClearButtonPressed(ActionEvent event) {

		monthFromComboBox.getSelectionModel().clearSelection();
		monthToComboBox.getSelectionModel().clearSelection();
		yearFromComboBox.getSelectionModel().clearSelection();
		yearToComboBox.getSelectionModel().clearSelection();

	}

	@FXML
	void onShowComboBoxPressed(MouseEvent event) {
		showComboBox.getSelectionModel().clearSelection();
	}

	@FXML
	void onYear3ComboBoxPressed(MouseEvent event) {
		year3ComboBox.getSelectionModel().clearSelection();
	}

	@FXML
	void onMonth3ComboBoxPressed(MouseEvent event) {
		month3ComboBox.getSelectionModel().clearSelection();
	}

	@FXML
	void onInComboBoxPressed(MouseEvent event) {
		inComboBox.getSelectionModel().clearSelection();
	}

	@FXML
	void onUpdateButtonPressed(ActionEvent event) {

		pieChart.getData().clear();
		System.out.println("Button pressed");

		createPieChartData(showComboBox.getSelectionModel().getSelectedItem().toString(),
				inComboBox.getSelectionModel().getSelectedItem().toString(),
				year3ComboBox.getSelectionModel().getSelectedItem(),
				month3ComboBox.getSelectionModel().getSelectedItem());

	}

	@FXML
	void initialize() {
		assert dailyNecessitiesCheckBox != null
				: "fx:id=\"dailyNecessitiesCheckBox\" was not injected: check your FXML file 'CheckBoxes.fxml'.";
		assert alcoholTobaccoCheckBox != null
				: "fx:id=\"alcoholTobaccoCheckBox\" was not injected: check your FXML file 'CheckBoxes.fxml'.";
		assert workEducationCheckBox != null
				: "fx:id=\"workEducationCheckBox\" was not injected: check your FXML file 'CheckBoxes.fxml'.";
		assert otherCheckBox != null
				: "fx:id=\"otherCheckBox\" was not injected: check your FXML file 'CheckBoxes.fxml'.";
		assert trafficCarCheckBox != null
				: "fx:id=\"trafficCarCheckBox\" was not injected: check your FXML file 'CheckBoxes.fxml'.";
		assert restaurantHotelsCheckBox != null
				: "fx:id=\"restaurantHotelsCheckBox\" was not injected: check your FXML file 'CheckBoxes.fxml'.";
		assert clothesShoesCheckBox != null
				: "fx:id=\"clothesShoesCheckBox\" was not injected: check your FXML file 'CheckBoxes.fxml'.";
		assert leasureSportCultureCheckBox != null
				: "fx:id=\"leasureSportCultureCheckBox\" was not injected: check your FXML file 'CheckBoxes.fxml'.";
		assert incomeCheckBox != null
				: "fx:id=\"incomeCheckBox\" was not injected: check your FXML file 'CheckBoxes.fxml'.";
		assert fixedExpenditureCheckBox != null
				: "fx:id=\"fixedExpenditureCheckBox\" was not injected: check your FXML file 'CheckBoxes.fxml'.";
		assert fluctExpendituresCheckBox != null
				: "fx:id=\"fluctExpendituresCheckBox\" was not injected: check your FXML file 'CheckBoxes.fxml'.";
		assert totalExpendituresCheckBox != null
				: "fx:id=\"totalExpendituresCheckBox\" was not injected: check your FXML file 'CheckBoxes.fxml'.";
		assert absoluteCheckBox != null
				: "fx:id=\"absoluteCheckBox\" was not injected: check your FXML file 'CheckBoxes.fxml'.";
		assert relativeCheckBox != null
				: "fx:id=\"relativeCheckBox\" was not injected: check your FXML file 'CheckBoxes.fxml'.";
		assert monthCheckBox != null
				: "fx:id=\"monthCheckBox\" was not injected: check your FXML file 'CheckBoxes.fxml'.";
		assert yearCheckBox != null
				: "fx:id=\"yearCheckBox\" was not injected: check your FXML file 'CheckBoxes.fxml'.";
		assert fiveYearsCheckBox != null
				: "fx:id=\"fiveYearsCheckBox\" was not injected: check your FXML file 'CheckBoxes.fxml'.";

		/*
		 * lineChart-settings and initializations
		 */
		lineChart.setAnimated(false);
		yearCheckBox.setSelected(true);
		absoluteCheckBox.setSelected(true);

		lineChart.getData().add(LcSeries1);
		lineChart.getData().add(LcSeries2);
		lineChart.getData().add(LcSeries3);
		lineChart.getData().add(LcSeries4);
		lineChart.getData().add(LcSeries5);
		lineChart.getData().add(LcSeries6);
		lineChart.getData().add(LcSeries7);
		lineChart.getData().add(LcSeries8);
		lineChart.getData().add(LcSeries9);
		lineChart.getData().add(LcSeries10);
		lineChart.getData().add(LcSeries11);
		lineChart.getData().add(LcSeries12);

		LcSeries1.setName("DAILY_NECESSITIES");
		LcSeries2.setName("ALCOHOL_TOBACCO");
		LcSeries3.setName("WORK_EDUCATION");
		LcSeries4.setName("TRAFFIC_CAR");
		LcSeries5.setName("RESTAURANT_HOTELS");
		LcSeries6.setName("CLOTHES_SHOES");
		LcSeries7.setName("LEASURE_SPORT_CULTURE");
		LcSeries8.setName("OTHER");
		LcSeries9.setName("ALL FLUCT. EXP.");
		LcSeries10.setName("ALL FIXED EXP.");
		LcSeries11.setName("All INCOME");
		LcSeries12.setName("TOTAL EXP.");

		/*
		 * barChart-settings and intializations
		 */
		barChart.setAnimated(false);
		barChart.setBarGap(10);
		barChart.setCategoryGap(10);

		barChart.getData().add(BcSet);
		barChart.getData().add(BcSet2);

		monthFromComboBox.getItems().setAll(Month.values());
		monthToComboBox.getItems().setAll(Month.values());

		yearFromComboBox.getItems().setAll(dateList);
		yearToComboBox.getItems().setAll(dateList);

		/*
		 * pieChart-settings and intializations
		 */
		month3ComboBox.getItems().setAll(Month.values());
		year3ComboBox.getItems().setAll(dateList);

		showComboBox.getItems().setAll(Category.values());
		inComboBox.getItems().addAll("Fluct. Expenditures", "Fixed Expenditures", "Total Expenditures", "Income");

	}

	// booleans for triggering different checkbox-events

	boolean DN = false;
	boolean AT = false;
	boolean WE = false;
	boolean O = false;
	boolean RH = false;
	boolean TC = false;
	boolean CS = false;
	boolean LSC = false;
	boolean FlE = false;
	boolean FE = false;
	boolean Inc = false;
	boolean TE = false;

	boolean DN2 = false;
	boolean AT2 = false;
	boolean WE2 = false;
	boolean O2 = false;
	boolean RH2 = false;
	boolean TC2 = false;
	boolean CS2 = false;
	boolean LSC2 = false;
	boolean FlE2 = false;
	boolean FE2 = false;
	boolean Inc2 = false;
	boolean TE2 = false;

	// Charts for every Category

	XYChart.Series<String, Double> LcSeries1 = new XYChart.Series<>();
	XYChart.Series<String, Double> LcSeries2 = new XYChart.Series<>();
	XYChart.Series<String, Double> LcSeries3 = new XYChart.Series<>();
	XYChart.Series<String, Double> LcSeries4 = new XYChart.Series<>();
	XYChart.Series<String, Double> LcSeries5 = new XYChart.Series<>();
	XYChart.Series<String, Double> LcSeries6 = new XYChart.Series<>();
	XYChart.Series<String, Double> LcSeries7 = new XYChart.Series<>();
	XYChart.Series<String, Double> LcSeries8 = new XYChart.Series<>();
	XYChart.Series<String, Double> LcSeries9 = new XYChart.Series<>();
	XYChart.Series<String, Double> LcSeries10 = new XYChart.Series<>();
	XYChart.Series<String, Double> LcSeries11 = new XYChart.Series<>();
	XYChart.Series<String, Double> LcSeries12 = new XYChart.Series<>();

	XYChart.Series<String, Double> BcSet = new XYChart.Series<>();
	XYChart.Series<String, Double> BcSet2 = new XYChart.Series<>();

//	List<XYChart.Series> listSeries = new ArrayList<XYChart.Series>(series1);

	/*
	 * LineChart:
	 */

	// create-chart-method essentially

	private void createLineChartSeries(String categories, Series<String, Double> series) {
		series.getData().clear();

		// set time-scale
		int i;
		if (monthCheckBox.isSelected() == true) {
			i = 30;
		} else if (yearCheckBox.isSelected() == true) {
			i = 365;
		} else {
			i = 1825;
		}

		final int tempInt = i;

		// filter for categories and sort by date
		FilteredList<FluctExpenditures> category = new FilteredList<>(fluctExpendituresList);
		Predicate<FluctExpenditures> itemsCategories = it -> it.getCategory().toString() == categories;
		Predicate<FluctExpenditures> itemsTime = it -> it.getDate().isAfter(LocalDate.now().minusDays(tempInt));
		;
		category.setPredicate(itemsCategories.and(itemsTime));
		List<FluctExpenditures> categoryDatePriceSorted = category.stream()
				.sorted(Comparator.comparing(FluctExpenditures::getDate)).collect(Collectors.toList());
		List<Double> categoryPrices = categoryDatePriceSorted.stream().map(f -> f.getPrice())
				.collect(Collectors.toList());

		System.out.println(categoryPrices);
		for (int k = 1; k < categoryPrices.size(); k++) {

			categoryPrices.set(k, (categoryPrices.get(k) + categoryPrices.get(k - 1)));
		}

		// feed data from the filtered and sorted list to series
		if (categoryDatePriceSorted.size() >= 1) {
			for (int l = 0; l < categoryDatePriceSorted.size(); l++) {
				series.getData().add(new XYChart.Data<String, Double>(
						categoryDatePriceSorted.get(l).getDate().toString(), categoryPrices.get(l)));
			}
			lineChart.getData().add(series);
		}

	}

	private void createLineChartSeriesAllFluct(Series<String, Double> series) {
		series.getData().clear();

		// set time-scale
		int i;
		if (monthCheckBox.isSelected()) {
			i = 30;
		} else if (yearCheckBox.isSelected()) {
			i = 365;
		} else {
			i = 1825;
		}

		final int tempInt = i;

		FilteredList<FluctExpenditures> allFluct = new FilteredList<>(fluctExpendituresList);
		Predicate<FluctExpenditures> itemsTime = it -> it.getDate().isAfter(LocalDate.now().minusDays(tempInt));

		allFluct.setPredicate(itemsTime);
		List<FluctExpenditures> allFluctTimeSorted = allFluct.stream()
				.sorted(Comparator.comparing(FluctExpenditures::getDate)).collect(Collectors.toList());
		List<Double> allFluctTimePrices = allFluctTimeSorted.stream().map(f -> f.getPrice())
				.collect(Collectors.toList());

		System.out.println(allFluctTimePrices);
		for (int k = 1; k < allFluctTimePrices.size(); k++) {

			allFluctTimePrices.set(k, (allFluctTimePrices.get(k) + allFluctTimePrices.get(k - 1)));
		}
		System.out.println(allFluctTimePrices);
		// feed data from the filtered and sorted list to series
		if (allFluctTimeSorted.size() >= 1) {
			for (int l = 0; l < allFluctTimeSorted.size(); l++) {
				series.getData().add(new XYChart.Data<String, Double>(allFluctTimeSorted.get(l).getDate().toString(),
						allFluctTimePrices.get(l)));
			}
			lineChart.getData().add(series);
		}

	}

	private void createLineChartSeriesAllFixed(Series<String, Double> series) {

		series.getData().clear();

		// set time-scale
		int i;
		if (monthCheckBox.isSelected()) {
			i = 30;
		} else if (yearCheckBox.isSelected()) {
			i = 365;
		} else {
			i = 1825;
		}

		final int tempInt = i;

		FilteredList<FixedExpenditures> allFixedExp = new FilteredList<FixedExpenditures>(fixedExpendituresList);
		Predicate<FixedExpenditures> itemsTime = it -> it.getDateFixedExpenditures()
				.isAfter(LocalDate.now().minusDays(tempInt));

		allFixedExp.setPredicate(itemsTime);
		List<FixedExpenditures> allIncFixedExpSorted = allFixedExp.stream()
				.sorted(Comparator.comparing(FixedExpenditures::getDateFixedExpenditures)).collect(Collectors.toList());
		List<Double> allFixedExpNumbers = allIncFixedExpSorted.stream().map(f -> f.getAmount())
				.collect(Collectors.toList());

		for (int k = 1; k < allIncFixedExpSorted.size(); k++) {

			allFixedExpNumbers.set(k, (allFixedExpNumbers.get(k) + allFixedExpNumbers.get(k - 1)));
		}
		System.out.println(allFixedExpNumbers);
		// feed data from the filtered and sorted list to series
		if (allIncFixedExpSorted.size() >= 1) {
			for (int l = 0; l < allIncFixedExpSorted.size(); l++) {
				series.getData().add(new XYChart.Data<String, Double>(
						allIncFixedExpSorted.get(l).getDateFixedExpenditures().toString(), allFixedExpNumbers.get(l)));
			}
			lineChart.getData().add(series);

		}

	}

	private void createLineChartSeriesAllInc(Series<String, Double> series) {

		series.getData().clear();

		// set time-scale
		int i;
		if (monthCheckBox.isSelected()) {
			i = 30;
		} else if (yearCheckBox.isSelected()) {
			i = 365;
		} else {
			i = 1825;
		}

		final int tempInt = i;

		FilteredList<Income> allInc = new FilteredList<Income>(incomeList);
		Predicate<Income> itemsTime = it -> it.getDateInc().isAfter(LocalDate.now().minusDays(tempInt));

		allInc.setPredicate(itemsTime);
		List<Income> allIncTimeSorted = allInc.stream().sorted(Comparator.comparing(Income::getDateInc))
				.collect(Collectors.toList());
		List<Double> allIncNumbers = allIncTimeSorted.stream().map(f -> f.getAmountInc()).collect(Collectors.toList());

		for (int k = 1; k < allIncNumbers.size(); k++) {

			allIncNumbers.set(k, (allIncNumbers.get(k) + allIncNumbers.get(k - 1)));
		}
		System.out.println(allIncNumbers);
		// feed data from the filtered and sorted list to series
		if (allIncTimeSorted.size() >= 1) {
			for (int l = 0; l < allIncTimeSorted.size(); l++) {
				series.getData().add(new XYChart.Data<String, Double>(allIncTimeSorted.get(l).getDateInc().toString(),
						allIncNumbers.get(l)));
			}
			lineChart.getData().add(series);

		}

	}

	private void createLineChartSeriesTotal(Series<String, Double> series) {
		series.getData().clear();

		// set time-scale
		int i;
		if (monthCheckBox.isSelected()) {
			i = 30;
		} else if (yearCheckBox.isSelected()) {
			i = 365;
		} else {
			i = 1825;
		}

		final int tempInt = i;

		FilteredList<FluctExpenditures> allFluct = new FilteredList<>(fluctExpendituresList);
		Predicate<FluctExpenditures> itemsTime = it -> it.getDate().isAfter(LocalDate.now().minusDays(tempInt));

		allFluct.setPredicate(itemsTime);
		List<FluctExpenditures> allFluctTimeSorted = allFluct.stream()
				.sorted(Comparator.comparing(FluctExpenditures::getDate)).collect(Collectors.toList());
		List<Double> allFluctTimePrices = allFluctTimeSorted.stream().map(f -> f.getPrice())
				.collect(Collectors.toList());

		System.out.println(allFluctTimePrices);
		for (int k = 1; k < allFluctTimePrices.size(); k++) {

			allFluctTimePrices.set(k, (allFluctTimePrices.get(k) + allFluctTimePrices.get(k - 1)));
		}
		System.out.println(allFluctTimePrices);
		// feed data from the filtered and sorted list to series
		if (allFluctTimeSorted.size() >= 1) {
			for (int l = 0; l < allFluctTimeSorted.size(); l++) {
				series.getData().add(new XYChart.Data<String, Double>(allFluctTimeSorted.get(l).getDate().toString(),
						allFluctTimePrices.get(l)));
			}
			lineChart.getData().add(series);
		}

	}

	private void createLineChart(String category, Boolean bool, XYChart.Series<String, Double> series) {

		lineChart.getData().remove(series);

		if (bool == true) {

			createLineChartSeries(category, series);

		}
	}

	private void createLineChartAllInc(Boolean bool, XYChart.Series<String, Double> series) {

		lineChart.getData().remove(series);

		if (bool == true) {

			createLineChartSeriesAllInc(series);

		}
	}

	private void createLineChartAllFluct(Boolean bool, XYChart.Series<String, Double> series) {

		lineChart.getData().remove(series);

		if (bool == true) {

			createLineChartSeriesAllFluct(series);

		}
	}

	private void createLineChartAllFixed(Boolean bool, XYChart.Series<String, Double> series) {

		lineChart.getData().remove(series);

		if (bool == true) {

			createLineChartSeriesAllFixed(series);

		}
	}

	private void lineChartTimeSelectionChanged() {

		createLineChart("DAILY_NECESSITIES", DN, LcSeries1);
		createLineChart("ALCOHOL_TOBACCO", AT, LcSeries2);
		createLineChart("WORK_EDUCATION", WE, LcSeries3);
		createLineChart("TRAFFIC_CAR", TC, LcSeries4);
		createLineChart("RESTAURANT_HOTELS", RH, LcSeries5);
		createLineChart("CLOTHES_SHOES", CS, LcSeries6);
		createLineChart("LEASURE_SPORT_CULTURE", LSC, LcSeries7);
		createLineChart("OTHER", O, LcSeries8);
		createLineChartAllFluct(FlE, LcSeries9);
		createLineChartAllFixed(FE, LcSeries10);
		createLineChartAllInc(Inc, LcSeries11);
	}

	/*
	 * Create-series - methods
	 */

	private void createBarChartSeriesSingleFluct(String categories, Month month, int year,
			XYChart.Series<String, Double> series) {
		System.out.println("Create Bc");

		FilteredList<FluctExpenditures> categoryYearMonthList = new FilteredList<>(fluctExpendituresList);
		Predicate<FluctExpenditures> itemsCategories = ic -> ic.getCategory().toString() == categories;
		Predicate<FluctExpenditures> itemsCategoriesYears = iy -> iy.getDate().getYear() == year;
		Predicate<FluctExpenditures> itemsCategoriesMonth = im -> im.getDate().getMonth() == month;
		categoryYearMonthList.setPredicate(itemsCategories.and(itemsCategoriesYears.and(itemsCategoriesMonth)));
		categoryYearMonthList.stream().sorted(Comparator.comparing(FluctExpenditures::getDate))
				.collect(Collectors.toList());

		if (!categoryYearMonthList.isEmpty()) {

			List<Double> filteredPrices = categoryYearMonthList.stream().map(f -> f.getPrice())
					.collect(Collectors.toList());
			Double sum = filteredPrices.stream().mapToDouble(f -> f).sum();

			series.getData().add(new XYChart.Data<String, Double>(categories, sum));

		}
	}

	private void createBarChartSeriesSingleFluctYear(String categories, int year,
			XYChart.Series<String, Double> series) {
		System.out.println("Create Bc");

		FilteredList<FluctExpenditures> categoryYearList = new FilteredList<>(fluctExpendituresList);
		Predicate<FluctExpenditures> itemsCategories = ic -> ic.getCategory().toString() == categories;
		Predicate<FluctExpenditures> itemsCategoriesYears = iy -> iy.getDate().getYear() == year;
		categoryYearList.setPredicate(itemsCategories.and(itemsCategoriesYears));
		categoryYearList.stream().sorted(Comparator.comparing(FluctExpenditures::getDate)).collect(Collectors.toList());

		if (!categoryYearList.isEmpty()) {

			List<Double> filteredPrices = categoryYearList.stream().map(f -> f.getPrice()).collect(Collectors.toList());
			Double sum = filteredPrices.stream().mapToDouble(f -> f).sum();

			series.getData().add(new XYChart.Data<String, Double>(categories, sum));

		}
	}

	private void createBarChartSeriesAllFluct(Month month, int year, XYChart.Series<String, Double> series) {

		FilteredList<FluctExpenditures> allFluctYearMonthList = new FilteredList<>(fluctExpendituresList);
		Predicate<FluctExpenditures> itemsCategoriesYears = iy -> iy.getDate().getYear() == year;
		Predicate<FluctExpenditures> itemsCategoriesMonth = im -> im.getDate().getMonth() == month;
		allFluctYearMonthList.setPredicate(itemsCategoriesYears.and(itemsCategoriesMonth));
		allFluctYearMonthList.stream().sorted(Comparator.comparing(FluctExpenditures::getDate))
				.collect(Collectors.toList());

		if (!allFluctYearMonthList.isEmpty()) {

			List<Double> filteredPrices = allFluctYearMonthList.stream().map(f -> f.getPrice())
					.collect(Collectors.toList());
			Double sum = filteredPrices.stream().mapToDouble(f -> f).sum();

			series.getData().add(new XYChart.Data<String, Double>("All Fluct. Expenditures", sum));

		}
	}

	private void createBarChartSeriesAllFluctYear(int year, XYChart.Series<String, Double> series) {

		FilteredList<FluctExpenditures> allFluctYearList = new FilteredList<>(fluctExpendituresList);
		Predicate<FluctExpenditures> itemsCategoriesYears = iy -> iy.getDate().getYear() == year;
		allFluctYearList.setPredicate(itemsCategoriesYears);
		allFluctYearList.stream().sorted(Comparator.comparing(FluctExpenditures::getDate)).collect(Collectors.toList());

		if (!allFluctYearList.isEmpty()) {

			List<Double> filteredPrices = allFluctYearList.stream().map(f -> f.getPrice()).collect(Collectors.toList());
			Double sum = filteredPrices.stream().mapToDouble(f -> f).sum();

			series.getData().add(new XYChart.Data<String, Double>("All Fluct. Expenditures", sum));

		}
	}

	private void createBarChartSeriesAllFluctMonth(Month month, XYChart.Series<String, Double> series) {

		FilteredList<FluctExpenditures> allFluctMonthList = new FilteredList<>(fluctExpendituresList);

		Predicate<FluctExpenditures> itemsCategoriesMonth = (im -> im.getDate().getMonth() == month);
		allFluctMonthList.setPredicate(itemsCategoriesMonth);
		allFluctMonthList.stream().sorted(Comparator.comparing(FluctExpenditures::getDate))
				.collect(Collectors.toList());

		if (!allFluctMonthList.isEmpty()) {

			List<Double> filteredPrices = allFluctMonthList.stream().map(f -> f.getPrice())
					.collect(Collectors.toList());
			Double sum = filteredPrices.stream().mapToDouble(f -> f).sum();

			series.getData().add(new XYChart.Data<String, Double>("All Fluct. Expenditures", sum));

		}
	}

	private void createBarChartSeriesAllFixed(XYChart.Series<String, Double> series) {

		List<FixedExpenditures> allFixedList = new ArrayList<>(fixedExpendituresList);

		if (!allFixedList.isEmpty()) {

			List<Double> allFixedExp = allFixedList.stream().map(f -> f.getAmount()).collect(Collectors.toList());
			Double sum = allFixedExp.stream().mapToDouble(f -> f).sum();

			series.getData().add(new XYChart.Data<String, Double>("All Fixed Expenditures", sum));

		}

	}

	private void createBarChartSeriesAllInc(XYChart.Series<String, Double> series) {

		List<Income> allIncomeList = new ArrayList<>(incomeList);

		if (!allIncomeList.isEmpty()) {

			List<Double> allInc = allIncomeList.stream().map(f -> f.getAmountInc()).collect(Collectors.toList());
			Double sum = allInc.stream().mapToDouble(f -> f).sum();

			series.getData().add(new XYChart.Data<String, Double>("All Income", sum));

		}
	}

	private void createBarChartSeriesTotalExp(Month month, int year, XYChart.Series<String, Double> series) {

		Double sum1 = 0D;
		Double sum2 = 0D;
		List<FixedExpenditures> allFixedList = new ArrayList<>(fixedExpendituresList);

		if (!allFixedList.isEmpty()) {

			List<Double> allFixedExp = allFixedList.stream().map(f -> f.getAmount()).collect(Collectors.toList());
			sum1 = allFixedExp.stream().mapToDouble(f -> f).sum();
		}
		FilteredList<FluctExpenditures> allFluctYearMonthList = new FilteredList<>(fluctExpendituresList);
		Predicate<FluctExpenditures> itemsCategoriesYears = iy -> iy.getDate().getYear() == year;
		Predicate<FluctExpenditures> itemsCategoriesMonth = im -> im.getDate().getMonth() == month;
		allFluctYearMonthList.setPredicate(itemsCategoriesYears.and(itemsCategoriesMonth));
		allFluctYearMonthList.stream().sorted(Comparator.comparing(FluctExpenditures::getDate))
				.collect(Collectors.toList());

		if (!allFluctYearMonthList.isEmpty()) {

			List<Double> filteredPrices = allFluctYearMonthList.stream().map(f -> f.getPrice())
					.collect(Collectors.toList());
			sum2 = filteredPrices.stream().mapToDouble(f -> f).sum();
		}
		Double sumTotal = sum1 + sum2;
		if (sumTotal > 0)
			series.getData().add(new XYChart.Data<String, Double>("Total Expenditures", sumTotal));
	}
	/*
	 * clear - methods
	 */

	private void clearBcSeriesSingleFluct(String categories, XYChart.Series<String, Double> series) {
		series.getData().removeIf(f -> f.getXValue().contains(categories));
		System.out.println("data cleared");

	}

	private void clearBcSeriesAllFluct(XYChart.Series<String, Double> series) {
		series.getData().removeIf(f -> f.getXValue().contains("All Fluct. Expenditures"));
	}

	private void clearBcSeriesAllFixed(XYChart.Series<String, Double> series) {
		series.getData().removeIf(f -> f.getXValue().contains("All Fixed Expenditures"));
	}

	private void clearBcSeriesAllInc(XYChart.Series<String, Double> series) {
		series.getData().removeIf(f -> f.getXValue().contains("All Income"));
	}

	private void clearBcSeriesTotalExp(XYChart.Series<String, Double> series) {
		series.getData().removeIf(f -> f.getXValue().contains("Total Expenditures"));
	}

	/*
	 * Create actual Barchart from data - methods
	 */
	private void createBarChart(String category, Boolean bool, XYChart.Series<String, Double> series,
			XYChart.Series<String, Double> series2) {

		clearBcSeriesSingleFluct(category, series);
		clearBcSeriesSingleFluct(category, series2);

		if (bool == true && !monthFromComboBox.getSelectionModel().isEmpty()
				&& !yearFromComboBox.getSelectionModel().isEmpty()) {
			createBarChartSeriesSingleFluct(category, monthFromComboBox.getValue(), yearFromComboBox.getValue(),
					series);
		}

		if (bool == true && !monthToComboBox.getSelectionModel().isEmpty()
				&& !yearToComboBox.getSelectionModel().isEmpty()) {
			createBarChartSeriesSingleFluct(category, monthToComboBox.getValue(), yearToComboBox.getValue(), series2);

		}
		if (bool == true && monthFromComboBox.getSelectionModel().isEmpty()
				&& !yearFromComboBox.getSelectionModel().isEmpty()) {
			createBarChartSeriesSingleFluctYear(category, yearFromComboBox.getValue(), series);

		}
		if (bool == true && monthToComboBox.getSelectionModel().isEmpty()
				&& !yearToComboBox.getSelectionModel().isEmpty()) {
			createBarChartSeriesSingleFluctYear(category, yearToComboBox.getValue(), series2);

		}
	}

	private void createBarChartAllFluct(Boolean bool, XYChart.Series<String, Double> series,
			XYChart.Series<String, Double> series2) {

		clearBcSeriesAllFluct(series);
		clearBcSeriesAllFluct(series2);

		if (bool == true && !monthFromComboBox.getSelectionModel().isEmpty()
				&& !yearFromComboBox.getSelectionModel().isEmpty()) {
			createBarChartSeriesAllFluct(monthFromComboBox.getValue(), yearFromComboBox.getValue(), series);
		}

		if (bool == true && !monthToComboBox.getSelectionModel().isEmpty()
				&& !yearToComboBox.getSelectionModel().isEmpty()) {
			createBarChartSeriesAllFluct(monthToComboBox.getValue(), yearToComboBox.getValue(), series2);
		}

		if (bool == true && monthFromComboBox.getSelectionModel().isEmpty()
				&& !yearFromComboBox.getSelectionModel().isEmpty()) {
			createBarChartSeriesAllFluctYear(yearFromComboBox.getValue(), series);
		}

		if (bool == true && monthToComboBox.getSelectionModel().isEmpty()
				&& !yearToComboBox.getSelectionModel().isEmpty()) {
			createBarChartSeriesAllFluctYear(yearToComboBox.getValue(), series2);
		}

		if (bool == true && !monthFromComboBox.getSelectionModel().isEmpty()
				&& yearFromComboBox.getSelectionModel().isEmpty()) {
			createBarChartSeriesAllFluctMonth(monthFromComboBox.getValue(), series);
		}

		if (bool == true && !monthToComboBox.getSelectionModel().isEmpty()
				&& yearToComboBox.getSelectionModel().isEmpty()) {
			createBarChartSeriesAllFluctMonth(monthToComboBox.getValue(), series2);
		}

	}

	private void createBarChartAllFixed(Boolean bool, XYChart.Series<String, Double> series) {

		clearBcSeriesAllFixed(series);

		if (bool == true) {
			createBarChartSeriesAllFixed(series);
		}

	}

	private void createBarChartAllInc(Boolean bool, XYChart.Series<String, Double> series) {

		clearBcSeriesAllInc(series);

		if (bool == true) {
			createBarChartSeriesAllInc(series);
		}

	}

	private void createBarChartTotalExp(Boolean bool, XYChart.Series<String, Double> series,
			XYChart.Series<String, Double> series2) {

		clearBcSeriesTotalExp(series);
		clearBcSeriesTotalExp(series2);

		if (bool == true && !monthFromComboBox.getSelectionModel().isEmpty()
				&& !yearFromComboBox.getSelectionModel().isEmpty()) {
			createBarChartSeriesTotalExp(monthFromComboBox.getValue(), yearFromComboBox.getValue(), series);
		}

		if (bool == true && !monthToComboBox.getSelectionModel().isEmpty()
				&& !yearToComboBox.getSelectionModel().isEmpty()) {
			createBarChartSeriesTotalExp(monthToComboBox.getValue(), yearToComboBox.getValue(), series2);
		}
	}

	private void barChartComboBoxesPressed() {

		createBarChart("DAILY_NECESSITIES", DN2, BcSet, BcSet2);
		createBarChart("ALCOHOL_TOBACCO", AT2, BcSet, BcSet2);
		createBarChart("WORK_EDUCATION", WE2, BcSet, BcSet2);
		createBarChart("TRAFFIC_CAR", TC2, BcSet, BcSet2);
		createBarChart("RESTAURANT_HOTELS", RH2, BcSet, BcSet2);
		createBarChart("CLOTHES_SHOES", CS2, BcSet, BcSet2);
		createBarChart("LEASURE_SPORT_CULTURE", LSC2, BcSet, BcSet2);
		createBarChart("OTHER", O2, BcSet, BcSet2);
		createBarChartAllFluct(FlE2, BcSet, BcSet2);
		createBarChartAllFixed(FE2, BcSet);
		createBarChartAllInc(Inc2, BcSet);
		createBarChartTotalExp(TE2, BcSet, BcSet2);
	}

	/*
	 * Pie-Chart
	 */

	private void createPieChartData(String categoryFrom, String categoryTo, int year, Month month) {
		double sum1 = 0;
		double sum2 = 0;
		double sumTemp1 = 0;
		double sumTemp2 = 0;

		FilteredList<FluctExpenditures> categorySingleYearMonthList = new FilteredList<>(fluctExpendituresList);
		FilteredList<FluctExpenditures> categorySingleYearList = new FilteredList<>(fluctExpendituresList);
		FilteredList<FluctExpenditures> categorySingleList = new FilteredList<>(fluctExpendituresList);
		FilteredList<FluctExpenditures> categoryAllYearMonthList = new FilteredList<>(fluctExpendituresList);
		FilteredList<FluctExpenditures> categoryAllYearList = new FilteredList<>(fluctExpendituresList);
		FilteredList<FluctExpenditures> categoryAllList = new FilteredList<>(fluctExpendituresList);

		Predicate<FluctExpenditures> itemsCategories = it -> it.getCategory().toString() == categoryFrom;
		Predicate<FluctExpenditures> itemsCategoriesYears = iy -> iy.getDate().getYear() == year;
		Predicate<FluctExpenditures> itemsCategoriesMonth = im -> im.getDate().getMonth() == month;

		categorySingleYearMonthList.setPredicate(itemsCategories.and(itemsCategoriesYears.and(itemsCategoriesMonth)));
		categorySingleYearList.setPredicate(itemsCategories.and(itemsCategoriesYears));
		categorySingleList.setPredicate(itemsCategories);

		categoryAllYearMonthList.setPredicate(itemsCategoriesYears.and(itemsCategoriesMonth));
		categoryAllYearList.setPredicate(itemsCategoriesYears);

		if (!categorySingleYearMonthList.isEmpty() && !showComboBox.getSelectionModel().isEmpty()
				&& !month3ComboBox.getSelectionModel().isEmpty() && !year3ComboBox.getSelectionModel().isEmpty()) {

			List<Double> filteredSingleYearMonthSum = categorySingleYearMonthList.stream().map(f -> f.getPrice())
					.collect(Collectors.toList());
			sum1 = filteredSingleYearMonthSum.stream().mapToDouble(f -> f).sum();

		} else if (!categorySingleYearList.isEmpty() && !showComboBox.getSelectionModel().isEmpty()
				&& month3ComboBox.getSelectionModel().isEmpty() && !year3ComboBox.getSelectionModel().isEmpty()) {
			List<Double> filteredSingleYearSum = categorySingleYearList.stream().map(f -> f.getPrice())
					.collect(Collectors.toList());
			sum1 = filteredSingleYearSum.stream().mapToDouble(f -> f).sum();

		} else if (!categorySingleList.isEmpty() && !showComboBox.getSelectionModel().isEmpty()
				&& month3ComboBox.getSelectionModel().isEmpty() && year3ComboBox.getSelectionModel().isEmpty()) {
			List<Double> filteredSingleSum = categorySingleList.stream().map(f -> f.getPrice())
					.collect(Collectors.toList());
			sum1 = filteredSingleSum.stream().mapToDouble(f -> f).sum();
		}

//		else if (!categoryAllYearMonthList.isEmpty() && !showComboBox.getSelectionModel().isEmpty()
//				&& !month3ComboBox.getSelectionModel().isEmpty() && !year3ComboBox.getSelectionModel().isEmpty()) {
//
//			List<Double> filteredAllYearMonthSum = categoryAllYearMonthList.stream().map(f -> f.getPrice())
//					.collect(Collectors.toList());
//			sum1 = filteredAllYearMonthSum.stream().mapToDouble(f -> f).sum();
//	}
		else if (!categoryAllYearList.isEmpty() && !showComboBox.getSelectionModel().isEmpty()
				&& month3ComboBox.getSelectionModel().isEmpty() && !year3ComboBox.getSelectionModel().isEmpty()) {
			List<Double> filteredAllYearsSum = categoryAllYearList.stream().map(f -> f.getPrice())
					.collect(Collectors.toList());
			sum1 = filteredAllYearsSum.stream().mapToDouble(f -> f).sum();

		}

		FilteredList<FixedExpenditures> allFixedExpenditures = new FilteredList<>(fixedExpendituresList);
		FilteredList<Income> allIncome = new FilteredList<>(incomeList);

		if (categoryTo == "Fixed Expenditures" && !allFixedExpenditures.isEmpty()) {
			List<Double> fixedExpSum = allFixedExpenditures.stream().map(f -> f.getAmount())
					.collect(Collectors.toList());
			sum2 = fixedExpSum.stream().mapToDouble(f -> f).sum();
		}
		if (categoryTo == "Income" && !allIncome.isEmpty()) {
			List<Double> incSum = allIncome.stream().map(f -> f.getAmountInc()).collect(Collectors.toList());
			sum2 = incSum.stream().mapToDouble(f -> f).sum();
		}
		if (categoryTo == "Fluct. Expenditures" && !categoryAllYearList.isEmpty()
				&& !year3ComboBox.getSelectionModel().isEmpty()) {
			List<Double> fluctExpSum = categoryAllYearList.stream().map(f -> f.getPrice()).collect(Collectors.toList());
			sum2 = fluctExpSum.stream().mapToDouble(f -> f).sum();
		}
		if (categoryTo == "Total Expenditures" && !categoryAllList.isEmpty()
				|| !allFixedExpenditures.isEmpty() && !year3ComboBox.getSelectionModel().isEmpty()) {
			List<Double> fluctExpAllYearSum = categoryAllYearList.stream().map(f -> f.getPrice())
					.collect(Collectors.toList());
			sumTemp1 = fluctExpAllYearSum.stream().mapToDouble(f -> f).sum();

			List<Double> fixedExpSum = allFixedExpenditures.stream().map(f -> f.getAmount())
					.collect(Collectors.toList());
			sumTemp2 = fixedExpSum.stream().mapToDouble(f -> f).sum();
			sum2 = sumTemp1 + sumTemp2;
		}

		if (categoryTo == "Total Expenditures" && !categoryAllList.isEmpty()
				|| !allFixedExpenditures.isEmpty() && year3ComboBox.getSelectionModel().isEmpty()) {
			List<Double> fluctExpAllSum = categoryAllList.stream().map(f -> f.getPrice()).collect(Collectors.toList());
			sumTemp1 = fluctExpAllSum.stream().mapToDouble(f -> f).sum();

			List<Double> fixedExpSum = allFixedExpenditures.stream().map(f -> f.getAmount())
					.collect(Collectors.toList());
			sumTemp2 = fixedExpSum.stream().mapToDouble(f -> f).sum();
			sum2 = sumTemp1 + sumTemp2;
		}

		System.out.println(sum1);
		System.out.println(sum2);
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(

				new PieChart.Data(categoryFrom, ((sum1) / (sum1 + sum2))),
				new PieChart.Data(categoryTo, ((sum2) / (sum1 + sum2))));
		System.out.println(pieChartData);

		pieChart.getData().addAll(pieChartData);

	}

}
