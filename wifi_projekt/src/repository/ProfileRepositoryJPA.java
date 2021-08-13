package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import controller.CommonPropertiesController;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import model.Profile;

public class ProfileRepositoryJPA extends CommonPropertiesController implements ProfileRepository {
	
	public static final String PROJECT_DB ="jdbc:derby:helloDB; create=true; user=simon; password=test";
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("projectJPA");
	private static final EntityManager em = emf.createEntityManager();

	@Override
	public void add(Profile profile) {

		EntityTransaction et = em.getTransaction();	
		et.begin();
		em.persist(profile);
		et.commit();
		
		System.out.println("Profiles inserted");
		
	}

	@Override
	public Profile update(Profile profile) {

		EntityTransaction et = em.getTransaction();	
		et.begin();
		Profile mergedprofiles = em.merge(profile);
		et.commit();
		
		System.out.println("Profiles updated");
		
		return mergedprofiles;
	}

	@Override
	public Optional<Profile> read(long id) {

		Profile profile = null;
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		profile = em.find(Profile.class, id);
		et.commit();
		
		System.out.println("Profiles read");

		return Optional.ofNullable(profile);
	}

	@Override
	public List<Profile> readAll() {

		List<Profile> profileList = new ArrayList<>();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		TypedQuery<Profile> query = em.createNamedQuery("readAllProfiles", Profile.class);
		profileList = query.//setParameter("queryProfile", loginName).
				getResultList();
		et.commit();
		
		System.err.println("All Profile:" + "\n");
		profileList.forEach(t -> System.err.println(t));
		
		return profileList;
	}

	@Override
	public void delete(Profile profile) {

		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		em.remove(profile);
		transaction.commit();
	}

}
