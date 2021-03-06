package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import model.Income;

public class IncomeRepositoryJPA implements IncomeRepository {
	
	public static final String PROJECT_DB ="jdbc:derby:helloDB; create=true; user=simon; password=test";
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("projectJPA");
	private static final EntityManager em = emf.createEntityManager();

	@Override
	public void add(Income income) {

		EntityTransaction et = em.getTransaction();	
		et.begin();
		em.persist(income);
		et.commit();
		System.out.println("Income inserted");
		
	}

	@Override
	public Income update(Income income) {

		EntityTransaction et = em.getTransaction();	
		et.begin();
		Income mergedIncome = em.merge(income);
		et.commit();
		
		System.out.println("Income updated");
		
		return mergedIncome;
	}

	@Override
	public Optional<Income> read(long id) {

		Income income = null;
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		income = em.find(Income.class, id);
		et.commit();
		
		System.out.println("Income read");

		return Optional.ofNullable(income);
	}

	@Override
	public List<Income> readAll() {

		List<Income> incomeList = new ArrayList<>();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		TypedQuery<Income> query = em.createNamedQuery("readAllIncome", Income.class);
		incomeList = query.getResultList();
		et.commit();
		
		System.err.println("All Income:" + "\n");
		incomeList.forEach(t -> System.err.println(t));
		return incomeList;
	}

	@Override
	public void delete(Income income) {

EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		em.remove(income);
		transaction.commit();
	}

}
