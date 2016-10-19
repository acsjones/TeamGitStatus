package co.grandcircus.vitamenu.model;

import java.text.DecimalFormat;

import com.google.gson.JsonObject;

public class Nutrition {

	private String name;
	private int calories;
	private String unit;
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}

	private int yield;
	private int calPerServing;
	public int getCalPerServing() {
		return calPerServing;
	}
	public void setCalPerServing(int calPerServing) {
		this.calPerServing = calPerServing;
	}

	private String vitA;
	private String vitB;
	private String vitB2;
	private String vitB3;
	private String vitB6;
	private String vitB9;
	private String vitB12;
	private String vitC;
	private String vitD;
	private String vitE;
	private String vitK;
	
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

	public String getVitB2() {
		return vitB2;
	}
	public void setVitB2(String vitB2) {
		this.vitB2 = vitB2;
	}
	public String getVitB3() {
		return vitB3;
	}
	public void setVitB3(String vitB3) {
		this.vitB3 = vitB3;
	}

	public String getVitB6() {
		return vitB6;
	}
	public void setVitB6(String vitB6) {
		this.vitB6 = vitB6;
	}

	public String getVitB9() {
		return vitB9;
	}
	public void setVitB9(String vitB9) {
		this.vitB9 = vitB9;
	}
	public String getVitB12() {
		return vitB12;
	}
	public void setVitB12(String vitB12) {
		this.vitB12 = vitB12;
	}
	public String getVitC() {
		return vitC;
	}
	public void setVitC(String vitC) {
		this.vitC = vitC;
	}
	public String getVitD() {
		return vitD;
	}
	public void setVitD(String vitD) {
		this.vitD = vitD;
	}
	public String getVitE() {
		return vitE;
	}
	public void setVitE(String vitE) {
		this.vitE = vitE;
	}
	public String getVitK() {
		return vitK;
	}
	public void setVitK(String vitK) {
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
	public String getVitA() {
		return vitA;
	}
	public void setVitA(String vitA) {
		this.vitA = vitA;
	}
	public String getVitB() {
		return vitB;
	}
	public void setVitB(String vitB) {
		this.vitB = vitB;
	}
	
	public String formatNum(double x) {
		DecimalFormat df = new DecimalFormat();
		df.setMinimumFractionDigits(0);
		return df.format(x);
	}
}
