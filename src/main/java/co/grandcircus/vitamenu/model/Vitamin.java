package co.grandcircus.vitamenu.model;

public class Vitamin {

	private String vitamin_letter;
	private String vitamin_name;
	private Integer vitamin_key;
	private String vitamin_benefits;
	private String vitamin_defiency;

	/**
	 * @return the vitamin_defiency
	 */
	public String getVitamin_defiency() {
		return vitamin_defiency;
	}

	/**
	 * @param vitamin_defiency
	 *            the vitamin_defiency to set
	 */
	public void setVitamin_defiency(String vitamin_defiency) {
		this.vitamin_defiency = vitamin_defiency;
	}

	private String food_1;
	private String food_2;
	private String food_3;
	private String food_4;
	private String food_5;

	public String getFood_4() {
		return food_4;
	}

	public void setFood_4(String food_4) {
		this.food_4 = food_4;
	}

	public String getFood_5() {
		return food_5;
	}

	public void setFood_5(String food_5) {
		this.food_5 = food_5;
	}

	public String getFood_2() {
		return food_2;
	}

	public void setFood_2(String food_2) {
		this.food_2 = food_2;
	}

	public String getFood_3() {
		return food_3;
	}

	public void setFood_3(String food_3) {
		this.food_3 = food_3;
	}

	private String recipe;

	/**
	 * @return the recipe
	 */
	public String getRecipe() {
		return recipe;
	}

	/**
	 * @param recipe
	 *            the recipe to set
	 */
	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}

	/**
	 * @return the food_1
	 */
	public String getFood_1() {
		return food_1;
	}

	/**
	 * @param food_1
	 *            the food_1 to set
	 */
	public void setFood_1(String food_1) {
		this.food_1 = food_1;
	}

	/**
	 * @return the vitamin_key
	 */
	public Integer getVitamin_key() {
		return vitamin_key;
	}

	/**
	 * @param vitamin_key
	 *            the vitamin_key to set
	 */
	public void setVitamin_key(Integer vitamin_key) {
		this.vitamin_key = vitamin_key;
	}

	/**
	 * @return the vitamin_benefits
	 */
	public String getVitamin_benefits() {
		return vitamin_benefits;
	}

	/**
	 * @param vitamin_benefits
	 *            the vitamin_benefits to set
	 */
	public void setVitamin_benefits(String vitamin_benefits) {
		this.vitamin_benefits = vitamin_benefits;
	}

	/**
	 * @return the vitamin_letter
	 */
	public String getVitamin_letter() {
		return vitamin_letter;
	}

	/**
	 * @param vitamin_letter
	 *            the vitamin_letter to set
	 */
	public void setVitamin_letter(String vitamin_letter) {
		this.vitamin_letter = vitamin_letter;
	}

	/**
	 * @return the vitamin_name
	 */
	public String getVitamin_name() {
		return vitamin_name;
	}

	/**
	 * @param vitamin_name
	 *            the vitamin_name to set
	 */
	public void setVitamin_name(String vitamin_name) {
		this.vitamin_name = vitamin_name;
	}

	public Vitamin(Integer vitamin_key, String vitamin_letter, String vitamin_name) {
		this.vitamin_letter = vitamin_letter;
		this.vitamin_name = vitamin_name;
		this.vitamin_key = vitamin_key;
	}

	public Vitamin(int vitamin_key, String vitamin_letter, String vitamin_benefits, String vitamin_defiency,
			String vitamin_name, String food_1, String food_2, String food_3,String food_4,String food_5) {
		this.vitamin_key = vitamin_key;
		this.vitamin_benefits = vitamin_benefits;
		this.vitamin_defiency = vitamin_defiency;
		this.vitamin_name = vitamin_name;
		this.vitamin_letter = vitamin_letter;
		this.food_1 = food_1;
		this.food_2 = food_2;
		this.food_3 = food_3;
		this.food_4 = food_4;
		this.food_5 = food_5;
	}

	public Vitamin() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Vitamin [vitamin_letter=" + vitamin_letter + ", vitamin_name=" + vitamin_name + ", vitamin_key="
				+ vitamin_key + ", vitamin_benefits=" + vitamin_benefits + ", food_1=" + food_1 + "]";
	}

}