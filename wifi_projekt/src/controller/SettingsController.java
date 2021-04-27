package controller;

import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.Period;
import java.time.Year;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.Axis;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import model.FluctExpenditures;

public class SettingsController extends CommonPropertiesController {
    MonthDay day;
    double price;
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
    void onAbsoluteCheckBoxPressed(ActionEvent event) {
    	
    	relativeCheckBox.setSelected(false);

    }
    
    @FXML
    void onRelativeCheckBoxPressed(ActionEvent event) {
    	absoluteCheckBox.setSelected(false);

    }

    @FXML
    void onMonthCheckboxPressed(ActionEvent event) {
    	
    	yearCheckBox.setSelected(false);
    	fiveYearsCheckBox.setSelected(false);

    }
    
    @FXML
    void onYearCheckboxPressed(ActionEvent event) {
    	
    	monthCheckBox.setSelected(false);
    	fiveYearsCheckBox.setSelected(false);

    }
    
    @FXML
    void onFiveYearsCheckBoxPressed(ActionEvent event) {
    	
    	yearCheckBox.setSelected(false);
    	monthCheckBox.setSelected(false);

    }
    @FXML
    void onAlcoholTobaccoCheckBoxPressed(ActionEvent event) {

    }

    @FXML
    void onClothesShoesCheckBoxPressed(ActionEvent event) {

    }

    @FXML
    void onDailyNecessitiesCheckBoxPressed(ActionEvent event) {

    }

    @FXML
    void onExitButtonPressed(ActionEvent event) {

    }

   

    @FXML
    void onFixedExpendituresCheckBoxPressed(ActionEvent event) {

    }

    @FXML
    void onFluctExpendituresCheckBoxPressed(ActionEvent event) {

    }

    @FXML
    void onIncomeCheckBoxPressed(ActionEvent event) {

    }

    @FXML
    void onLeasureSportCultureCheckBoxPressed(ActionEvent event) {

    }

    @FXML
    void onOtherCheckBoxPressed(ActionEvent event) {

    }

    @FXML
    void onRestaurantHotelsCheckBoxPressed(ActionEvent event) {

    }

    @FXML
    void onTotalExpendituresCheckBoxPressed(ActionEvent event) {

    }

    @FXML
    void onTrafficCarCheckBoxPressed(ActionEvent event) {

    }

    @FXML
    void onUpdateButtonPressed(ActionEvent event) {

    }

    @FXML
    void onWorkEducationCheckBoxPressed(ActionEvent event) {

    }
 
    @FXML
    private ComboBox<Month> monthComboBox;

    @FXML
    private ComboBox<Year> yearComboBox;

    @FXML
    private ComboBox<?> showComboBox;

    @FXML
    private ComboBox<?> inComboBox;

    @FXML
    void onInComboBoxPressed(ActionEvent event) {

    }

    @FXML
    void onMonthComboBoxPressed(ActionEvent event) {

    }

    @FXML
    void onShowComboBoxPressed(ActionEvent event) {

    }

    @FXML
    void onYearComboBoxPressed(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert dailyNecessitiesCheckBox != null : "fx:id=\"dailyNecessitiesCheckBox\" was not injected: check your FXML file 'CheckBoxes.fxml'.";
        assert alcoholTobaccoCheckBox != null : "fx:id=\"alcoholTobaccoCheckBox\" was not injected: check your FXML file 'CheckBoxes.fxml'.";
        assert workEducationCheckBox != null : "fx:id=\"workEducationCheckBox\" was not injected: check your FXML file 'CheckBoxes.fxml'.";
        assert otherCheckBox != null : "fx:id=\"otherCheckBox\" was not injected: check your FXML file 'CheckBoxes.fxml'.";
        assert trafficCarCheckBox != null : "fx:id=\"trafficCarCheckBox\" was not injected: check your FXML file 'CheckBoxes.fxml'.";
        assert restaurantHotelsCheckBox != null : "fx:id=\"restaurantHotelsCheckBox\" was not injected: check your FXML file 'CheckBoxes.fxml'.";
        assert clothesShoesCheckBox != null : "fx:id=\"clothesShoesCheckBox\" was not injected: check your FXML file 'CheckBoxes.fxml'.";
        assert leasureSportCultureCheckBox != null : "fx:id=\"leasureSportCultureCheckBox\" was not injected: check your FXML file 'CheckBoxes.fxml'.";
        assert incomeCheckBox != null : "fx:id=\"incomeCheckBox\" was not injected: check your FXML file 'CheckBoxes.fxml'.";
        assert fixedExpenditureCheckBox != null : "fx:id=\"fixedExpenditureCheckBox\" was not injected: check your FXML file 'CheckBoxes.fxml'.";
        assert fluctExpendituresCheckBox != null : "fx:id=\"fluctExpendituresCheckBox\" was not injected: check your FXML file 'CheckBoxes.fxml'.";
        assert totalExpendituresCheckBox != null : "fx:id=\"totalExpendituresCheckBox\" was not injected: check your FXML file 'CheckBoxes.fxml'.";
        assert absoluteCheckBox != null : "fx:id=\"absoluteCheckBox\" was not injected: check your FXML file 'CheckBoxes.fxml'.";
        assert relativeCheckBox != null : "fx:id=\"relativeCheckBox\" was not injected: check your FXML file 'CheckBoxes.fxml'.";
        assert monthCheckBox != null : "fx:id=\"monthCheckBox\" was not injected: check your FXML file 'CheckBoxes.fxml'.";
        assert yearCheckBox != null : "fx:id=\"yearCheckBox\" was not injected: check your FXML file 'CheckBoxes.fxml'.";
        assert fiveYearsCheckBox != null : "fx:id=\"fiveYearsCheckBox\" was not injected: check your FXML file 'CheckBoxes.fxml'.";
        assert monthComboBox != null : "fx:id=\"monthComboBox\" was not injected: check your FXML file 'PieChart.fxml'.";
        assert yearComboBox != null : "fx:id=\"yearComboBox\" was not injected: check your FXML file 'PieChart.fxml'.";
        assert showComboBox != null : "fx:id=\"showComboBox\" was not injected: check your FXML file 'PieChart.fxml'.";
        assert inComboBox != null : "fx:id=\"inComboBox\" was not injected: check your FXML file 'PieChart.fxml'.";
        


final NumberAxis xAxis = new NumberAxis(1, 30, 1);
xAxis.setLabel("time");



final NumberAxis yAxis = new NumberAxis();
yAxis.setLabel("amount");

final LineChart<Number,Number> lineChart = 
new LineChart<Number,Number>(xAxis,yAxis);

XYChart.Series<Axis, Axis> series = new XYChart.Series<Axis, Axis>();














        
        
        
    }
    List<LocalDate> allDatesStream = (fluctExpendituresList.stream()
			   .map(f-> f.getDate())
			   .distinct()
			   .collect(Collectors.toList()));
    
    ObservableList<LocalDate> allDatesList = FXCollections.observableArrayList(allDatesStream);
    
//    private void filterDatesLastThirtyDays(LocalDate time) {
//    	FilteredList<LocalDate> dates = new FilteredList<LocalDate>(allDatesList);
//    	Predicate<LocalDate> datesLastThirtyDays = d ->d.
//    }

}

