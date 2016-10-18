package co.grandcircus.vitamenu.model;

import com.google.gson.JsonObject;

public class Nutrition {

	private String name;
	private String calories;
	private JsonObject nutrients;
	private JsonObject vitA;
	private String label;
	private int quantity;

	
	
	
	
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}
	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	/**
	 * @return the nutrients
	 */
	public JsonObject getNutrients() {
		return nutrients;
	}
	/**
	 * @param jsonObject the nutrients to set
	 */
	public void setNutrients(JsonObject jsonObject) {
		this.nutrients = jsonObject;
	}
	/**
	 * @param jsonObject the vitA to set
	 */
	public void setVitA(JsonObject jsonObject) {
		this.vitA = jsonObject;
	}
	/**
	 * @return the vitA
	 */
	public JsonObject getVitA() {
		return vitA;
	}
	/**
	 * @param vitA the vitA to set
	 */

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCalories() {
		return calories;
	}
	public void setCalories(String calories) {
		this.calories = calories;
	}



	
	
	
	
	
}
