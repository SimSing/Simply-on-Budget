package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import model.FluctExpenditures;

public class FluctExpendituresRepositoryJPA implements FluctExpendituresRepository{
	
	public static final String PROJECT_DB ="jdbc:derby:helloDB; create=true; user=simon; password=test";
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("projectJPA");
	private static final EntityManager em = emf.createEntityManager();

	@Override
	public void add(FluctExpenditures fluctExpenditures) {

		EntityTransaction et = em.getTransaction();	
		et.begin();
		em.persist(fluctExpenditures);
		et.commit();
		
		System.out.println("Fluct Expenditures inserted");
		
	}

	@Override
	public FluctExpenditures update(FluctExpenditures fluctExpenditures) {

		EntityTransaction et = em.getTransaction();	
		et.begin();
		FluctExpenditures mergedFluctExpenditures = em.merge(fluctExpenditures);
		et.commit();
		
		System.out.println("Fluct Expenditures updated");
		
		return mergedFluctExpenditures;
	}

	@Override
	public Optional<FluctExpenditures> read(long id) {

		FluctExpenditures fluctExpenditures = null;
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		fluctExpenditures = em.find(FluctExpenditures.class, id);
		et.commit();
		
		System.out.println("Fluct Expenditures read");

		return Optional.ofNullable(fluctExpenditures);
	}

	@Override
	public List<FluctExpenditures> readAll() {

		List<FluctExpenditures> fluctExpendituresList = new ArrayList<>();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		TypedQuery<FluctExpenditures> query = em.createNamedQuery("readAllFluctExpenditures", FluctExpenditures.class);
		fluctExpendituresList = query.getResultList();
		et.commit();
		
		System.err.println("All FluctExpenditures:" + "\n");
		fluctExpendituresList.forEach(t -> System.err.println(t));
		
		return fluctExpendituresList;
	}

	@Override
	public void delete(FluctExpenditures fluctExpenditures) {

		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		em.remove(fluctExpenditures);
		transaction.commit();
	}

}
