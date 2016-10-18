package co.grandcircus.vitamenu.model;

import com.google.gson.JsonObject;

public class Nutrition {

	private String name;
	private int calories;
	private int yield;
	private int calPerServing;
	public int getCalPerServing() {
		return calPerServing;
	}
	public void setCalPerServing(int calPerServing) {
		this.calPerServing = calPerServing;
	}

	private int vitA;
	private int vitB;
	private int vitB2;
	private int vitB3;
	private int vitB6;
	private int vitB9;
	private int vitB12;
	private int vitC;
	private int vitD;
	private int vitE;
	private int vitK;
	
	private String url;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	private JsonObject nutrients;
	public int getYield() {
		return yield;
	}
	public void setYield(int yield) {
		this.yield = yield;
	}

	public int getVitB2() {
		return vitB2;
	}
	public void setVitB2(int vitB2) {
		this.vitB2 = vitB2;
	}
	public int getVitB3() {
		return vitB3;
	}
	public void setVitB3(int vitB3) {
		this.vitB3 = vitB3;
	}

	public int getVitB6() {
		return vitB6;
	}
	public void setVitB6(int vitB6) {
		this.vitB6 = vitB6;
	}

	public int getVitB9() {
		return vitB9;
	}
	public void setVitB9(int vitB9) {
		this.vitB9 = vitB9;
	}
	public int getVitB12() {
		return vitB12;
	}
	public void setVitB12(int vitB12) {
		this.vitB12 = vitB12;
	}
	public int getVitC() {
		return vitC;
	}
	public void setVitC(int vitC) {
		this.vitC = vitC;
	}
	public int getVitD() {
		return vitD;
	}
	public void setVitD(int vitD) {
		this.vitD = vitD;
	}
	public int getVitE() {
		return vitE;
	}
	public void setVitE(int vitE) {
		this.vitE = vitE;
	}
	public int getVitK() {
		return vitK;
	}
	public void setVitK(int vitK) {
		this.vitK = vitK;
	}
	private String label;
	private int quantity;
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public JsonObject getNutrients() {
		return nutrients;
	}
	public void setNutrients(JsonObject jsonObject) {
		this.nutrients = jsonObject;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCalories() {
		return calories;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	public int getVitA() {
		return vitA;
	}
	public void setVitA(int vitA) {
		this.vitA = vitA;
	}
	public int getVitB() {
		return vitB;
	}
	public void setVitB(int vitB) {
		this.vitB = vitB;
	}
}
