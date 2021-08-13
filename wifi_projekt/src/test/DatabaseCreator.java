package test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import model.FixedExpenditures;
import model.FluctExpenditures;
import model.Income;
import model.Income.CategoryInc;
import model.Inflation;
import model.Profile;
import model.FluctExpenditures.Category;

public class DatabaseCreator {
	public static final String PROJECT_DB = "jdbc:derby:helloDB; create=true; user=simon; password=test";

	public static void main(String[] args) {
		System.out.println("test");
		insertTestData();

	}

	private static void insertTestData() {

		List<Profile> profileList = List.of(new Profile("Simon1", "1"), new Profile("Simon2", "2"),
				new Profile("Simon3", "3"));
		List<FixedExpenditures> fixedExpenditures = List
				.of(new FixedExpenditures("Rent", 1500.25, LocalDate.now(), profileList.get(0)));
		List<Income> income = List
				.of(new Income(CategoryInc.WAGE_SALARY, 3000.25, LocalDate.now(), "testdata", profileList.get(1)));
		List<FluctExpenditures> fluctExpenditures = 
		List.of(new FluctExpenditures(Category.DAILY_NECESSITIES, 40.25, LocalDate.now(), "food", "billa",
				profileList.get(2)));
		List<Inflation> inflation = List.of(new Inflation(2020, 3d), new Inflation(2019, 5d), new Inflation(2018, 10d));

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("projectJPA");
		EntityManager em = emf.createEntityManager();

		EntityTransaction transaction = em.getTransaction();

		transaction.begin();

		for (Profile prf : profileList) {
			em.persist(prf);

		}

		for (FixedExpenditures fe : fixedExpenditures) {
			em.persist(fe);
		}
		for (FluctExpenditures fle : fluctExpenditures) {
			em.persist(fle);
		}

		for (Inflation inf : inflation) {
			em.persist(inf);
		}
		for (Income in : income) {
			em.persist(in);
		}

		transaction.commit();

		em.close();
		emf.close();

		System.out.println("Test Data successfully inserted");
		System.out.println(fluctExpenditures);
		System.out.println(income);
		System.out.println(profileList);
	}

}
