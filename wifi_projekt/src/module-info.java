module wifi_projekt {
	exports controller;
	exports application;
	exports test;
	exports model;
	exports repository;

	requires jakarta.persistence;
	requires java.sql;
	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	
	opens model to eclipselink;
	opens controller to javafx.fxml;
	opens application to javafx.graphics, javafx.fxml;
	}
