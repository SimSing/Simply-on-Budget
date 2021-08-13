package repository;

import java.util.List;
import java.util.Optional;

import model.FixedExpenditures;

public interface FixedExpendituresRepository {

	
	void add (FixedExpenditures fixedExpenditures);
	
	FixedExpenditures update (FixedExpenditures fixedExpenditures);
	
	Optional<FixedExpenditures> read(long id);
	
	List<FixedExpenditures> readAll();
	
//	List<LocalDate> readYearsFixedExpenditures();
	
	void delete(FixedExpenditures fixedExpenditures);

}
