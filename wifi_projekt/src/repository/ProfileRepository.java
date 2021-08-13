package repository;

import java.util.List;
import java.util.Optional;


import model.Profile;

public interface ProfileRepository {
	
	void add (Profile profile);
	
	Profile update (Profile profile);
	
	Optional<Profile> read(long id);
	
	List<Profile> readAll();
	
//	List<LocalDate> readYearsFixedExpenditures();
	
	void delete(Profile profile);

}
