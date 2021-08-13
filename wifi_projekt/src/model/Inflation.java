package model;



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
	public long id;
	public Double inflationFigure;
	public Integer inflationYear;
	
	public Inflation(Integer inflationYear, Double inflationFigure) {
		super();
		
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
	public Integer getInflationYear() {
		return inflationYear;
	}
	public void setInflationYear(Integer inflationYear) {
		this.inflationYear = inflationYear;
	}
	public Double getInflationFigure() {
		return inflationFigure;
	}
	public void setInflationFigure(Double inflationFigure) {
		this.inflationFigure = inflationFigure;
	}
	@Override
	public String toString() {
		return "Inflation [id=" + id + ", year=" + inflationYear + ", inflationFigure=" + inflationFigure + "]";
	}
	
	

}
