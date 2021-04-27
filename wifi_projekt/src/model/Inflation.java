package model;


import java.time.Year;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQuery(name = "readAllInflation", query = "select inf from Inflation inf")

public class Inflation {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private double inflationFigure;
	private Year inflationYear;
	
	public Inflation(Year inflationYear, double inflationFigure) {
		super();
		
		this.inflationYear = inflationYear;
		this.inflationFigure = inflationFigure;
	}
	
	public Inflation(long id, double inflationFigure, Year inflationYear) {
		super();
		this.id = id;
		this.inflationYear = inflationYear;
		this.inflationFigure = inflationFigure;
	}
	
	public Inflation () {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Year getYear() {
		return inflationYear;
	}
	public void setYear(Year inflationYear) {
		this.inflationYear = inflationYear;
	}
	public double getInflationFigure() {
		return inflationFigure;
	}
	public void setInflationFigure(double inflationFigure) {
		this.inflationFigure = inflationFigure;
	}
	@Override
	public String toString() {
		return "Inflation [id=" + id + ", year=" + inflationYear + ", inflationFigure=" + inflationFigure + "]";
	}
	
	

}
