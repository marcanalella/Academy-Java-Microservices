package com.acme.jpa;

import java.util.List;

public interface CarDao {
	
 void insert (Car car);
 
 void delete (Car car);
 
 void update (Car car); // to be discussed
 
 Car findById (int id);
 
 List<Car> findByMaker (String maker);
}
