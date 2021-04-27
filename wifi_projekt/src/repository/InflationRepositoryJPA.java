package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import model.Inflation;

public class InflationRepositoryJPA implements InflationRepository {
	public static final String PROJECT_DB = "jdbc:derby:helloDB; create=true; user=simon; password=test";
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("projectJPA");
	private static final EntityManager em = emf.createEntityManager();

	@Override
	public void add(Inflation inflation) {

		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(inflation);
		et.commit();
		System.out.println("Inflation inserted");

	}

	@Override
	public Inflation update(Inflation inflation) {

		EntityTransaction et = em.getTransaction();
		et.begin();
		Inflation mergedInflation = em.merge(inflation);
		et.commit();

		System.out.println("Inflation updated");

		return mergedInflation;
	}

	@Override
	public Optional<Inflation> read(long id) {

		Inflation inflation = null;
		EntityTransaction et = em.getTransaction();

		et.begin();
		inflation = em.find(Inflation.class, id);
		et.commit();

		System.out.println("Inflation read");

		return Optional.ofNullable(inflation);
	}

	@Override
	public List<Inflation> readAll() {

		List<Inflation> inflationList = new ArrayList<>();
		EntityTransaction et = em.getTransaction();

		et.begin();
		TypedQuery<Inflation> query = em.createNamedQuery("readAllInflation", Inflation.class);
		inflationList = query.getResultList();
		et.commit();

		System.err.println("All Income:" + "\n");
		inflationList.forEach(t -> System.err.println(t));
		return inflationList;
	}

	@Override
	public void delete(Inflation inflation) {

		EntityTransaction transaction = em.getTransaction();

		transaction.begin();
		em.remove(inflation);
		transaction.commit();
	}

}