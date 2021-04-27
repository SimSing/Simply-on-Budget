package repository;

import java.util.List;
import java.util.Optional;

import model.FluctExpenditures;


public interface FluctExpendituresRepository {
	
	void add (FluctExpenditures fluctExpenditures);
	
	FluctExpenditures update (FluctExpenditures fluctExpenditures);
	
	Optional<FluctExpenditures> read(long id);
	
	List<FluctExpenditures> readAll();
	
	void delete(FluctExpenditures fluctExpenditures);


}
