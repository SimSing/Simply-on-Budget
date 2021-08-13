module wifi_projekt {
	exports controller;
	exports application;
	exports test;
	exports model;
	exports repository;

	requires jakarta.persistence;
	requires java.desktop;
	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
//	requires org.junit.jupiter.api;
	opens model to eclipselink;
	opens controller to javafx.fxml;
	opens application to javafx.graphics, javafx.fxml;



		

}