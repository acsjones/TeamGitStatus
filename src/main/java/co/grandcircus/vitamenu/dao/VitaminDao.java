package co.grandcircus.vitamenu.dao;

import java.util.List;


import co.grandcircus.vitamenu.exception.NotFoundException;

import co.grandcircus.vitamenu.model.Vitamin;

public interface VitaminDao {


	
	public List<Vitamin> getAllVitamins();
	
	public List<Vitamin> getAllVitaminsSortedBy(String sort) throws IllegalArgumentException;
	
	Vitamin getVitamin(int vitamin_key) throws NotFoundException;
	
	public void addFoodItem(String vname , String food);



}
