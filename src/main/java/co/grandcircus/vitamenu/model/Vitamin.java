package co.grandcircus.vitamenu.model;

public class Vitamin {

	private String vitamin_letter;
	private String vitamin_name;
	private Integer vitamin_key;
	private String vitamin_benefits;
	private String food_1;
	private String recipe;
	/**
	 * @return the recipe
	 */
	public String getRecipe() {
		return recipe;
	}
	/**
	 * @param recipe the recipe to set
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
	 * @param food_1 the food_1 to set
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
	 * @param vitamin_key the vitamin_key to set
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
	 * @param vitamin_benefits the vitamin_benefits to set
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
	 * @param vitamin_letter the vitamin_letter to set
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
	 * @param vitamin_name the vitamin_name to set
	 */
	public void setVitamin_name(String vitamin_name) {
		this.vitamin_name = vitamin_name;
	}
	
	public Vitamin(Integer vitamin_key, String vitamin_letter, String vitamin_name) {
		this.vitamin_letter = vitamin_letter;
		this.vitamin_name = vitamin_name;
		this.vitamin_key = vitamin_key;
	}
	public Vitamin(int vitamin_key, String vitamin_letter, String vitamin_benefits, String vitamin_name, String food_1) {
		this.vitamin_key = vitamin_key;
		this.vitamin_benefits = vitamin_benefits;
		this.vitamin_name = vitamin_name;
		this.vitamin_letter = vitamin_letter;
		this.food_1 = food_1;
	}
	public Vitamin() {
		// TODO Auto-generated constructor stub
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Vitamin [vitamin_letter=" + vitamin_letter + ", vitamin_name=" + vitamin_name + ", vitamin_key="
				+ vitamin_key + ", vitamin_benefits=" + vitamin_benefits + ", food_1=" + food_1 + "]";
	}

	
}
