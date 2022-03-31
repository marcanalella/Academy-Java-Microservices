package com.acme.jpa;

import java.util.List;

import javax.ejb.Singleton;
import javax.ejb.TransactionAttribute;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

//@ApplicationScoped
@Singleton
@TransactionAttribute
public class JpaCarDao implements CarDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override 
	public void insert(Car car) {
		em.persist(car);
	}

	@Override
	public void delete(Car car) {
		em.remove(car);
	}
	
	//@Override
	public void deleteById (String id) {
		Car car = em.find(Car.class, id);
		
		if (car != null) {
			em.remove(car);
		}
	}

	@Override
	public void update(Car car) {
//		Car c = em.find(Car.class, car.getId());
		Car c = em.merge(car);
		c.setMaker(car.getMaker());
		c.setModel(car.getModel());
	}

	@Override
	public Car findById(int id) {
		return em.find(Car.class, id);
	}

	@Override
	public List<Car> findByMaker(String maker) {
		
		// maker = Audi'; DROP TABLE CAR; --
		// SELECT * FROM CAR WHERE MAKER = 'Audi'; DROP TABLE CAR; --'
		
		// SELECT * FROM CAR WHERE MAKER = 'Audi'
		String q = "SELECT c FROM Car c WHERE c.maker = :maker";
		return em.createQuery(q, Car.class)
				 .setParameter("maker", maker)
			     .getResultList();
	}

}
