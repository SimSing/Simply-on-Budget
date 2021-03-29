package repository;

import java.util.List;
import java.util.Optional;

import model.Income;

public interface IncomeRepository {
	
	void add (Income income);
	
	Income update (Income income);
	
	Optional<Income> read(long id);
	
	List<Income> readAll();
	
	void delete(Income income);

}
