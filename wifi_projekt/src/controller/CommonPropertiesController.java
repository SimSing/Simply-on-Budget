package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.FixedExpenditures;
import model.FluctExpenditures;
import model.Income;
import model.Inflation;
import model.Profile;
import repository.FixedExpendituresRepository;
import repository.FixedExpendituresRepositoryJPA;
import repository.FluctExpendituresRepository;
import repository.FluctExpendituresRepositoryJPA;
import repository.IncomeRepository;
import repository.IncomeRepositoryJPA;
import repository.InflationRepository;
import repository.InflationRepositoryJPA;
import repository.ProfileRepository;
import repository.ProfileRepositoryJPA;

public class CommonPropertiesController {
	
	static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
	
	static ObjectProperty<FluctExpenditures> selectedFluctExpendituresProperty = new SimpleObjectProperty<FluctExpenditures>();
	static ObjectProperty<Income> selectedIncomeProperty = new SimpleObjectProperty<Income>();
	static ObjectProperty<FixedExpenditures> selectedFixedExpendituresProperty = new SimpleObjectProperty<FixedExpenditures>();
	static ObjectProperty<Inflation> selectedInflationProperty = new SimpleObjectProperty<Inflation>();
	static ObjectProperty<Profile> selectedProfileProperty = new SimpleObjectProperty<Profile>();

	
	static FluctExpendituresRepository fluctExpendituresRepository = new FluctExpendituresRepositoryJPA();
	static ObservableList<FluctExpenditures> fluctExpendituresList = FXCollections.observableArrayList(fluctExpendituresRepository.readAll());
	
	static IncomeRepository incomeRepository = new IncomeRepositoryJPA();
	static ObservableList<Income> incomeList = FXCollections.observableArrayList(incomeRepository.readAll());
	
	static FixedExpendituresRepository fixedExpendituresRepository = new FixedExpendituresRepositoryJPA();
	static ObservableList<FixedExpenditures> fixedExpendituresList = FXCollections.observableArrayList(fixedExpendituresRepository.readAll());


	static ProfileRepository profileRepository = new ProfileRepositoryJPA();
	static ObservableList<Profile> profileList = FXCollections.observableArrayList(profileRepository.readAll());
	
	static InflationRepository inflationRepository = new InflationRepositoryJPA();
	static ObservableList<Inflation> inflationList = FXCollections.observableArrayList(inflationRepository.readAll());
	
	
	
	
	
	
	static {
		fluctExpendituresList.addListener(new ListChangeListener<FluctExpenditures>() {

			@Override
			public void onChanged(Change<? extends FluctExpenditures> c) {
				
				while (c.next()) {
					if(c.wasReplaced()) {
						System.err.println("Fluct. Expenditure updated " +c.wasUpdated());
						for(FluctExpenditures fluctExpenditures : c.getAddedSubList()) {
							fluctExpendituresRepository.update(fluctExpenditures);
						}
					}else if (c.wasAdded()) {
						System.err.println("Fluct. Expenditure was added to list");
						for (FluctExpenditures fluctExpenditures : c.getAddedSubList()) {
							fluctExpendituresRepository.add(fluctExpenditures);
						}
					}else if(c.wasRemoved()) {
						System.err.println("Fluct. Expenditure was removed from list");
						for (FluctExpenditures fluctExpenditures : c.getRemoved()) {
							fluctExpendituresRepository.delete(fluctExpenditures);
						}
					}
				}
				
			}
			
		});
	}
	
	static {
		incomeList.addListener(new ListChangeListener<Income>() {

			@Override
			public void onChanged(Change<? extends Income> c) {
				
				while (c.next()) {
					if(c.wasReplaced()) {
						System.err.println("Income " +c.wasUpdated());
						for(Income income : c.getAddedSubList()) {
							incomeRepository.update(income);
						}
					}else if (c.wasAdded()) {
						System.err.println("Income was added to list");
						for (Income income : c.getAddedSubList()) {
							incomeRepository.add(income);
						}
					}else if(c.wasRemoved()) {
						System.err.println("Income removed from list");
						for (Income income : c.getRemoved()) {
							incomeRepository.delete(income);
						}
					}
				}
				
			}
			
		});
	}
	
	static {
		fixedExpendituresList.addListener(new ListChangeListener<FixedExpenditures>() {

			@Override
			public void onChanged(Change<? extends FixedExpenditures> c) {
				
				while (c.next()) {
					if(c.wasReplaced()) {
						System.err.println("Fixed. Expenditure updated " +c.wasUpdated());
						for(FixedExpenditures fixedExpenditures : c.getAddedSubList()) {
							fixedExpendituresRepository.update(fixedExpenditures);
						}
					}else if (c.wasAdded()) {
						System.err.println("Fixed. Expenditure was added to list");
						for (FixedExpenditures fixedExpenditures : c.getAddedSubList()) {
							fixedExpendituresRepository.add(fixedExpenditures);
						}
					}else if(c.wasRemoved()) {
						System.err.println("Fixed. Expenditure was removed from list");
						for (FixedExpenditures fixedExpenditures : c.getRemoved()) {
							fixedExpendituresRepository.delete(fixedExpenditures);
						}
					}
				}
				
			}
			
		});
	}
	
	static {
		inflationList.addListener(new ListChangeListener<Inflation>() {

			@Override
			public void onChanged(Change<? extends Inflation> c) {
				
				while (c.next()) {
					if(c.wasReplaced()) {
						System.err.println("Inflation " +c.wasUpdated());
						for(Inflation inflation : c.getAddedSubList()) {
							inflationRepository.update(inflation);
						}
					}else if (c.wasAdded()) {
						System.err.println("Inflation was added to list");
						for (Inflation inflation : c.getAddedSubList()) {
							inflationRepository.add(inflation);
						}
					}else if(c.wasRemoved()) {
						System.err.println("Inflation removed from list");
						for (Inflation inflation : c.getRemoved()) {
							inflationRepository.delete(inflation);
						}
					}
				}
				
			}
			
		});
	}
	static {
		profileList.addListener(new ListChangeListener<Profile>() {

			@Override
			public void onChanged(Change<? extends Profile> c) {
				
				while (c.next()) {
					if(c.wasReplaced()) {
						System.err.println("Profile updated " +c.wasUpdated());
						for(Profile profile : c.getAddedSubList()) {
							profileRepository.update(profile);
						}
					}else if (c.wasAdded()) {
						System.err.println("Profile was added to list");
						for (Profile profile : c.getAddedSubList()) {
							profileRepository.add(profile);
						}
					}else if(c.wasRemoved()) {
						System.err.println("Profile was removed from list");
						for (Profile profile : c.getRemoved()) {
							profileRepository.delete(profile);
						}
					}
				}
				
			}
			
		});
	}
	public final void loadScene(String string) {
		
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/application/"+string+".fxml"));

		try {
			Parent root = loader.load();
			Stage stage = new Stage();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
