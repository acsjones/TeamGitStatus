package co.grandcircus.vitamenu.model;

import java.text.DecimalFormat;

import com.google.gson.JsonObject;

public class Nutrition {
	private String vitB9;
	private String vitB12;
	private String vitC;
	private String vitCPer;
	private String vitD;
	private String vitDPer;
	private String vitE;
	private String vitEPer;
	private String vitK;
	private String vitKPer;
	private String url;
	public String getVitCPer() {
		return vitCPer;
	}
	public void setVitCPer(String vitCPer) {
		this.vitCPer = vitCPer;
	}
	public String getVitDPer() {
		return vitDPer;
	}
	public void setVitDPer(String vitDPer) {
		this.vitDPer = vitDPer;
	}
	public String getVitEPer() {
		return vitEPer;
	}
	public void setVitEPer(String vitEPer) {
		this.vitEPer = vitEPer;
	}
	public String getVitKPer() {
		return vitKPer;
	}
	public void setVitKPer(String vitKPer) {
		this.vitKPer = vitKPer;
	}
	public String getVitBPer() {
		return vitBPer;
	}
	public void setVitBPer(String vitBPer) {
		this.vitBPer = vitBPer;
	}
	public String getVitB2Per() {
		return vitB2Per;
	}
	public void setVitB2Per(String vitB2Per) {
		this.vitB2Per = vitB2Per;
	}
	public String getVitB3Per() {
		return vitB3Per;
	}
	public void setVitB3Per(String vitB3Per) {
		this.vitB3Per = vitB3Per;
	}
	public String getVitB6Per() {
		return vitB6Per;
	}
	public void setVitB6Per(String vitB6Per) {
		this.vitB6Per = vitB6Per;
	}
	public String getVitB9Per() {
		return vitB9Per;
	}
	public void setVitB9Per(String vitB9Per) {
		this.vitB9Per = vitB9Per;
	}
	public String getVitB12Per() {
		return vitB12Per;
	}
	public void setVitB12Per(String vitB12Per) {
		this.vitB12Per = vitB12Per;
	}

	private String vitA;
	private String vitB;
	private String vitB2;
	private String vitB3;
	private String vitB6;
	private String vitAPer;
	private String vitBPer;
	private String vitB2Per;
	private String vitB3Per;
	private String vitB6Per;
	private String vitB9Per;
	private String vitB12Per;
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

	public String getVitAPer() {
		return vitAPer;
	}
	
	public void setVitAPer(String vitAPer) {
		this.vitAPer = vitAPer;
	}

	
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
