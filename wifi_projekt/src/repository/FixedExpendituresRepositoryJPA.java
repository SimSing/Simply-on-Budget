package repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import model.FixedExpenditures;

public class FixedExpendituresRepositoryJPA implements FixedExpendituresRepository {

	
	public static final String PROJECT_DB ="jdbc:derby:helloDB; create=true; user=simon; password=test";
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("projectJPA");
	private static final EntityManager em = emf.createEntityManager();
	
	
	@Override
	public void add(FixedExpenditures fixedExpenditures) {
		
		EntityTransaction et = em.getTransaction();	
		et.begin();
		em.persist(fixedExpenditures);
		et.commit();
		
		System.out.println("Fixed Expenditures inserted");
		
	}

	@Override
	public FixedExpenditures update(FixedExpenditures fixedExpenditures) {
		
		EntityTransaction et = em.getTransaction();	
		et.begin();
		FixedExpenditures mergedFixedExpenditures = em.merge(fixedExpenditures);
		et.commit();
		
		System.out.println("Fixed Expenditures updated");
		
		return mergedFixedExpenditures;
	}

	@Override
	public Optional<FixedExpenditures> read(long id) {
		
		FixedExpenditures fixedExpenditures = null;
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		fixedExpenditures = em.find(FixedExpenditures.class, id);
		et.commit();
		
		System.out.println("Fixed Expenditures read");

		return Optional.ofNullable(fixedExpenditures);
	}

	@Override
	public List<FixedExpenditures> readAll() {

		List<FixedExpenditures> fixedExpendituresList = new ArrayList<>();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		TypedQuery<FixedExpenditures> query = em.createNamedQuery("readAllFixedExpenditures", FixedExpenditures.class);
		fixedExpendituresList = query.getResultList();
		et.commit();
		
		System.err.println("All FixedExpenditures:" + "\n");
		fixedExpendituresList.forEach(t -> System.err.println(t));
		return fixedExpendituresList;
	}
//	@Override
//	public List<LocalDate> readYearsFixedExpenditures() {
//		
//		List<LocalDate> fixedExpendituresYearsList = new ArrayList<>();
//		EntityTransaction et = em.getTransaction();
//		
//		et.begin();
//		TypedQuery<LocalDate> query = em.createNamedQuery("readAllFixedExpendituresYears", LocalDate.class);
//		fixedExpendituresYearsList = query.getResultList();
//		et.commit();
//		
//		System.err.println("All FixedExpendituresYears:" + "\n");
//		fixedExpendituresYearsList.forEach(t -> System.err.println(t));
//		return fixedExpendituresYearsList;
//	}
	@Override
	public void delete(FixedExpenditures fixedExpenditures) {

		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		em.remove(fixedExpenditures);
		transaction.commit();
		
	}

}
