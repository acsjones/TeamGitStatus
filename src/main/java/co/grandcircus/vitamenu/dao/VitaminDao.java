package co.grandcircus.vitamenu.dao;

import java.util.List;

import co.grandcircus.vitamenu.model.Vitamin;

public interface VitaminDao {

	List<Vitamin> getAllVitamins();
	
	List<Vitamin> getAllVitaminsSortedBy(String sort) throws IllegalArgumentException;

}
