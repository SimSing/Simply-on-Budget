package repository;

import java.util.List;
import java.util.Optional;


import model.Inflation;

public interface InflationRepository {
	
	void add (Inflation inflation);
	
	Inflation update (Inflation inflation);
	
	Optional<Inflation> read(long id);
	
	List<Inflation> readAll();
	
	void delete(Inflation inflation);

}
